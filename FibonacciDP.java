// https://leetcode.com/problems/fibonacci-number/description/

import java.util.HashMap;
import java.util.Map;

public class FibonacciDP {
	Map<Integer, Integer> memoMap = new HashMap<>();
	
	public int fib(int n) {
		if (n <= 1) {
			return n;
		}
		
		if (memoMap.containsKey(n)) {
			return memoMap.get(n);
		}
		
		int value = fib(n - 1) + fib(n - 2);
		memoMap.put(n, value);
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