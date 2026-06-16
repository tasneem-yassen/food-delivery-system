import java.util.Comparator;

public class RestaurantComparator implements Comparator<Restaurant>{
	@Override 
	public int compare(Restaurant r1, Restaurant r2) {
		return Double.compare(r2.getRestaurantRating(), r1.getRestaurantRating());
	}
}
