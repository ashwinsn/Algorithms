package com.ashcode.app;

import apple.laf.JRSUIUtils;

/**
 * Created by anatarajan on 12/9/15.
 */
public class BinaryTree {
    TreeNode root;

    public BinaryTree(TreeNode root){
        this.root = root;
    }

    public void insertToMakeaSearchTree(TreeNode node){
        TreeNode currentNode = root;
        TreeNode currentParent = null;
        char currentDirection = 'x';

        if(root == null){
            root = node;
            return;
        }

        while(currentNode != null) {
            currentParent = currentNode;
            if (node.data > currentNode.data) {
                currentNode = currentNode.right;
                currentDirection = 'r';
            } else {
                currentNode = currentNode.left;
                currentDirection = 'l';
            }
        }

        if(currentDirection == 'l') {
            currentParent.left = node;
        } else if(currentDirection == 'r'){
            currentParent.right = node;
        }
    }

    public void insertDataIntoTree(int[] data){
        for(int eachEntry : data){
            TreeNode someNode = new TreeNode(eachEntry);
            insertToMakeaSearchTree(someNode);
        }
    }
}
