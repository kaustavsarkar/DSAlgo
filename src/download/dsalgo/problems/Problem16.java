package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of real numbers greater than zero in form of strings. Find if
 * there exists a triplet (a,b,c) such that 1 < a+b+c < 2 . Return 1 for true or
 * 0 for false.
 * 
 * Example:
 * 
 * Given [0.6, 0.7, 0.8, 1.2, 0.4] ,
 * 
 * You should return 1
 * 
 * as
 * 
 * 0.6+0.7+0.4=1.7
 * 
 * 1<1.7<2
 * 
 * Hence, the output is 1.
 * 
 * @author kaussark
 *
 */
public class Problem16 {

	public static void main(String[] args) {
		args = new String[] { "0.366507", "0.234601", "2.126313", "1.372403",
				"2.022170", "0.308558", "2.120754", "1.561462" };
		// { "0.297657", "0.420048", "0.053365", "0.437979",
		// "0.375614", "0.264731", "0.060393", "0.197118", "0.203301",
		// "0.128168" };
		// { "0.547388", "0.203640", "0.511646", "0.456251",
		// "0.431441", "0.240933" };
		// { "2.254749", "2.084043", "1.467452", "2.570546",
		// "1.183171", "0.776592", "2.108878" };
		/*
		 * { "0.503094", "0.648924", "0.999298", "0.853928", "3.457635",
		 * "5.030008", "2.434625", "3.081333", "4.629904", "0.551040",
		 * "2.950470", "2.248522", "1.426132", "4.848954", "4.624663",
		 * "1.095358", "0.980046", "3.620912", "3.504833", "1.930379" };
		 */
		/*
		 * { "0.843965", "0.929296", "1.525570", "1.469064", "1.318529",
		 * "1.207967", "1.294448", "1.145449", "1.767975", "1.008212" };
		 */
		// {"2.673662", "2.419159", "0.573816", "2.454376", "0.403605",
		// "2.503658", "0.806191"};
		// { "0.6", "0.7", "0.8", "1.2", "0.4" };
		// {"0.503094", "0.648924", "0.999298"};
		Problem16 problem = new Problem16();
		System.out.println(problem.solve(args));
	}
	 public int _solve(ArrayList<String> A) {
	        if(A.size() < 3) return 0;

	        double a = Double.parseDouble(A.get(0)); 
	        double b = Double.parseDouble(A.get(1)); 
	        double c = Double.parseDouble(A.get(2)); 

	        for(int i = 3; i < A.size(); i++){
	            if((a+b+c) > 1 && (a+b+c) < 2){
	                return 1;
	            }

	            double n = Double.parseDouble(A.get(i));
	            
	           if((a+b+c) >= 2){
	                if(a > b && a > c){
	                    a = n;
	                } else if( b > c){
	                    b = n;
	                } else{
	                    c = n;
	                }
	            } 
	            else{
	                if(a < b && a < c){
	                    a = n;
	                } else if( b < c){
	                    b = n;
	                } else{
	                    c = n;
	                }
	            }
	        }
	        
	        if((a+b+c) > 1 && (a+b+c) < 2){
	            return 1;
	        }
	       
	        return 0;

	    }

	public int solve(ArrayList<String> A) {
		int n = A.size();
		double[] arr = new double[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Double.valueOf(A.get(i));
		}
		double a = arr[0], b = arr[1], c = arr[2];
		for (int i = 3; i < n; i++) {
			// check if sum fall in (1, 2)
			if (a + b + c > 1 && a + b + c < 2) {
				return 1;
			}
			// if not, then check is sum greater than 2
			// if so, then replece MAX(a,b,c) to new number
			else if (a + b + c > 2) {
				if (a > b && a > c) {
					a = arr[i];
				} else if (b > a && b > c) {
					b = arr[i];
				} else if (c > a && c > b) {
					c = arr[i];
				}
			}
			// else then sum must be less than 1
			// then replace MIN(a,b,c) to new number
			else {
				if (a < b && a < c) {
					a = arr[i];
				} else if (b < a && b < c) {
					b = arr[i];
				} else if (c < a && c < b) {
					c = arr[i];
				}
			}
		}
		// check for last a, b, c triplet
		if (a + b + c > 1 && a + b + c < 2) {
			return 1;
		} else {
			return 0;
		}
	}

