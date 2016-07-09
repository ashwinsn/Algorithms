package com.ashcode.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by anatarajan on 3/5/16.
 */
public class AddNumbertoArrayAsIfIsOneNumberTest {

    int[] inputArray = {0,0,2,5};
    AddNumbertoArrayAsIfIsOneNumber subject = new AddNumbertoArrayAsIfIsOneNumber(inputArray, 452);
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findNumberOfDigits_returnsNumberOfDigits(){
        assertThat(subject.findNumberOfDigits(3456), is(equalTo(4)));
    }

    @Test
    public void addNumberToArray_adds_number_as_single_number(){
        int[] input = subject.returnInput();

        int number = 15;
        for(int i=input.length-1; i>=0; i++){
            input[i] = input[i] + number;

        }
    }

    @Test
    public void addNumberToArray_returns_Array_with_correct_length_when_there_are_leading_zeros(){

    }

    @Test
    public void addNumberToArray_returns_Array_when_the_array_expands_after_addition(){

    }

    @Test
    public void convertNumberToArray_builds_array_properly(){

    }

    @Test
    public void convertArrayToNumber_converts_to_number_properly(){
        int number = subject.convertArrayToNumber();
        assertThat(number, is(equalTo(25)));
    }
}