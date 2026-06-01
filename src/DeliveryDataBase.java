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
	private HashMap<String, ArrayList<Order>> ordersByCustomer;
	private Hashtable<String, ArrayList<Restaurant>> restaurantsByCustomer;
	private HashMap<String, Double> totalPaidByCustomer;

	public DeliveryDataBase() {
		this.systemAdministrator = new Admin("System admin", "admin", "12345");
		this.restAdmins = new ArrayList<RestAdmin>();
		this.restaurants = new ArrayList<Restaurant>();
		this.customers = new ArrayList<Customer>();
		this.riders = new ArrayList<Rider>();
		this.orders = new ArrayList<Order>();
		this.ordersByCustomer = new HashMap<String, ArrayList<Order>>();
		this.restaurantsByCustomer = new Hashtable<String, ArrayList<Restaurant>>();
		this.totalPaidByCustomer = new HashMap<String, Double>();
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

	public HashMap<String, ArrayList<Order>> getOrdersByCustomer() {
		return ordersByCustomer;
	}

	public void setOrdersByCustomer(HashMap<String, ArrayList<Order>> ordersByCustomer) {
		this.ordersByCustomer = ordersByCustomer;
	}

	public Hashtable<String, ArrayList<Restaurant>> getRestaurantsByCustomer() {
		return restaurantsByCustomer;
	}

	public void setRestaurantsByCustomer(Hashtable<String, ArrayList<Restaurant>> restaurantsByCustomer) {
		this.restaurantsByCustomer = restaurantsByCustomer;
	}

	public HashMap<String, Double> getTotalPaidByCustomer() {
		return totalPaidByCustomer;
	}

	public void setTotalPaidByCustomer(HashMap<String, Double> totalPaidByCustomer) {
		this.totalPaidByCustomer = totalPaidByCustomer;
	}

	public boolean addOrderToCustomer(String customerCode, Order order) {
		if (!InputValidation.isNotEmpty(customerCode) || order == null) {
			return false;
		}
		customerCode = customerCode.trim();
		if (!ordersByCustomer.containsKey(customerCode)) {
			ordersByCustomer.put(customerCode, new ArrayList<Order>());
		}
		ArrayList<Order> customerOrders = ordersByCustomer.get(customerCode);
		if (customerOrders.contains(order)) {
			return false;
		}
		customerOrders.add(order);
		return true;
	}

	public ArrayList<Order> getActiveOrdersByRider(String riderCode) {
		ArrayList<Order> activeOrders = new ArrayList<Order>();
		if (riderCode == null || !InputValidation.isNotEmpty(riderCode)) {
			return activeOrders;
		}
		riderCode = riderCode.trim();
		for (Order order : orders) {
			if (order.getRiderCode().equals(riderCode) && (order.getOrderStatus().equalsIgnoreCase("sent")
					|| order.getOrderStatus().equalsIgnoreCase("on the way"))) {
				activeOrders.add(order);
			}
		}
		return activeOrders;
	}

	public ArrayList<Restaurant> getPremiumRestaurantsByCustomer(Customer customer) {
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		if (customer == null) {
			return restaurants;
		}
		String customerCode = customer.getCustomerCode();
		if (customerCode == null) {
			return restaurants;
		}
		customerCode = customerCode.trim();
		if (!InputValidation.isNotEmpty(customerCode) || !InputValidation.isOnlyDigits(customerCode)) {
			return restaurants;
		}
		if (!restaurantsByCustomer.containsKey(customerCode)) {
			return restaurants;
		}
		ArrayList<Restaurant> customerRestaurants = restaurantsByCustomer.get(customerCode);
		for (Restaurant restaurant : customerRestaurants) {
			if (restaurant instanceof PremiumRestaurant) {
				restaurants.add(restaurant);
			}
		}
		return restaurants;
	}

	public Customer getCustomerWithMostOrders() {
		if (ordersByCustomer.isEmpty()) {
			return null;
		}
		String bestCustomerCode = null;
		int maxOrders = -1;
		for (String customerCode : ordersByCustomer.keySet()) {
			ArrayList<Order> customerOrders = ordersByCustomer.get(customerCode);
			if (customerOrders.size() > maxOrders) {
				maxOrders = customerOrders.size();
				bestCustomerCode = customerCode;
			}
		}
		for (Customer customer : customers) {
			if (customer.getCustomerCode().equals(bestCustomerCode)) {
				return customer;
			}
		}
		return null;
	}

	public Rider getRiderWithMostDeliveries() {
		if (riders.isEmpty()) {
			return null;
		}
		Rider bestRider = riders.get(0);
		for (Rider rider : riders) {
			if (rider.getOrders().size() > bestRider.getOrders().size()) {
				bestRider = rider;
			}
		}
		return bestRider;
	}

	public ArrayList<Restaurant> getOpenRestaurantsByCuisine(String cuisine) {
		ArrayList<Restaurant> result = new ArrayList<Restaurant>();
		if (!InputValidation.isNotEmpty(cuisine)) {
			return result;
		}
		cuisine = cuisine.trim();
		for (Restaurant restaurant : restaurants) {
			if (restaurant.isOpen() && restaurant.getCuisine().equalsIgnoreCase(cuisine)) {
				result.add(restaurant);
			}
		}
		return result;
	}

/////////////////finding opjects by code or id methods///////////////
	public Customer findCustomerByCode(String code) {
		if (!InputValidation.isNotEmpty(code)) {
			return null;
		}
		code = code.trim();
		for (Customer customer : customers) {
			if (customer.getCustomerCode().equals(code)) {
				return customer;
			}
		}
		return null;
	}

	public Restaurant findRestaurantByCode(String code) {
		if (!InputValidation.isNotEmpty(code)) {
			return null;
		}
		code = code.trim();
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getRestaurantCode().equals(code)) {
				return restaurant;
			}
		}
		return null;
	}

	public Rider findRiderById(String id) {
		if (!InputValidation.isNotEmpty(id)) {
			return null;
		}
		id = id.trim();
		for (Rider rider : riders) {
			if (rider.getRiderId().equals(id)) {
				return rider;
			}
		}
		return null;
	}

	public Order findOrderByCode(String code) {
		if (!InputValidation.isNotEmpty(code)) {
			return null;
		}
		code = code.trim();
		for (Order order : orders) {
			if (order.getOrderCode().equals(code)) {
				return order;
			}
		}
		return null;
	}

	public RestAdmin findRestAdminByUserName(String userName) {
		if (!InputValidation.isNotEmpty(userName)) {
			return null;
		}
		userName = userName.trim();
		for (RestAdmin restAdmin : restAdmins) {
			if (restAdmin.getUserName().equals(userName)) {
				return restAdmin;
			}
		}
		return null;
	}

	public Rider findAvailableRider() {
		for (Rider rider : riders) {
			if (rider.isAvailable()) {
				return rider;
			}
		}
		return null;
	}

