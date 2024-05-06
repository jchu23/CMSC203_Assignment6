/*
 * Class: CMSC203 CRN 30340
 * Instructor: Khandan Monshi
 * Description: Coffee java file, defines the Coffee class.
 * Due: 05/05/2024
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Jeffrey Chu
 */

public class Coffee extends Beverage {
	
	// Fields/attributes
	private double basePrice = 0;
	private String bevName;
	private Type type;
	private Size size;
	private final double SIZE_PRICE = 0.5;
	private boolean extraShot = false;
	private boolean extraSyrup = false;
	private final double SHOT_PRICE = 0.5;
	private final double SYRUP_PRICE = 0.5;
	
	// Parameterized constructor
	/**
	 * Creates a Coffee object using the given values
	 * @param bevName
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	// Other methods
	/**
	 * Indicates whether or not extra shot is added
	 * @return extra shot
	 */
	public boolean getExtraShot() {
		return this.extraShot;
	}
	
	/**
	 * Indicates whether or not extra syrup is added
	 * @return extra syrup
	 */
	public boolean getExtraSyrup() {
		return this.extraSyrup;
	}
	
	@Override
	/**
	 * Calculates the price of the coffee based on base price, size, extra shot, and extra syrup
	 * @return the price of a coffee beverage
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
		
		if (this.extraShot) {
			price += SHOT_PRICE;
		}
		
		if (this.extraSyrup) {
			price += SYRUP_PRICE;
		}
		
		return price;
	}
	
	@Override
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @param anotherBev
	 * @return true if the name, type, size and base price and whether or not it contains extra shot and extra syrup false otherwise
	 */
	public boolean equals(Object anotherBev) {
		if (this.bevName.equals(((Beverage) anotherBev).getBevName()) && this.type == ((Beverage) anotherBev).getType() && this.size == ((Beverage) anotherBev).getSize() && this.extraShot == ((Coffee) anotherBev).getExtraShot() && this.extraSyrup == ((Coffee) anotherBev).getExtraSyrup()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Represents a Coffee beverage in the following String format: name, size, whether it contains extra shot, extra syrup, and price
	 * @return string representation of a Coffee
	 */
	public String toString() {
		return this.bevName + ", " + this.size + ", " + this.extraShot + ", " + this.extraSyrup + ", " + this.calcPrice();
	}
	
}