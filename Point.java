/**
 * @author huangshengwei
 * @studentID 1475765
 */
package model;

/**
 * 
 * @author 
 * This class represents a point int the level
 */
public class Point {
	private int x;
	private int y;
	
	/**
	 * 
	 * @return the x position of the point
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @param x the x position to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return the y position of the point
	 */
	public int getY() {
		return y;
	}
	/**
	 * 
	 * @param y the y position of the point to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode(){
		return (x+y)%100;
	}
	
	@Override
	public boolean equals(Object o){
		Point p = (Point)o;
		return p.x == this.x && p.y == this.y;
	}
}
