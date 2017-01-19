import java.util.HashSet;
import java.util.Set;

public class BookClass implements Book {
	public boolean pack(String box) {
		// TODO Auto-generated method stub
		return false;
	}

	public static int numUnique(double[] list) {
		Set<Double> uniqueSet = new HashSet<>();
		for (int i = 0; i < list.length; i++) {
			uniqueSet.add(list[i]);
		}
		return uniqueSet.size();
	}

}
