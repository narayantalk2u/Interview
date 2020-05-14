package com.example.linkedlist;

import com.example.util.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @Test
    void createList() {
    }

    @Test
    void display() {
        Integer arr[] = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        SingleLinkedList testObj = new SingleLinkedList();
        testObj.display(testObj.createList(arr));
    }

    @Test
    void reverseList() {
        Integer arr[] = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        SingleLinkedList testObj = new SingleLinkedList();
        Node<Integer> root = testObj.createList(arr);
        testObj.display(root);

        root = testObj.reverseList(root);
        testObj.display(root);

        root = testObj.reverseListRecursion(root);
        testObj.display(root);
    }
}