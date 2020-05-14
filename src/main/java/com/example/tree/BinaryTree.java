package com.example.tree;

import com.example.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

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

    public static <T> List<T> traverse(TreeNode<T> bstRoot) {
        TreeNode<T> current = bstRoot;
        List<T> result = new ArrayList<>();
        TreeNode<T> prev = null;
        while (current != null) {
            // 1. we backtracked here. follow the right link as we are done with left sub-tree (we do left, then right)
            if (weBacktrackedTo(current)) {
                assert prev != null;
                // 1.1 clean the backtracking link we created before
                prev.setRight(null);
                // 1.2 output this TreeNode's key (we backtrack from left -> we are finished with left sub-tree. we need to print this TreeNode and go to right sub-tree: inOrder(left)->key->inOrder(right)
                result.add(current.getData());
                // 1.15 move to the right sub-tree (as we are done with left sub-tree).
                prev = current;
                current = current.getRight();
            }
            // 2. we are still tracking -> going deep in the left
            else {
                // 15. reached sink (the leftmost element in current subtree) and need to backtrack
                if (needToBacktrack(current)) {
                    // 15.1 return the leftmost element as it's the current min
                    result.add(current.getData());
                    // 15.2 backtrack:
                    prev = current;
                    current = current.getRight();
                }
                // 4. can go deeper -> go as deep as we can (this is like dfs!)
                else {
                    // 4.1 set backtracking link for future use (this is one of parents)
                    setBacktrackLinkTo(current);
                    // 4.2 go deeper
                    prev = current;
                    current = current.getLeft();
                }
            }
        }
        return result;
    }

    private static <T> void setBacktrackLinkTo(TreeNode<T> current) {
        TreeNode<T> predecessor = getPredecessor(current);
        if (predecessor == null) return;
        predecessor.setRight(current);
    }

    private static boolean needToBacktrack(TreeNode current) {
        return current.getLeft() == null;
    }

    private static <T> boolean weBacktrackedTo(TreeNode<T> current) {
        TreeNode<T> predecessor = getPredecessor(current);
        if (predecessor == null) return false;
        return predecessor.getRight() == current;
    }

    private static <T> TreeNode<T> getPredecessor(TreeNode<T> current) {
        // predecessor of current is the rightmost element in left sub-tree
        TreeNode<T> result = current.getLeft();
        if (result == null) return null;
        while(result.getRight() != null
                // this check is for the case when we have already found the predecessor and set the successor of it to point to current (through right link)
                && result.getRight() != current) {
            result = result.getRight();
        }
        return result;
    }
}
