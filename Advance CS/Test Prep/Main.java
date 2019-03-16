class Main {
  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.add(91);
    tree.add(80);
    tree.add(100);
    tree.add(98);
    tree.add(99);
    tree.add(110);
    System.out.println(tree);
    System.out.println(tree.toStringPreOrder());
    System.out.println(tree.findTreeHeight());
    tree = new BinarySearchTree<>();
    tree.add(90);
    tree.add(100);
    tree.add(98);
    tree.add(110);
    System.out.println(tree);
    System.out.println(tree.toStringPreOrder());
    System.out.println(tree.findTreeHeight());
  }
}
