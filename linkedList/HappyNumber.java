// https://leetcode.com/problems/happy-number/description/
// Kunal Kushwaha (LL)

package linkedList;

/**
 * 1. move `slow` once and `fast` twice
 * 2. If `fast` reaches a `1`, it's a happy number.
 * 3. If they meet at a number other than `1`, it's unhappy.
 *
 */

public class HappyNumber {
	public boolean isHappy(int n) {
		int slow = n;
		int fast = n;
		
		do {
			slow = getNext(slow);
			fast = getNext(getNext(fast));
		}
		while (fast != 1 && slow != fast);
		
		if (fast == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private int getNext(int n) {
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += digit * digit;
			n /= 10;
		}
		return sum;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		HappyNumber myObj = new HappyNumber();
		System.out.println("Is 19 happy? " + myObj.isHappy(19) + " (expected: true)");
		System.out.println("Is 2 happy? " + myObj.isHappy(2) + " (expected: false)");
	}
}