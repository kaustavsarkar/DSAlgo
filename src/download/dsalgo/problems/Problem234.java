package download.dsalgo.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Problem234 {

	public static void main(String[] args) {
		int destX = 2;
		int destY = 3;
		int circles = 1;
		int radius = 1;
		Integer[] xcoords = { 1 };
		Integer[] ycoords = { 1 };
		System.out.println(new Problem234().solve(destX, destY, circles, radius,
				new ArrayList<>(Arrays.asList(xcoords)),
				new ArrayList<>(Arrays.asList(ycoords))));
	}

	public String solve(int A, int B, int C, int D, ArrayList<Integer> E,
			ArrayList<Integer> F) {
		if (E == null || E.isEmpty()) {
			return "YES";
		}

		List<Circle> circles = createCircles(D, E, F);
		Stack<Coordinate> adjacentCoords = new Stack<>();
		Set<Coordinate> visited = new HashSet<>();

		Coordinate destination = new Coordinate(A, B);
		Coordinate start = new Coordinate(0, 0);
		adjacentCoords.addAll(getValidCoords(start, destination, circles));
		visited.add(start);
		while (!adjacentCoords.isEmpty()) {
			Coordinate coord = adjacentCoords.pop();
			if (!visited.contains(coord)) {
				visited.add(coord);
				if (isValid(coord, circles, destination)
						&& coord.equals(destination)) {
					return "YES";
				}
				for (Coordinate adj : getValidCoords(coord, destination,
						circles)) {
					if (!visited.contains(adj)) {
						adjacentCoords.add(adj);
					}
				}
			}
		}

		return "NO";
	}

	private static class Coordinate {
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public List<Coordinate> getAdjacentCoords() {
			List<Coordinate> result = new ArrayList<>();
			result.add(new Coordinate(x + 1, y + 1));
			result.add(new Coordinate(x, y + 1));
			result.add(new Coordinate(x + 1, y));
			result.add(new Coordinate(x - 1, y - 1));
			result.add(new Coordinate(x - 1, y));
			result.add(new Coordinate(x, y - 1));
			result.add(new Coordinate(x + 1, y - 1));
			result.add(new Coordinate(x - 1, y + 1));
			return result;
		}

		public boolean equals(Object o) {
			//System.out.println("Called Equals");
			if (o == null) {
				return false;
			}
			if (!(o instanceof Coordinate)) {
				return false;
			}

			Coordinate coord = (Coordinate) o;
			if (this.x != coord.x || this.y != coord.y) {
				return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			//System.out.println("Called hashCodes");
			return ( y << 32 ) ^ x;
		}

		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	private static class Circle {
		Coordinate center;
		int radius;

		public Circle(Coordinate center, int radius) {
			this.center = center;
			this.radius = radius;
		}

		public boolean isInside(Coordinate coords) {
			long distance = ((center.x - coords.x) * (center.x - coords.x))
					+ ((center.y - coords.y) * (center.y - coords.y));
			return distance <= radius * radius;
		}

		public String toString() {
			return center + " " + radius;
		}
	}

	private List<Coordinate> getValidCoords(Coordinate coord,
			Coordinate destination, List<Circle> circles) {
		List<Coordinate> adjacents = coord.getAdjacentCoords();
		adjacents = adjacents.stream()
				.filter(adj -> isValid(adj, circles, destination))
				.collect(Collectors.toList());
		return adjacents;
	}

	private boolean isValid(Coordinate coord, List<Circle> circles,
			Coordinate destination) {
		if (coord.x > destination.x || coord.y > destination.y || coord.y < 0
				|| coord.x < 0) {
			return false;
		}

		for (Circle circle : circles) {
			if (circle.isInside(coord)) {
				return false;
			}
		}
		return true;
	}

	public List<Circle> createCircles(int radius, ArrayList<Integer> xcoord,
			ArrayList<Integer> ycoord) {
		List<Circle> circles = new ArrayList<>();
		for (int index = 0; index < xcoord.size(); index++) {
			Coordinate center = new Coordinate(xcoord.get(index),
					ycoord.get(index));
			circles.add(new Circle(center, radius));
		}
		return circles;
	}
}
