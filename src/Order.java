public class Order {
	private String orderCode;
	private String customerCode;
	private Restaurant restaurant; 
	private String restaurantCode;
	private String riderCode;
	private MyDate orderDate;
	private MyDate deliveryDate;
	private double baseAmount;
	private double finalPrice;
	private String orderStatus;
///////////////constructor/////////////////////
	public Order(String orderCode, String customerCode, Restaurant restaurant, String restaurantCode, String riderCode,
			MyDate orderDate, MyDate deliveryDate, double baseAmount, String orderStatus) {
		setOrderCode(orderCode);
		setCustomerCode(customerCode);
		setRestaurant(restaurant);
		setRestaurantCode(restaurantCode);
		setRiderCode(riderCode);
		setOrderDate(orderDate);
		setOrderStatus(orderStatus);
		setDeliveryDate(deliveryDate);
		setBaseAmount(baseAmount);
		setFinalPrice();
	}
//////////////////getters and setters////////////////
	public String getOrderCode() {
		return orderCode;
	}
	public boolean setOrderCode(String orderCode) {
		// check if the code is not empty and is only digits 
		if(InputValidation.isNotEmpty(orderCode) && InputValidation.isOnlyDigits(orderCode)) {
			orderCode = orderCode.trim();
			this.orderCode = orderCode;
			return true;
		}
		return false; 
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public boolean setCustomerCode(String customerCode) {
		// check if the code is not empty and is only digits 
		if(InputValidation.isNotEmpty(customerCode) && InputValidation.isOnlyDigits(customerCode)) {
			customerCode = customerCode.trim();
			this.customerCode = customerCode;
			return true;
		}
		return false; 
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public boolean setRestaurant(Restaurant restaurant) {
		if(restaurant != null) {
			this.restaurant = restaurant;
			return true;
		}
		return false;
	}
	public String getRestaurantCode() {
		return restaurantCode;
	}
	public boolean setRestaurantCode(String restaurantCode) {
		//check if restaurant code is not empty and is only digits 
		if(InputValidation.isNotEmpty(restaurantCode) && InputValidation.isOnlyDigits(restaurantCode)) {
			restaurantCode = restaurantCode.trim();
			this.restaurantCode = restaurantCode;
			return true;
		}
		return false; 
	}
	public String getRiderCode() {
		return riderCode;
	}
	public boolean setRiderCode(String riderCode) {
		//check if the rider code is not null or empty 
		if(riderCode == null || !InputValidation.isNotEmpty(riderCode)) {
			this.riderCode = "000";
			return true;
		}
		if(InputValidation.isOnlyDigits(riderCode)) {
			riderCode = riderCode.trim();
			this.riderCode = riderCode;
			return true;
		}
		return false;
	}
	public MyDate getOrderDate() {
		return orderDate;
	}
	public boolean setOrderDate(MyDate orderDate) {
		if(orderDate == null) {
			return false;
		}
		this.orderDate = orderDate;
		return true; 
	}
	public MyDate getDeliveryDate() {
		return deliveryDate;
	}
	public boolean setDeliveryDate(MyDate deliveryDate) {
		//check if delivery date is not null 
		if(this.orderStatus == null) {
			return false; 
		}
		//check if the order status is not deliverd 
		if(!this.orderStatus.equalsIgnoreCase("delivered")) {
			this.deliveryDate = new MyDate(0,0,0); 
			return true; 
		}
		if(deliveryDate != null && 
				this.orderDate !=null && (this.getOrderDate().isBefore(deliveryDate) || this.getOrderDate().equals(deliveryDate))) { 
			this.deliveryDate = deliveryDate;
			return true;
		}
		return false;
	}
	public double getBaseAmount() {
		return baseAmount;
	}
	public boolean setBaseAmount(double baseAmount) {
		if(baseAmount > 0) {
			this.baseAmount = baseAmount;
			return true;
		}
		return false;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public boolean setFinalPrice() {
		if(this.restaurant != null && this.baseAmount > 0) {
			this.finalPrice = this.restaurant.calcFinalPrice(this.baseAmount);
			return true; 
		}
		return false;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public boolean setOrderStatus(String orderStatus) {
		if(orderStatus == null) {
			return false; 
		}
		orderStatus = orderStatus.trim();
		//check if the order status is one of the 3 options allowed 
		if(orderStatus.equalsIgnoreCase("sent") ||
				orderStatus.equalsIgnoreCase("on the way") ||
				orderStatus.equalsIgnoreCase("delivered")) {
			this.orderStatus = orderStatus;
			return true;
		}
		return false;
	}
////////////////toString/////////////////////////
	@Override
	public String toString() {
		return "Order: (Order Code: " + orderCode + ", Customer Code: " + customerCode + ", Restaurant: " + restaurant
				+ ", Restaurant Code: " + restaurantCode + ", Rider Code: " + riderCode + ", Order Date: " + orderDate.toString()
				+ ", Delivery Date:" + deliveryDate.toString() + ", Base Amount: " + baseAmount + ", Final Price=" + finalPrice
				+ ", Order Status: " + orderStatus + ")";
	}
	/// override the equals method : 2 orders are equal if they have the same code 
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true; 
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false; 
		}
		Order other = (Order)obj;
		return this.orderCode.equals(other.orderCode);
	}
}