///////////////// adding opjects methods//////////////////////
	public boolean addCustomer(Customer other) {
		if (other == null) {
			return false;
		}
		if (findCustomerByCode(other.getCustomerCode()) != null) {
			return false;
		}
		customers.add(other);
		return true;
	}

	public boolean addRestaurant(Restaurant other) {
		if (other == null) {
			return false;
		}
		if (findRestaurantByCode(other.getRestaurantCode()) != null) {
			return false;
		}
		restaurants.add(other);
		return true;
	}

	public boolean addRider(Rider other) {
		if (other == null) {
			return false;
		}
		if (findRiderById(other.getRiderId()) != null) {
			return false;
		}
		riders.add(other);
		return true;
	}

	public boolean addOrder(Order other) {
		if (other == null) {
			return false;
		}
		if (findOrderByCode(other.getOrderCode()) != null) {
			return false;
		}
		orders.add(other);
		return true;
	}

	public boolean addRestAdmin(RestAdmin other) {
		if (other == null) {
			return false;
		}
		if (findRestAdminByUserName(other.getUserName()) != null) {
			return false;
		}
		restAdmins.add(other);
		return true;
	}

/////////////////assigning methods ////////////////////////////
	public boolean assignRiderToOrder(String riderId, String orderCode) {
		Rider rider = findRiderById(riderId);
		Order order = findOrderByCode(orderCode);
		if (rider == null || order == null) {
			return false;
		}
		if (!rider.isAvailable()) {
			return false;
		}
		if (order.getRiderCode() != null && !order.getRiderCode().equals("000")) {
			return false;
		}
		order.setRiderCode(rider.getRiderId());
		rider.getOrders().add(order);
		rider.setOrderCount(rider.getOrders().size());
		rider.setAvailable(false);
		return true;
	}

	public boolean assignRestAdminToRestaurant(String userName, String restaurantCode) {
		RestAdmin admin = findRestAdminByUserName(userName);
		Restaurant restaurant = findRestaurantByCode(restaurantCode);
		if (admin == null || restaurant == null) {
			return false;
		}
		return admin.addRestaurant(restaurant);
	}

/////////////////// methods for orders//////////////////////////
	public boolean markOrderDelivered(String orderCode, MyDate date) {
		Order order = findOrderByCode(orderCode);
		if (order == null) {
			return false;
		}
		if (!order.setOrderStatus("delivered")) {
			return false;
		}
		if (!order.setDeliveryDate(date)) {
			return false;
		}
		Rider rider = findRiderById(order.getRiderCode());
		if (rider != null) {
			rider.setAvailable(true);
		}
		return true;
	}

	public boolean markOrderOnTheWay(String orderCode) {
		Order order = findOrderByCode(orderCode);
		if (order == null) {
			return false;
		}
		return order.setOrderStatus("on the way");
	}

}
