public class FastFoodRestaurant extends Restaurant{ 
	protected int averagePrepTime; 
	protected double fastDeliveryFee;
///////////////////////constructor/////////////////
	public FastFoodRestaurant(String restaurantcode, String restaurantName, String cuisine, double restaurantRating,
			boolean isOpen, double baseDeliveryFee, int averagePrepTime, double fastDeliveryFee) {
		super(restaurantcode, restaurantName, cuisine, restaurantRating, isOpen, baseDeliveryFee);
		setAveragePrepTime(averagePrepTime);
		setFastDeliveryFee(fastDeliveryFee);
	}
///////////////getters and setters/////////////
	public int getAveragePrepTime() {
		return averagePrepTime;
	}

	public boolean setAveragePrepTime(int averagePrepTime) {
		if(averagePrepTime <= 0) {
			return false; 
		}
		this.averagePrepTime = averagePrepTime;
		return true; 
	}

	public double getFastDeliveryFee() {
		return fastDeliveryFee;
	}

	public boolean setFastDeliveryFee(double fastDeliveryFee) {
		if(fastDeliveryFee < 0 ) {
			return false ;
		}
		this.fastDeliveryFee = fastDeliveryFee;
		return true;
	}
////////////toString/////////////////
	@Override
	public String toString() {
		return super.toString() + 
				" ,Fast Food Restaurant: (AveragePrepTime: " + averagePrepTime + 
				", Fast Delivery Fee: " + fastDeliveryFee + ")";
	}
///////////helper method//////////////
	@Override 
	public double calcFinalPrice(double baseAmount) {
		return baseAmount + this.fastDeliveryFee + this.baseDeliveryFee;
	}
}
