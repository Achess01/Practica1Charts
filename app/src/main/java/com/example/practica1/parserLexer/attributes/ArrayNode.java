/*
 * Welcome
 */
package com.example.practica1.parserLexer.attributes;

/**
 *
 * @author achess
 */
public class ArrayNode<T> {
    private T value;
    private ArrayNode<T> next;

    public ArrayNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ArrayNode<T> getNext() {
        return next;
    }

    public void setNext(ArrayNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if(next != null) return "value='" + value + "'\n" +next.toString();
        return "value='" + value + "'";
    }
    
    
}
