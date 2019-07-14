package download.dsalgo.problems;

import java.util.ArrayList;

public class Problem4 {

	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<>();
		x.add(-7);
		//x.add(-13);
		ArrayList<Integer> y = new ArrayList<>();
		y.add(-1);
		//y.add(-5);
		
		Problem4 problem = new Problem4();
		String steps = problem.coverPoints(x, y);
		System.out.println(steps);
	}
	
	public String coverPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
		String step = "0";
		for (int counter = 0; counter < x.size()-1; counter++) {
			int maxStep = Math.max(Math.abs(x.get(counter)-x.get(counter+1)), Math.abs(y.get(counter)-y .get(counter+1)));
			step = Integer.valueOf(Integer.valueOf(step) + maxStep).toString();
		}
		//return 1 > 2 : 1  ? 2;
		return step;
	}
}
