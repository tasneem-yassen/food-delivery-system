import java.util.Arrays;

public class RestAdmin extends Admin {
	protected Restaurant[] restaurants;
	protected int count ;
//////////////constructor////////////////////////
	public RestAdmin(String name, String userName, String password, Restaurant[] restaurants, int count) {
		super(name, userName, password);
		setRestaurants(restaurants);
		setCount(count);
	}
///////////////getters and setters////////////////////
	public Restaurant[] getRestaurants() {
		return restaurants;
	}
	public boolean setRestaurants(Restaurant[] restaurants) {
		if(restaurants != null && restaurants.length > 0 ) {
			this.restaurants = restaurants;
			return true;
		}
		return false ; 
	}
	public int getCount() {
		return count;
	}
	public boolean setCount(int count) {
		if(this.restaurants == null)
		    return false;
		if(count < 0 || count > this.restaurants.length) {
			return false; 
		}
		this.count = count;
		return true; 
	}
/////////////toString////////////////
	@Override
	public String toString() {
		return super.toString() + " ,RestAdmin: (restaurants: " + Arrays.toString(restaurants) 
		+ ", count: " + count + ")";
	}
	public boolean addRestaurant(Restaurant restaurant) {
		if(restaurant == null) {
			return false;
		}
		if(count >= restaurants.length) {
			return false; 
		}
		for(int i=0 ; i<count ;i++) {
			if(restaurants[i].equals(restaurant)) {
				return false; 
			}
		}
		restaurants[count] = restaurant; 
		count++;
		return true; 
	}
	public boolean isResponsibleFor(String restaurantCode) {
		for(int i=0 ; i< count ; i++) {
			if(restaurants[i].getRestaurantCode().equals(restaurantCode)) {
				return true;
			}
		}
		return false; 
	}
}
