package com.ashcode.app;

/**
 * Created by anatarajan on 12/9/15.
 */
public class BasicTreeNode {

    public int data;
    public BasicTreeNode left;
    public BasicTreeNode right;
    int row; //height information
    int column;

    public BasicTreeNode(int data){
        this.data = data;
    }

    public BasicTreeNode(int data, BasicTreeNode left, BasicTreeNode right){
        this.data =data;
        this.left = left;
        this.right = right;
        this.row = 0;
        this.column = 0;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
