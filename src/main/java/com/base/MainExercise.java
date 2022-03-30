package com.base;

import com.component.Palindrome;
import com.component.CardValidator;

import java.util.Scanner;

public class MainExercise {

    public static void main(String []args){
        System.out.println("Exercise #1: Credit Card Validator");
        CardValidator cardValidator = new CardValidator();
        String card = fetchCreditCardFromInput();
        System.out.println(cardValidator.verifyByLuhn(card));

        System.out.println("Exercise #2: Reverse and Add");
        Palindrome palindrome = new Palindrome(fetchIntegerFromInput());
        System.out.println(palindrome.getPalindrome() + " " + palindrome.getIterations());
    }

    public static int fetchIntegerFromInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        long number; // Long value to avoid Overflow/Underflow
        boolean rangeCheck = false;
        do {
            while (!sc.hasNextLong()) {
                System.out.println("That's not a integer!");
                //Not a number? Go to next input
                sc.next();
            }
            number = sc.nextLong();
            if(Integer.MIN_VALUE < number && number < Integer.MAX_VALUE){
                rangeCheck = true;
            }else{
                System.out.println("That integer  is outside of it's range!");
                //Outside of integer range? Go to next input
                sc.next();
            }
        } while (!rangeCheck);
        return (int) number;
    }
    public static String fetchCreditCardFromInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an credit card number : ");
        String number;
        boolean sizeCheck = false;
        do{
            while(!sc.hasNext("\\d*")){
                System.out.println("That's not a number!");
                //Not a number? Go to next input
                sc.nextLine();
            }
            number = sc.nextLine();
            if(12 <= number.length() && number.length() <= 19){
                sizeCheck = true;
            }
            else {
                System.out.println("Invalid input: card number cannot have less than 12 or more than 19 digits!");
                //Outside of card number digit range? Go to next input
                sc.nextLine();
            }
        }while (!sizeCheck);
        return number;
    }
}
