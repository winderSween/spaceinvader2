/**
 * @author huangshengwei
 * @studentID 1475765
 */
package conf;

public class LevelConf {
	private int width;//the width of the level
	private int height;//the height of the level
	private int aliens_line_num;//how many aliens in one line
	private int aliens_one_line;//how many lines of alien
	private double alien_fire_rate;//the alien fire rate
	private int hero_lives;//num of hero lives
	private int bullet_steps_one_turn;//how many steps a bullet move in one turn
	/**
	 * 
	 * @return the width of the level
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * 
	 * @param width the width of the level to set
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
	 * @return how many aliens in one line
	 */
	public int getAliens_line_num() {
		return aliens_line_num;
	}
	/**
	 * 
	 * @param aliens_line_num how many aliens in one line to set
	 */ 
	public void setAliens_line_num(int aliens_line_num) {
		this.aliens_line_num = aliens_line_num;
	}
	/**
	 * 
	 * @return how many lines of alien
	 */
	public int getAliens_one_line() {
		return aliens_one_line;
	}
	/**
	 * 
	 * @param aliens_one_line how many lines of alien to set
	 */
	public void setAliens_one_line(int aliens_one_line) {
		this.aliens_one_line = aliens_one_line;
	}
	/**
	 * 
	 * @return the alien fire rate
	 */
	public double getAlien_fire_rate() {
		return alien_fire_rate;
	}
	/**
	 * 
	 * @param the alien fire rate to set
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
	 * @return how many steps a bullet move in one turn
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
	
}
