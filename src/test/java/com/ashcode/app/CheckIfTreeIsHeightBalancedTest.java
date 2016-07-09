package com.ashcode.app;

import com.ashcode.app.utils.MutableInt;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by anatarajan on 7/4/16.
 */
public class CheckIfTreeIsHeightBalancedTest {

    CheckIfTreeIsHeightBalanced subject;
    BasicTreeNode root, left, right, right1, left1;

    @BeforeMethod
    public void setUp() throws Exception {
       subject = new CheckIfTreeIsHeightBalanced();

       root = new BasicTreeNode(40);
       left = new BasicTreeNode(30);
       right = new BasicTreeNode(50);

       right1 = new BasicTreeNode(60);
       left1 = new BasicTreeNode(25);


       root.left = left;
       root.right = right;
       subject.setRoot(root);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        if(root.right !=null){
            root.right.right = null;
        }

    }

    @Test
    public void testExecute_returnsTrueForBalancedTree() {
        MutableInt height = new MutableInt(0);
        assertTrue(subject.execute(subject.getRoot(), height));

    }

    @Test
    public void testExecute_returnsTrueForTreeWithaDifferenceOfOne(){
        MutableInt height = new MutableInt(0);
        root.right.right = right1;
        assertTrue(subject.execute(subject.getRoot(), height));
    }

    @Test
    public void testExecute_returnsFalseForNonBalancedTree(){
        MutableInt height = new MutableInt(0);
        root.left = null;

        root.right.right = right1;
        assertFalse(subject.execute(subject.getRoot(), height));
    }

    @Test
    public void testExecute_returnsTrueForOneNodeTree(){
        MutableInt height = new MutableInt(0);
        root.left = null;
        root.right = null;

        assertTrue(subject.execute(subject.getRoot(), height));
    }


}