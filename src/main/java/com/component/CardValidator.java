package com.component;

import java.util.Arrays;

public class CardValidator {
    public int[] convertArray(String input){
        int[] cardArray = new int[input.length()];
        for (int id = 0; id < input.length(); id++){
            cardArray[id] = Integer.parseInt("" + input.charAt(id));
        }
        return cardArray;
    }

    public int[] arrayDigitDouble(int[] input){
        for (int id = input.length - 2; id >= 0; id -= 2){
            input[id] *= 2;
        }
        return input;
    }

    public int[] arrayDigitSum(int[] input){
        for (int id = input.length - 2; id >= 0; id -= 2){
            if(input[id] > 9)
            {
                input[id] = input[id]%10 + input[id]/10;
            }
        }
        return input;
    }

    public boolean verifyByLuhn(String card){
        return Arrays.stream(
                arrayDigitSum(
                        arrayDigitDouble(
                                convertArray(card)
                        )
                )
        ).sum() %10==0;
    }
}
