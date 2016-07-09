package com.ashcode.app;

/**
 * Created by anatarajan on 3/5/16.
 */
public class AddNumbertoArrayAsIfIsOneNumber{

    int[] input;
    int addingNumber;

    int[] numberArray;

    public AddNumbertoArrayAsIfIsOneNumber(int[] input, int number){
        this.addingNumber = number;
        this.input = input;
    }

    //This mehtod might not be required. The numberArray when created using new
    //is already prefilled with zeros.
    private void prefillWithZeroIfRequired(int number, int requiredArrayLength) {
        int arrayLength = findNumberOfDigits(number);
        int numberofZeroPrefills = requiredArrayLength - arrayLength;

        if (numberofZeroPrefills <= 0) {
            numberArray = new int[arrayLength];
        } else {
            numberArray = new int[requiredArrayLength];
            if (numberofZeroPrefills > 0) {
                for (int i = 0; i < numberofZeroPrefills; i++) {
                    numberArray[i] = 0;
                }
            }
        }
    }

    public int findNumberOfDigits(int number){
        int numberOfDigits = 0;
        int currentNumber = number;

        while(currentNumber / 10 > 0){
            currentNumber = currentNumber / 10;
            numberOfDigits++;
        }
        return numberOfDigits+1;
    }

    public int[] convertNumberToArray(int requiredArrayLength, int number){
      prefillWithZeroIfRequired(number, requiredArrayLength);

      int currentNumber = number;
      int currentIndex = numberArray.length-1;

      while(currentNumber / 10 > 0){
        numberArray[currentIndex] = currentNumber % 10;
        currentNumber = currentNumber / 10;
        currentIndex--;
      }
      numberArray[currentIndex] = currentNumber % 10;
      return numberArray;
    }

    public int convertArrayToNumber(){
        int number = 0;
        int tenthPower = input.length-1;

        for(int i=0; i<input.length; i++){
           number += input[i] * (int)Math.pow(10, tenthPower);
           tenthPower = tenthPower - 1;
        }
        return number;
    }

    public static void main(String args[]){
        int[] sourceArray = {0,9,8,7};

        AddNumbertoArrayAsIfIsOneNumber object = new AddNumbertoArrayAsIfIsOneNumber(sourceArray, 25);

        int finalSum = 0;
        finalSum = object.convertArrayToNumber() + 25;

        int numberOfDigitsinSum = object.findNumberOfDigits(finalSum);
        int numberOfDigitsRequireForArray = sourceArray.length > numberOfDigitsinSum ? sourceArray.length : numberOfDigitsinSum;
        int[] outputArray = object.convertNumberToArray(numberOfDigitsRequireForArray, finalSum);
        System.out.println(outputArray);

        for(int number : outputArray){
            System.out.print(number + ",");
        }
     }

    public int[] returnInput(){
        return input;
    }

    public int getAddingNumber() {
        return addingNumber;
    }

}
