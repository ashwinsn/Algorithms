package com.ashcode.app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by anatarajan on 12/6/15.
 */
public class RemoveTrailingZerosTest {

    RemoveTrailingZeros removeTrailingZeros = new RemoveTrailingZeros();
    int[] inputArray = {0,3,4,5,0,2,3};

    @Before
    public void setUp(){

    }

    @Test
    public void moveZerosMovesZerosTotheEnd(){
        removeTrailingZeros.moveZeros(inputArray);
        System.out.println(inputArray[0]);
        assertEquals(inputArray[0], equals(3));
        assertEquals(inputArray[1], equals(4));
        assertEquals(inputArray[2], equals(5));
        assertEquals(inputArray[3], equals(2));
        assertEquals(inputArray[4], equals(3));
        assertEquals(inputArray[5], equals(0));
        assertEquals(inputArray[6], equals(0));
    }

}