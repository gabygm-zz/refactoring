package com.refactoring;

public class Movie {
	// types of movies
	public static final int  CHILDRENS = 2;
	public static final int  REGULAR = 0;
	public static final int  NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}

    double getCharge(int getDaysRented ) {

        double totalAmount = 0;
        // determine amounts for each line
        switch (getPriceCode()) {
            case Movie.REGULAR:
                totalAmount += 2;
                if (getDaysRented > 2)
                    totalAmount += (getDaysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                totalAmount += getDaysRented * 3;
                break;
            case Movie.CHILDRENS:
                totalAmount += 1.5;
                if (getDaysRented > 3)
                    totalAmount += (getDaysRented - 3) * 1.5;
                break;

        }
        return totalAmount;
    }
}

