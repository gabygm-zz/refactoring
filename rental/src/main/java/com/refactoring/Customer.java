package com.refactoring;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
		String result = String.format("%s%s%s",getHeader(), getDetailsMovieRented(), getFooter());
		return result;
	}

	private String getFooter() {
		String result = "";
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentTotalPoint())
				+ " frequent renter points";
		return result;
	}

	private String getDetailsMovieRented() {
		String result = rentalList.stream().map(Rental::getDetailRentalMovie).collect(Collectors.joining());
		return result;
	}

	private String getHeader() {
		return "Rental Record for " + getName() + "\n";
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
