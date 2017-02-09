/**
 * @author huangshengwei
 * @studentID 1475765
 */
package model;
/**
 * 
 * @author 
 * This class represents the linkedlist
 *
 */
public class LinkedList {
	private Node header;
	public LinkedList(){
		this.header = new Node();
		this.header.setNext(null);
	}
	
	/**
	 * 
	 * @return the header node
	 */
	public Node getHeader() {
		return header;
	}
	
	/**
	 * 
	 * @param header  the header node to set
	 */
	public void setHeader(Node header) {
		this.header = header;
	}
	
	/**
	 * 
	 * @param p the point to add
	 */
	public void addNode(Point p){
		Node t = header;
		while(t.getNext()!=null){
			t = t.getNext();
		}
		Node node = new Node(p,null);
		t.setNext(node);
	}
	/**
	 * 
	 * @param p the point to delete
	 */
	public void deleteNode(Point p){
		Node t = header;
		while(t.getNext()!=null){
			if(t.getNext().getP().equals(p)){
				Node n = t.getNext().getNext();
				t.setNext(n);
				break;
			}
			t = t.getNext();
		}
	}
}
