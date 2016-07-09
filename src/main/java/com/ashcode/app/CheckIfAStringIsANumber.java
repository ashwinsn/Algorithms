package com.ashcode.app;

/**
 * Created by anatarajan on 6/25/16.
 */
public class CheckIfAStringIsANumber {

    public boolean isNumber(String number){

        char[] numberArray = number.toCharArray();
        int dotCount = 0;

        for(int i=0; i<numberArray.length; i++ ){
            char currentChar = numberArray[i];
            if(currentChar < '0' || currentChar > '9'){
                if( i == 0 && currentChar == '-'){
                    continue;
                }
                if(currentChar == '.'){
                    if(dotCount >= 1){
                        return false;
                    }
                    dotCount++;
                    continue;
                }
                return false;
            }
        }

        return true;

    }

    public static void main(String args[]){
        CheckIfAStringIsANumber checkIfAStringIsANumber = new CheckIfAStringIsANumber();
        System.out.println(checkIfAStringIsANumber.isNumber("2342323."));
        System.out.println(checkIfAStringIsANumber.isNumber("+12312"));
        System.out.println(checkIfAStringIsANumber.isNumber("-12312"));
        System.out.println(checkIfAStringIsANumber.isNumber("12312-9877"));
        System.out.println(checkIfAStringIsANumber.isNumber("12312.9877"));
        System.out.println(checkIfAStringIsANumber.isNumber("12312.9877."));

    }
}
