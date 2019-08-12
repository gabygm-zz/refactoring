package com.refactoring;

public class Rental {

    private Movie mov;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.mov = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMov() {
        return mov;
    }
}