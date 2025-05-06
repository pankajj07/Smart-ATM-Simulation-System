package com.smartatm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Main Driver Class
public class SmartATMSimulation {
 static Map<Integer, User> userDB = new HashMap<>();
 static ATMImplementation atm = new ATMImplementation(userDB);
 static Scanner scanner = new Scanner(System.in);
 static int accCounter = 1001;

 public static void main(String[] args) {
     while (true) {
         System.out.println("\n1. Create Account 2. Login 3. Exit");
         int choice = scanner.nextInt();
         switch (choice) {
             case 1:
                 createAccount();
                 break;
             case 2:
                 login();
                 break;
             case 3:
                 System.exit(0);
         }
     }
 }

 static void createAccount() {
     System.out.print("Enter Name: ");
     String name = scanner.next();
     System.out.print("Enter Mobile: ");
     String mobile = scanner.next();
     System.out.print("Set PIN: ");
     int pin = scanner.nextInt();
     System.out.print("Initial Deposit: ");
     double balance = scanner.nextDouble();

     User newUser = new User(accCounter, name, mobile, pin, balance);
     userDB.put(accCounter, newUser);
     System.out.println("Account Created! Your Account Number: " + accCounter);
     accCounter++;
 }

 static void login() {
     System.out.print("Enter Account Number: ");
     int accNo = scanner.nextInt();
     System.out.print("Enter PIN: ");
     int pin = scanner.nextInt();

     if (userDB.containsKey(accNo) && userDB.get(accNo).pin == pin) {
         userMenu(accNo);
     } else {
         System.out.println("Invalid credentials!");
     }
 }

 static void userMenu(int accNo) {
     while (true) {
         System.out.println("\n1. Deposit 2. Withdraw 3. Balance 4. Mini Statement 5. Change PIN 6. Logout");
         int choice = scanner.nextInt();
         try {
             switch (choice) {
                 case 1:
                     System.out.print("Enter amount: ");
                     double dAmount = scanner.nextDouble();
                     atm.deposit(accNo, dAmount);
                     break;
                 case 2:
                     System.out.print("Enter amount: ");
                     double wAmount = scanner.nextDouble();
                     atm.withdraw(accNo, wAmount);
                     break;
                 case 3:
                     atm.viewBalance(accNo);
                     break;
                 case 4:
                     atm.viewMiniStatement(accNo);
                     break;
                 case 5:
                     System.out.print("Enter old PIN: ");
                     int oldPin = scanner.nextInt();
                     System.out.print("Enter new PIN: ");
                     int newPin = scanner.nextInt();
                     atm.changePin(accNo, oldPin, newPin);
                     break;
                 case 6:
                     return;
             }
         } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
         }
     }
 }
}
