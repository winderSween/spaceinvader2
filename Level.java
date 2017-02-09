/**
 * @author huangshengwei
 * @studentID 1475765
 */
package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import conf.LevelConf;
import model.Hero;
import model.LinkedList;
import model.Point;
/**
 * 
 * @author
 * This class represents the level
 */
public class Level {
	private LevelConf conf;
	private int grids[][];
	private boolean aliensDirectionLeft = true;
	private Hero hero = new Hero();
	private LinkedList bulletList = new LinkedList();
	/**
	 * This method take one life from the hero off
	 * @return if the hero is dead
	 */
	public boolean subHeroLives() {
		hero.setLives(hero.getLives() - 1);
		return hero.getLives() <= 0;
	}

	public Level(LevelConf conf) {
		this.conf = conf;
		grids = new int[conf.getHeight()][conf.getWidth()];
		hero.setLives(conf.getHero_lives());
		initGridsZero();
		int width = conf.getWidth();
		int aliensInOneLine = conf.getAliens_one_line();
		int begin = (width - aliensInOneLine * 2) / 2;
		for (int i = 1; i <= conf.getAliens_line_num(); i++) {
			for (int j = begin; j < begin + 2 * aliensInOneLine; j++) {
				if (j % 2 == 0) {
					grids[i][j] = 1;// 1 means there is an alien
				}
			}
		}
		for (int i = conf.getHeight() - 5; i < conf.getHeight() - 3; i++) {
			int j = (conf.getWidth() - 49) / 2;
			int m = 0;
			while (j + 10 < conf.getWidth() && m < 4) {
				for (int k = 0; k < 4; k++) {
					grids[i][j + k] = 2;// 2 means there is a barrier
				}
				j += 15;
				m++;
			}
		}
		int heroPos = conf.getWidth() / 2;
		hero.setHeroCol(heroPos);
		grids[conf.getHeight() - 1][heroPos] = 3;// 3 means there is a hero
	}

