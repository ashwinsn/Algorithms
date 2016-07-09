package com.ashcode.app;

/**
 * Created by anatarajan on 12/9/15.
 */
public class BinaryTree {
    BasicTreeNode root;

    public BinaryTree(BasicTreeNode root){
        this.root = root;
    }

    public void insertToMakeaSearchTree(BasicTreeNode node){
        BasicTreeNode currentNode = root;
        BasicTreeNode currentParent = null;
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
            BasicTreeNode someNode = new BasicTreeNode(eachEntry);
            insertToMakeaSearchTree(someNode);
        }
    }
}
