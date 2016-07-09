package com.ashcode.app;

/**
 * Created by anatarajan on 5/28/16.
 */
public class Interval {

    private int begin;
    private int end;

    public Interval(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    /*
     * Returns 0 if the intervals overlap.
     */
    public static int compare(Interval interval1, Interval interval2){
        if(interval1.getEnd() < interval2.getBegin()){
            return -1;
        }
        if(interval2.getEnd() < interval1.getBegin()){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o){
       if(o instanceof Interval && ((Interval) o).getBegin() == begin
               && ((Interval) o).getEnd() == end){
           return true;
       } else {
           return false;
       }
    }

    @Override
    public int hashCode(){
        return begin + end;
    }

}
