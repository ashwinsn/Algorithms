package com.ashcode.app;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by anatarajan on 5/27/16.
 *
 * Use Dynamic Programming
 */

public class DecodeNumberToString {
    private String encodedNumber;
    private HashMap<String, HashSet<String>> codeMap;

    public DecodeNumberToString(String encodedNumber){
        this.encodedNumber = encodedNumber;
        this.codeMap = new HashMap<String, HashSet<String>>();
    }
    public String returnStringFromCode(int code){
       return Character.toString((char) (code + 64));
    }

    public HashSet<String> decode(String encodedNumber){
        if(codeMap.containsKey(encodedNumber)){
            return codeMap.get(encodedNumber);
        }
        HashSet<String> decodedStrings = new HashSet<String>();

        if(encodedNumber.length() <= 0){
            return decodedStrings;
        } else if(encodedNumber.length() == 1
                || encodedNumber.length() == 2 && Integer.parseInt(encodedNumber) <= 26){
            decodedStrings.add(returnStringFromCode(Integer.parseInt(encodedNumber)));
        }

        if(encodedNumber.length() > 1){
            String subString_n_1 = encodedNumber.substring(0, encodedNumber.length()-1);
            HashSet<String> decodedStrings_n_1 = decode(subString_n_1);

            String remainingString_n_1 = encodedNumber.substring(encodedNumber.length()-1);
            HashSet<String> remainingDecodedStrings = decode(remainingString_n_1);

            combineOutputs(decodedStrings, decodedStrings_n_1, remainingDecodedStrings);
        }

        if(encodedNumber.length() > 2){
            String subString_n_2 = encodedNumber.substring(0, encodedNumber.length()-2);
            HashSet<String> decodedStrings_n_2 = decode(subString_n_2);

            String remainingString_n_2 = encodedNumber.substring(encodedNumber.length()-2);
            HashSet<String> remainingDecodedStrings = decode(remainingString_n_2);

            combineOutputs(decodedStrings, decodedStrings_n_2, remainingDecodedStrings);
        }

        codeMap.put(encodedNumber, decodedStrings);
        return decodedStrings;
    }

    private void combineOutputs(HashSet<String> decodedStrings, HashSet<String> decodedStrings_n_1, HashSet<String> remainingDecodedStrings) {
        for(String output : decodedStrings_n_1){
            for(String remainingDecodedString : remainingDecodedStrings){
                decodedStrings.add(output.concat(remainingDecodedString));
            }
        }
    }

    public static void main(String args[]){

        DecodeNumberToString decodeNumberToString = new DecodeNumberToString("123");
        HashSet<String> decodedStrings = decodeNumberToString.decode("111111");

        for(String s : decodedStrings){
            System.out.println(s);
        }
    }
}
