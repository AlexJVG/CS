public class Node<E>{
	private E data;
	private Node<E> next,prev;
	public Node(E data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	public E get(){
		return this.data;
	}
	public Node<E> next(){
		return this.next;
	}
	public Node<E> prev(){
		return this.prev;
	}
	public void setNext(Node<E> next){
		this.next = next;
	}
	public void setPrev(Node<E> prev){
		this.prev = prev;
	}
	public void setData(E data){
		this.data =data;
	}
}