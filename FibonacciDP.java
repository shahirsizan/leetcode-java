// https://leetcode.com/problems/fibonacci-number/description/

import java.util.HashMap;
import java.util.Map;

public class FibonacciDP {
	// memoization map. We could have used array also because the subproblems have only 1 parameter.
	Map<Integer, Integer> memoMap = new HashMap<>();
	
	public int fib(int n) {
		// if base case, return `0` or `1`
		if (n <= 1) {
			return n;
		}
		
		// not base case, but pre-calculated in the map, return it
		if (memoMap.containsKey(n)) {
			return memoMap.get(n);
		}
		
		// not pre-calculated, calculate
		int value = fib(n - 1) + fib(n - 2);
		// store the calculation in map
		memoMap.put(n, value);
		// return
		return value;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		FibonacciDP myObj = new FibonacciDP();
		
		System.out.println("F(2) = " + myObj.fib(2));
		System.out.println("F(4) = " + myObj.fib(4));
		System.out.println("F(10) = " + myObj.fib(10));
		System.out.println("F(45) = " + myObj.fib(45));
	}
}