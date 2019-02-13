public class DLList{
  private Node head,tail;
  private int size;

  public DLList(){
    head = new Node(null);
		tail = new Node(null);
		size = 0;
		head.setNext(tail);
		tail.setPrevious(head);
  }

  private Node getNode(int index){
		Node current;
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

  public void add(Word data){
    Node two = new Node(data);
    Node one = tail.previous();
    one.setNext(two);
    two.setNext(tail);
    tail.setPrevious(two);
    two.setPrevious(one);
    size++;
  }

  public String toString(){
    String returnString = "";
    Node current = head.next();
    while(current.next()!=null){
      returnString+=current.get().toString()+" ";
      current = current.next();
    }
    return returnString;
  }
}