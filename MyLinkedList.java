/*
 * A simple linked list implementation. The main attraction I shall say is the remove the kth 
 * element from the end, given the last element is the 0th element from last
 */
class LinkedList<E> {

  Node<E> head = null;

  public void add(E data){
    if (head == null){
      head = new Node<E>(data);
      return;
    }
    //we add new nodes at the start as this is a constant time operation
    Node<E> node = new Node<E>(data);
    node.next = head;
    head = node;
  }
  public boolean remove(E data){
    //If the linkedlist is uninitialized
    if (head ==null)
      return false;
    //If the head element is to be deleted
    if (head.data == data){
      head = head.next;
      return true;
    }
    Node<E> node = head;
    while(node.next != null){
      if (node.next.data == data){
        node.next = node.next.next;
        return true;
      }
      node = node.next;
    }
    return false;
  }
  //Thhe key method here is the next one. It deletes the kth node from the end
  //It is assumed that the last node is the 0th node;
  //Therfore if we have to delete the third node from the end in the list [0, 1, 2, 3, 4, 5]
  //then it is the node with value 2
  public E removeKthFromLast(int k) throws IllegalArgumentException{
    if (k < 0)
      throw new IllegalArgumentException("The argument should be a non negative number not "+ k);
    Node<E> first = head;
    Node<E> second = head;
    if (head == null)
      return null;
    for (int offset=0; offset<k; offset++) {
      if (second.next != null)
          second = second.next;
      else
        return null;
    }
    if (second.next == null){
      E d = first.data;
      head = head.next;
      return d;
    }

    second = second.next;
    while (second.next != null){
      second = second.next;
      first = first.next;
    }
    //Now first.next should point to the element ot be deleted
    E d = first.next.data;
    first.next = first.next.next;
    return d;
  }
  public void printAll(){
    Node<E> node = head;
    while(node != null){
      System.out.print("-->"+node.data);
      node = node.next;
    }
    System.out.println();
  }
  private static class Node<E>{
    Node<E> next;
    E data;
    Node(E data){
      this.data = data;
      this.next = null;
    }
    }
  }

  public class MyLinkedList{
    public static void main(String[] args){
      LinkedList<Integer> list = new LinkedList<Integer>();
      list.add(5);
      list.add(4);
      list.add(3);
    list.add(2);
      list.add(1);
    list.add(0);
    list.printAll(); // [0 1 2 3 4 5]
    System.out.println("---------------------------------------------------------");
    System.out.println(list.removeKthFromLast(3));
    list.printAll(); //[0 1 3 4 5]
    System.out.println("---------------------------------------------------------");
    System.out.println(list.removeKthFromLast(4));
    list.printAll(); // [1 3 4 5]
    System.out.println("---------------------------------------------------------");
    System.out.println(list.removeKthFromLast(0)); //[1 3 4]
    list.printAll();
  }
}
