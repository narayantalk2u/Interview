package com.example.util;

public class CreateBST {

    public <T> TreeNode<T> createTree(T []arr){
        TreeNode<T> root = null;
        TreeNode<T> current = null;
        TreeNode<T> parrent = null;
        for(T elem:arr){
            TreeNode<T> newNode = new TreeNode<>(elem);
            if(root ==  null){
                root = newNode;
                current = newNode;
            }else{
                while(current != null){
                    parrent = current;
                    current = current.getLeft();
                }
                if(parrent.getLeft() == null){
                    parrent.setLeft(newNode);
                }else{
                    parrent.setRight(newNode);
                }
                if(parrent.getRight() == null){
                    current = parrent.getRight();
                }else {
                    current = parrent;
                }
            }
        }
        return root;
    }
}
