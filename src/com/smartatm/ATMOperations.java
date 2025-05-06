package com.smartatm;

interface ATMOperations {
    void deposit(int accNo, double amount) throws InvalidPinException;
    void withdraw(int accNo, double amount) throws InvalidPinException, InsufficientBalanceException;
    void viewBalance(int accNo);
    void viewMiniStatement(int accNo);
    void changePin(int accNo, int oldPin, int newPin) throws InvalidPinException;
}
