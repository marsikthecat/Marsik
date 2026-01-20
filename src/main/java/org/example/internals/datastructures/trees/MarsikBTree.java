package org.example.internals.datastructures.trees;

public class MarsikBTree<T extends Comparable<T>> {

  private BNode<T> root;

  private void insertData(BNode<T> node, T data){
    int index = node.getSize();
    for (int i = node.getSize() - 1; i > -1; i--){
      T d = node.getData()[i];
      if (data.compareTo(d) < 0) {
        node.setData(node.getData()[i], i+1);;
        index = i;
      } else {
        break;
      }
    }
    node.setData(data, index);
    node.setSize(node.getSize() + 1);
  }

  @SuppressWarnings("unchecked")
  private BNode<T> splitNode(BNode<T> node, T key){
    int mid = node.getSize() / 2;
    int t = 3;
    BNode<T> node1 = new BNode<>(t);
    BNode<T> node2 = new BNode<>(t);
    BNode<T> parent = node.getParent();

    for (int i = 0; i < mid; i++) {
      node1.setData(node.getData()[i], i);
      node1.setChildren(node.getChildren()[i], i);
      node1.setSize(node1.getSize() + 1);
    }
    node1.setChildren(node.getChildren()[mid], mid);
    int j = 0;
    for (int i = mid+1; i < node.getSize(); i++){
      node2.setData(node.getData()[i], j);
      node2.setChildren(node.getChildren()[i], j);
      node2.setSize(node2.getSize() + 1);
      j++;
    }
    node2.setChildren(node.getChildren()[node.getSize()], mid);

    node1.setLeaf(node.isLeaf());
    node2.setLeaf(node.isLeaf());

    if (parent == null) {
      T temp = node.getData()[mid];
      node.setData((T[]) new Comparable[2 * t - 1]);
      node.setData(temp, 0);
      node.setSize(1);
      node.setLeaf(false);
      node.setChildren(node1, 0);
      node.setChildren(node2, 1);
      node1.setParent(node);
      node2.setParent(node);

      return key.compareTo(temp) > 0 ? node2 : node1;
    }
    int index = parent.getSize();
    T data = node.getData()[mid];
    for (int i = parent.getSize() - 1; i > -1; i--) {
      if (data.compareTo(parent.getData()[i]) < 0){
        parent.setData(parent.getData()[i], i + 1);
        parent.setChildren(parent.getChildren()[i + 1], i + 2);
        index = i;
      } else {
        break;
      }
    }
    parent.setData(data, index);
    parent.setChildren(node1, index);
    parent.setChildren(node2, index + 1);
    parent.setSize(parent.getSize() + 1);
    node1.setParent(parent);
    node2.setParent(parent);
    return key.compareTo(data) > 0 ? node2 : node1;
  }

  public void display(BNode<T> node, int level){
    if(node == null) {
      return;
    }
    System.out.println("Level : " + level + " " + "Data : ");
    for (int i = 0; i < node.getSize(); i++){
      System.out.println(node.getData()[i] + " ");
    }
    System.out.println(" ");
    if (node.isLeaf()){
      return;
    }
    for (int i = 0; i < node.getSize() + 1; i++){
      display(node.getChildren()[i],level+1);
    }
  }
}