import java.util.function.Predicate;
public class PredicateReports {
	// this method uses Predicate to check if a customer's balance is above 100
	public static void showCustomersWithHighBalance(DeliveryDataBase system) {
		Predicate<Customer> highPalance = 
				c -> c.getRefundBalance() > 100 ;
		for(Customer customer : system.getCustomers()) {
			if(highPalance.test(customer)) {
				System.out.println(customer);
			}
		}
	}
}
