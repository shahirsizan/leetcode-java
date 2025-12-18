// https://leetcode.com/problems/lemonade-change/description/

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
	
	public boolean lemonadeChange(int[] billsList) {
		Map<Integer, Integer> cashBox = new HashMap<>();
		cashBox.put(5, 0);
		cashBox.put(10, 0);
		cashBox.put(20, 0);
		
		
		for (int bill : billsList) {
			/**
			 * if bill is 5: nothing to do. Just hand over the lemonade.
			 * if bill is 10: we need at least `one 5` bill in our cashBox.
			 * if bill is 20: we either need (at least `one 10` AND `one 5` ) OR ( at least `three 5` ) in our cashBox.
			 * */
			
			// bill 5
			if (bill == 5) {
				cashBox.put(5, cashBox.get(5) + 1);
			}
			// bill 10
			else if (bill == 10) {
				if (cashBox.get(5) >= 1) {
					cashBox.put(5, cashBox.get(5) - 1);
					cashBox.put(10, cashBox.get(10) + 1);
				} else {
					return false;
				}
			}
			// bill 20
			else {
				if (cashBox.get(10) >= 1 && cashBox.get(5) >= 1) {
					cashBox.put(5, cashBox.get(5) - 1);
					cashBox.put(10, cashBox.get(10) - 1);
					cashBox.put(20, cashBox.get(20) + 1);
				} else if (cashBox.get(5) >= 3) {
					cashBox.put(5, cashBox.get(5) - 3);
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// ✅main✅
	public static void main(String[] args) {
		LemonadeChange myObj = new LemonadeChange();
		
		int[] bills1 = {5, 5, 5, 10, 20};
		System.out.println("Input: [5, 5, 5, 10, 20]");
		System.out.println(myObj.lemonadeChange(bills1));
		
		int[] bills2 = {5, 5, 10, 10, 20};
		System.out.println("\nInput: [5, 5, 10, 10, 20]");
		System.out.println(myObj.lemonadeChange(bills2));
		
		int[] bills3 = {5, 5, 5, 5, 20, 20, 10};
		System.out.println("\nInput: [5, 5, 5, 5, 20, 20, 10]");
		System.out.println(myObj.lemonadeChange(bills3));
	}
}