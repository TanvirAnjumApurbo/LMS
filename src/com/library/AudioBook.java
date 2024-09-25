package com.library;

public class AudioBook extends Book {
    private double duration; // in hours
    private String narrator;

    public AudioBook(String bookID, String title, String author, String publisher, String category, double duration, String narrator) {
        super(bookID, title, author, publisher, category); // Call to superclass constructor
        setDuration(duration);  // Validate and set duration
        this.narrator = narrator;
        setAvailableAudioBookCopies(1); // Mark audiobook as available
        setAudioBookDuration(duration); // Initialize audiobook attributes in superclass
        setAudioBookNarrator(narrator); // Initialize audiobook attributes in superclass
    }

    // Getters and Setters
    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        try {
            if (duration > 0) {
                this.duration = duration;
            } else {
                throw new IllegalArgumentException("Duration must be positive.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }
}