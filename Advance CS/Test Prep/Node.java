public class Node<E>{
  private E data;
  private Node<E> parent;
  private Node<E> left;
  private Node<E> right;
  public Node(E data){
    this.data=data;
    left=null;
    right=null;
  }
  public E get(){
    return data;
  }
  public Node<E>  getLeft(){
    return left;
  }
  public Node<E> getRight(){
    return right;
  }
  public Node<E> getParent(){
    return parent;
  }
  public void setParent(Node<E> n){
    parent=n;
  }
  public void setLeft(Node<E> n){
    left=n;
  }
  public void setRight(Node<E> n){
    right=n;
  }
  public void set(E data){
    this.data=data;
  }
}










//public class Node<E>{
//   private E data;
//   private Node<E> left;
//   private Node<E> right;
//
//   public Node(E data){
//     this.data = data;
//     left = null;
//     right = null;
//   }
//
//   public E get(){
//     return data;
//   }
//
//   public Node<E> getLeft(){
//     return left;
//   }
//
//   public Node<E> getRight(){
//     return right;
//   }
//
//   public void setLeft(Node<E> data){
//     left = data;
//   }
//
//   public void setRight(Node<E> data){
//     right = data;
//   }
//   public void set(E data){
//     this.data =data;
//   }
// }
