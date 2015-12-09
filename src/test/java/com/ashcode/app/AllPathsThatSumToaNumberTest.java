package com.ashcode.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by anatarajan on 12/9/15.
 */
public class AllPathsThatSumToaNumberTest {

    TreeNode rootNode = new TreeNode(10);
    BinaryTree someTree = new BinaryTree(rootNode);

    AllPathsThatSumToaNumber subject;

    @Before
    public void setUp() throws Exception {
        int[] someSampleData = {3,3,-3,11,11,-11};
        someTree.insertDataIntoTree(someSampleData);
        subject = new AllPathsThatSumToaNumber(someTree,13);
    }

    @Test
    public void executeReturnsAListOfPaths(){

    }

    @Test
    public void executeReturnsTheCorrectListOfPaths(){
        subject.setFinalSum(13);

        List<List<Integer>> outputList = subject.execute();
        assertThat(outputList.size(), equalTo(2));

        assertThat(outputList.get(0).get(0), equalTo(10));
        assertThat(outputList.get(0).get(1), equalTo(3));

        assertThat(outputList.get(1).get(0), equalTo(10));
        assertThat(outputList.get(1).get(1), equalTo(3));
        assertThat(outputList.get(1).get(2), equalTo(3));
        assertThat(outputList.get(1).get(3), equalTo(-3));

    }

    @Test
    public void executeReturnsAnEmptyListWhenThereisNoPathWithTheSum(){
        int[] someSampleData = {3,4};
        someTree.insertDataIntoTree(someSampleData);

        subject.setFinalSum(15);

        List<List<Integer>> outputList = subject.execute();
        assertThat(outputList.size(), equalTo(0));
    }

    @After
    public void tearDown() throws Exception {

    }
}