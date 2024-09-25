package com.library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final String transactionID;
    private final Book book;
    private final Member member;
    private final Date borrowDate;
    private Date returnDate;
    private String status;  // "In Progress" or "Completed"

    // Date format for displaying dates
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    // Constructor for a new transaction (borrow operation)
    public Transaction(Book book, Member member) {
        this.transactionID = UUID.randomUUID().toString();  // Generate unique transaction ID
        this.book = book;
        this.member = member;
        this.borrowDate = new Date();  // Set borrow date to current date and time
        this.status = "In Progress";   // Initially, the status is "In Progress"
    }

    // Log transaction details
    public void logTransaction() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Book: " + book.getTitle());
        System.out.println("Member: " + member.getName());
        System.out.println("Borrow Date: " + dateFormat.format(borrowDate));
        if (returnDate != null) {
            System.out.println("Return Date: " + dateFormat.format(returnDate));
        } else {
            System.out.println("Book not yet returned.");
        }
        System.out.println("Status: " + status);
    }

    // Return book and update the transaction with the return date
    public void completeTransaction() {
        this.returnDate = new Date();  // Set the return date to current date and time
        this.status = "Completed";     // Mark the transaction as completed
    }

    // Getters
    public String getTransactionID() {
        return transactionID;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }
}