package com.personal.miniproject.simplecache;

public class DoublyLinkedList<E> {

  private final DLLNode<E> _dummyHead;
  private final DLLNode<E> _dummyTail;

  public DoublyLinkedList() {
    _dummyHead = new DLLNode<>(null);
    _dummyTail = new DLLNode<>(null);

    _dummyHead.setNext(_dummyTail);
    _dummyTail.setPrev(_dummyHead);
  }

  public DLLNode<E> addLast(E element) {
    if (element == null) {
      throw new RuntimeException("Null is not a valid element");
    }
    DLLNode<E> node = new DLLNode<>(element);
    addNodeAtLast(node);
    return node;
  }

  public void addNodeAtLast(DLLNode<E> node) {
    DLLNode<E> tailPrev = _dummyTail.getPrev();
    tailPrev.setNext(node);
    node.setNext(_dummyTail);
    _dummyTail.setPrev(node);
    node.setPrev(tailPrev);
  }

  public void unlinkNode(DLLNode<E> node) {
    if(node != null) {
      node.getPrev().setNext(node.getNext());
      node.getNext().setPrev(node.getPrev());
    }
  }

  public boolean isEmpty() {
    return _dummyHead.getNext() == _dummyTail;
  }

  public DLLNode<E> getFirstNode() {
    return isEmpty() ? null : _dummyHead.getNext();
  }

  public DLLNode<E> getLastNode() {
    return isEmpty() ? null : _dummyHead.getNext();
  }

}
