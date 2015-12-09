package com.ashcode.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created on 10/30/15.
 */
public class FindSubArraysThatAddToSumTest {

    int[] inputArray = {7, 4, 1, -3, 3, 4, 1};
    FindSubArraysThatAddToSum testObject;

    @Before
    public void setUp() throws Exception {
        testObject = new FindSubArraysThatAddToSum(inputArray);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void itReturnsAListOfObjectsWithstartIndexandEndIndex(){
        FindSubArraysThatAddToSum testObject = new FindSubArraysThatAddToSum(inputArray);
        assertThat(testObject.findSum(), instanceOf(List.class));
    }

    @Test
    public void itReturnsValidIndicesWithinTheArray(){

    }

    @Test
    public void itReturnsAnySubarrayWithTheSum(){

    }

    @Test
    public void calcuatePartialArraySums_ReturnsSumAtEachStep(){
        List<List<Integer>> partialSums = testObject.calculatePartialSums(4);
        assertThat(partialSums.get(2).get(4), equalTo(1));
        assertThat(partialSums.get(0).get(3), equalTo(9));


    }
}


