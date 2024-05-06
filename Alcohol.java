/*
 * Class: CMSC203 CRN 30340
 * Instructor: Khandan Monshi
 * Description: Alcohol java file, defines the Alcohol class.
 * Due: 05/05/2024
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Jeffrey Chu
 */

public class Alcohol extends Beverage {
	
	// Fields/attributes
	private double basePrice = 0;
	private String bevName;
	private Type type;
	private Size size;
	private final double SIZE_PRICE = 0.5;
	private boolean isWeekend = false;
	private final double WEEKEND_PRICE = 0.6;
	
	// Parameterized constructor
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	// Other methods
	/**
	 * Indicates whether or not it is the weekend
	 * @return true, if is weekend
	 */
	public boolean isWeekend() {
		return this.isWeekend;
	}
	
	@Override
	/**
	 * Calculates the price of the alcohol
	 * @return the price of the alcohol beverage
	 */
	public double calcPrice() {
		double price = 0;
		
		if (this.size == Size.SMALL) {
			price = this.basePrice;
		} else if (this.size == Size.MEDIUM) {
			price = this.basePrice + SIZE_PRICE;
		} else {
			price = this.basePrice + (2 * SIZE_PRICE);
		}
		
		if (this.isWeekend) {
			price += WEEKEND_PRICE;
		}
		
		return price;
	}
	
	@Override
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @param anotherBev
	 * @return true if the name, type, size and base price, number of Fruits and add protein are the same, false otherwise
	 */
	public boolean equals(Object anotherBev) {
		if (this.bevName.equals(((Beverage) anotherBev).getBevName()) && this.type == ((Beverage) anotherBev).getType() && this.size == ((Beverage) anotherBev).getSize() && this.basePrice == ((Beverage) anotherBev).getBasePrice() && this.isWeekend == ((Alcohol) anotherBev).isWeekend()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	/**
	 * Returns Represents a Alcohol drink. Contains the name, size, whether or not beverage is offered in weekend, and price
	 * @return string representation of a Alcohol drink
	 */
	public String toString() {
		return this.bevName + ", " + this.SIZE_PRICE + ", " + this.isWeekend + ", " + calcPrice();
	}
	
}