public class Node{
	private Word data;
	private Node next;
	private Node previous;
	public Node(Word data){
		this.data = data;
		next = null;
		previous = null;
	}
	public Word get(){
		return data;
	}
	public Node next(){
		return next;
	}
	public Node previous(){
		return previous;
	}
	public void setNext(Node next){
		this.next = next;
	}
	public void setPrevious(Node previous){
		this.previous = previous;
	}
}