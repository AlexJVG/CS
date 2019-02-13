public class DLList<E>{
	private Node<E> head,tail;
	private int size;
	public DLList(){
		this.size=0;
		this.head = new Node<E>(null);
		this.tail = new Node<E>(null);
		head.setNext(tail);
		tail.setNext(null);
		tail.setPrev(head);
		head.setPrev(null);
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
		Node<E> two = tail.prev();
		one.setNext(tail);
		two.setNext(one);
		one.setPrev(two);
		tail.setPrev(one);
		size++;
	}
	public void add(int index,E data){
		Node<E> one = getNode(index).prev();
		Node<E> two = new Node<E>(data);
		Node<E> three = one.next();
		one.setNext(two);
		two.setPrev(one);
		three.setPrev(two);
		two.setNext(three);
		size++;
	}
	public E get(int index){
		return getNode(index).get();
	}
	public void set(int index,E data){
		getNode(index).setData(data);
	}
	public void remove(int index){
		Node<E> two = getNode(index);
		Node<E> one = two.prev();
		Node<E> three = two.next();
		one.setNext(three);
		three.setPrev(one);
		size--;
	}
	public boolean remove(E data){
		Node<E> current = head.next();
		int index =0;
		while(current.next()!=null){
			if(current.get().equals(data)){
				remove(index);
				return true;
			}
			index++;
			current = current.next();
		}
		return false;
	}
	public int size(){
		return size;
	}
	public boolean containsWater(int x, int y){
		// System.out.println("Size:"+size());
		Node<E> current = head.next();
		System.out.println("Wtesting");
		while(current.next()!=null){
			Article temp = (Article)current.get();
			// System.out.println(temp.getName());
			// System.out.println("X:"+temp.getX()+"Y:"+temp.getY());
			if(temp.getName().equals("Water")&&temp.getX()==x&&temp.getY()==y){
				System.out.println("true");
				System.out.println(temp.getX()+":"+temp.getY());
				return true;
			}
			current = current.next();
		}
		System.out.println("false");
		return false;
	}
	public boolean containsObject(int x,int y){
		Node<E> current = head.next();
		System.out.println("Otesting");
		while(current.next()!=null){
			Article temp = (Article)current.get();
			if((temp.getName().equals("Boulder")||temp.getName().equals("City")||temp.getName().equals("Tree"))&&temp.getX()==x&&temp.getY()==y){
				System.out.println("true");
				System.out.println(temp.getX()+":"+temp.getY());
				return true;
			}
			current = current.next();
		}
		System.out.println("false");
		return false;
	}
}
