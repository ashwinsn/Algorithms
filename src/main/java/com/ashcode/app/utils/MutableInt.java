package com.ashcode.app.utils;

/**
 * Created by anatarajan on 7/4/16.
 */
public class MutableInt {
    private int intValue;

    public MutableInt(int value){
        this.intValue = value;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public void increment(){
        this.intValue++;
    }

    public void decrement(){
        this.intValue--;
    }


}
