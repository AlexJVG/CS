public class Node<E>{
	private E data;
	private Node<E> next;
	private Node<E> previous;
	public Node(E data){
		this.data = data;
		next = null;
		previous = null;
	}
	public void setData(E data){
		this.data = data;
	}
	public E get(){
		return data;
	}
	public Node<E> next(){
		return next;
	}
	public Node<E> previous(){
		return previous;
	}
	public void setNext(Node<E> next){
		this.next = next;
	}
	public void setPrevious(Node<E> previous){
		this.previous = previous;
	}
}