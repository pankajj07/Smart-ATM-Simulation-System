package com.smartatm;

import java.util.LinkedList;
import java.util.Queue;

class User {
    int accountNumber;
    String name;
    String mobile;
    int pin;
    double balance;
    Queue<String> miniStatement = new LinkedList<>();

    public User(int accountNumber, String name, String mobile, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.mobile = mobile;
        this.pin = pin;
        this.balance = balance;
    }
}
