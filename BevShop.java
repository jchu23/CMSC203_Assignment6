/*
 * Class: CMSC203 CRN 30340
 * Instructor: Khandan Monshi
 * Description: BevShop java file, defines the BevShop class.
 * Due: 05/05/2024
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Jeffrey Chu
 */

import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	
	// Fields/attributes
	public ArrayList<Order> orders;
	private Order currentOrder;
	
	// Default constructor
	/**
	 * Default Constructor Initializes a BevShop Object
	 */
	public BevShop() {
		this.orders = new ArrayList<Order>();
	}
	
	@Override
	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	public boolean isValidTime(int time) {
		if (time >= BevShopInterface.MIN_TIME && time <= BevShopInterface.MAX_TIME) {
			return true;
		}
		
		return false;
	}
	
	@Override
	/**
	 * Returns the constant value for the max number of fruit
	 * @return returns the value for the max number of fruit
	 */
	public int getMaxNumOfFruits() {
		return BevShopInterface.MAX_FRUIT;
	}
	
	@Override
	/**
	 * Returns the constant value for the minimum age for offering Alcohol drink
	 * @return returns the value for the minimum age for offering Alcohol drink
	 */
	public int getMinAgeForAlcohol() {
		return BevShopInterface.MIN_AGE_FOR_ALCOHOL;
	}
	
	@Override
	/**
	 * returns true if the passed parameter exceeds the Maximum FRUIT allowed
	 * @return true if the passed parameter exceeds the MAXIUM number of fruits allowed for the SMOTHIE drink, false otherwise
	 */
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits == getMaxNumOfFruits()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	/**
	 * Returns constant maximum number of alcohol beverages/per order offered by the beverage shop
	 * @return constant maximum number of alcohol beverages/per order offered by the beverage shop
	 */
	public int getMaxOrderForAlcohol() {
		return BevShopInterface.MAX_ORDER_FOR_ALCOHOL;
	}
	
	@Override
	/**
	 * Checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return true if number of alcohol drinks for the current order has reached the maximum, false otherwise
	 */
	public boolean isEligibleForMore() {
		return this.orders.size() < getMaxOrderForAlcohol();
	}
	
	@Override
	/**
	 * Returns the number of alcohol drinks for the current order
	 * @return returns the number of alcohol drinks for the current order
	 */
	public int getNumOfAlcoholDrink() {
		return currentOrder.findNumOfBeveType(Type.ALCOHOL);
	}
	
	@Override
	/**
	 * Check the valid age for the alcohol drink
	 * @return returns true if age is more than minimum eligible age , false otherwise
	 */
	public boolean isValidAge(int age) {
		return age >= BevShopInterface.MIN_AGE_FOR_ALCOHOL;
	}
	
	@Override
	/**
	 * Creates a new order, NO BEVERAGE is added to the order yet
	 */
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		this.currentOrder = new Order(time, day, new Customer(customerName, customerAge));
	}
	
	@Override
	/**
	 * Process the Coffee order for the current order by adding it to the current order
	 */
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		this.currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	@Override
	/**
	 * Process the Alcohol order for the current order by adding it to the current order
	 */
	public void processAlcoholOrder(String bevName, Size size) {
		this.currentOrder.addNewBeverage(bevName, size);
	}
	
	@Override
	/**
	 * Process the Smoothie order for the current order by adding it to the current order
	 */
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		this.currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	@Override
	/**
	 * Locate an order based on the order number
	 * @return the index of the order in the list of Orders if found or -1 if not found
	 */
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		
		return -1;
	}
	
	@Override
	/**
	 * Locates an order in the list of orders and returns the total value on the order
	 * @return the calculated price on this order
	 */
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}
	
	@Override
	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale() {
		double sum = 0;
		
		for (int i = 0; i < orders.size(); i++) {
			sum+=orders.get(i).calcOrderTotal();
		}
		
		return sum;
	}
	
	@Override
	/**
	 * Returns total numbers of orders within the month
	 * @return total numbers of orders within the month
	 */
	public int totalNumOfMonthlyOrders() {
		return this.orders.size();
	}
	
	@Override
	/**
	 * Returns the current Order located in the index in the list of orders. Notes: this method returns the shallow copy of the order
	 * @return the current order
	 */
	public Order getCurrentOrder() {
		return this.currentOrder;
	}
	
	@Override
	/**
	 * Returns Order in the list of orders at the index Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index
	 */
	public Order getOrderAtIndex(int index) {
		return this.orders.get(index);
	}
	
	@Override
	/**
	 * Sorts the orders within this bevShop using the Selection sort algorithm
	 */
	public void sortOrders() {
		for (int i = 0; i < this.orders.size()-1; i++) {
			int minOrder = i;
			
			for (int j = i+1; j < this.orders.size(); j++) {
				if (this.orders.get(j).getOrderNo() < this.orders.get(minOrder).getOrderNo()) {
					minOrder = j;
				}
			}
			
			Order temp = this.orders.get(minOrder);
			this.orders.set(minOrder, this.orders.get(i));
			this.orders.set(i, temp);
		}
	}
	
	@Override
	/**
	 * Returns the string representation of all the orders and the total monthly sale
	 * @return the string representation of all the orders and the total monthly sale
	 */
	public String toString() {
		String str = "BEV SHOP\nMONTHLY SALES: " + totalMonthlySale() + "\n\n";
		
		for (int i = 0; i < this.orders.size(); i++) {
			str += "Order " + i + "\n";
			str += this.orders.get(i).toString();
		}
		
		return str;
	}
	
}	