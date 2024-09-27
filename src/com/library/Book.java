package com.library;

public class Book {
    private final String bookID;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private int availablePrintedCopies;
    private int availableEBookCopies;
    private int availableAudioBookCopies;

    // Additional attributes for eBooks
    private double eBookFileSize;
    private String eBookFormat;

    // Additional attributes for audiobooks
    private double audioBookDuration;
    private String audioBookNarrator;

    // Constructor with all attributes
    public Book(String bookID, String title, String author, String publisher, String category, int totalPrintedCopies) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.availablePrintedCopies = totalPrintedCopies;
    }

    // Constructor without availableCopies for AudioBook and EBook
    public Book(String bookID, String title, String author, String publisher, String category) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }

    // Getters and setters
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    void setCategory(String category) {
        this.category = category;
    }

    public int getAvailablePrintedCopies() {
        return availablePrintedCopies;
    }

    public void setAvailablePrintedCopies(int availablePrintedCopies) {
        if (availablePrintedCopies < 0) {
            System.out.println("Available printed copies cannot be negative.");
        } else {
            this.availablePrintedCopies = availablePrintedCopies;
        }
    }

    public int getAvailableEBookCopies() {
        return availableEBookCopies;
    }

    public void setAvailableEBookCopies(int availableEBookCopies) {
        if (availableEBookCopies < 0) {
            System.out.println("Available eBook copies cannot be negative.");
        } else {
            this.availableEBookCopies = availableEBookCopies;
        }
    }

    public int getAvailableAudioBookCopies() {
        return availableAudioBookCopies;
    }

    public void setAvailableAudioBookCopies(int availableAudioBookCopies) {
        if (availableAudioBookCopies < 0) {
            System.out.println("Available audiobook copies cannot be negative.");
        } else {
            this.availableAudioBookCopies = availableAudioBookCopies;
        }
    }

    // Getters and setters for eBook attributes
    public double geteBookFileSize() {
        return eBookFileSize;
    }

    public void seteBookFileSize(double eBookFileSize) {
        this.eBookFileSize = eBookFileSize;
    }

    public String geteBookFormat() {
        return eBookFormat;
    }

    public void seteBookFormat(String eBookFormat) {
        this.eBookFormat = eBookFormat;
    }

    // Getters and setters for audiobook attributes
    public double getAudioBookDuration() {
        return audioBookDuration;
    }

    public void setAudioBookDuration(double audioBookDuration) {
        this.audioBookDuration = audioBookDuration;
    }

    public String getAudioBookNarrator() {
        return audioBookNarrator;
    }

    public void setAudioBookNarrator(String audioBookNarrator) {
        this.audioBookNarrator = audioBookNarrator;
    }

    // Display book information
    public void displayInfo() {
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Category: " + category);
        System.out.println("Available Printed Copies: " + availablePrintedCopies);
        System.out.println("eBook: " + (isEBookAvailable() ? "Available" : "Not Available"));
        if (isEBookAvailable()) {
            System.out.println("File Size: " + formatFileSize(eBookFileSize));
            System.out.println("Format: " + eBookFormat);
        }
        System.out.println("Audiobook: " + (isAudioBookAvailable() ? "Available" : "Not Available"));
        if (isAudioBookAvailable()) {
            System.out.println("Duration: " + formatDuration(audioBookDuration));
            System.out.println("Narrator: " + audioBookNarrator);
        }
    }

    // Utility method to format file size into a more readable format (MB or GB)
    public String formatFileSize(double fileSize) {
        if (fileSize >= 1024) {
            return String.format("%.2f GB", fileSize / 1024);
        } else {
            return String.format("%.2f MB", fileSize);
        }
    }

    // Utility method to format duration into hours and minutes
    public String formatDuration(double hours) {
        int hrs = (int) hours;
        int mins = (int) ((hours - hrs) * 60);
        return hrs + " hrs " + mins + " mins";
    }

    public boolean isEBookAvailable() {
        return availableEBookCopies > 0;
    }

    public boolean isAudioBookAvailable() {
        return availableAudioBookCopies > 0;
    }
}