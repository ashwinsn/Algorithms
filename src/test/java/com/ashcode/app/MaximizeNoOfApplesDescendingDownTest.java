package com.ashcode.app;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anatarajan on 11/21/15.
 */
public class MaximizeNoOfApplesDescendingDownTest {

    int[][] firstAppleSquare = {
        {9, 3, 4},
        {5, 4, 5},
        {4, 5, 6}
    };

    int[][] secondAppleRectangle = {
            {10, 3, 4, 2},
            {12, 3, 4, 3},
            {3,  4, 4, 4},
            {4,  5, 6, 7}
    };

    int[][] smallAppleSquare = {
            {2,4},
            {3,5}
    };

    MaximizeNoOfApplesDescendingDown subject;

    @Before
    public void Setup(){
        subject = new MaximizeNoOfApplesDescendingDown();
    }

    @Test
    public void executeReturnsTheMaxNoOfApplesDescendingDownASquare(){

    }

    @Test
    public void executeReturnsTheMaximumNoOfApplesDescendingDownARectangle(){
        assertThat(subject.execute(smallAppleSquare), is(equalTo(11)));
    }

    @Test
    public void executeReturnsTheonlyCellifTheSquareis1x1(){
        int[][] appleArray = {{3}};
        assertThat(subject.execute(appleArray), is(equalTo(3)));
    }

    @Test
    public void executeReturnsTheSumOfRowElementsIfNoColumns(){
        int[][] appleArray = {{3},{4},{5}};
        assertThat(subject.execute(appleArray), is(equalTo(12)));
    }

    @Test
    public void executeReturnsTheSumOfColumnElementsIfNoRows(){
        int[][] appleArray = {{3,4}};
        assertThat(subject.execute(appleArray), is(equalTo(7)));
    }

    @Test
    public void extractColumnsXYReturnsCorrectResults(){
        int [][] appleArray = {{3,4,5}};
        int [][] result = subject.extractColumsXY(appleArray,1,2);
        assertThat(result[0][0], is(equalTo(4)));
        assertThat(result[0][1], is(equalTo(5)));

        int[][] anotherResult = subject.extractColumsXY(appleArray,1,1);
        assertThat(anotherResult[0][0], is(equalTo(4)));

        int[][] yetAnotherResult = subject.extractColumsXY(appleArray,2,2);
        assertThat(yetAnotherResult[0][0], is(equalTo(5)));
    }

    @Test
    public void extractRowsXYReturnsCorrectResults(){
        int [][] appleArray = {{3},{4},{5}};
        int [][] result = subject.extractRowsXY(appleArray,1,2);
        assertThat(result[0][0], is(equalTo(4)));
        assertThat(result[1][0], is(equalTo(5)));

        int[][] anotherResult = subject.extractRowsXY(appleArray,1,1);
        assertThat(anotherResult[0][0], is(equalTo(4)));

        int[][] yetAnotherResult = subject.extractRowsXY(appleArray,2,2);
        assertThat(yetAnotherResult[0][0], is(equalTo(5)));
    }
}