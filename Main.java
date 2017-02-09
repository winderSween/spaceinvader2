/**
 * @author huangshengwei
 * @studentID 1475765
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import view.BossLevel;
import view.Level;
import conf.BossLevelConf;
import conf.LevelConf;

/**
 * 
 * @author
 * @this is the main class, then entrance of this program
 */
public class Main {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * this is the main method
	 * 
	 * @param args
	 *            the parameters from the command line
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		List<Level> levelList = new ArrayList<Level>();
		List<BossLevel> bossLevelList = new ArrayList<BossLevel>();
		File levelDirectory = new File("levels");
		List<Integer> levelIdList = new ArrayList<Integer>();
		for (File file : levelDirectory.listFiles()) {
			levelIdList.add(Integer.parseInt(file.getName().split("\\.")[0]));
		}
		Collections.sort(levelIdList);
		for (int id : levelIdList) {
			File file = new File("levels/" + id + ".txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String tag = reader.readLine();
			if ("N".equalsIgnoreCase(tag)) {
				LevelConf levelConf = new LevelConf();
				String width = reader.readLine();
				levelConf.setWidth(Integer.parseInt(width));
				String height = reader.readLine();
				levelConf.setHeight(Integer.parseInt(height));
				String aliensLineNum = reader.readLine();
				levelConf.setAliens_line_num(Integer.parseInt(aliensLineNum));
				String aliensOneLine = reader.readLine();
				levelConf.setAliens_one_line(Integer.parseInt(aliensOneLine));
				String alienFireRate = reader.readLine();
				levelConf.setAlien_fire_rate(Double.parseDouble(alienFireRate));
				String heroLives = reader.readLine();
				levelConf.setHero_lives(Integer.parseInt(heroLives));
				String bulletStepsOneTure = reader.readLine();
				levelConf.setBullet_steps_one_turn(Integer
						.parseInt(bulletStepsOneTure));
				levelList.add(new Level(levelConf));
			} else {
				BossLevelConf levelConf = new BossLevelConf();
				String width = reader.readLine();
				levelConf.setWidth(Integer.parseInt(width));
				String height = reader.readLine();
				levelConf.setHeight(Integer.parseInt(height));
				String alienFireRate = reader.readLine();
				levelConf.setAlien_fire_rate(Double.parseDouble(alienFireRate));
				String heroLives = reader.readLine();
				levelConf.setHero_lives(Integer.parseInt(heroLives));
				String bossLives = reader.readLine();
				levelConf.setBoss_lives(Integer.parseInt(bossLives));
				String bulletStepsOneTure = reader.readLine();
				levelConf.setBullet_steps_one_turn(Integer
						.parseInt(bulletStepsOneTure));
				String downStep = reader.readLine();
				levelConf.setDown_step(Integer.parseInt(downStep));
				String pointsStr = reader.readLine();
				levelConf.setPoints(pointsStr);
				bossLevelList.add(new BossLevel(levelConf));
				
			}
		}
		int i = 0;
		while (true) {
			if (i < levelList.size()) {
				Level level = levelList.get(i);
				level.draw();
				String cmd = getUserInput();
				if (cmd.equalsIgnoreCase("Q") || cmd.equalsIgnoreCase("Quit")) {
					break;
				} else if (cmd.equalsIgnoreCase("A")) {
					level.left();
				} else if (cmd.equalsIgnoreCase("D")) {
					level.right();
				} else if (cmd.equalsIgnoreCase("F")) {
					level.fire();
				} else if (cmd.equalsIgnoreCase("AF")) {
					level.left();
					level.fire();
				} else if (cmd.equalsIgnoreCase("DF")) {
					level.right();
					level.fire();
				} else if (cmd.equalsIgnoreCase("FD")) {
					level.fire();
					level.right();
				} else if (cmd.equalsIgnoreCase("FA")) {
					level.fire();
					level.left();
				} else {
					System.out.println("Invalid Command!");
					continue;
				}
				boolean end = level.moveAliens();
				if (end) {
					System.out.println("Game Over! You have lost!");
					break;
				}
				end = level.moveBullets();
				if (end) {
					if (level.subHeroLives()) {
						System.out.println("Game Over! You have lost!");
						break;
					} else {
						System.out.println("You have lost one life!");
					}
				}
				if (level.checkWin()) {
					i++;
					continue;
				}
				if ((!level.aliensLeft()) && (!level.aliensRight())) {
					level.alienFire();
				}
			} else {
				if (i - levelList.size() < bossLevelList.size()) {
					BossLevel level = bossLevelList.get(i-levelList.size());
					level.draw();
					String cmd = getUserInput();
					if (cmd.equalsIgnoreCase("Q") || cmd.equalsIgnoreCase("Quit")) {
						break;
					} else if (cmd.equalsIgnoreCase("A")) {
						level.left();
					} else if (cmd.equalsIgnoreCase("D")) {
						level.right();
					} else if (cmd.equalsIgnoreCase("F")) {
						level.fire();
					} else if (cmd.equalsIgnoreCase("AF")) {
						level.left();
						level.fire();
					} else if (cmd.equalsIgnoreCase("DF")) {
						level.right();
						level.fire();
					} else if (cmd.equalsIgnoreCase("FD")) {
						level.fire();
						level.right();
					} else if (cmd.equalsIgnoreCase("FA")) {
						level.fire();
						level.left();
					} else {
						System.out.println("Invalid Command!");
						continue;
					}
					boolean end = level.moveAliens();
					if (end) {
						System.out.println("Game Over! You have lost!");
						break;
					}
					end = level.moveBullets();
					if (end) {
						if (level.subHeroLives()) {
							System.out.println("Game Over! You have lost!");
							break;
						} else {
							System.out.println("You have lost one life!");
						}
					}
					if (level.checkWin()) {
						i++;
						continue;
					}
					if ((!level.aliensLeft()) && (!level.aliensRight())) {
						level.alienFire();
					}
				
				} else {
					System.out.println("Game Over! You won!");
					break;
				}
			}
		}
		scanner.close();
	}

	private static String getUserInput() {
		System.out
				.println("Please input the command(A/D/F/AF/DF/FD/FA/Q(uit) ):");
		String input = scanner.nextLine();
		return input;
	}
}
