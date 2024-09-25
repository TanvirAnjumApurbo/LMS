package com.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final ArrayList<Book> bookInventory;
    private final HashMap<String, Member> members;
    private final List<Transaction> transactions;

    public Library() {
        this.bookInventory = new ArrayList<>();
        this.members = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    // Adding and removing books from inventory
    public void addBook(Book book) {
        boolean exists = false;
        for (Book b : bookInventory) {
            if (b.getBookID().equals(book.getBookID())) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            bookInventory.add(book);
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Book with ID " + book.getBookID() + " already exists.");
        }
    }

    public void removeBook(Book book) {
        if (bookInventory.remove(book)) {
            System.out.println("Book removed: " + book.getTitle());
        } else {
            System.out.println("Book not found in inventory.");
        }
    }

    // Update book information
    public void updateBook(String bookID) {
        Scanner input = new Scanner(System.in);
        for (Book book : bookInventory) {
            if (book.getBookID().equals(bookID)) {
                System.out.print("Enter Format to Update (Printed/EBook/AudioBook): ");
                String format = input.nextLine().toLowerCase();

                switch (format) {
                    case "printed":
                        System.out.print("Enter Number of Printed Copies: ");
                        int printedCopies = input.nextInt();
                        input.nextLine(); // consume newline
                        book.setAvailablePrintedCopies(printedCopies);
                        break;
                    case "ebook":
                        System.out.print("Enter File Size (MB): ");
                        double fileSize = input.nextDouble();
                        input.nextLine(); // consume newline
                        System.out.print("Enter Format (PDF/EPUB): ");
                        String bookFormat = input.nextLine();
                        book.seteBookFileSize(fileSize);
                        book.seteBookFormat(bookFormat);
                        book.setAvailableEBookCopies(1); // Mark eBook as available
                        break;
                    case "audiobook":
                        System.out.print("Enter Duration (hours): ");
                        double duration = input.nextDouble();
                        input.nextLine(); // consume newline
                        System.out.print("Enter Narrator: ");
                        String narrator = input.nextLine();
                        book.setAudioBookDuration(duration);
                        book.setAudioBookNarrator(narrator);
                        book.setAvailableAudioBookCopies(1); // Mark audiobook as available
                        break;
                    default:
                        System.out.println("Invalid format.");
                        break;
                }
                System.out.println("Book updated: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Adding and removing members
    public void addMember(Member member) {
        members.put(member.getMemberID(), member);
        System.out.println("Member added: " + member.getName());
    }

    public void removeMember(Member member) {
        if (members.remove(member.getMemberID()) != null) {
            System.out.println("Member removed: " + member.getName());
        } else {
            System.out.println("Member not found.");
        }
    }

    // Search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : bookInventory) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Borrow a book
    public boolean borrowBook(Member member, String bookTitle) {
        Book book = searchBookByTitle(bookTitle);
        if (book != null) {
            if (book.getAvailablePrintedCopies() > 0) {
                book.setAvailablePrintedCopies(book.getAvailablePrintedCopies() - 1);
                member.getBorrowedBooks().add(book);
                Transaction transaction = new Transaction(book, member);
                transactions.add(transaction);
                transaction.logTransaction();
                return true;
            } else {
                System.out.println("No printed copies of '" + bookTitle + "' are currently available.");
                return false;
            }
        } else {
            System.out.println("Book '" + bookTitle + "' not found in inventory.");
            return false;
        }
    }

    // Return a book
    public boolean returnBook(Member member, String transactionID) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionID().equals(transactionID) && transaction.getStatus().equals("In Progress")) {
                Book book = transaction.getBook();
                if (member.getBorrowedBooks().remove(book)) {
                    book.setAvailablePrintedCopies(book.getAvailablePrintedCopies() + 1);
                    transaction.completeTransaction();
                    transaction.logTransaction();
                    return true;
                }
            }
        }
        System.out.println("Transaction ID '" + transactionID + "' not found or already completed.");
        return false;
    }

    // List inventory and members
    public void listInventory() {
        System.out.println("Library Inventory:");
        for (Book book : bookInventory) {
            book.displayInfo();
        }
    }

    public void listMembers() {
        System.out.println("Library Members:");
        for (Member member : members.values()) {
            System.out.println(member.getName() + " (ID: " + member.getMemberID() + ")");
        }
    }

    // Getter method for members
    public Member getMember(String memberID) {
        return members.get(memberID);
    }
}