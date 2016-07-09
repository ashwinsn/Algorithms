package com.ashcode.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by anatarajan on 5/28/16.
 */
public class MergeIntervalsTest {

    MergeIntervals subject;

    @Before
    public void setUp() throws Exception {
       subject = new MergeIntervals();
    }

    @Test
    public void testMergeIntervalsWhenIntervalsDontOverlap_mergesIntervals() throws Exception{
        Interval someInterval = new Interval(10,20);
        Interval anotherInterval = new Interval(30,40);

        List<Interval> interval1 = new ArrayList<Interval>();
        interval1.add(someInterval);

        List<Interval> interval2 = new ArrayList<Interval>();
        interval2.add(anotherInterval);

        subject.setIntervals(interval1, interval2);
        subject.execute();

        assertThat(subject.getMergedIntervals().size(), is(equalTo(2)));
        assertThat(subject.getMergedIntervals().get(0).getBegin(), is(equalTo(10)));
        assertThat(subject.getMergedIntervals().get(1).getBegin(), is(equalTo(30)));
    }

    @Test
    public void testMergeIntervalsWhenIntervalsOverlap_mergesIntervals() throws Exception{
        Interval someInterval = new Interval(10,20);
        Interval anotherInterval = new Interval(15,25);

        List<Interval> interval1 = new ArrayList<Interval>();
        interval1.add(someInterval);

        List<Interval> interval2 = new ArrayList<Interval>();
        interval2.add(anotherInterval);

        subject.setIntervals(interval1, interval2);
        subject.execute();

        assertThat(subject.getMergedIntervals().size(), is(equalTo(1)));
        assertThat(subject.getMergedIntervals().get(0).getBegin(), is(equalTo(10)));
        assertThat(subject.getMergedIntervals().get(0).getEnd(), is(equalTo(25)));

    }

    @Test
    public void testMergeIntervalsWhenOneListIsDoneMergingEarlier_mergesIntervals() throws Exception{
        Interval someInterval = new Interval(10,20);
        Interval anotherInterval = new Interval(15,25);
        Interval thirdInterval = new Interval(30,40);
        Interval fourthInterval = new Interval(42, 50);

        List<Interval> intervalList1 = new ArrayList<Interval>();
        intervalList1.add(someInterval);
        intervalList1.add(thirdInterval);
        intervalList1.add(fourthInterval);

        List<Interval> intervalList2 = new ArrayList<Interval>();
        intervalList2.add(anotherInterval);

        subject.setIntervals(intervalList1, intervalList2);
        subject.execute();

        assertThat(subject.getMergedIntervals().size(), is(equalTo(3)));
        assertThat(subject.getMergedIntervals().get(0).getBegin(), is(equalTo(10)));
        assertThat(subject.getMergedIntervals().get(0).getEnd(), is(equalTo(25)));

        assertThat(subject.getMergedIntervals().get(1).getBegin(), is(equalTo(30)));
        assertThat(subject.getMergedIntervals().get(2).getBegin(), is(equalTo(42)));
    }
}