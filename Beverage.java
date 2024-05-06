/*
 * Class: CMSC203 CRN 30340
 * Instructor: Khandan Monshi
 * Description: Beverage java file, defines the Beverage class.
 * Due: 05/05/2024
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Jeffrey Chu
 */

public abstract class Beverage {
	
	// Fields/attributes
	private double basePrice = 0;
	private String bevName;
	private Type type;
	private Size size;
	private final double SIZE_PRICE = 0.5;
	
	// Parameterized constructor
	/**
	 * Creates a Beverage object using given values
	 * @param bevName
	 * @param type
	 * @param size
	 */
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	// Accessor/getter methods
	/**
	 * Gets the base price
	 * @return the base price
	 */
	public double getBasePrice() {
		return this.basePrice;
	}
	
	/**
	 * Gets the name of the beverage
	 * @return the beverage name
	 */
	public String getBevName() {
		return this.bevName;
	}
	
	/**
	 * Gets beverage type
	 * @return type of beverage
	 */
	public Type getType() {
		return this.type;
	}
	
	/*
	 * Gets the size of the beverage
	 * @return size of the beverage
	 */
	public Size getSize() {
		return this.size;
	}
	
	// Other methods
	/**
	 * Calculates a new price by adding the size price to the base price. There is no additional cost for small size, for medium and large beverages the additional cost of size price is added to base price For example if the base price is 2 and SIZE_PRICE is .5 then the cost of small beverage is 2, the medium beverage is 2.5 and the large beverage is 3.
	 * @return a new price that by adding the size price to the base price
	 */
	public double addSizePrice() {
		if (this.size == Size.SMALL) {
			return this.basePrice;
		} else if (this.size == Size.MEDIUM) {
			return this.basePrice += SIZE_PRICE;
		} else {
			return this.basePrice += (2 * SIZE_PRICE);
		}
	}
	
	/**
	 * Calculates the beverage price
	 * @return the price of the beverage
	 */
	public abstract double calcPrice();
	
	@Override
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @param anotherBev
	 * @return true if the name, type, size, false otherwise
	 */
	public boolean equals(Object anotherBev) {
		if (this.bevName.equals(((Beverage) anotherBev).getBevName()) && this.type == ((Beverage) anotherBev).getType() && this.size == ((Beverage) anotherBev).getSize()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Represents a Beverage object in String with the format of bevName, size
	 * @return string representation of beverage
	 */
	public String toString() {
		return this.bevName + ", " + this.size;
	}
	
}