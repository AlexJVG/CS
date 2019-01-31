import java.util.*;
public class SLL{
  private Node head;
  private int listCount;
  private int sortTyped;

  public SLL(){
    head = null;
    listCount = 0;
    sortTyped = 3;
  }

  public void add(String item,double price){
    boolean itemFound = false;
    Node temp = new Node(new Item(item,price,1,new Date()));
    Node current = head;
    while(current.next() != null){
      current = current.next();
      if(current.getData().sameItem(temp.getData().getName(),temp.getData().getPrice())){
        itemFound=true;
        break;
      }
    }
    if(!itemFound){
      current.setNext(temp);
      listCount++;
    }else{
      current.getData().addItem();
    }
    sortType(sortTyped);
  }

  public void add(String item, double price,int index){
    boolean itemFound = false;
    Node temp = new Node(new Item(item,price,1,new Date()));
    Node current = head;
    for(int i =1; i < index&&current.next()!=null;i++){
      current = current.next();
      if(current.getData().sameItem(temp.getData().getName(),temp.getData().getPrice())){
        itemFound=true;
        break;
      }
    }
    if(!itemFound){
      temp.setNext(current.next());
      current.setNext(temp);
      listCount++;
    }else{
      current.getData().addItem();
    }
    sortType(sortTyped);
  }

  public void add(String item,double price,int quantity,Date date){
    Node temp = new Node(new Item(item,price,quantity,date));
    if(head==null){
      head = temp;
    }else{
      Node current = head;
      while(current.next() != null){
        current = current.next();
      }
      current.setNext(temp);
    }
    listCount++;
    sortType(sortTyped);
  }

  public Item get(int index){
    if(index<=0){
      return null;
    }
    Node current = head;
    for(int i = 1;i<index;i++){
      if(current.next()==null){
        return null;
      }
      current = current.next();
    }
    sortType(sortTyped);
    return current.getData();
  }

  public boolean remove(int index){
    if(index<1||index>size()){
      return false;
    }
    Node current = head;
    for(int i=1; i< index;i++){
      if(current.next()==null){
        return false;
      }
    }
    current.setNext(current.next().next());
    listCount--;
    sortType(sortTyped);
    return true;
  }

  public boolean remove(String name, double price){
    boolean itemFound = false;
    Node current = head;
    if (current == null) {
          return false;
      } else if (current.getData().sameItem(name,price)) {
          head = current.next();
          listCount--;
          sortType(sortTyped);
          return true;
      }
    while(true){
      Node next = current.next();
      if(next==null){
        return false;
      } else if(next.getData().sameItem(name,price)){
        break;
      }
      current = next;
    }
    Node next = current.next();
    current.setNext(next.next());
    next.setNext(null);
    listCount--;
    sortType(sortTyped);
    return true;
  }

  public Node mergeSortAZ(Node head){
    if(head == null||head.next()==null){
      return head;
    }

    Node middle = getMiddle(head);
    Node nextMiddle = middle.next();

    middle.setNext(null);

    Node left = mergeSortAZ(head);
    Node right = mergeSortAZ(nextMiddle);

    Node sortedList = sortedMerge(left,right);

    return sortedList;

  }

  public Node sortedMerge(Node a, Node b){
    Node result = null;
    if(a == null){
      return b;
    }if(b==null){
      return a;
    }

    if(b.getData().getName().compareTo(a.getData().getName())==0||b.getData().getName().compareTo(a.getData().getName())>=1){
      result=a;
      result.setNext(sortedMerge(a.next(),b));
    }else{
      result = b;
      result.setNext(sortedMerge(a,b.next()));
    }
    return result;
  }

  public Node getMiddle(Node head){
    if(head==null){
      return head;
    }
    Node slow=head;
    Node fast = head.next();

    while(fast!=null){
      fast = fast.next();
      if(fast!=null){
        fast = fast.next();
        slow = slow.next();
      }
    }
    return slow;
  }

  public Node mergeSortPrice(Node head){
    if(head == null||head.next()==null){
      return head;
    }

    Node middle = getMiddle(head);
    Node nextMiddle = middle.next();

    middle.setNext(null);

    Node left = mergeSortPrice(head);
    Node right = mergeSortPrice(nextMiddle);

    Node sortedList = sortedMergePrice(left,right);

    return sortedList;

  }

  public Node sortedMergePrice(Node a, Node b){
    Node result = null;
    if(a == null){
      return b;
    }if(b==null){
      return a;
    }

    if(b.getData().getPrice()>=a.getData().getPrice()){
      result=a;
      result.setNext(sortedMergePrice(a.next(),b));
    }else{
      result = b;
      result.setNext(sortedMergePrice(a,b.next()));
    }
    return result;
  }

  public Node mergeSortTime(Node head){
    if(head == null||head.next()==null){
      return head;
    }

    Node middle = getMiddle(head);
    Node nextMiddle = middle.next();

    middle.setNext(null);

    Node left = mergeSortTime(head);
    Node right = mergeSortTime(nextMiddle);

    Node sortedList = sortedMergeTime(left,right);

    return sortedList;

  }

  public Node sortedMergeTime(Node a, Node b){
    Node result = null;
    if(a == null){
      return b;
    }if(b==null){
      return a;
    }

    if(b.getData().getTime()>=a.getData().getTime()){
      result=a;
      result.setNext(sortedMergeTime(a.next(),b));
    }else{
      result = b;
      result.setNext(sortedMergeTime(a,b.next()));
    }
    return result;
  }

  public void sortType(int type){
    sortTyped = type;
    if(sortTyped==1){
      head = mergeSortPrice(head);
    }
    if(sortTyped==2){
      head = mergeSortAZ(head);
    }
    if(sortTyped==3){
      head = mergeSortTime(head);
    }
  }

  public int size(){
    return listCount;
  }
  public String toString() {
        Node current = head;
        String output = "";
        while (current != null) {
            output += "[" + current.getData().toString() + "]";
            current = current.next();
        }
        return output;
  }

  private class Node{
    private Item data;
    private Node next;

    public Node(Item data){
      this.next = null;
      this.data = data;
    }

    public Item getData(){
      return data;
    }

    public void setData(Item data){
      this.data = data;
    }

    public Node next(){
      return next;
    }

    public void setNext(Node next){
      this.next = next;
    }
}
}
