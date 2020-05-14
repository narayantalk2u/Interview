package com.example.linkedlist;

import com.example.util.Node;

public class NodeDto {
    Node<Integer> node;
    Boolean status;

    public Node<Integer> getNode() {
        return node;
    }

    public void setNode(Node<Integer> node) {
        this.node = node;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
