package com.ashcode.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anatarajan on 12/9/15.
 */
public class AllPathsThatSumToaNumber {

    BinaryTree tree;
    List<List<Integer>> outputList;
    int finalSum;

    public AllPathsThatSumToaNumber(BinaryTree tree, int finalSum){
        this.tree = tree;
        this.finalSum = finalSum;
        outputList =  new ArrayList<List<Integer>>();
    }

    public List<List<Integer>> execute(){
       int currentSum = 0;
       ArrayList<Integer> currentPath = new ArrayList<Integer>();
       checkIfPathLeadsToSum(currentSum, currentPath, tree.root);
        return outputList;
    }

    private void checkIfPathLeadsToSum(int currentSum, ArrayList<Integer> currentPath, TreeNode currentNode) {
        currentPath.add(currentNode.data);
        currentSum += currentNode.data;
        if(currentSum == finalSum){
            List<Integer> anotherList = (ArrayList<Integer>) currentPath.clone();
            outputList.add(anotherList);
        }

        if(currentNode.left != null){
            checkIfPathLeadsToSum(currentSum, currentPath, currentNode.left);
        }

        if(currentNode.right != null){
            ArrayList<Integer> newPath = (ArrayList<Integer>) currentPath.clone();
            checkIfPathLeadsToSum(currentSum, newPath, currentNode.right);
        }
    }

    public void setTree(BinaryTree tree) {
        this.tree = tree;
    }

    public void setFinalSum(int finalSum) {
        this.finalSum = finalSum;
    }
}
