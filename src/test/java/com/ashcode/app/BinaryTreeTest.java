package com.ashcode.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by anatarajan on 3/15/16.
 */
public class BinaryTreeTest {

    BinaryTree subject;
    @Before
    public void setUp() throws Exception {
       BasicTreeNode basicTreeNode = new BasicTreeNode(23);
       subject = new BinaryTree(basicTreeNode);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindNodesOrLCA_finds_Nodes_only_IfNoLCA_In_Subtree(){

    }
}