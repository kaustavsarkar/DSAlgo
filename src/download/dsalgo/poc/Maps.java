package download.dsalgo.poc;

import java.util.HashMap;
import java.util.Map;

public class Maps {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(1, 1);
		Integer num = map.get(2);
		System.out.println(num);
	}
}
