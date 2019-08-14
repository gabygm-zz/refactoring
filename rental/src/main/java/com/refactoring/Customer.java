package com.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentTotalPoint())
				+ " frequent renter points";
		return result;
	}

	private double getTotalAmount() {
		double totalAmount = rentalList.stream().mapToDouble(Rental::getCharge).sum();
		return totalAmount;
	}

	private int getTotalFrequentTotalPoint(){
		int frequentRenterPoints = rentalList.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
		return frequentRenterPoints;

	}

}
