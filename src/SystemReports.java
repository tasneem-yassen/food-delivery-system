import java.util.ArrayList;
public class SystemReports {
	public static void printRestaurants(ArrayList<? extends Restaurant> restaurants) {
		//this method orints all restaurants in a list 
		if(restaurants == null || restaurants.isEmpty()) {
			System.out.println("No restaurants to display.");
			return ;
		}
		for(Restaurant rest : restaurants) {
			System.out.println(rest);
		}
	}
	public static double ordersFinalPriceSum(ArrayList<? extends Order> orders) {
		//this method return the sum of all the orders final prices 
		double sum = 0 ;
		if(orders == null || orders.isEmpty()) {
			System.out.println("No orders to calculate final price.");
			return sum;
		}
		for(Order order : orders) {
			sum+=order.getFinalPrice();
		}
		return sum ; 
	}
	public static boolean addFastFoodRestaurantToList(ArrayList<? super
			FastFoodRestaurant> restaurants, FastFoodRestaurant restaurant) {
		//this method adds a fast food restaurant int the list and returns true if it was successfull and false otherwise 
		if(restaurant == null || restaurants.isEmpty()) {
			return false;
		}
		restaurants.add(restaurant);
		return true; 
	}
	public static <T extends Comparable<T>> T getMax(ArrayList<T> list) {
		//this is a generic method that return the biggest item in a list 
		if(list == null || list.isEmpty()) {
			return null;
		}
		T max = list.get(0);
		for(T item : list) {
			if(item.compareTo(max) > 0) {
				max = item;
			}
		}
		return max; 
	}
}
