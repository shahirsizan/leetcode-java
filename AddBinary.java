public class AddBinary {
	
	public String addBinary(String a, String b) {
		StringBuilder resultString = new StringBuilder();
		
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		
		// loop as long as there are digits in `a` OR `b` OR `carry`
		while (i >= 0 || j >= 0 || carry == 1) {
			int currentSum = 0;
			
			if (i >= 0) {
				currentSum += a.charAt(i) - '0';
				i--;
			}
			if (j >= 0) {
				currentSum += b.charAt(j) - '0';
				j--;
			}
			if (carry != 0) {
				currentSum += carry;
			}
			
			resultString.append(currentSum % 2);
			carry = currentSum / 2;
		}
		
		// above `resultString.append()` appends characters left->right. So must be reversed now.
		resultString.reverse();
		return String.valueOf(resultString);
	}
	
	// --- Main ---
	
	public static void main(String[] args) {
		AddBinary solver = new AddBinary();
		
		// Example 1: 1010 + 1011 = 21 (Decimal). Result: 10101
		String a1 = "1010";
		String b1 = "1011";
		String result1 = solver.addBinary(a1, b1);
		System.out.println("Sum of " + a1 + " + " + b1 + " = " + result1 + " (Expected: 10101)");
		
		// Example 2: 1 + 1 = 2 (Decimal). Result: 10
		String a2 = "1";
		String b2 = "1";
		String result2 = solver.addBinary(a2, b2);
		System.out.println("Sum of " + a2 + " + " + b2 + " = " + result2 + " (Expected: 10)");
		
		// Example 3: 11 + 1 = 4 (Decimal). Result: 100
		String a3 = "11";
		String b3 = "1";
		String result3 = solver.addBinary(a3, b3);
		System.out.println("Sum of " + a3 + " + " + b3 + " = " + result3 + " (Expected: 100)");
	}
}