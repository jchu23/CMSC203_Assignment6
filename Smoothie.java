/*
 * Class: CMSC203 CRN 30340
 * Instructor: Khandan Monshi
 * Description: Smoothie java file, defines the Smoothie class.
 * Due: 05/05/2024
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Jeffrey Chu
 */

public class Smoothie extends Beverage {
	
	// Fields/attributes
	private double basePrice = 0;
	private String bevName;
	private Type type;
	private Size size;
	private final double SIZE_PRICE = 0.5;
	private int numOfFruits = 0;
	private boolean addProtein = false;
	private final double FRUIT_PRICE = 0.5;
	private final double PROTEIN_PRICE = 1.5;
	
	// Parameterized constructor
	/**
	 * Creates a Smoothie object using given values
	 * @param bevName
	 * @param size
	 * @param numOfFruits
	 * @param addProtein
	 */
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	// Other methods
	/**
	 * Return number of fruits
	 * @return num of fruits
	 */
	public int getNumOfFruits() {
		return this.numOfFruits;
	}
	
	/**
	 * Indicates whether or not protein is added
	 * @return whether or not protein is added
	 */
	public boolean getAddProtein() {
		return this.addProtein;
	}
	
	@Override
	/**
	 * Calculates the price of the smoothie based on base price, size, number of fruit, and added protein
	 * @return the price of a smoothie beverage
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
		
		price += this.numOfFruits * FRUIT_PRICE;
		
		if (this.addProtein) {
			price += PROTEIN_PRICE;
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
		if (this.bevName.equals(((Beverage) anotherBev).getBevName()) && this.type == ((Beverage) anotherBev).getType() && this.size == ((Beverage) anotherBev).getSize() && this.basePrice == ((Beverage) anotherBev).getBasePrice() && this.numOfFruits == ((Smoothie) anotherBev).getNumOfFruits() && this.addProtein == ((Smoothie) anotherBev).getAddProtein()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	/**
	 * Returns Represents a Smoothie drink. Contains the name, size, whether or not protein added, number of fruits, and price
	 * @return string representation of a Smoothie drink
	 */
	public String toString() {
		return this.bevName + ", " + this.SIZE_PRICE + ", " + this.addProtein + ", " + this.numOfFruits + ", " + calcPrice();
	}
	
}