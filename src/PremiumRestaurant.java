public class PremiumRestaurant extends Restaurant {
	protected double minOrderAmount;
	protected double extraCommissionPercent;
////////////constructor////////////////////
	public PremiumRestaurant(String restaurantcode, String restaurantName, String cuisine, double restaurantRating,
			boolean isOpen, double baseDeliveryFee, double minOrderAmount, double extraCommissionPercent) {
		super(restaurantcode, restaurantName, cuisine, restaurantRating, isOpen, baseDeliveryFee);
		setMinOrderAmount(minOrderAmount);
		setExtraCommissionPercent(extraCommissionPercent);
	}
/////////////////////getters and setters////////////////
	public double getMinOrderAmount() {
		return minOrderAmount;
	}
	public boolean setMinOrderAmount(double minOrderAmount) {
		if(minOrderAmount <= 0) {
			return false;
		}
		this.minOrderAmount = minOrderAmount;
		return true;
	}
	public double getExtraCommissionPercent() {
		return extraCommissionPercent;
	}
	public boolean setExtraCommissionPercent(double extraCommissionPercent) {
		if(extraCommissionPercent <= 0) {
			return false;
		}
		this.extraCommissionPercent = extraCommissionPercent;
		return true; 
	}
////////////////toString///////////////////////
	@Override
	public String toString() {
		return super.toString() + 
				" ,PremiumRestaurant: (Minimum Order Amount:" 
				+ minOrderAmount + ", Extra Commission Percent: "
				+ extraCommissionPercent + ")";
	}
	@Override
	public double calcFinalPrice(double baseAmount) {
		if(baseAmount < this.minOrderAmount) {
			baseAmount = this.minOrderAmount ; 
		}
		return baseAmount + this.baseDeliveryFee + (this.extraCommissionPercent / 100) * baseAmount ; 
	}
}
