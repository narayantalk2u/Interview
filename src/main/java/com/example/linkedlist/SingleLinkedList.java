package com.example.linkedlist;

import com.example.util.Node;

import java.util.HashSet;

public class SingleLinkedList {
    private Node<Integer> root = null;

    public Node<Integer> createList(Integer arr[]) {
        Node<Integer> next = null;
        for (int elem : arr) {
            Node<Integer> newNode = new Node<Integer>(elem);
            if (root == null) {
                root = newNode;
                next = newNode;
            } else {
                next.setNext(newNode);
                next = next.getNext();
            }
        }
        return root;
    }

    public void display(Node<Integer> start) {
        Node<Integer> iterNode = start;
        while (iterNode != null) {
            System.out.print(iterNode.getData());
            if (iterNode.getNext() != null) {
                System.out.print("-->");
            }
            iterNode = iterNode.getNext();
        }
        System.out.println();
    }

    public Node<Integer> reverseList(Node<Integer> start) {
        Node<Integer> prev = null;
        Node<Integer> next = null;
        Node<Integer> cur = start;

        while (cur != null) {
            next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        start = prev;
        root = prev;
        return prev;
    }

    public Node<Integer> reverseListRecursion(Node<Integer> start) {
        if (start == null || start.getNext() == null) {
            return start;
        }
        Node<Integer> last = reverseList(start.getNext());
        start.getNext().setNext(start);
        start.setNext(null);
        root = last;
        return last;
    }

    /**
     * Remove a duplicate from single link list keeping only first occurence.
     * Solu-1 : Using HashSet
     */

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        if (head == null) {
            return head;
        }

        HashSet<Integer> dupSet = new HashSet<>();
        Node<Integer> curr = head;
        dupSet.add(curr.getData());

        while (curr.getNext() != null) {
            if (!dupSet.contains(curr.getNext().getData())) {
                // Element not found in map, let's add it.
                dupSet.add(curr.getNext().getData());
                curr = curr.getNext();
            } else {
                // Duplicate node found. Let's remove it from the list.
                curr.getNext().setNext(curr.getNext().getNext());
            }
        }
        return head;

    }

    /**
     * Remove a duplicate from single link list keeping only first occurence.
     * Solu-1 : Without Using HashSet
     * Additional Thoughts: The interviewer might say that we are not allowed to use any extra memory, i.e., the space
     * complexity of our algorithm should be O(1)O(1)O(1).
     *
     * We can take these approaches based on the requirements:
     *
     *     If we are allowed to change the order of the list, we can just sort the linked list in O(nlogn) time.
     *     After sorting, all duplicates must be adjacent and can be removed in a linear scan.
     *
     *     For each node in the linked list, do another scan of the preceding nodes to see if it already exists or not.
     *     The time complexity of this algorithm is O(n2)O(n^2)O(n​2​​) and does not require any extra space.
     */

    public static Node<Integer> removeDuplicatesNoExtraSpace(Node<Integer> head) {
        //to be implemented
       return null;

    }

    public int countNoOfNodes(Node<Integer> head){
        int noOfNodes = 0;
        while(head!=null){
            noOfNodes++;
            head = head.getNext();
        }
        return noOfNodes;
    }


}