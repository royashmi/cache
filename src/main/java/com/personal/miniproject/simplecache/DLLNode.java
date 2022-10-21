package com.personal.miniproject.simplecache;

/**
 * An ADT representing a Doubly LinkedList Node
 */
public class DLLNode<E> {

  /**
   * Next pointer for the node
   */
  private DLLNode<E> _next;

  /**
   * Previous pointer for the node
   */
  private DLLNode<E> _prev;

  /**
   * Value of the element stored in the node
   */
  private final E _element;

  public DLLNode(E element) {
    _element = element;
    _next = null;
    _prev = null;
  }

  public DLLNode<E> getNext() {
    return _next;
  }

  public DLLNode<E> getPrev() {
    return _prev;
  }

  public void setNext(DLLNode<E> next) {
    _next = next;
  }

  public void setPrev(DLLNode<E> prev) {
    _prev = prev;
  }

  public E getElement() {
    return _element;
  }
}
