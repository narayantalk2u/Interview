package com.example.tree;

import com.example.util.TreeNode;

import java.util.Stack;

public class InorderIteratorBST {
    Stack<TreeNode> stk = new Stack<TreeNode>();

    public InorderIteratorBST(TreeNode root) {
        while (root != null) {
            stk.push(root);
            root = root.getLeft();
        }
    }

    public boolean hasNext() {
        return !stk.isEmpty();
    }

    public TreeNode getNext() {
        if (stk.isEmpty())
            return null;

        TreeNode rVal = stk.pop();
        TreeNode temp = rVal.getRight();
        while (temp != null) {
            stk.push(temp);
            temp = temp.getLeft();
        }
        return rVal;
    }

    public static String toString(TreeNode root) {
        InorderIteratorBST iter = new InorderIteratorBST(root);
        StringBuffer result = new StringBuffer("{ ");
        while (iter.hasNext()) {
            result.append(iter.getNext().getData()).append(" ");
        }
        result.append(" }");
        return result.toString();
    }
}
