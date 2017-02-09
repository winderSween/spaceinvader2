/**
 * @author huangshengwei
 * @studentID 1475765
 */
package conf;

public class BossLevelConf {
	private int width;//the width of the level
	private int height;//the height of the level
	private double alien_fire_rate;//the alien fire rate
	private int hero_lives;//num of hero lives
	private int boss_lives;//num of boss lives
	private int bullet_steps_one_turn;//how many steps a bullet move in one turn
	private int down_step;//how many step the boss move towards downside ont turn
	private String points;//the points of the boss 
	
	/**
	 * 
	 * @return the width of level
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * 
	 * @param width the width of level to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * 
	 * @return the height of the level
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * 
	 * @param height the height of the level to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * 
	 * @return the fire rate of alien
	 */
	public double getAlien_fire_rate() {
		return alien_fire_rate;
	}
	/**
	 * 
	 * @param alien_fire_rate the fire rate of alien to set
	 */
	public void setAlien_fire_rate(double alien_fire_rate) {
		this.alien_fire_rate = alien_fire_rate;
	}
	/**
	 * 
	 * @return num of hero lives
	 */
	public int getHero_lives() {
		return hero_lives;
	}
	/**
	 * 
	 * @param hero_lives num of hero lives to set
	 */
	public void setHero_lives(int hero_lives) {
		this.hero_lives = hero_lives;
	}
	/**
	 * 
	 * @return num of boss lives
	 */
	public int getBoss_lives() {
		return boss_lives;
	}
	/**
	 * 
	 * @param boss_lives num of boss lives to set
	 */
	public void setBoss_lives(int boss_lives) {
		this.boss_lives = boss_lives;
	}
	/**
	 * 
	 * @return  how many steps a bullet move in one turn
	 */
	public int getBullet_steps_one_turn() {
		return bullet_steps_one_turn;
	}
	/**
	 * 
	 * @param bullet_steps_one_turn how many steps a bullet move in one turn to set
	 */
	public void setBullet_steps_one_turn(int bullet_steps_one_turn) {
		this.bullet_steps_one_turn = bullet_steps_one_turn;
	}
	/**
	 * 
	 * @return how many step the boss move towards downside ont turn
	 */
	public int getDown_step() {
		return down_step;
	}
	/**
	 * 
	 * @param down_step how many step the boss move towards downside ont turn to set
	 */
	public void setDown_step(int down_step) {
		this.down_step = down_step;
	}
	/**
	 * 
	 * @return the points of the boss 
	 */
	public String getPoints() {
		return points;
	}
	/**
	 * 
	 * @param points the points of the boss to set
	 */
	public void setPoints(String points) {
		this.points = points;
	}
	
}
