package com.example.tree;

import com.example.util.TreeNode;

public class InorderSuccessor {

    boolean nodeFind = false;
    public <T> TreeNode<T> inorderSuccessor(TreeNode<T> root, TreeNode<T> x){

        if(x.getRight() != null){
            TreeNode<T> solNode = leftMostNode(x.getRight());
            return solNode;
        }
        return null;
    }

    public <T> TreeNode<T> leftMostNode(TreeNode<T> x){
        while(x.getLeft() != null){
            x.setLeft(x.getLeft());
        }
        nodeFind = true;
        return x;
    }
}
