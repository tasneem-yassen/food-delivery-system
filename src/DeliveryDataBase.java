import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
public class DeliveryDataBase {
	private Admin systemAdministrator;
	private ArrayList<RestAdmin> restAdmins;
	private ArrayList<Restaurant> restaurants;
	private ArrayList<Customer> customers;
	private ArrayList<Rider> riders;
	private ArrayList<Order> orders;
	private HashMap<Integer, ArrayList<Order>> ordersByCustomer;
	private Hashtable<Integer, ArrayList<Restaurant>> restaurantsByCustomer;
	private HashMap<Integer, Double> totalPaidByCustomer;
	public DeliveryDataBase() {
		this.systemAdministrator = new Admin("System admin","admin","12345");
		this.restAdmins = new ArrayList<RestAdmin>();
		this.restaurants = new ArrayList<Restaurant>();
		this.customers = new ArrayList<Customer>();
		this.riders = new ArrayList<Rider>();
		this.orders = new ArrayList<Order>();
		this.ordersByCustomer = new HashMap<Integer, ArrayList<Order>>();
        this.restaurantsByCustomer = new Hashtable<Integer, ArrayList<Restaurant>>();
        this.totalPaidByCustomer = new HashMap<Integer, Double>();
	}
	public Admin getSystemAdministrator() {
		return systemAdministrator;
	}
	public void setSystemAdministrator(Admin systemAdministrator) {
		this.systemAdministrator = systemAdministrator;
	}
	public ArrayList<RestAdmin> getRestAdmins() {
		return restAdmins;
	}
	public void setRestAdmins(ArrayList<RestAdmin> restAdmins) {
		this.restAdmins = restAdmins;
	}
	public ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(ArrayList<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public ArrayList<Rider> getRiders() {
		return riders;
	}
	public void setRiders(ArrayList<Rider> riders) {
		this.riders = riders;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public HashMap<Integer, ArrayList<Order>> getOrdersByCustomer() {
		return ordersByCustomer;
	}
	public void setOrdersByCustomer(HashMap<Integer, ArrayList<Order>> ordersByCustomer) {
		this.ordersByCustomer = ordersByCustomer;
	}
	public Hashtable<Integer, ArrayList<Restaurant>> getRestaurantsByCustomer() {
		return restaurantsByCustomer;
	}
	public void setRestaurantsByCustomer(Hashtable<Integer, ArrayList<Restaurant>> restaurantsByCustomer) {
		this.restaurantsByCustomer = restaurantsByCustomer;
	}
	public HashMap<Integer, Double> getTotalPaidByCustomer() {
		return totalPaidByCustomer;
	}
	public void setTotalPaidByCustomer(HashMap<Integer, Double> totalPaidByCustomer) {
		this.totalPaidByCustomer = totalPaidByCustomer;
	}
	
}
