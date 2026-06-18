import java.util.List;
import java.util.stream.Collectors;
//this class is for using streams 
public class StreamReports {
	//this method prints all the open restaurants 
	public static void showOpenRestaurants(DeliveryDataBase system) {
		List<Restaurant> openRestaurants = system.getRestaurants().stream()
				.filter(Restaurant::isOpen).collect(Collectors.toList());
		openRestaurants.forEach(System.out::println); 
	}
	//this method prints all the premium restaurants
	public static void showPremiumRestaurants(DeliveryDataBase system) {
		List<Restaurant> premiumRestaurants = system.getRestaurants().stream()
				.filter(r -> r instanceof PremiumRestaurant).collect(Collectors.toList());
		premiumRestaurants.forEach(System.out::println);
	}
	//this method prints all the available riders
	public static void showAvailableRiders(DeliveryDataBase system) {
		List<Rider> availableRiders = system.getRiders().stream()
				.filter(Rider::isAvailable).collect(Collectors.toList());
		if (availableRiders.isEmpty()) {
			System.out.println("No available riders");
			return;
		}
		availableRiders.forEach(System.out::println);
	}
	//this method calculates and returns the total revenue
	public static double calculateTotalRevenue(DeliveryDataBase system) {
		return system.getOrders().stream().map(Order::getFinalPrice).reduce(0.0, Double::sum);
	}
	//this method prints the number of open restaurants 
	public static long countOpenRestaurants(DeliveryDataBase system){
		return system.getRestaurants().stream().filter(Restaurant::isOpen).count();
	}
}
