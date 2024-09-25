package com.library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LMS {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add Member");
            System.out.println("4. Remove Member");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search Book by Title");
            System.out.println("8. Display All Books");
            System.out.println("9. Update Book");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = input.nextInt();
                input.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        String bookID = input.nextLine();
                        System.out.print("Enter Title: ");
                        String title = input.nextLine();
                        System.out.print("Enter Author: ");
                        String author = input.nextLine();
                        System.out.print("Enter Publisher: ");
                        String publisher = input.nextLine();
                        System.out.print("Enter Category: ");
                        String category = input.nextLine();
                        System.out.print("Enter Format (Printed/EBook/AudioBook): ");
                        String format = input.nextLine();

                        Book newBook = null;
                        switch (format.toLowerCase()) {
                            case "printed":
                                System.out.print("Enter Number of Printed Copies: ");
                                int printedCopies = input.nextInt();
                                newBook = new Book(bookID, title, author, publisher, category, printedCopies);
                                break;
                            case "ebook":
                                System.out.print("Enter File Size (MB): ");
                                double fileSize = input.nextDouble();
                                input.nextLine(); // consume newline
                                System.out.print("Enter Format (PDF/EPUB): ");
                                String bookFormat = input.nextLine();
                                newBook = new EBook(bookID, title, author, publisher, category, fileSize, bookFormat);
                                break;
                            case "audiobook":
                                System.out.print("Enter Duration (hours): ");
                                double duration = input.nextDouble();
                                input.nextLine(); // consume newline
                                System.out.print("Enter Narrator: ");
                                String narrator = input.nextLine();
                                newBook = new AudioBook(bookID, title, author, publisher, category, duration, narrator);
                                break;
                            default:
                                System.out.println("Invalid format.");
                                break;
                        }
                        if (newBook != null) {
                            library.addBook(newBook);
                        }
                        break;

                    case 2:
                        System.out.print("Enter Title of the Book to Remove: ");
                        String removeTitle = input.nextLine();
                        Book removeBook = library.searchBookByTitle(removeTitle);
                        if (removeBook != null) {
                            library.removeBook(removeBook);
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Member ID: ");
                        String memberID = input.nextLine();
                        System.out.print("Enter Name: ");
                        String memberName = input.nextLine();
                        System.out.print("Enter Contact Info: ");
                        String contactInfo = input.nextLine();

                        Member newMember = new Member(memberID, memberName, contactInfo);
                        library.addMember(newMember);
                        break;

                    case 4:
                        System.out.print("Enter Member ID to Remove: ");
                        String removeMemberID = input.nextLine();
                        Member removeMember = library.getMember(removeMemberID);
                        if (removeMember != null) {
                            library.removeMember(removeMember);
                        } else {
                            System.out.println("Member not found.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Member ID: ");
                        String borrowMemberID = input.nextLine();
                        Member borrowMember = library.getMember(borrowMemberID);
                        if (borrowMember != null) {
                            System.out.print("Enter Book Title to Borrow: ");
                            String borrowTitle = input.nextLine();
                            borrowMember.borrowBook(library, borrowTitle);
                        } else {
                            System.out.println("Member not found.");
                        }
                        break;

                    case 6:
                        System.out.print("Enter Member ID: ");
                        String returnMemberID = input.nextLine();
                        Member returnMember = library.getMember(returnMemberID);
                        if (returnMember != null) {
                            System.out.print("Enter Transaction ID: ");
                            String transactionID = input.nextLine();
                            returnMember.returnBook(library, transactionID);
                        } else {
                            System.out.println("Member not found.");
                        }
                        break;

                    case 7:
                        System.out.print("Enter Book Title to Search: ");
                        String searchTitle = input.nextLine();
                        Book searchBook = library.searchBookByTitle(searchTitle);
                        if (searchBook != null) {
                            searchBook.displayInfo();
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 8:
                        library.listInventory();
                        break;

                    case 9:
                        System.out.print("Enter Book ID to Update: ");
                        String updateBookID = input.nextLine();
                        library.updateBook(updateBookID);
                        break;

                    case 10:
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                input.nextLine(); // consume invalid input
            }
        }
        input.close();
    }
}