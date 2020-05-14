package com.example.tree;


import com.example.util.TreeNodeChar;

public class InOrderSuccessorBinaryTree {
    public static TreeNodeChar n = null;
    public static Boolean nodeFound = false;
    public TreeNodeChar inOrderSuccBiTree(TreeNodeChar root, TreeNodeChar x){
        nodeFound = false;
        if(x.right!=null){
            TreeNodeChar temp = leftMostTreeNode(x.right);
            System.out.println("The In Order Successor for '" + x.data + "' is "+ temp.data );
            return null;
        }
        return findRecur(root, x);
    }
    public void display(TreeNodeChar root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }

    public TreeNodeChar findRecur(TreeNodeChar root, TreeNodeChar x){
        if(root==null) return null;
        if(root==x||(n = findRecur(root.left,x))!=null||(n=findRecur(root.right,x))!=null){

            if(n!=null){
                if(root.left==n){
                    nodeFound = true;
                    System.out.println("The In Order Successor for '" + x.data + "' is "+ root.data );
                    return null;
                }
            }
            return root;
        }
        return null;
    }
    public TreeNodeChar leftMostTreeNode(TreeNodeChar x){
        while(x.left!=null){
            x = x.left;
        }
        nodeFound = true;
        return x;
    }
    public static void main(String args[]){
        TreeNodeChar root = new TreeNodeChar('a');
        root.left = new TreeNodeChar('b');
        root.right = new TreeNodeChar('c');
        root.left.left = new TreeNodeChar('d');
        root.left.right = new TreeNodeChar('e');
        TreeNodeChar x = new TreeNodeChar('x');
        root.left.right.left = new TreeNodeChar('i');
        root.left.right.left.right = new TreeNodeChar('j');
        root.left.right.left.right.right = x;
        root.right.left = new TreeNodeChar('f');
        TreeNodeChar y = new TreeNodeChar('g');
        root.right.right = y;

        InOrderSuccessorBinaryTree i = new InOrderSuccessorBinaryTree();
        System.out.print(" Tree : ");
        i.display(root);
        System.out.println();
        nodeFound = false;
        i.inOrderSuccBiTree(root, x);
        if(!nodeFound){
            System.out.println("InOrder Successor of " + x.data + " is NULL");
        }
        nodeFound = false;
        i.inOrderSuccBiTree(root, root);
        if(!nodeFound){
            System.out.println("InOrder Successor of " + root.data + " is NULL");
        }
        nodeFound = false;
        i.inOrderSuccBiTree(root, y);
        if(!nodeFound){
            System.out.println("InOrder Successor of " + y.data + " is NULL");
        }
    }
}
