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
        double totalAmount = 0;
        // determine amounts for each line
        switch (getMovie().getPriceCode()) {
        case Movie.REGULAR:
            totalAmount += 2;
            if (getDaysRented() > 2)
                totalAmount += (getDaysRented() - 2) * 1.5;
            break;
        case Movie.NEW_RELEASE:
            totalAmount += getDaysRented() * 3;
            break;
        case Movie.CHILDRENS:
            totalAmount += 1.5;
            if (getDaysRented() > 3)
                totalAmount += (getDaysRented() - 3) * 1.5;
            break;

        }
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