public class DLList<E>{
	private Node<E> head,tail;
	private int size;
	public DLList(){
		head = new Node<E>(null);
		tail = new Node<E>(null);
		size = 0;
		head.setNext(tail);
		tail.setPrevious(head);
	}
	private Node<E> getNode(int index){
		Node<E> current;
		if(index< size/2){
			current = head.next();
			for(int i =0;i< index;i++){
				current = current.next();
			}
			return current;
		}else{
			current = tail.previous();
			for(int i = size-1; i > index; i--){
				current = current.previous();
			}
			return current;
		}
	}
	public void add(E data){
		Node<E> two = new Node<E>(data);
	    Node<E> one = tail.previous();
	    one.setNext(two);
	    two.setNext(tail);
	    tail.setPrevious(two);
	    two.setPrevious(one);
	    size++;
	}
	public void add(int index,E data){
		Node<E> one = getNode(index).previous();
		Node<E> two = new Node<E>(data);
		Node<E> three = one.next();
		one.setNext(two);
		two.setNext(three);
		three.setPrevious(two);
		two.setPrevious(one);
		size++;
	}
	public E get(int index){
		return getNode(index).get();
	}
	public void remove(int index){
		Node<E> two = getNode(index);
		Node<E> one = two.previous();
		Node<E> three = two.next();
		one.setNext(three);
		three.setPrevious(one);
		size--;
	}
	public void remove(E data){
		Node<E> current = head.next();
		int index = 0;
		while(current.next()!=null){
			if(current.get().equals(data)){
				remove(index);
				break;
			}
			current = current.next();
		}
	}
	public void set(int index, E data){
		getNode(index).setData(data);
	}
	public int size(){
		return size;
	}
	public void reverse(){
		Node<E> temp = head;
		head = tail;
		head.setNext(head.previous());
		Node<E> current = head;
		while(current.previous()!=null){
			current.setNext(current.previous());
			current = current.previous();
		}
		current.setNext(temp);
		temp.setPrevious(current);
		temp.setNext(null);
	}
}