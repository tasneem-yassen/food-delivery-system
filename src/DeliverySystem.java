import java.util.Arrays;
public class DeliverySystem {
	private Customer[] customers;
	private RestAdmin[] restAdmins;
	private Restaurant[] restaurants;
	private Rider[] riders;
	private Order[] orders;
	private int customerCount;
	private int restAdminCount;
    private int restaurantCount;
    private int riderCount;
    private int orderCount;
///////////constructor///////////////
    public DeliverySystem(int maxCustomers, int maxRestAdmins, int maxRestaurants, int maxRiders, int maxOrders) {
    	this.customers = new Customer[maxCustomers];
    		this.restAdmins = new RestAdmin[maxRestAdmins];
    		this.restaurants = new Restaurant[maxRestaurants];
    		this.riders = new Rider[maxRiders];
    		this.orders = new Order[maxOrders];

        this.customerCount = 0;
        this.restAdminCount = 0;
        this.restaurantCount = 0;
        this.riderCount = 0;
        this.orderCount = 0;
    }
///////////getters and setters/////////////////
	public Customer[] getCustomers() {
		return customers;
	}

	public RestAdmin[] getRestAdmins() {
		return restAdmins;
	}

	public Restaurant[] getRestaurants() {
		return restaurants;
	}

	public Rider[] getRiders() {
		return riders;
	}

	public Order[] getOrders() {
		return orders;
	}

	public int getCustomerCount() {
		return customerCount;
	}

	public int getRestAdminCount() {
		return restAdminCount;
	}

	public int getRestaurantCount() {
		return restaurantCount;
	}

	public int getRiderCount() {
		return riderCount;
	}

