public class DLList<E>{
	private Node<E> head,tail;
	private int size;
	public DLList(){
		this.size =0;
		this.head = new Node<E>(null);
		this.tail = new Node<E>(null);
		this.head.setNext(tail);
		this.head.setPrev(null);
		this.tail.setNext(null);
		this.tail.setPrev(head);
	}
	private Node<E> getNode(int index){
		Node<E> current;
		if(index<size/2){
			current = head.next();
			for(int i =0;i<index;i++){
				current = current.next();
			}
			return current;
		}else{
			current = tail.prev();
			for(int i = size-1;i>index;i--){
				current = current.prev();
			}
			return current;
		}
	}
	public void add(E data){
		Node<E> one = new Node<E>(data);
		Node<E> two = this.tail.prev();
		two.setNext(one);
		this.tail.setPrev(one);
		one.setNext(tail);
		one.setPrev(two);
	}
	public E get(int index){
		return getNode(index).get();
	}
	public void remove(E data){
		Node<E> current = this.head.next();
		int index =0;
		while(current.next()!=null){
			if(current.get().equals(data)){
				Node<E> two = getNode(index);
				Node<E> one = two.prev();
				Node<E> three = two.next();
				one.setNext(three);
				three.setPrev(one);
				size--;
			}
			index++;
			current = current.next();
		}
	}
	public String toString(){

	}
	public int size(){
		return this.size;
	}
}