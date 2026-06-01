public class Restaurant {
	protected String restaurantCode;
	protected String restaurantName;
	protected String cuisine;
	protected double restaurantRating;
	protected boolean isOpen; //true if the restaurant is opn false otherwise 
	protected double baseDeliveryFee; //the minimum amount allowed per order 
//////////////constructor///////////// 
	public Restaurant(String restaurantcode, String restaurantName, String cuisine, double restaurantRating,
			boolean isOpen, double baseDeliveryFee) {
		setRestaurantCode(restaurantcode);
		setRestaurantName(restaurantName);
		setCuisine(cuisine);
		setRestaurantRating(restaurantRating);
		setOpen(isOpen);
		setBaseDeliveryFee(baseDeliveryFee);
	}
////////////////getters and setters/////////////////// 
	public String getRestaurantCode() {
		return restaurantCode;
	}
	public boolean setRestaurantCode(String restaurantCode) {
		//check if code is not empty and only has numbers 
		if(InputValidation.isNotEmpty(restaurantCode) && InputValidation.isOnlyDigits(restaurantCode)) {
			restaurantCode = restaurantCode.trim();
			this.restaurantCode = restaurantCode;
			return true;
		}
		return false;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public boolean setRestaurantName(String restaurantName) {
		// check if the name is not empty and doesnt include any numbers/special charcaters 
		if(InputValidation.isNotEmpty(restaurantName) && InputValidation.isOnlyLettersAndSpaces(restaurantName)) {
			restaurantName = restaurantName.trim();
			this.restaurantName = restaurantName;
			return true;
		}
		return false;
	}
	public String getCuisine() {
		return cuisine;
	}
	public boolean setCuisine(String cuisine) {
		//check if cuisine is not empty and doesnt include any numbers/special charcaters
		if(InputValidation.isNotEmpty(cuisine) && InputValidation.isOnlyLettersAndSpaces(cuisine)) {
			cuisine = cuisine.trim();
			this.cuisine = cuisine;
			return true;
		}
		return false;
	}
	public double getRestaurantRating() {
		return restaurantRating;
	}
	public boolean setRestaurantRating(double restaurantRating) {
		// check if the rating is positive or 0 
		if(restaurantRating < 0 || restaurantRating > 5) {
			return false;
		}
		this.restaurantRating = restaurantRating;
		return true;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public double getBaseDeliveryFee() {
		return baseDeliveryFee;
	}
	public boolean setBaseDeliveryFee(double baseDeliveryFee) {
		if(baseDeliveryFee < 0) {
			return false;
		}
		this.baseDeliveryFee = baseDeliveryFee;
		return true;
	}
////////////////toString/////////////////// 
	@Override
	public String toString() {
		return "Restaurant: (Code: " + restaurantCode +
				", Name: " + restaurantName +", Cuisine: "
				+ cuisine + ", Rating: " + restaurantRating +
				", Open? " + isOpen + ", Base Delivery Fee: "
				+ baseDeliveryFee + ")";
	}
	public double calcFinalPrice(double baseAmount) {
		return baseAmount+this.baseDeliveryFee; 
	}
////////override the deafult equals method : 2 restaurants are equal if they have the same code 
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true; 
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false; 
		}
		Restaurant other = (Restaurant)obj;
		return this.restaurantCode.equals(other.restaurantCode);
	}
	
}
