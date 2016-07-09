package com.ashcode.app;

/**
 * Created by anatarajan on 6/24/16.
 */
public class CheckIfTwoTreesAreSymmetrical {
    BinaryTree tree1;
    BinaryTree tree2;

    public CheckIfTwoTreesAreSymmetrical(BinaryTree tree1, BinaryTree tree2){
        this.tree1 = tree1;
        this.tree2 = tree2;
    }

    public boolean performCheck(BasicTreeNode tree1, BasicTreeNode tree2){
        if(tree1 == null && tree2 == null){
            return true;
        }

        if(tree1.data == tree2.data){
            if(performCheck(tree1.left, tree2.right) && performCheck(tree1.right, tree2.left)){
                return true;
            }
        }

        return false;
    }
}
