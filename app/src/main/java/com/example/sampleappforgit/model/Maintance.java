package com.example.sampleappforgit.model;

public class Maintance
{

    private int expenses;
    private int balance;
    private int date;
    private String type;

    public Maintance( int expenses, int balance, int date, String type) {
        this.expenses = expenses;
        this.balance = balance;
        this.date = date;

        this.type = type;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


}
