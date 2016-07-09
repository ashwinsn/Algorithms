package com.ashcode.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by anatarajan on 6/1/16.
 */
public class SmallestSetOfIntervalsCoveringATargetRangeTest {

    SmallestSetOfIntervalsCoveringATargetRange subject;
    @Before
    public void setUp() throws Exception {
      List<Interval> listOfIntervals = new ArrayList<Interval>();
      listOfIntervals.add(new Interval(1, 3));
      listOfIntervals.add(new Interval(3, 5));
      listOfIntervals.add(new Interval(1, 7));
      subject = new SmallestSetOfIntervalsCoveringATargetRange(listOfIntervals);
    }

    @Test
    public void testExecute_returnsTheIntervalWhenSomeIntervalisPresent() throws Exception{
        subject.setTargetInterval(new Interval(3,4));
        List<Interval> output = subject.execute();
        assertThat(output.size(), is(equalTo(1)));
        assertThat(output.get(0).getBegin(), is(equalTo(3)));
        assertThat(output.get(0).getEnd(), is(equalTo(5)));
    }

    @Test
    public void testExecute_ReturnsNullWhenNoIntervalisPresent() throws Exception{
        subject.setTargetInterval(new Interval(3,30));
        List<Interval> output = subject.execute();
        assertThat(output.size(), is(equalTo(0)));
    }

    @Test
    public void testExecute_returnsTheSmallestSetOfIntervals() throws Exception{
        subject.setTargetInterval(new Interval(1,6));
        List<Interval> output = subject.execute();
        assertThat(output.size(), is(equalTo(1)));
        assertThat(output.get(0).getBegin(), is(equalTo(1)));
        assertThat(output.get(0).getEnd(), is(equalTo(7)));
    }
}