import java.util.Comparator;

public class OrderComparator implements Comparator<Order>{
	@Override
	public int compare(Order o1, Order o2) {
		return Double.compare(o2.getFinalPrice(), o1.getFinalPrice());
	}
}