	public int getOrderCount() {
		return orderCount;
	}
/////////////////finding opjects by code or id methods///////////////
//	public Customer findCustomerByCode(String code) {
//		if(!InputValidation.isNotEmpty(code)) {
//			return null;
//		}
//		code = code.trim();
//		for(int i = 0; i < customerCount; i++) {
//			if(customers[i].getCustomerCode().equals(code)) {
//				return customers[i];
//			}
//		}
//		return null;
//	}
//	public Restaurant findRestaurantByCode(String code) {
//		if(!InputValidation.isNotEmpty(code)) {
//			return null;
//		}
//		code = code.trim();
//		for(int i = 0; i < restaurantCount; i++) {
//			if(restaurants[i].getRestaurantCode().equals(code)) {
//				return restaurants[i];
//			}
//		}
//		return null;
//	}
//	public Rider findRiderById(String id) {
//		if(!InputValidation.isNotEmpty(id)) {
//			return null;
//		}
//		id = id.trim();
//		for(int i = 0; i < riderCount; i++) {
//			if(riders[i].getRiderId().equals(id)) {
//				return riders[i];
//			}
//		}
//		return null;
//	}
//	public Order findOrderByCode(String code) {
//		if(!InputValidation.isNotEmpty(code)) {
//			return null;
//		}
//		code = code.trim();
//		for(int i = 0; i < orderCount; i++) {
//			if(orders[i].getOrderCode().equals(code)) {
//				return orders[i];
//			}
//		}
//		return null;
//	}
//	public RestAdmin findRestAdminByUserName(String userName) {
//		if(!InputValidation.isNotEmpty(userName)) {
//			return null;
//		}
//		userName = userName.trim();
//		for(int i = 0; i < restAdminCount; i++) {
//			if(restAdmins[i].getUserName().equals(userName)) {
//				return restAdmins[i];
//			}
//		}
//		return null;
//	}
//	public Rider findAvailableRider() {
//		for(int i=0 ; i<riderCount;i++) {
//			if(riders[i].isAvailable()) {
//				return riders[i];
//			}
//		}
//		return null;
//	}
/////////////////// adding opjects methods//////////////////////
//	public boolean addCustomer(Customer other) {
//		if(other == null) {
//			return false;
//		}
//		//resize customers array if full
//		if(customerCount >= customers.length) {
//			customers = Arrays.copyOf(customers, customers.length + 1);
//		}
//		if(findCustomerByCode(other.getCustomerCode()) != null) {
//			return false;
//		}
//		customers[customerCount]= other;
//		customerCount++ ; 
//		return true; 
//	}
//	public boolean addRestaurant(Restaurant other) {
//		if(other == null) {
//			return false;
//		}
//		//resize restaurants array if full  
//		if(restaurantCount >= restaurants.length) {
//			restaurants = Arrays.copyOf(restaurants, restaurants.length + 1);
//		}
//		if(findRestaurantByCode(other.getRestaurantCode()) != null) {
//			return false;
//		}
//		restaurants[restaurantCount]= other;
//		restaurantCount++ ; 
//		return true; 
//	}
//	public boolean addRider(Rider other) {
//		if(other == null) {
//			return false;
//		}
//		//resize oreders array if full
//		if(riderCount >= riders.length) {
//			riders = Arrays.copyOf(riders, riders.length + 1);
//		}
//		if(findRiderById(other.getRiderId()) != null) {
//			return false;
//		}
//		riders[riderCount]= other;
//		riderCount++ ; 
//		return true; 
//	}
//	public boolean addOrder(Order other) {
//		if(other == null) {
//			return false;
//		}
//		//resize orders array if full
//		if(orderCount >= orders.length) {
//			orders = Arrays.copyOf(orders, orders.length + 1);
//		}
//		if(findOrderByCode(other.getOrderCode()) != null) {
//			return false;
//		}
//		orders[orderCount]= other;
//		orderCount++ ; 
//		return true; 
//	}
//	public boolean addRestAdmin(RestAdmin other) {
//		if(other == null) {
//			return false;
//		}
//		//resize restaurant admin array if full
//		if(restAdminCount >= restAdmins.length) {
//			restAdmins = Arrays.copyOf(restAdmins, restAdmins.length + 1);
//		}
//		if(findRestAdminByUserName(other.getUserName()) != null) {
//			return false;
//		}
//		restAdmins[restAdminCount]= other;
//		restAdminCount++ ; 
//		return true; 
//	}
///////////////////assigning methods ////////////////////////////
//	public boolean assignRiderToOrder(String riderId , String orderCode) {
//		Rider rider = findRiderById(riderId);
//		Order order = findOrderByCode(orderCode);
//		if(rider == null || order == null) {
//			return false; 
//		}
//		if(!rider.isAvailable()) {
//			return false;
//		}
//		if(order.getRiderCode() != null && !order.getRiderCode().equals("000")) {
//			return false;
//		}
//		order.setRiderCode(rider.getRiderId());
//		rider.getOrders().add(order);
//		rider.setOrderCount(rider.getOrders().size()); 
//		rider.setAvailable(false);
//		return true; 
//	}
//	
//	public boolean assignRestAdminToRestaurant(String userName, String restaurantCode) {
//		RestAdmin admin = findRestAdminByUserName(userName);
//		Restaurant restaurant = findRestaurantByCode(restaurantCode);
//		if(admin == null || restaurant == null) {
//			return false;
//		}
//		return admin.addRestaurant(restaurant);
//	}
///////////////////// methods for orders//////////////////////////
//	public boolean markOrderDelivered(String orderCode, MyDate date) {
//		Order order = findOrderByCode(orderCode);
//		if(order == null) {
//			return false;
//		}
//		if(!order.setOrderStatus("delivered")) {
//			return false;
//		}
//		if(!order.setDeliveryDate(date)) {
//			return false; 
//		}
//		Rider rider = findRiderById(order.getRiderCode());
//		if(rider != null) {
//			rider.setAvailable(true);
//		}
//		return true; 
//	}
//	public boolean markOrderOnTheWay(String orderCode) {
//		Order order = findOrderByCode(orderCode);
//		if(order == null) {
//			return false;
//		}
//		return order.setOrderStatus("on the way"); 
//	}
//	
//////////////////////methods for customer////////////////////////////
	public boolean updateCustomerPhone(String customerCode, String newPhone) {
		Customer customer = findCustomerByCode(customerCode);
		if(customer == null) {
			return false;
		}
		return customer.setCustomerPhone(newPhone);
	}
	public boolean updateCustomerAddress(String customerCode, Address newAddress) {
		Customer customer = findCustomerByCode(customerCode);
		if(customer == null || newAddress == null) {
			return false;
		}
		return customer.setAddress(newAddress);
	}
////////////////////// Login methods///////////////////////////
	public boolean systemAdminLogin(String userName , String password) { 
		// return true if the admin login info is corrcet and false otherwise 
		if(userName == null || password == null) {
			return false;
		}
		userName = userName.trim();
		password = password.trim();
		if(!userName.equals("admin") || !password.equals("12345")) {
			return false;
		}
		return true ; 
	}
	//if the restaurant admin login info is corrcet return restaurant admin and null otherwise
	public RestAdmin restAdminLogin(String userName , String password) {
		if(userName == null || password == null) {
			return null;
		}
		userName = userName.trim();
		password = password.trim();
		for(int i=0 ; i < restAdminCount ; i++) {
			if(restAdmins[i].getUserName().equals(userName) && 
					restAdmins[i].getPassword().equals(password)) {
				return restAdmins[i]; 
			}
		}
		return null; 
	}
	// if the rider login info is corrcet return rider and null otherwise 
	public Rider riderLogin(String id) {
		if(id == null) {
			return null;
		}
		id = id.trim();
		for(int i=0 ; i < riderCount ; i++) {
			if(riders[i].getRiderId().equals(id)) {
				return riders[i]; 
			}
		}
		return null; 
	}
	// if the customer login info is corrcet return customer and null otherwise 
	public Customer customerLogin(String code) {
		if(code == null) {
			return null;
		}
		code = code.trim();
		for(int i=0 ; i< customerCount ; i++) {
			if(customers[i].getCustomerCode().equals(code)) {
				return customers[i];
			}
		}
		return null;
	} 
//////////////////display helper methods//////////////////// 
	public void printOrdersByRider(String riderCode) {
		if(findRiderById(riderCode) == null) {
			return;
		}
		for(int i = 0; i < orderCount; i++) {
			if(orders[i].getRiderCode().equals(riderCode)) {
				System.out.println(orders[i]);
			}
		}
	}
	public void printOrdersByCustomer(String customerCode) {
		if(findCustomerByCode(customerCode) == null) {
			return;
		}
		for(int i = 0; i < orderCount; i++) {
			if(orders[i].getCustomerCode().equals(customerCode)) {
				System.out.println(orders[i]);
			}
		}
	}
	public void printAllRestaurants() {
		for(int i=0 ; i< restaurantCount ; i++) {
			System.out.println(restaurants[i]);
		}
	}
	public void printAllCustomers() {
		for(int i=0 ; i< customerCount ; i++) {
			System.out.println(customers[i]);
		}
	}
	public void printAllRiders() {
		for(int i=0 ; i< riderCount ; i++) {
			System.out.println(riders[i]);
		}
	}
	public void printAllRestAdmins() {
		for(int i=0 ; i< restAdminCount ; i++) {
			System.out.println(restAdmins[i]);
		}
	}
	public void printAllOrders() {
		for(int i=0 ; i< orderCount ; i++) {
			System.out.println(orders[i]);
		}
	}
}
