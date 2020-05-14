package com.example.util;

public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(){
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() { return data; }

    public void setData(T newData){
        this.data = newData;
    }

    public void setNext(Node<T> newNext){
        this.next = newNext;
    }

    public Node<T> getNext() {
        return next;
    }
}
