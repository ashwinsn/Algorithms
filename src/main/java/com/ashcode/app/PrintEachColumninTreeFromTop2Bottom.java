package com.ashcode.app;

import java.util.*;

/**
 * Created by anatarajan on 3/4/16.
 */
//traverse tree in any order and update the height and column information and add the elements to an hashtable with value
//as arraylist. Merge sort the arraylist.
public class PrintEachColumninTreeFromTop2Bottom {

    BinaryTree tree;

    private TreeMap<Integer, ArrayList<BasicTreeNode>> columnMap = null;
    public TreeMap<Integer, ArrayList<BasicTreeNode>> getColumnMap() {
        return columnMap;
    }

    public PrintEachColumninTreeFromTop2Bottom(BinaryTree tree){
        this.tree = tree;
        columnMap = new TreeMap<Integer, ArrayList<BasicTreeNode>>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue();
            }
        });
    }

    public BinaryTree getTree(){
        return tree;
    }

    //This will require to sort the lists in the hashmap by height or row value
    public void inroderTraverseAndUpdateTreeWithRowAndColumn(BasicTreeNode root){
       if(root.left != null){
           int column = root.getColumn() - 1;
           root.left.setColumn(column);
           root.left.setRow(root.getRow() + 1);
           inroderTraverseAndUpdateTreeWithRowAndColumn(root.left);
       }
       if(root.right != null){
           root.right.setColumn(root.getColumn() + 1);
           root.right.setRow(root.getRow() + 1);
           inroderTraverseAndUpdateTreeWithRowAndColumn(root.right);
       }
    }

    public void BFTUpdateTreeWithRowAndColumn(){
        BasicTreeNode root = tree.root;
        LinkedList<BasicTreeNode> BFTQueue = new LinkedList();
        BFTQueue.add(root);
        addToColumnMap(root,0);

        while(!BFTQueue.isEmpty()){
            BasicTreeNode currentNode = BFTQueue.remove();
            ProcessLeftChild(BFTQueue, currentNode);
            ProcessRightChild(BFTQueue, currentNode);
        }
    }

    private void ProcessRightChild(LinkedList<BasicTreeNode> BFTQueue, BasicTreeNode currentNode) {
        if(currentNode.right != null){
            BasicTreeNode right = currentNode.right;
            updateRowAndColumn(right, currentNode.getRow() + 1, currentNode.getColumn() + 1);
            BFTQueue.add(right);
            addToColumnMap(right, currentNode.getColumn() + 1);
        }
    }

    private void ProcessLeftChild(LinkedList<BasicTreeNode> BFTQueue, BasicTreeNode currentNode) {
        if(currentNode.left != null){
            BasicTreeNode left = currentNode.left;
            updateRowAndColumn(left, currentNode.getRow() + 1, currentNode.getColumn() - 1);
            BFTQueue.add(left);
            addToColumnMap(left, currentNode.getColumn() - 1);
        }
    }

    private void updateRowAndColumn(BasicTreeNode left, int row, int column) {
        left.setRow(row);
        left.setColumn(column);
    }

    private void addToColumnMap(BasicTreeNode right, int key) {
        ArrayList<BasicTreeNode> columnList = columnMap.get(key);
        if (columnList == null) {
            columnList = new ArrayList();
            columnList.add(right);
            columnMap.put(key, columnList);
        } else {
            columnList.add(right);
        }
    }

    public void printColumnWiseFromTopToBottom(){
        for(Integer key : columnMap.keySet()){
            ArrayList<BasicTreeNode> currentColumnList = columnMap.get(key);
            for(BasicTreeNode node : currentColumnList){
                System.out.print(node.data + ",");
            }
        }
        System.out.println();
    }


}
