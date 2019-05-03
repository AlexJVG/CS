import java.io.Serializable;
public class Node<E> implements Serializable{
	private Node<E> left,right;
	private E data;
	private final static long serialVersionUID = 6529685098267757690L;
	public Node(E data){
		this.left = null;
		this.right = null;
		this.data=data;
	}
	public void setData(E data){
		this.data = data;
	}
	public void setLeft(Node<E> left){
		this.left = left;
	}
	public void setRight(Node<E> right){
		this.right=right;
	}
	public E get(){
		return this.data;
	}
	public Node<E> getLeft(){
		return this.left;
	}
	public Node<E> getRight(){
		return this.right;
	}
}