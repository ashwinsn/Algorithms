package com.ashcode.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by anatarajan on 3/16/16.
 */
public class LCABinaryTreeTest {

    LCABinaryTree subject;
    BasicTreeNode root, node1, node2, node3, node4;
    @Before
    public void setUp() throws Exception {
      subject = new LCABinaryTree();

      root = new BasicTreeNode(23);
      BinaryTree tree = new BinaryTree(root);

      node1 = new BasicTreeNode(34);
      tree.insertToMakeaSearchTree(node1);

      node2 = new BasicTreeNode(20);
      tree.insertToMakeaSearchTree(node2);

      node3 = new BasicTreeNode(22);
      tree.insertToMakeaSearchTree(node3);

      node4 = new BasicTreeNode(15);
      tree.insertToMakeaSearchTree(node4);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindNodesAndLCA() throws Exception {
       ArrayList<BasicTreeNode> foundNodes = new ArrayList<BasicTreeNode>();
       BasicTreeNode LCA = subject.findNodesAndLCA(root, node2, node3, foundNodes);
       assertThat(LCA, is(equalTo(root)));
    }

    @Test
    public void testFindNodesWhenNodesinRSTandLST() throws Exception {
        ArrayList<BasicTreeNode> foundNodes = new ArrayList<BasicTreeNode>();
        BasicTreeNode LCA = subject.findNodesAndLCA(root, node1, node3, foundNodes);
        assertThat(LCA, is(equalTo(root)));
    }

    @Test
    public void testFindNodesWhenLCAIsNotRoot() throws Exception {
        ArrayList<BasicTreeNode> foundNodes = new ArrayList<BasicTreeNode>();
        BasicTreeNode LCA = subject.findNodesAndLCA(root, node4, node3, foundNodes);
        assertThat(LCA, is(equalTo(node2)));
    }

    @Test
    public void testLCAWhenBST() throws Exception {
        BasicTreeNode LCA = subject.LCAWhenBST(root, node4, node3, null);
        assertThat(LCA, is(equalTo(node2)));
    }

    @Test
    public void testLCAWhenBST_whenWeSendNonPresentNodeItReturnsNull() throws Exception{
        BasicTreeNode someNode = new BasicTreeNode(100);
        BasicTreeNode LCA = subject.LCAWhenBST(root, someNode, node1, null);
        assertThat(LCA, is(equalTo(null)));
    }
}