	/**
	 * This method redraw the level
	 */
	public void draw() {
		for (int j = 0; j < conf.getHeight() + 2; j++) {
			if (j == 0 || j == conf.getHeight() + 1) {
				for (int i = 0; i < conf.getWidth() + 2; i++) {
					System.out.print("-");
				}
				System.out.println();
			} else {
				System.out.print("|");
				for (int i = 1; i < conf.getWidth() + 1; i++) {
					if (grids[j - 1][i - 1] == 1) {
						System.out.print("X");
					} else if (grids[j - 1][i - 1] == 2) {
						System.out.print("=");
					} else if (grids[j - 1][i - 1] == 3) {
						System.out.print("P");
					} else if (grids[j - 1][i - 1] == 4) {
						System.out.print("^");
					} else if (grids[j - 1][i - 1] == 5) {
						System.out.print("v");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println("|");
			}
		}
	}

	// init all grid to 0
	private void initGridsZero() {
		for (int i = 0; i < conf.getHeight(); i++) {
			for (int j = 0; j < conf.getWidth(); j++) {
				grids[i][j] = 0;
			}
		}
	}


	/**
	 * This method move the hero to left one step
	 */
	public void left() {
		if (hero.getHeroCol() > 0) {
			grids[conf.getHeight() - 1][hero.getHeroCol()] = 0;
			hero.setHeroCol(hero.getHeroCol() - 1);
			grids[conf.getHeight() - 1][hero.getHeroCol()] = 3;
		}
	}

	/**
	 * This method move the hero to right one step
	 */
	public void right() {
		if (hero.getHeroCol() < conf.getWidth() - 1) {
			grids[conf.getHeight() - 1][hero.getHeroCol()] = 0;
			hero.setHeroCol(hero.getHeroCol() + 1);
			grids[conf.getHeight() - 1][hero.getHeroCol()] = 3;
		}
	}

	/**
	 * This method let the hero fire once
	 */
	public void fire() {
		grids[conf.getHeight() - 2][hero.getHeroCol()] = 4;
		bulletList.addNode(new Point(hero.getHeroCol(),conf.getHeight() - 2));
	}

	/**
	 * This method let the aliens fire randomly
	 */
	public void alienFire() {
		for (int i = 0; i < conf.getWidth(); i++) {
			int maxRow = -1;// the max row of alien in column i
			for (int j = 0; j < conf.getHeight(); j++) {
				if (grids[j][i] == 1) {
					maxRow = j;
				}
			}
			if (maxRow != -1) {
				Random random = new Random();
				int rand = random.nextInt(100);
				if (rand < 10) {
					grids[maxRow + 1][i] = 5;
					bulletList.addNode(new Point(i,maxRow + 1));
				}
			}
		}
	}
	/**
	 * This method  checks whether the hero has moved to the leftmost side
	 * @return if aliens have moved to the leftmost side
	 */
	public boolean aliensLeft(){
		boolean left = false;
		for (int j = 0; j < conf.getHeight(); j++) {
			if (grids[j][0] == 1) {
				if (aliensDirectionLeft) {
					left = true;
				}
			}
		}
		return left;
	}
	/**
	 * This method  checks whether the hero has moved to the rightmost side
	 * @return if aliens have moved to the rightmost side
	 */
	public boolean aliensRight(){
		boolean right = false;
		for (int j = 0; j < conf.getHeight(); j++) {
			if (grids[j][conf.getWidth() - 1] == 1) {
				if (!aliensDirectionLeft) {
					right = true;
				}
			}
		}
		return right;
	}
	/**
	 * This method moves the aliens one step
	 * @return if the aliens have moved to the bottom
	 */
	public boolean moveAliens() {
		boolean left = false;
		boolean right = false;
		for (int j = 0; j < conf.getHeight(); j++) {
			if (grids[j][0] == 1) {
				if (aliensDirectionLeft) {
					left = true;
					aliensDirectionLeft = false;
				}
			}
			if (grids[j][conf.getWidth() - 1] == 1) {
				if (!aliensDirectionLeft) {
					right = true;
					aliensDirectionLeft = true;
				}
			}
		}
		if (left || right) {
			for (int i = 0; i < conf.getWidth(); i++) {
				for (int k = conf.getHeight() - 1; k > 0; k--) {
					if (grids[k - 1][i] == 1) {
						grids[k - 1][i] = 0;
						grids[k][i] = 1;
					} else {
						if (grids[k][i] == 1 && grids[k - 1][i] == 0) {
							grids[k][i] = 0;
						}
					}
				}
			}
			for (int i = 0; i < conf.getWidth(); i++) {
				if (grids[conf.getHeight() - 1][i] == 1) {
					return true;
				}
			}
		} else {
			List<Point> list = new ArrayList<Point>();
			if (aliensDirectionLeft) {
				for (int i = 0; i < conf.getWidth() - 1; i++) {
					for (int k = 0; k < conf.getHeight(); k++) {
						if (grids[k][i + 1] == 1) {
							if(grids[k][i] == 4){
								list.add(new Point(i,k));
							}
							grids[k][i + 1] = 0;
							grids[k][i] = 1;
						} else {
							if (grids[k][i] == 1 && grids[k][i + 1] == 0) {
								grids[k][i] = 0;
							}
						}
					}
				}
			} else {
				for (int i = conf.getWidth() - 1; i > 0; i--) {
					for (int k = 0; k < conf.getHeight(); k++) {
						if (grids[k][i - 1] == 1) {
							if(grids[k][i] == 4){
								list.add(new Point(i,k));
							}
							grids[k][i - 1] = 0;
							grids[k][i] = 1;
						} else {
							if (grids[k][i] == 1 && grids[k][i - 1] == 0) {
								grids[k][i] = 0;
							}
						}
					}
				}
			}
			for(Point p : list){
				grids[p.getY()][p.getX()] = 0;
				bulletList.deleteNode(p);
			}
		}
		return false;
	}

	/**
	 * This method moves the bullets
	 * @return if the hero is killed once
	 */
	public boolean moveBullets() {
		boolean heroKilled = false;
		//UP BULLET
		for (int i = 0; i < conf.getWidth(); i++) {
			for (int j = 0; j < conf.getHeight(); j++) {
				if (grids[j][i] == 4) {
					int end = j - conf.getBullet_steps_one_turn();
					if (end < 0) {
						end = 0;
					}

					boolean alienKilled = false;
					for (int k = j; k >= end; k--) {
						if (grids[k][i] == 1 || grids[k][i] == 2 || grids[k][i] == 5) {
							grids[k][i] = 0;
							if(grids[k][i] == 5){
								bulletList.deleteNode(new Point(i,k));
							}
							alienKilled = true;
							break;
						}
					}
					if(!alienKilled){
						for(int ii = 1;ii<=conf.getBullet_steps_one_turn();ii++){
							if(end-ii>=0&&grids[end-ii][i] == 5){
								bulletList.deleteNode(new Point(i,end-ii));
								grids[end-ii][i] = 0;
								alienKilled = true;
								break;
							}
						}
					}
					if (j - conf.getBullet_steps_one_turn() >= 0) {
						if (!alienKilled) {
							grids[end][i] = 4;
							bulletList.addNode(new Point(i,end));
						}
					}
					bulletList.deleteNode(new Point(i, j));
					grids[j][i] = 0;
				}
			}
		}
		//DOWN BULLET
		for (int i = 0; i < conf.getWidth(); i++) {
			for (int j = conf.getHeight() - 1; j >= 0; j--) {
				if (grids[j][i] == 5) {
					int end = j + conf.getBullet_steps_one_turn();
					if (end >= conf.getHeight()) {
						end = conf.getHeight() - 1;
					}

					boolean killed = false;
					for (int k = j; k <= end; k++) {
						if (grids[k][i] == 3 || grids[k][i] == 2 || grids[k][i] == 4) {
							if (grids[k][i] == 3) {
								heroKilled = true;
							}
							if(!heroKilled){
								if(grids[k][i] == 4){
									bulletList.deleteNode(new Point(i,k));
								}
								grids[k][i] = 0;
							}
							killed = true;
							break;
						}
					}
					if (j + conf.getBullet_steps_one_turn() < conf.getHeight()) {
						if (!killed) {
							grids[end][i] = 5;
							bulletList.addNode(new Point(i,end));
						}
					}
					for(int m = 0;m<=end;m++){
						if(grids[m][i] == 4){
							bulletList.deleteNode(new Point(i,m));
							grids[m][i] = 0;
							grids[end][i] = 0;
							heroKilled = false;
							break;
						}
					}
					bulletList.deleteNode(new Point(i,j));
					grids[j][i] = 0;
				}
			}
		}
		return heroKilled;
	}

	/**
	 * This method checks whether the hero wins
	 * @return if the hero wins
	 */
	public boolean checkWin() {
		boolean win = true;
		for (int i = 0; i < conf.getWidth(); i++) {
			for (int j = 0; j < conf.getHeight(); j++) {
				if (grids[j][i] == 1) {
					win = false;
				}
			}
		}
		return win;
	}

}
