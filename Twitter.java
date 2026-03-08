// CPS academy DSA sheet (Heaps & Priority Queues)
// https://leetcode.com/problems/design-twitter/description/

import java.util.*;

class Twitter {
	private static int timeStamp = 0;
	private Map<Integer, User> userMap;
	
	private class Tweet {
		int id;
		int time;
		Tweet next;
		
		Tweet(int id) {
			this.id = id;
			this.time = timeStamp++;
			this.next = null;
		}
	}
	
	private class User {
		int id;
		Tweet tweetHead;
		Set<Integer> followed;
		
		User(int id) {
			this.id = id;
			followed = new HashSet<>();
			// Follow self to see own tweets in newsfeed
			follow(id);
			tweetHead = null;
		}
		
		void post(int id) {
			Tweet t = new Tweet(id);
			t.next = tweetHead;
			tweetHead = t;
		}
		
		void follow(int id) {
			followed.add(id);
		}
		
		void unfollow(int id) {
			if (id != this.id) {
				followed.remove(id);
			}
		}
		
	}
	
	public Twitter() {
		userMap = new HashMap<>();
	}
	
	public void postTweet(int userId, int tweetId) {
		if (!userMap.containsKey(userId)) {
			userMap.put(userId, new User(userId));
		}
		userMap.get(userId).post(tweetId);
	}
	
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> result = new LinkedList<>();
		
		if (!userMap.containsKey(userId)) {
			return result;
		}
		
		PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> {
			return b.time - a.time;
		});
		Set<Integer> users = userMap.get(userId).followed;
		
		for (int id : users) {
			Tweet t = userMap.get(id).tweetHead;
			// a user may not have posted anything yet, so check for null
			if (t != null) {
				// put into maxHeap
				pq.offer(t);
			}
			
		}
		
		// get top 10 tweets
		int count = 0;
		while (!pq.isEmpty() && count < 10) {
			Tweet t = pq.poll();
			result.add(t.id);
			
			// if user has older tweets, push into `pq`
			if (t.next != null) {
				pq.offer(t.next);
			}
			count++;
		}
		
		return result;
	}
	
	public void follow(int followerId, int followeeId) {
		if (!userMap.containsKey(followerId)) {
			userMap.put(followerId, new User(followerId));
		}
		if (!userMap.containsKey(followeeId)) {
			userMap.put(followeeId, new User(followeeId));
		}
		userMap.get(followerId).follow(followeeId);
	}
	
	public void unfollow(int followerId, int followeeId) {
		if (userMap.containsKey(followerId)) {
			userMap.get(followerId).unfollow(followeeId);
		}
	}
}