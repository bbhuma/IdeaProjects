package com.example.java8practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.TransactionScoped;

 class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}


public class StreamGoodExample {
	/*
	 * getDepositAmounts: Filters transactions of type "Deposit", maps them to their amounts, and collects them into a list. 
	 * getTotalDepositAmount: Filters transactions of type "Deposit", calculates the total amount, and returns it.
	 * getHighAmountTransactions: Filters transactions with amounts greater than a  specified threshold and returns them.
	 */
	
	// Filter transactions of type "Deposit", map them to their amounts, and collect into a list
    public static List<Double> getDepositAmounts(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getType().equals("Deposit"))
                .map(Transaction::getAmount)
                .collect(Collectors.toList());
    }

    // Filter transactions of type "Deposit", calculate the total amount, and return
    public static double getTotalDepositAmount(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getType().equals("Deposit"))
                .mapToDouble(Transaction::getAmount)
                .reduce(0, Double::sum);
    }
  
    // Filter transactions with amount greater than a threshold and return
    public static List<Transaction> getHighAmountTransactions(List<Transaction> transactions, double threshold) {
        return transactions.stream()
                .filter(t -> t.getAmount() > threshold)
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Deposit", 1000),
                new Transaction("Withdrawal", 500),
                new Transaction("Deposit", 1500),
                new Transaction("Withdrawal", 200)
        );

        List<Double> depositAmounts = getDepositAmounts(transactions);
        System.out.println("Deposit amounts: " + depositAmounts);

        double totalDepositAmount = getTotalDepositAmount(transactions);
        System.out.println("Total deposit amount: " + totalDepositAmount);
        
        List<Transaction> highAmountTransactions = getHighAmountTransactions(transactions, 1000);
        System.out.println("High amount transactions: " + highAmountTransactions);
    }

}
