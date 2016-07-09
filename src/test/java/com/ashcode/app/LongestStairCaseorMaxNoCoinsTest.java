package com.ashcode.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by anatarajan on 5/28/16.
 */
public class LongestStairCaseorMaxNoCoinsTest {
    LongestStairCaseorMaxNoCoins subject;
    @Before
    public void setUp() throws Exception {
       subject = new LongestStairCaseorMaxNoCoins(new ArrayList<PairOfCoordinates>());
    }

    @Test
    public void testGetLongestStairCaseReturnsStairCaseWhenSethasOneElement() throws Exception {
       PairOfCoordinates somePairOfCoordinates =  new PairOfCoordinates(3,4);
       subject.getPairsOfCoordinates().add(somePairOfCoordinates);
       Integer stairCaseSize = subject.getLongestStairCase(somePairOfCoordinates);
       assertThat(stairCaseSize, is(equalTo(1)));
    }

    @Test
    public void testGetLongestStairCaseReturnsStairCaseWhenSethasTwoElements() throws Exception {
        PairOfCoordinates somePairOfCoordinates =  new PairOfCoordinates(3,4);
        PairOfCoordinates anotherPairOfCoordinates = new PairOfCoordinates(4,5);

        subject.getPairsOfCoordinates().add(somePairOfCoordinates);
        subject.getPairsOfCoordinates().add(anotherPairOfCoordinates);

        Integer stairCaseSize = subject.getLongestStairCase(somePairOfCoordinates);
        assertThat(stairCaseSize, is(equalTo(2)));
    }

    @Test
    public void testGetLongestStairCaseReturnsLongestStairCaseWhenSethasMoreThanTwoElements() throws Exception {
        PairOfCoordinates somePairOfCoordinates =  new PairOfCoordinates(3,4);
        PairOfCoordinates secondPairOfCoordinates = new PairOfCoordinates(4,5);
        PairOfCoordinates thirdPairOfCoordinates = new PairOfCoordinates(5,6);
        PairOfCoordinates fourthPairOfCoordinates = new PairOfCoordinates(6,7);

        subject.getPairsOfCoordinates().add(fourthPairOfCoordinates);
        subject.getPairsOfCoordinates().add(somePairOfCoordinates);
        subject.getPairsOfCoordinates().add(thirdPairOfCoordinates);
        subject.getPairsOfCoordinates().add(secondPairOfCoordinates);


        Integer stairCaseSize = subject.getLongestStairCase(somePairOfCoordinates);
        assertThat(stairCaseSize, is(equalTo(4)));

        stairCaseSize = subject.getLongestStairCase(thirdPairOfCoordinates);
        assertThat(stairCaseSize, is(equalTo(2)));
    }


}