	public int solve(String[] A) {

		List<Double> _006 = new ArrayList<>();// 0 to 0.6 --> A
		List<Double> _0601 = new ArrayList<>(); // 0.6 to 1 --> B
		List<Double> _12 = new ArrayList<>(); // 1 to 2 --> C
		double sum = 0;
		// AAA --> largest 3 values
		// AAB --> A large B small
		// AAC --> A small C small
		// ABB --> A large B small || small A
		// ABC --> small A small in B small in C

		for (String s : A) {
			double num = Double.valueOf(s);
			if (num > 0 && num < 0.6) {
				_006.add(num);
			} else if (num >= 0.6 && num < 1) {
				if (_0601.size() == 2) {
					if (_0601.get(0) > num) {
						_0601.remove(0);
						_0601.add(0, num);
					} else if (_0601.get(1) > num) {
						_0601.remove(1);
						_0601.add(1, num);
					}
				} else if (_0601.size() == 1 && _0601.get(0) > num) {
					_0601.add(0, num);
				} else {
					_0601.add(num);
				}

			} else if (num >= 1 && num < 2) {
				if (_12.isEmpty()) {
					_12.add(num);
				} else if (num < _12.get(0)) {
					_12.remove(0);
					_12.add(0, num);
				}
			}
		}
		Collections.sort(_006);
		if (_006.size() >= 4) {
			double min = _006.get(0);
			_006 = _006.subList(_006.size() - 3, _006.size());
			_006.add(0, min);
		} else {
			_006 = _006.subList(0, _006.size());
		}
		System.out.println(_006);
		System.out.println(_0601);
		System.out.println(_12);
		// AAA
		for (int i = _006.size() - 1; i >= 0 && _006.size() >= 3; i--) {
			sum += _006.get(i);
		}
		if (sum > 1 && sum < 2) {
			return 1;
		}
		sum = 0;
		// AAB || AAC
		for (int i = _006.size() - 1; i > _006.size() - 3
				&& _006.size() >= 2; i--) {
			sum += _006.get(i);
		}
		if (sum != 0 && !_0601.isEmpty()) {
			sum += _0601.get(0);
		} else if (sum != 0 && !_12.isEmpty()) {
			sum += _12.get(0);
		}

		if (sum > 1 && sum < 2) {
			return 1;
		}

		sum = 0;
		// AAC
		for (int i = 1; i <= 2 && _006.size() >= 3; i++) {
			sum += _006.get(i);
		}
		if (sum != 0 && !_12.isEmpty()) {
			sum += _12.get(0);
		}
		if (sum > 1 && sum < 2) {
			return 1;
		}
		sum = 0;
		// ABB || ABC
		if (!_006.isEmpty()) {
			sum = _006.get(0);
		}

		if (sum != 0 && _0601.size() == 2) {
			for (int i = 0; i < 2; i++) {
				sum += _0601.get(i);
			}
		} else if (sum != 0 && _0601.size() == 1 && !_12.isEmpty()) {
			sum += _0601.get(0);
			sum += _12.get(0);
		}
		if (sum > 1 && sum < 2) {
			return 1;
		}

		// AAC
		sum = 0;
		if (_006.size() >= 2) {
			sum += _006.get(0);
			sum += _006.get(1);

		}
		if (sum != 0 && !_12.isEmpty()) {
			sum += _12.get(0);
		}
		if (sum > 1 && sum < 2) {
			return 1;
		}
		return 0;
	}

}
