package com.ashcode.app;

import com.ashcode.app.utils.MutableInt;

/**
 * Created by anatarajan on 7/4/16.
 */
public class CheckIfTreeIsHeightBalanced {
    BasicTreeNode root;

    public boolean execute(BasicTreeNode root, MutableInt height){
        MutableInt lheight = new MutableInt(0);
        MutableInt rheight = new MutableInt(0);

        boolean lbalanced = true;
        boolean rbalanced = true;

        if(root.left != null){
            lbalanced = execute(root.left, lheight);
            if(!lbalanced){
                return false;
            }
        }

        if(root.right != null){
            rbalanced = execute(root.right, rheight);
            if(!rbalanced){
                return false;
            }
        }

        if(lheight.getIntValue() > rheight.getIntValue()){
            height.setIntValue(lheight.getIntValue()+1);
        } else {
            height.setIntValue(rheight.getIntValue()+1);
        }

        if(Math.abs(lheight.getIntValue() - rheight.getIntValue()) <= 1){
            return  true;
        }

        return false;
    }

    public BasicTreeNode getRoot() {
        return root;
    }

    public void setRoot(BasicTreeNode root) {
        this.root = root;
    }
}
