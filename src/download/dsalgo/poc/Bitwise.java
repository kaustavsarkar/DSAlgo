package download.dsalgo.poc;

import java.util.Arrays;

public class Bitwise {

	public static void main(String[] args) {
		Bitwise bitwise = new Bitwise();
		// bitwise.compute2i(0);
		// bitwise.compute2iP1(0);
		// bitwise.computeiB2(1);
		// bitwise.checkXOR(7, 2);

		//bitwise.checkZeroOne();
		int num = 1 << -31;
		//System.out.println(Integer.toBinaryString(num).length());
		//System.out.println(num);
		//System.out.println(~-3);
		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(-2 >> 1));
		System.out.println(Integer.toBinaryString(-2 >>> 1));

		//bitwise.power(4);
	}
	
	private void power(int i) {
		System.out.println(i << 2);
	}

	private void checkZeroOne() {
		System.out.println(2 & (1 << 1));
	}
	
	private void checkXOR(int i, int j) {
		System.out.println(i ^ j);
	}

	public void pairDist(int i, int j) {
		System.out.println(i&j);
	}

	private void compute2i(int i) {
		System.out.println((i + 1) << 1);
	}

	private void compute2iP1(int i) {
		System.out.println((i << 1) + 1);
	}

	private void computeiB2(int i) {
		System.out.println((i - 1) >> 1);
	}
}
