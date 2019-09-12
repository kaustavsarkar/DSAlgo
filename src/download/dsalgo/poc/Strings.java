package download.dsalgo.poc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Strings {

	public static void main(String[] args) {
		List<String> strings =  new ArrayList<>();
		strings.add("30");
		strings.add("31");
		strings.add("34");
		strings.add("35");
		strings.add("3");
		StringBuilder builder = new StringBuilder();

		Collections.sort(strings);
		System.out.println('A'+'B');
		print(null);
	}

	public static void print(String string) {
		System.out.println("string");
	}
	public static void print(Object object) {
		System.out.println("object");
	}
}
