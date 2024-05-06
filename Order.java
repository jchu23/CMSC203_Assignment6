/*
 * Class: CMSC203 CRN 30340
 * Instructor: Khandan Monshi
 * Description: Order java file, defines the Order class.
 * Due: 05/05/2024
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Jeffrey Chu
 */

import java.lang.Math;
import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order> {
	
	// Fields/attributes
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private int orderNo;
	private ArrayList<Beverage> beverages;
	
	// Parameterized constructor
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		this.orderNo = generateOrder();
		this.beverages = new ArrayList<Beverage>();
	}
	
	// Other methods
	/**
	 * Adds alcohol order to this order
	 * @param bevName
	 * @param size
	 */
	public void addNewBeverage(String bevName, Size size) {
		Alcohol alcohol = new Alcohol(bevName, size, this.isWeekend());
		beverages.add(alcohol);
	}
	
	/**
	 * Adds coffee order to this order
	 * @param bevName
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(coffee);
	}
	
	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName
	 * @param size
	 * @param numOfFruits
	 * @param addProtein
	 */
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(smoothie);
	}
	
	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	public double calcOrderTotal() {
		double total = 0.0;
		
		for (int i = 0; i < beverages.size(); i++) {
			total = total + beverages.get(i).calcPrice();
		}
		
		return total;
	}
	
	/**
	 * Returns an int from comparing two orders
	 * @param anotherOrder
	 * @return the difference between orderNo and orderNo of anotherOrder
	 */
	public int compareTo(Order anotherOrder) {
		return this.orderNo - anotherOrder.getOrderNo();
	}
	
	/**
	 * Returns the number of beverages of same type in an order
	 * @param type
	 * @return number of beverages of type type in this order
	 */
	public int findNumOfBeveType(Type type) {
		int numOfBevtype  = 0;
		
		for (int i = 0; i < beverages.size();i++) {
			if (beverages.get(i).getType() == type) {
				numOfBevtype++;
			}
		}
		
		return numOfBevtype;
	}
	
	/**
	 * Automatically generate order number
	 * @return a random order number between 10000 and 90000
	 */
	public int generateOrder() {
		return 10000 + (int)(Math.random() * ((90000 - 10000) + 1));
	}
	
	/**
	 * Returns the beverage listed in the itemNo of the order, for example if itemNo is 0 this method will return the first beverage in this order Note: this method returns the shallow copy of the Beverage
	 * @param itemNo
	 * @return the beverage listed in the itemNo of the order or null if there is no item in the order
	 */
	public Beverage getBeverage(int itemNo) {
		return beverages.get(itemNo);
	}
	
	/**
	 * Return the customer
	 * @return customer
	 */
	public Customer getCustomer() {
		return this.cust;
	}
	
	/**
	 * Return order day (MONDAY, TUESDAY.....,SUNDAY)
	 * @return order day
	 */
	public Day getDay() {
		return getOrderDay();
	}
	
	/**
	 * Returns the order day
	 * @return order day
	 */
	public Day getOrderDay() {
		return this.orderDay;
	}
	
	/**
	 * Returns the order number
	 * @return order number
	 */
	public int getOrderNo() {
		return this.orderNo;
	}
	
	/**
	 * Returns the order time
	 * @return order time
	 */
	public int getOrderTime() {
		return this.orderTime;
	}
	
	/**
	 * Returns the total number of beverages ordered within this order
	 * @return total number of beverages ordered within this order
	 */
	public int getTotalItems() {
		return beverages.size();
	}
	
	/**
	 * Returns the value of isWeekend
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
	public boolean isWeekend() {
		if (getDay() == Day.SUNDAY || getDay() == Day.SATURDAY) {
			return true;
		}
		
		return false;
	}
	
	@Override
	/**
	 * String representation of the order, Includes order number, time, day, customer name and age, and the list of beverages
	 * @return string containing the order information
	 */
	public String toString() {
		return this.orderNo + ", " + this.orderTime + ", " + this.orderDay + ", " + this.cust.getName() + ", " + this.cust.getAge() + ", " + beverages;
	}
	
}