public class BinarySearchTree<E extends Comparable<E>>{
  private Node<E> root;
  private String str = "";
  private int treeHeight = 0;

  public BinarySearchTree() {}

  public void add(E data) {
    if (root == null) {
      root = new Node<E>(data);
      return;
    } else {
      add(data, root);
    }
  }

  private void add(E data, Node<E> current) {
    if (current.get().compareTo(data) < 0) {
      if (current.getRight() == null) {
        current.setRight(new Node<E>(data));
      } else {
        current.getRight().setParent(current);
        add(data, current.getRight());
      }
    } else {
      if (current.getLeft() == null) {
        current.setLeft(new Node<E>(data));
      } else {
        current.getLeft().setParent(current);
        add(data, current.getLeft());
      }
    }
  }

  public String toString() {
    str = "";
    toString(root);

    return str;
  }

  private void toString(Node<E> current) {
    if (current != null) {
	    toString(current.getLeft());
	    str += current.get() + " ";
	    toString(current.getRight());
    }
  }

  public String toStringPreOrder() {
    str = "";
    toStringPreOrder(root);

    return str;
  }

  public void toStringPreOrder(Node<E> current) {
    if (current != null) {
      str += current.get() + " ";
      toStringPreOrder(current.getLeft());
      toStringPreOrder(current.getRight());
    }
  }

  public boolean contains(E data) {
    return contains(data, root);
  }

  private boolean contains(E data, Node<E> current) {
    if (current.get().equals(data)) {
      return true;
    }

    if (current.get().compareTo(data) > 0) {
      if (current.getLeft() == null) {
        return false;
      }

      return contains(data, current.getLeft());
    } else  {
      if (current.getRight() == null) {
        return false;
      }

      return contains(data, current.getRight());
    }
  }

  public void remove(E data) {
    if (contains(data)) {
      remove(data, root, null);
    }
  }

  private void remove(E data, Node<E> current, Node<E> parent) {

    if (current.get().equals(data)) {

      if (current.getLeft() == null && current.getRight() == null) {
        if (parent == null) {
          root = null;
          return;
        }

        if (parent.getRight().get().equals(data)) {
          parent.setRight(null);
        } else {
          parent.setLeft(null);
        }
      } else if (current.getLeft() == null && current.getRight() != null) {
        if (parent == null) {
          root = current.getRight();
          return;
        }


        if (parent.getRight().get().equals(data)) {
          parent.setRight(current.getRight());
        } else {
          parent.setLeft(current.getRight());
        }
      } else if (current.getLeft() != null && current.getRight() == null) {

        if (parent == null) {
          root = current.getLeft();
          return;
        }

        if (parent.getRight().get().equals(data)) {
          parent.setRight(current.getLeft());
        } else {
          parent.setLeft(current.getLeft());
        }
      } else if (current.getLeft() != null && current.getRight() != null) {
        Node<E> smallest = findSmallestAndDelete(data, current.getRight(), current);
        current.set(smallest.get());


      }

    } else {

      if (current.get().compareTo(data) > 0) {
        remove(data, current.getLeft(), current);
      } else  {
        remove(data, current.getRight(), current);
      }

    }
  }

  public Node<E> findSmallestAndDelete(E data, Node<E> current, Node<E> parent) {
    if (current.getLeft() != null) {
      return findSmallestAndDelete(data, current.getLeft(), current);
    }

    if (parent.get().equals(data)) {
      parent.setRight(null);
    } else {
      parent.setLeft(null);
    }
    return current;
  }

  public int findTreeHeight(){
    return findTreeHeightRec(root);
  }

  public int findTreeHeightRec(Node<E> current){
    if (current == null)
            return -1;
        else
        {
            int lDepth = findTreeHeightRec(current.getLeft());
            int rDepth = findTreeHeightRec(current.getRight());
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
  }
}





















// public class BinarySearchTree<E extends Comparable<E>>{
//   private Node<E> root;
//   private String str = "";
//
//   public BinarySearchTree() {}
//
//   public void add(E data) {
//     if (root == null) {
//       root = new Node<E>(data);
//       return;
//     } else {
//       add(data, root);
//     }
//   }
//
//   private void add(E data, Node<E> current) {
//     if (current.get().compareTo(data) < 0) {
//       if (current.getRight() == null) {
//         current.setRight(new Node<E>(data));
//       } else {
//         add(data, current.getRight());
//       }
//     } else {
//       if (current.getLeft() == null) {
//         current.setLeft(new Node<E>(data));
//       } else {
//         add(data, current.getLeft());
//       }
//     }
//   }
//
//   public String toString() {
//     str = "";
//     toString(root);
//
//     return str;
//   }
//
//   private void toString(Node<E> current) {
//     if (current != null) {
// 	    toString(current.getLeft());
// 	    str += current.get() + " ";
// 	    toString(current.getRight());
//     }
//   }
//
//   public String toStringPreOrder() {
//     str = "";
//     toStringPreOrder(root);
//
//     return str;
//   }
//
//   public void toStringPreOrder(Node<E> current) {
//     if (current != null) {
//       str += current.get() + " ";
//       toStringPreOrder(current.getLeft());
//       toStringPreOrder(current.getRight());
//     }
//   }
//
//   public boolean contains(E data) {
//     return contains(data, root);
//   }
//
//   private boolean contains(E data, Node<E> current) {
//     if (current.get().equals(data)) {
//       return true;
//     }
//
//     if (current.get().compareTo(data) > 0) {
//       if (current.getLeft() == null) {
//         return false;
//       }
//
//       return contains(data, current.getLeft());
//     } else  {
//       if (current.getRight() == null) {
//         return false;
//       }
//
//       return contains(data, current.getRight());
//     }
//   }
//
//   public void remove(E data) {
//     if (contains(data)) {
//       remove(data, root, null);
//     }
//   }
//
//   private void remove(E data, Node<E> current, Node<E> parent) {
//
//     if (current.get().equals(data)) {
//
//       if (current.getLeft() == null && current.getRight() == null) {
//         if (parent == null) {
//           root = null;
//           return;
//         }
//
//         if (parent.getRight().get().equals(data)) {
//           parent.setRight(null);
//         } else {
//           parent.setLeft(null);
//         }
//       } else if (current.getLeft() == null && current.getRight() != null) {
//         if (parent == null) {
//           root = current.getRight();
//           return;
//         }
//
//
//         if (parent.getRight().get().equals(data)) {
//           parent.setRight(current.getRight());
//         } else {
//           parent.setLeft(current.getRight());
//         }
//       } else if (current.getLeft() != null && current.getRight() == null) {
//
//         if (parent == null) {
//           root = current.getLeft();
//           return;
//         }
//
//         if (parent.getRight().get().equals(data)) {
//           parent.setRight(current.getLeft());
//         } else {
//           parent.setLeft(current.getLeft());
//         }
//       } else if (current.getLeft() != null && current.getRight() != null) {
//         Node<E> smallest = findSmallestAndDelete(data, current.getRight(), current);
//         current.set(smallest.get());
//
//
//       }
//
//     } else {
//
//       if (current.get().compareTo(data) > 0) {
//         remove(data, current.getLeft(), current);
//       } else  {
//         remove(data, current.getRight(), current);
//       }
//
//     }
//   }
//
//   public Node<E> findSmallestAndDelete(E data, Node<E> current, Node<E> parent) {
//     if (current.getLeft() != null) {
//       return findSmallestAndDelete(data, current.getLeft(), current);
//     }
//
//     if (parent.get().equals(data)) {
//       parent.setRight(null);
//     } else {
//       parent.setLeft(null);
//     }
//     return current;
//   }
// }
//
