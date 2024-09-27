package com.library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String memberID;
    private String name;
    private String contactInfo;
    private final List<Book> borrowedBooks;

    public Member(String memberID, String name, String contactInfo) {
        this.memberID = memberID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

   void setName(String name) {
        this.name = name;
    }

    void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Borrow a book (checks availability in the Library class)
    public void borrowBook(Library library, String bookTitle) {
        if (library.borrowBook(this, bookTitle)) { // Use Library's method and check success
            System.out.println(name + " borrowed " + bookTitle);
        } else {
            System.out.println(name + " couldn't borrow " + bookTitle);
        }
    }

    // Return a book and increase the number of available copies in the Library
    public void returnBook(Library library, String bookTitle) {
        if (library.returnBook(this, bookTitle)) { // Use Library's method and check success
            System.out.println(name + " returned " + bookTitle);
        } else {
            System.out.println(name + " couldn't return " + bookTitle);
        }
    }

    // Update member's info
//    public void updateMemberInfo(String newName, String newContactInfo) {
//        this.name = newName;
//        this.contactInfo = newContactInfo;
//        System.out.println("Updated member info: " + name + ", Contact: " + contactInfo);
//    }

    // List all borrowed books
    public void listBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}
