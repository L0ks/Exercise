package com.component;

public class Palindrome {
    private int number;
    private int iterations = 0;

    public Palindrome(int number){
        this.number = number;
    }

    public int getPalindrome(){
        //Reset iterations, in case the method is called again
        iterations = 0;
        int value = number;
        do{
            //reverse the digits of the number and add it to the original
            value += reverseNumber(value);
            iterations++;

            if(iterations > 1000)
                return -1;

        }while (!isPalindrome(value));
        return value;
    }

    public int getIterations(){
        return iterations;
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }



    public boolean isPalindrome(int number){
        return number == reverseNumber(number);
    }

    public int reverseNumber(int input){
        int reversed = 0;
        while(input != 0) {
            // get last digit from input
            int digit = input % 10;
            reversed = reversed * 10 + digit;
            // remove the last digit from input
            input /= 10;
        }
        return reversed;
    }

    /*public String getPalindrome(int number){
        int iterations = 0;
        do{
            // reverse the digits of the number and add it to the original
            number += reverseNumber(number);
            iterations++;

            if(iterations > 1000)
                return "Iteration limit has been exceeded";

        }while (!isPalindrome(number));
        return String.format("%d %d", number, iterations);
    }*/



//    public static void main(String[] args) {
//        System.out.println(getPalindrome(readUserInput()));
//    }

//    public static int fetchIntegerFromInput(){
//        Scanner sc= new Scanner(System.in);
//        System.out.print("Enter an integer : ");
//        long number; // Long value to avoid Overflow/Underflow
//        boolean rangeCheck = false;
//        do {
//            while (!sc.hasNextLong()) {
//                System.out.println("That's not a integer!");
//                //Not a number? Go to next input
//                sc.next();
//            }
//            number = sc.nextLong();
//            if(Integer.MIN_VALUE < number && number < Integer.MAX_VALUE){
//                rangeCheck = true;
//            }else{
//                System.out.println("That integer  is outside of it's range!");
//                //Outside of integer range? Go to next input
//                sc.next();
//            }
//        } while (!rangeCheck);
//        return (int) number;
//    }
//
//    public static String getPalindrome(int number){
//        int iterations = 0;
//        do{
//            // reverse the digits of the number and add it to the original
//            number += reverseNumber(number);
//            iterations++;
//
//            if(iterations > 1000)
//                return "Iteration limit has been exceeded";
//
//        }while (!isPalindrome(number));
//        return String.format("%d %d", number, iterations);
//    }
//
//    public static boolean isPalindrome(int number){
//        return number == reverseNumber(number);
//    }
//
//    public static int reverseNumber(int input){
//        int reversed = 0;
//        while(input != 0) {
//            // get last digit from input
//            int digit = input % 10;
//            reversed = reversed * 10 + digit;
//            // remove the last digit from input
//            input /= 10;
//        }
//        return reversed;
//    }
}