package com.lexicon.demos;

import java.util.Scanner;

public class Main {


    static boolean performed = false;

    public static void main(String[] args) {


        Scanner keyboard = new Scanner(System.in);


        final int BALANCE = 1;
        final int DEPOSIT = 2;
        final int WITHDRAW = 3;
        final int INTEREST = 4;
        final int STOCKS = 5;
        final int QUIT = 6;
        int balance = 0;


        System.out.println("Welcome to ATM.");

        while (true){

            System.out.println("Please enter name and pin.\n");

            System.out.print("Name: ");
            String name = keyboard.next();
            System.out.print("Pin: ");
            int pin = keyboard.nextInt();

            //Change balance once, don't play method again
            if(name.equals("John")&!performed){
                balance = 1000;
                performed=true;}
            else if (name.equals("Jane")&!performed){
                balance = 250000;
                performed=true;}

            //Compare users
            if (name.equals("John")&&(pin == 1234) ||name.equals("Jane")&&(pin == 4321)) {

//Menu
                System.out.println("\nHello "+name+".\n\n1. Check balance. \n2. Deposit \n3. Withdraw \n4. Calculate interest\n5. Stock Market\n6. Quit");
                while (true)
                {
                    int choice = keyboard.nextInt();//Input command 1-6

                    //Check the balance
                    if (choice == BALANCE) {
                        System.out.println("\n"+name+", your balance is: \n"+balance+" kr");
                    }//balance

                    //Deposit cash
                    else if (choice == DEPOSIT) {
                        System.out.println("\n"+name+", your balance is: \n"+balance+" kr");
                        System.out.println("Enter your deposit.");

                        int deposit = keyboard.nextInt();
                        int newBalance = balance;

                        System.out.print("Your balance is now: \n"+(newBalance+deposit)+" kr\n");
                        balance = (newBalance+deposit); //Update the new balance
                    }//deposit

                    else if (choice == WITHDRAW) {
                        System.out.println("\n"+name+", your balance is: \n"+balance+ " kr");
                        System.out.println("Enter your withdrawal.");
                        int withdraw = keyboard.nextInt();
                        int newBalance = balance;
                        if (balance - withdraw<0){
                            System.out.print("ERROR. \nYou don't have enough.\n");
                        }
                        else if (withdraw>2000){
                            System.out.print("ERROR. \nWithdrawal sum is too large. Max 2000 kr\n");
                        }
                        else {
                            System.out.print("Your balance is now: \n"+(newBalance-withdraw)+" kr\n");
                            balance = (newBalance-withdraw);//Update the new balance
                        }//Withdraw

                    }
                    else if (choice == INTEREST) {
                        System.out.println("\n"+name+", your balance is: \n"+balance+ " kr");
                        System.out.println("Interest rate per annum.");
                        double irpa = keyboard.nextInt();
                        System.out.println("Years to calculate interest.");
                        double tyears = keyboard.nextDouble();
                        double totalrate = Math.pow(1 + irpa / 100, tyears);
                        double itotal = balance * totalrate;
                        System.out.print("Your balance after ");
                        System.out.print((int) tyears);
                        System.out.println(" years is ");
                        System.out.print(itotal);
                        System.out.println(" kr.");
                        System.out.print("With a net increase of ");
                        System.out.print(itotal - balance);
                        System.out.print(" kr.\n");

                    }//Interest

                    else if (choice == STOCKS) {//Randomized *
                        String market;//++Up --Down
                        System.out.println("\n"+name+", your balance is: \n"+balance+ " kr");
                        System.out.println("How much you like to spend on stocks.");

                        int spend = keyboard.nextInt();

                        int stocks = (int)Math.floor((Math.random() * 41) - 20);//Results between -20 and 20
                        int win;
                        int loss;
                        int result;
                        int newBalance = (balance - spend);

                        if (balance - spend < 0){//Not enough in balance
                            System.out.println("ERROR. Not enough funds!");
                        }
                        else {//else run stock market
                            if (stocks  >0){//If random rolls +1 - 20

                                win = (stocks*spend);
                                result = (spend+win);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("\nYou spend "+spend+" kr.");
                                try {
                                    Thread.sleep(1500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("\n++UP++  \nThe stock market went up with "+stocks+"00%!");
                                try {
                                    Thread.sleep(750);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("You have earned "+win+" kr.");
                                try {
                                    Thread.sleep(750);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Your investment of "+spend+" kr is also returned.");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("The stock market deposits "+result+" kr.");
                                balance = (newBalance + result);
                                try {
                                    Thread.sleep(750);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("\nYour balance is now: \n"+balance+ " kr");
                                try {
                                    Thread.sleep(1500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }//Win

                            if (stocks <0){//If random rolls -1 - -20

                                loss = (stocks*spend);
                                result = (spend+loss);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("\nYou spend "+spend+" kr.");
                                try {
                                    Thread.sleep(1500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("\n--DOWN-- \nThe stock market went down with " +stocks+"00%!");
                                try {
                                    Thread.sleep(750);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("You have lost a total of "+loss+" kr.");

                                balance = (newBalance + result);
                                try {
                                    Thread.sleep(750);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("You lose your investment of "+spend+" kr.");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("The stock market withdraws "+result+" kr.");
                                try {
                                    Thread.sleep(750);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("\nYour balance is now: \n"+balance+ " kr.");
                                try {
                                    Thread.sleep(1500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                if (balance< -1)System.out.println("You are now in debt!");//If the balance ends up below 0
                            }//Loss
                            else if (stocks == 0)//If random rolls 0
                                System.out.println("\nThe stock market was stable.");//Nothing

                        }//else if enough funds, run stock market


                    } //Stocks

                    //Exit the program
                    else if (choice == QUIT) {
                        System.out.println("\n Farewell, "+name+".");
                        return;
                    }

                    else System.out.println("\nERROR. Please use:");
                    System.out.println("\n1. Check balance. \n2. Deposit \n3. Withdraw \n4. Calculate interest\n5. Stock Market\n6. Quit");
                }//if accounts
            }
            //error wrong password
            else if((name.equals("John")&&(pin != 1234) ||name.equals("Jane")&&(pin != 4321))) System.out.println("Wrong password.");
                //error wrong username
            else System.out.println("User doesn't exist.");
        }//while
    }//Main


}//ATMmini
