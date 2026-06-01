import java.util.ArrayList; 
public class RestAdmin extends Admin {
	protected ArrayList<Restaurant> restaurants;
	protected int count ;
//////////////constructor////////////////////////
	public RestAdmin(String name, String userName, String password, ArrayList<Restaurant> restaurants, int count) {
		super(name, userName, password);
		if(!setRestaurants(restaurants)) {
			this.restaurants = new ArrayList<Restaurant>(); 
			this.count = 0; 
		}
	}
	public RestAdmin(String name, String userName, String password) {
		super(name, userName, password);
		this.restaurants = new ArrayList<Restaurant>();
        this.count = 0;
	}

///////////////getters and setters////////////////////
	public ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}
	public boolean setRestaurants(ArrayList<Restaurant> restaurants) {
		if(restaurants != null) {
			this.restaurants = restaurants;
			this.count = restaurants.size();
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
		if(count < 0 || count > this.restaurants.size()) {
			return false; 
		}
		this.count = count;
		return true; 
	}
/////////////toString////////////////
	@Override
	public String toString() {
		return super.toString() + " ,RestAdmin: (restaurants: " + restaurants
		+ ", count: " + count + ")";
	}
	public boolean addRestaurant(Restaurant restaurant) {
		if(restaurant == null) {
			return false;
		}
		if(restaurants.contains(restaurant)) {
			return false; 
		}

		restaurants.add(restaurant);
		count = restaurants.size();
		return true; 
	}
	public boolean isResponsibleFor(String restaurantCode) {
		for(Restaurant restaurant : restaurants) {
			if(restaurant.getRestaurantCode().equals(restaurantCode)) {
				return true;
			}
		}
		return false; 
	}
}
