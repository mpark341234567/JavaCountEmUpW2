package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class GroceryCounter{
    ArrayList<Integer> amount = new ArrayList<>();
    int NumOfDigits = 4;
    int overflows = 0;
    int MAX_VALUE = 9999;
    int MIN_VALUE = 0;
    Scanner input = new Scanner(System.in);
    public GroceryCounter(){
        getStartingValue();
        createArrayList(NumOfDigits);
    }
    public void getStartingValue(){
        boolean done = false;
        System.out.println("Enter a starting integer value: ");
        int IntCheck = 0;
        while (!done) {
            String startVal = input.nextLine();
            try {
                IntCheck = Integer.parseInt(startVal);
                if (IntCheck < MIN_VALUE){
                    throw new ArithmeticException();
                }
                done = true;
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } 
        input.close();
        String temp = Integer.toString(IntCheck);
        setNumOfDigits(temp.length());//mutator
    }
    public void getMaxValue(){
        boolean done = false;
        System.out.println("Enter a max integer value: ");
        int IntCheck = 0;
        while (!done) {
            String startVal = input.nextLine();
            try {
                IntCheck = Integer.parseInt(startVal);
                if ((IntCheck < MIN_VALUE)&&(IntCheck > Integer.parseInt(total()))){
                    throw new ArithmeticException();
                }
                done = true;
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println("Invalid input. Please enter a valid max integer.");
            }
        } 
        input.close();
        MAX_VALUE = IntCheck;
    }
    public void setNumOfDigits(int i){
        NumOfDigits = i;
    }
    public void createArrayList(int i){//fills array list of size NumOfDigits with NumOfDigits amount of zeros
        for (int j = 0; j < i; j++){
            amount.add(0);
        }
    }
    public void tens(){
        if (amount.get(NumOfDigits-4)==9){//if digit in the tens index equals 9
            overflows++;//increment overflow
            amount.set(NumOfDigits-4, 0);//set tens index to 0
        }
        else{
            amount.set(NumOfDigits-4, (amount.get(NumOfDigits-4)+1));//increment tens index
        }
    }//copy paste for other methods of this type
    public void ones(){
        if (amount.get(NumOfDigits-3)==9){
            tens();
            amount.set(NumOfDigits-3, 0);
        }
        else{
            amount.set(NumOfDigits-3, (amount.get(NumOfDigits-3)+1));
        }
    }
    public void tenths(){
        if (amount.get(NumOfDigits-2)==9){
            ones();
            amount.set(NumOfDigits-2, 0);
        }
        else{
            amount.set(NumOfDigits-2, (amount.get(NumOfDigits-2)+1));
        }
    }
    public void hundreths(){
        if (amount.get(NumOfDigits-1)==9){
            tenths();
            amount.set(NumOfDigits-1, 0);
        }
        else{
            amount.set(NumOfDigits-1, (amount.get(NumOfDigits-1)+1));
        }
    }
    public void decrementTens(){
        if (amount.get(NumOfDigits-4)==0){//if tens index is 0
            overflows--;//decrement overflows
            amount.set(NumOfDigits-4, 9);//set tens index to 9
        }
        else{
            amount.set(NumOfDigits-4, (amount.get(NumOfDigits-4)-1));//decrement tens index
        }
    }//copy paste for other methods of this type
    public void decrementOnes(){
        if (amount.get(NumOfDigits-3)==0){
            decrementTens();
            amount.set(NumOfDigits-3, 9);
        }
        else{
            amount.set(NumOfDigits-3, (amount.get(NumOfDigits-3)-1));
        }
    }
    public void decrementTenths(){
        if (amount.get(NumOfDigits-2)==0){
            decrementOnes();
            amount.set(NumOfDigits-2, 9);
        }
        else{
            amount.set(NumOfDigits-2, (amount.get(NumOfDigits-2)-1));
        }
    }
    public void decrementHundreths(){
        if (amount.get(NumOfDigits-1)==0){
            decrementTenths();
            amount.set(NumOfDigits-1, 9);
        }
        else{
            amount.set(NumOfDigits-1, (amount.get(NumOfDigits-1)-1));
        }
    }
    public String total(){
        String returnTotal = "$";//creates string with $
        for (int i = 0; i < NumOfDigits; i++){//iterates over each digit in amount array list
            if ((NumOfDigits-2)==i){//if there are 2 digits left to be printed
                returnTotal = returnTotal + ".";//add a . to denote cents
            }
            returnTotal = returnTotal + Integer.toString(amount.get(i));//add digit to string
        }
        return returnTotal;
    }
    public int overflows(){
        return overflows;
    }
    public void clear(){
        for (int i =0; i < NumOfDigits; i++){
            amount.set(i,0);
        }
    }
    public void increment(int amountToIncrement){
        
    }
}