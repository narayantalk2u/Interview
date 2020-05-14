package com.example.tree;

import com.example.util.CreateBST;
import com.example.util.TreeNode;

public class TreeTest {

    /*public static void main(String[] args) {
        BinaryTreeIdentical binaryTreeIdentical = new BinaryTreeIdentical();
        CreateBST createBST = new CreateBST();
        Integer arr1[] = {100,50,200,25,125,250};
        Integer arr2[] = {50,100,200,125,25,250};
        TreeNode<Integer> root1 = createBST.createTree(arr1);
        TreeNode<Integer> root2 = createBST.createTree(arr2);
        System.out.println(binaryTreeIdentical.isIdentical(root1,root2));
    }*/
    public static void main(String[] args) {
        CreateBST createBST = new CreateBST();
        Integer arr1[] = {100,50,200,25,125,250};

        TreeNode root = createBST.createTree(arr1);
        System.out.print("Inorder Iterator = ");
        System.out.println(InorderIteratorBST.toString(root));
    }
}
