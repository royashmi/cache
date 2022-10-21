package com.personal.miniproject.simplecache;

public class DLLNode<E> {

  private DLLNode<E> _next;
  private DLLNode<E> _prev;
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
