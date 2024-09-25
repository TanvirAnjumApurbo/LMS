package com.library;

public class EBook extends Book {
    private double fileSize; // in MB
    private String format; // e.g., PDF, EPUB

    public EBook(String bookID, String title, String author, String publisher, String category, double fileSize, String format) {
        super(bookID, title, author, publisher, category); // Call to superclass constructor
        setFileSize(fileSize); // Ensure file size is positive
        setFormat(format); // Ensure format is valid
        setAvailableEBookCopies(1); // Mark eBook as available
        seteBookFileSize(fileSize); // Initialize eBook attributes in superclass
        seteBookFormat(format); // Initialize eBook attributes in superclass
    }

    // Getters and Setters with validation
    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        if (fileSize > 0) {
            this.fileSize = fileSize;
        } else {
            throw new IllegalArgumentException("File size must be positive.");
        }
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if (isValidFormat(format)) {
            this.format = format;
        } else {
            throw new IllegalArgumentException("Unsupported format. Please choose a valid eBook format (PDF, EPUB, etc.).");
        }
    }

    // Private helper method to validate format
    private boolean isValidFormat(String format) {
        return format.equalsIgnoreCase("PDF") || format.equalsIgnoreCase("EPUB") || format.equalsIgnoreCase("MOBI");
    }
}