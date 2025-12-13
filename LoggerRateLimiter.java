// https://leetcode.com/problems/logger-rate-limiter/description/  [premium version]
// https://algo.monster/liteproblems/359

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
	
	private Map<String, Integer> ourMapp;
	
	public LoggerRateLimiter() {
		this.ourMapp = new HashMap<>();
	}
	
	public boolean shouldPrintMessage(int timestamp, String message) {
		
		if (!ourMapp.containsKey(message)) {
			ourMapp.put(message, timestamp + 10);
			// here `timestamp` is for the next allowed message
			return true;
		}
		
		int currentMsgExpireTime = ourMapp.get(message);
		
		if (timestamp >= currentMsgExpireTime) {
			ourMapp.put(message, timestamp + 10);
			return true;
		} else {
			return false;
		}
	}
	
	// ✅ main ✅
	public static void main(String[] args) {
		LoggerRateLimiter logger = new LoggerRateLimiter();
		
		// 1. Should print "foo" at time 1
		System.out.println("Time 1, foo: " + logger.shouldPrintMessage(1, "foo") + " (Expected: true)");
		// Output: true
		// Map: {"foo": 11}
		
		// 2. Should print "bar" at time 2
		System.out.println("Time 2, bar: " + logger.shouldPrintMessage(2, "bar") + " (Expected: true)");
		// Output: true
		// Map: {"foo": 11, "bar": 12}
		
		// 3. Should NOT print "foo" at time 11 (Too early, needs time 11 or later) - Wait, time is 3.
		System.out.println("Time 3, foo: " + logger.shouldPrintMessage(3, "foo") + " (Expected: false)");
		// Output: false
		
		// 4. Should print "bar" at time 8 (bar expiration is 12) - Wait, time is 8.
		System.out.println("Time 8, bar: " + logger.shouldPrintMessage(8, "bar") + " (Expected: false)");
		// Output: false
		
		// 5. Should print "foo" at time 11 (Expiration was 11)
		System.out.println("Time 11, foo: " + logger.shouldPrintMessage(11, "foo") + " (Expected: true)");
		// Output: true
		// Map: {"foo": 21, "bar": 12}
		
		// 6. Should print "bar" at time 12 (Expiration was 12)
		System.out.println("Time 12, bar: " + logger.shouldPrintMessage(12, "bar") + " (Expected: true)");
		// Output: true
		// Map: {"foo": 21, "bar": 22}
	}
}