package com.ashcode.app;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by anatarajan on 6/24/16.
 */
public class CheckIfTwoTreesAreSymmetricalTest {

    CheckIfTwoTreesAreSymmetrical subject;
    BinaryTree tree1;
    BinaryTree tree2;

    BasicTreeNode node1, node2, node3, node4, node5, node6, node7, node8;

    @org.testng.annotations.BeforeMethod
    public void setUp() throws Exception {
        node1 = new BasicTreeNode(20);
        node2 = new BasicTreeNode(25);
        node3 = new BasicTreeNode(30);
        node4 = new BasicTreeNode(20);
        node5 = new BasicTreeNode(25);
        node6 = new BasicTreeNode(30);
        node7 = new BasicTreeNode(44);
        node8 = new BasicTreeNode(44);

        node1.left = node2;
        node1.right = node3;

        node4.left = node5;
        node4.right = node6;
        node6.right = node8;

        tree1 = new BinaryTree(node1);
        tree2 = new BinaryTree(node4);

       subject = new CheckIfTwoTreesAreSymmetrical(tree1, tree2);
    }

    @Test
    public void testPerformCheck_returnsFalseForSymmetricalTrees(){
        assertFalse(subject.performCheck(tree1.root, tree2.root));
    }

    @Test
    public void testPerformCheck_returnsTrueForSymmetricalTrees(){
        node1.left = node3;
        node3.left = node7;

        node1.right = node2;

        assertTrue(subject.performCheck(tree1.root, tree2.root));
    }
}