public class DLList<E extends Comparable<E>>{
  private Node<E> dummy;
  private int size;

  public DLList(){
    dummy = new Node<E>(null);
    dummy.setNext(dummy);
    dummy.setPrev(dummy);
    size = 0;
  }

  private Node<E> getNode(int index){
    Node<E> current;
    if(index<size/2){
      current = dummy.next();
      for (int i = 0; i < index; i++) {
       current = current.next();
     }
     return current;
    }else{
      current = dummy.prev();
      for (int i = size - 1; i > index; i--) {
        current = current.prev();
      }
      return current;
    }
  }
  public int size(){
    return size;
  }
  public void add(E data){
    Node<E> temp = new Node<>(data);
    if(dummy.next()==dummy){
      dummy.setNext(temp);
      dummy.setPrev(temp);
      temp.setNext(dummy);
      temp.setPrev(dummy);
      size++;
    }else{
      Node<E> current = dummy.next();
      boolean added = false;
      int theSize = size();
      System.out.println("My size " + theSize);
      for(int i =0; i< theSize;i++){
        System.out.println(temp.get().compareTo(current.get()));
        System.out.println("Inside " + ((Task)temp.get()).getName());
        System.out.println("Insidec " + ((Task)current.get()).getName());
        if(temp.get().compareTo(current.get())<0){
          temp.setNext(current);
          temp.setPrev(current.prev());
          current.prev().setNext(temp);
          current.setPrev(temp);
          size++;
          added = true;
          System.out.println("here added");
          break;
        }else{
          current = current.next();
        }
      }
      if(!added){

          System.out.println("NNNNN added");
            current = current.prev();
        System.out.println("=Added " + ((Task)current.get()));
          temp.setNext(current.next());
          temp.setPrev(current);
          current.setNext(temp);
          size++;
        }
    }
    System.out.println(toString());
  }
  public E get(int index){
    return getNode(index).get();
  }
  public void remove(int index){
    Node<E> current = getNode(index);
    Node<E> one = current.prev();
    Node<E> two = current.next();
    one.setNext(two);
    two.setPrev(one);
    current.setPrev(null);
    current.setNext(null);
    size--;
  }
  public void remove(E data){
    Node<E> temp = new Node<E>(data);
    Node<E> current = dummy;
    for(int i =0;i<size();i++){
      if(current.get().compareTo(temp.get())==0){
        remove(i);
      }
    }
  }
  public void set(int index, E data){
    getNode(index).setData(data);
  }
  public void update(E data){
    Node<E> temp = new Node<E>(data);
    Node<E> current = dummy;
    for(int i =0;i<size();i++){
      if(current.get().compareTo(temp.get())==0){
        current.setData(data);
      }
    }
  }
  public String toString(){
    String returnString = "";
    Node<E> current = dummy.next();
    System.out.println("Size in toS " + size());
    for(int i = 0; i < size();i++){
      returnString += current.get().toString();
      current = current.next();
    }
    return returnString;
  }
}