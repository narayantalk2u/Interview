package com.example.linkedlist;

import com.example.util.Node;

public class LoopRemovalUtil {

    public NodeDto isLoopPresent(Node<Integer> root){

        Node<Integer> slow = root;
        Node<Integer> fast = root;
        NodeDto nodeDto = new NodeDto();
        while(slow!=null && fast!=null && fast.getNext()!=null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if(slow == fast){
                nodeDto.setNode(slow);
                nodeDto.setStatus(Boolean.TRUE);
                break;
            }
        }
        return nodeDto;
    }

    public void removeLoop(Node<Integer> root){
        NodeDto nodeDto = isLoopPresent(root);
        int noOfLoopNodes = 0;
        Node<Integer> prevPtr = root;
        Node<Integer> nextPtr = root;
        Node<Integer> lastPtr = root;
        if(nodeDto.getStatus()){
            noOfLoopNodes = getNoOfLoopNodes(nodeDto.getNode());
            while(noOfLoopNodes>=0){
                nextPtr = nextPtr.getNext();
                noOfLoopNodes--;
            }
            while(prevPtr!=nextPtr){
                lastPtr = prevPtr;
                prevPtr = prevPtr.getNext();
                nextPtr = nextPtr.getNext();
            }
            lastPtr.setNext(null);
        }
    }

    public int getNoOfLoopNodes(Node<Integer> loopNode){
        int noOfLoopNodes = 0;
        Node<Integer> prevPtr = loopNode;
        Node<Integer> nextPtr = loopNode;
        while (prevPtr.getNext() != nextPtr){
            prevPtr = prevPtr.getNext();
            noOfLoopNodes++;
        }
        return noOfLoopNodes;
    }


}
