public class Rider {
	private String riderId;
	private String riderFirstName; 
	private String riderFamilyName; 
	private String riderPhone; 
	private String vehicle; 
	private boolean isAvailable; // true if the rider is avilable and false otherwise 
	private Order[] orders; // array of orders for the rider 
	private int orderCount; // amount of orders the rider has 
/////////////constructor///////////// 
	public Rider(String riderId, String riderFirstName, String riderFamilyName, String riderPhone, String vehicle,
			boolean isAvailable, Order[] orders, int orderCount) {
		setRiderId(riderId);
		setRiderFirstName(riderFirstName);
		setRiderFamilyName(riderFamilyName);
		setRiderPhone(riderPhone);
		setVehicle(vehicle);
		setAvailable(isAvailable);
		setOrders(orders); 
		setOrderCount(orderCount);
	}
////////////////getters and setters///////////////// 
	public String getRiderId() {
		return riderId;
	}
	public boolean setRiderId(String riderId) {
		//make sure the Id is valid by calling isValidId method 
		if(InputValidation.isValidId(riderId)) {
			riderId = riderId.trim();
			this.riderId = riderId;
			return true;
		}
		return false;
	}
	public String getRiderFirstName() {
		return riderFirstName;
	}
	public boolean setRiderFirstName(String riderFirstName) {
		// check first name is not empty and is only letters using helper methods from InputValidation class
		if(InputValidation.isNotEmpty(riderFirstName) && InputValidation.isOnlyLetters(riderFirstName)) {
			riderFirstName = riderFirstName.trim();
			this.riderFirstName = riderFirstName;
			return true; 
		}
		return false;
	}
	public String getRiderFamilyName() {
		return riderFamilyName;
	}
	public boolean setRiderFamilyName(String riderFamilyName) {
		// check family name is not empty and doesnt include number/special characters 
		if(InputValidation.isNotEmpty(riderFamilyName) && InputValidation.isOnlyLettersAndSpaces(riderFamilyName)) {
			riderFamilyName = riderFamilyName.trim();
			this.riderFamilyName = riderFamilyName;
			return true; 
		}
		return false;
		
	}
	public String getRiderPhone() {
		return riderPhone;
	}
	public boolean setRiderPhone(String riderPhone) {
		// check if phone number is not empty, starts with 05, and its length is 10 
		if(InputValidation.isNotEmpty(riderPhone) && InputValidation.isOnlyDigits(riderPhone)) {
			riderPhone = riderPhone.trim();
			if(riderPhone.length()==10 && riderPhone.startsWith("05")) {
				this.riderPhone = riderPhone;
				return true;
			}
		}
		return false; 
	}
	public String getVehicle() {
		return vehicle;
	}
	public boolean setVehicle(String vehicle) {
		//check if vehicle is not empty and doesnt include any numbers/special characters 
		if(InputValidation.isNotEmpty(vehicle) && InputValidation.isOnlyLettersAndSpaces(vehicle)) {
			vehicle = vehicle.trim();
			if(vehicle.equalsIgnoreCase("car") || 
					vehicle.equalsIgnoreCase("bike") || 
					vehicle.equalsIgnoreCase("motorBike")) {
				this.vehicle = vehicle;
				return true;
			}
		}
		return false; 
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Order[] getOrders() {
		return orders;
	}
	public boolean setOrders(Order[] orders) {
		if(orders != null && orders.length != 0) {
			this.orders = orders;
			return true;
		}
		return false;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public boolean setOrderCount(int orderCount) {
		if(this.orders == null) {
			return false;
		}
		if(orderCount < 0 || orderCount > this.orders.length) {
			return false;
		}
		this.orderCount = orderCount;
		return true;
	}
////////////////// toString////////////////////
	@Override
	public String toString() {
		return "Rider: (Id: " + riderId + ", Name: " + riderFirstName + " "
				+ riderFamilyName + ", Phone: " + riderPhone + ", vehicle: " + vehicle + ", isAvailable: "
				+ isAvailable + ", Order Count: " + orderCount + ")";
	}
	// override the deafult equals method : riders are equal when they have the same Id
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true; 
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false; 
		}
		Rider other = (Rider)obj;
		return this.riderId.equals(other.riderId);
	}
}
