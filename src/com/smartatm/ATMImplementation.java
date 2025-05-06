package com.smartatm;

import java.util.Map;

class ATMImplementation implements ATMOperations {
    Map<Integer, User> userDB;

    public ATMImplementation(Map<Integer, User> userDB) {
        this.userDB = userDB;
    }

    public void deposit(int accNo, double amount) throws InvalidPinException {
        User user = userDB.get(accNo);
        user.balance += amount;
        user.miniStatement.add("Deposited: " + amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw(int accNo, double amount) throws InsufficientBalanceException {
        User user = userDB.get(accNo);
        if (user.balance < amount) {
            throw new InsufficientBalanceException("Insufficient funds.");
        }
        user.balance -= amount;
        user.miniStatement.add("Withdrawn: " + amount);
        System.out.println("Withdrawal successful.");
    }

    public void viewBalance(int accNo) {
        User user = userDB.get(accNo);
        System.out.println("Current Balance: " + user.balance);
    }

    public void viewMiniStatement(int accNo) {
        User user = userDB.get(accNo);
        System.out.println("Mini Statement:");
        for (String entry : user.miniStatement) {
            System.out.println(entry);
        }
    }

    public void changePin(int accNo, int oldPin, int newPin) throws InvalidPinException {
        User user = userDB.get(accNo);
        if (user.pin != oldPin) throw new InvalidPinException("Old PIN is incorrect.");
        user.pin = newPin;
        System.out.println("PIN changed successfully.");
    }
}
