package com.example.tree;

import com.example.util.TreeNode;

public class BinaryTreeIdentical {
    public Boolean isIdentical(TreeNode<Integer> root1,TreeNode<Integer> root2){
        if(root1 == null && root2 == null){
            return Boolean.TRUE;
        }
        if(root1 != null && root2 != null){
            return root1.getData() == root2.getData() &&
            isIdentical(root1.getLeft(),root2.getLeft())&&
            isIdentical(root1.getRight(),root2.getRight());
        }
        return Boolean.FALSE;
    }

}
