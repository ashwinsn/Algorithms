package com.ashcode.app;

public class MaximizeNoOfApplesDescendingDown{
  public MaximizeNoOfApplesDescendingDown(){

  }

  //Assume X and Y <= column length and Y >= X
  public int[][] extractColumsXY(int[][] appleArray, int X, int Y){
    int[][] extractedArray = new int[appleArray.length][Y-X+1];
    for(int i=0; i<appleArray.length;i++) {
      for (int j = X; j <= Y; j++) {
        extractedArray[i][j-X] = appleArray[i][j];
      }
    }
    return extractedArray;
  }

  public int[][] extractRowsXY(int[][] appleArray, int X, int Y){
    int[][] extractedArray = new int[Y-X+1][appleArray[0].length];
    for (int i = X; i <= Y; i++){
      for(int j=0; j<appleArray[0].length;j++) {
        extractedArray[i-X][j] = appleArray[i][j];
      }
    }
    return extractedArray;
  }

  public int execute(int[][] appleArray){
    int finalSum = 0;
    int arrayFromNextColumnSum = 0;
    int arrayFromNextRowSum = 0;


    if(appleArray.length == 1 && appleArray[0].length == 1){
      finalSum =  appleArray[0][0];
      return finalSum;
    }

    if(appleArray[0].length > 1) {
      arrayFromNextColumnSum = execute(extractColumsXY(appleArray,1,appleArray[0].length-1));
    }

    if(appleArray.length > 1){
      arrayFromNextRowSum = execute(extractRowsXY(appleArray,1,appleArray.length-1));
    }

    if(arrayFromNextColumnSum > arrayFromNextRowSum) {
      finalSum = appleArray[0][0] + arrayFromNextColumnSum;
    } else {
      finalSum = appleArray[0][0] + arrayFromNextRowSum;
    }
    return finalSum;
  }
};