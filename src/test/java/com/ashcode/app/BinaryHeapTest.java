package com.ashcode.app;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by anatarajan on 6/30/16.
 */
public class BinaryHeapTest {

    BinaryHeap subject;
    @BeforeMethod
    public void setUp() throws Exception {
        List<Integer> someList = Arrays.asList(2, 3, 4, 5);
        subject = new BinaryHeap(someList);
    }

    @Test
    public void testHeapifyANode() throws Exception {

    }

    @Test
    public void testHeapify() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testReturnMin() throws Exception {

    }
}