package com.personal.miniproject.simplecache;

/**
 * An implementation of a Doubly LinkedList
 * @param <E> Type of the element stored in the DLL node
 */
public class DoublyLinkedList<E> {

  // A dummy head node for the DLL
  private final DLLNode<E> _dummyHead;

  // A dummy tail node for the DLL
  private final DLLNode<E> _dummyTail;

  public DoublyLinkedList() {
    _dummyHead = new DLLNode<>(null);
    _dummyTail = new DLLNode<>(null);

    _dummyHead.setNext(_dummyTail);
    _dummyTail.setPrev(_dummyHead);
  }

  /**
   * Adds an element to the end of the DLL
   */
  public DLLNode<E> addLast(E element) {
    if (element == null) {
      throw new RuntimeException("Null is not a valid element");
    }
    DLLNode<E> node = new DLLNode<>(element);
    addNodeAtLast(node);
    return node;
  }

  /**
   * Adds a DLL node to the end of the list
   */
  public void addNodeAtLast(DLLNode<E> node) {
    DLLNode<E> tailPrev = _dummyTail.getPrev();
    tailPrev.setNext(node);
    node.setNext(_dummyTail);
    _dummyTail.setPrev(node);
    node.setPrev(tailPrev);
  }

  /**
   * Unlinks a DLL node from the list
   */
  public void unlinkNode(DLLNode<E> node) {
    if(node != null) {
      node.getPrev().setNext(node.getNext());
      node.getNext().setPrev(node.getPrev());
    }
  }

  /**
   * Returns if the list is empty or not
   */
  public boolean isEmpty() {
    return _dummyHead.getNext() == _dummyTail;
  }

  /**
   * Returns the first node from the list
   */
  public DLLNode<E> getFirstNode() {
    return isEmpty() ? null : _dummyHead.getNext();
  }

  /**
   * Returns the last node from the list
   */
  public DLLNode<E> getLastNode() {
    return isEmpty() ? null : _dummyHead.getNext();
  }

}
