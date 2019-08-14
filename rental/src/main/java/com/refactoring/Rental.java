package com.refactoring;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge() {
        double totalAmount = movie.getCharge(daysRented);
        return totalAmount;
    }



    int getFrequentRenterPoints() {
        int frequentRenterPoints = 1;
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    String getDetailRentalMovie() {
        String result = "";
        result += "\t" + getMovie().getTitle() + "\t" + String.valueOf(getCharge()) + "\n";
        return result;
    }
}