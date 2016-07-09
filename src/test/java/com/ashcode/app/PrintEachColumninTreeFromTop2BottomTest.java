package com.ashcode.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anatarajan on 3/4/16.
 */
public class PrintEachColumninTreeFromTop2BottomTest {

    PrintEachColumninTreeFromTop2Bottom subject;

    @Before
    public void setUp(){
        BasicTreeNode root = new BasicTreeNode(4,null,null);

        BinaryTree tree = new BinaryTree(root);
        int [] data = {3,4,5,7};
        tree.insertDataIntoTree(data);

        subject = new PrintEachColumninTreeFromTop2Bottom(tree);
    }

    @After
    public void tearDown(){

    }

    private void traverseTreeandVerifyRowAndColumn(BasicTreeNode root){
        assertThat(root.getColumn(), is(equalTo(0)));
        assertThat(root.left.getColumn(), is(equalTo(-1)));
        assertThat(root.left.right.getColumn(), is(equalTo(0)));
        assertThat(root.right.getColumn(), is(equalTo(1)));
        assertThat(root.right.right.getColumn(), is(equalTo(2)));

        assertThat(root.getRow(), is(equalTo(0)));
        assertThat(root.left.getRow(), is(equalTo(1)));
        assertThat(root.left.right.getRow(), is(equalTo(2)));
        assertThat(root.right.getRow(), is(equalTo(1)));
        assertThat(root.right.right.getRow(), is(equalTo(2)));
    }


    @Test
    public void inoroderTraverseAndUpdateTreeWithRowAndColumn_updates_each_node_with_Row_and_column_info(){
        subject.inroderTraverseAndUpdateTreeWithRowAndColumn(subject.getTree().root);
        traverseTreeandVerifyRowAndColumn(subject.getTree().root);
    }

    @Test
    public void BFTandUpdateTreeWithRowandColumn_updates_each_node_with_Row_and_column_info(){
        subject.BFTUpdateTreeWithRowAndColumn();
        traverseTreeandVerifyRowAndColumn(subject.getTree().root);
    }

    @Test
    public void BFTandUpdateTreeWithRowandColumn_Builds_ColumnList_In_Height_Order(){
        subject.BFTUpdateTreeWithRowAndColumn();
        TreeMap<Integer, ArrayList<BasicTreeNode>> columnMap = subject.getColumnMap();

        for(Integer key : columnMap.keySet()){
            System.out.print("key :"+ key);
            for(BasicTreeNode node : columnMap.get(key)){
                System.out.print(node.data + ",");
            }
            System.out.println();
        }

        assertThat(columnMap.get(0).get(0).data, is(equalTo(4)));
        assertThat(columnMap.get(0).get(1).data, is(equalTo(4)));
        assertThat(columnMap.get(-1).get(0).data, is(equalTo(3)));
        assertThat(columnMap.get(1).get(0).data, is(equalTo(5)));
        assertThat(columnMap.get(2).get(0).data, is(equalTo(7)));

        subject.printColumnWiseFromTopToBottom();
    }
}