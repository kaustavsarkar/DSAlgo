import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestIterators {

	public static void main(String[] args) {

		Set<String> stringSet = new HashSet<>();

		stringSet.add("a");
		stringSet.add("b");
		stringSet.add("c");

		Iterator<String> it = stringSet.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println("Print S  : "+s);
			if (it.hasNext())
				it.remove();
		}

		System.out.println(stringSet);
	}
}
