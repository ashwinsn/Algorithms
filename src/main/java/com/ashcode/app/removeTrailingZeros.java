package com.ashcode.app;

/**
 * Created by anatarajan on 12/6/15.
 */
public class RemoveTrailingZeros {

    public void moveZeros(int[] inputArray){
       int currentZerosCount = 0;
       for(int i=0; i<inputArray.length; i++){
           if(inputArray[i] == 0){
               currentZerosCount++;
           } else {
               inputArray[i-currentZerosCount] = inputArray[i];
           }
       }

       for(int i=inputArray.length - currentZerosCount; i<inputArray.length;i++){
           inputArray[i] = 0;
       }
    }

}
