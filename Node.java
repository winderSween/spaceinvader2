/**
 * @author huangshengwei
 * @studentID 1475765
 */
package model;

/**
 * 
 * @author
 * This class represents a node in linkedlist
 */
public class Node {
	private Point p;
	private Node next;
	/**
	 * 
	 * @return the point in the node
	 */
	public Point getP() {
		return p;
	}
	/**
	 * 
	 * @param p the point to set
	 */
	public void setP(Point p) {
		this.p = p;
	}
	/**
	 * 
	 * @return the next node
	 */
	public Node getNext() {
		return next;
	}
	/**
	 * 
	 * @param next the next node to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	public Node(Point p, Node next) {
		super();
		this.p = p;
		this.next = next;
	}
	public Node(){
		
	}
}
