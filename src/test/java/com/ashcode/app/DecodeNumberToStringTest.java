package com.ashcode.app;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by anatarajan on 5/28/16.
 */
public class DecodeNumberToStringTest {

    public DecodeNumberToString subject;
    @Before
    public void setUp() throws Exception {
        subject = new DecodeNumberToString("123");
    }

    @Test
    public void testDecodeDecodesASingleDigitCodeCorrectly() throws Exception{
        HashSet<String> output = subject.decode("1");
        assertThat(output.size(), is(equalTo(1)));
        assertThat(output.contains("A"), is(equalTo(true)));
    }

    @Test
    public void testDecodeDecodesAnEmptyStringSuccessfully() throws Exception {
        HashSet<String> output = subject.decode("");
        assertThat(output.size(), is(equalTo(0)));
    }

    @Test
    public void testDecodeDecodesATwoDigitCodeSuccessfully() throws Exception {
        HashSet<String> output = subject.decode("12");
        assertThat(output.size(), is(equalTo(2)));
        assertThat(output.contains("AB"), is(equalTo(true)));
        assertThat(output.contains("L"), is(equalTo(true)));
    }

    @Test
    public void testDecodeDecodesATwoDigitCodeGreaterThan26Successfully() throws Exception {
        HashSet<String> output = subject.decode("34");
        assertThat(output.size(), is(equalTo(1)));
        assertThat(output.contains("CD"), is(equalTo(true)));
    }

    @Test
    public void testDecodeDecodesAThreeDigitCodeSuccessfully() throws Exception{
        HashSet<String> output = subject.decode("123");
        assertThat(output.size(), is(equalTo(3)));
        assertThat(output.contains("AW"), is(equalTo(true)));
        assertThat(output.contains("LC"), is(equalTo(true)));
        assertThat(output.contains("ABC"), is(equalTo(true)));
    }


}