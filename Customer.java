/*
 * Class: CMSC203 CRN 30340
 * Instructor: Khandan Monshi
 * Description: Customer java file, defines the Customer class.
 * Due: 05/05/2024
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Jeffrey Chu
 */

public class Customer {
	
	// Fields/attributes
	private String name;
	private int age;
	
	// Parameterized constructor
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Copy constructor
	public Customer(Customer c) {
		this.name = c.getName();
		this.age = c.getAge();
	}
	
	// Mutator/setter methods
	/**
	 * Set method for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Set method for age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	// Accessor/getter methods
	/**
	 * Get method for name
	 * @return the age
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get method for age
	 * @return
	 */
	public int getAge() {
		return this.age;
	}
	
	@Override
	/**
	 * String representation of the customer includes the name and age of the customer
	 * @return string containing the customer information
	 */
	public String toString() {
		return this.name + ", " + this.age;
	}
	
}