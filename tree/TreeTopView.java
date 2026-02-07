// takeuforward
// https://www.youtube.com/watch?v=Et9OCDNvJ78&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=23

package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class TreeTopView {
	// node: (i) val, (ii) left pointer,(iii) right pointer
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	// pair: (i) node, (ii) it's current horizontal distance
	static class Pair {
		TreeNode node;
		int horizontalDIst; // Horizontal Distance
		
		Pair(TreeNode node, int horizontalDist) {
			this.node = node;
			this.horizontalDIst = horizontalDist;
		}
	}
	
	public void printTopView(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Map<Integer, Integer> ourMap = new HashMap<>();
		Queue<Pair> ourQueue = new LinkedList<>();
		ourQueue.add(new Pair(root, 0));
		
		// Track range to print in order without using a TreeMap
		int leftMostHD = 0, rightMostHD = 0;
		
		while (!ourQueue.isEmpty()) {
			Pair currPair = ourQueue.poll();
			int currNodeHD = currPair.horizontalDIst;
			TreeNode currNode = currPair.node;
			
			// if not in `ourMap`, means it's the first node on the vertical line and will be a part of top-view
			if (!ourMap.containsKey(currNodeHD)) {
				ourMap.put(currNodeHD, currNode.val);
			}
			
			// update distances range
			leftMostHD = Math.min(leftMostHD, currNodeHD);
			rightMostHD = Math.max(rightMostHD, currNodeHD);
			
			if (currNode.left != null) {
				ourQueue.add(new Pair(currNode.left, currNodeHD - 1));
			}
			if (currNode.right != null) {
				ourQueue.add(new Pair(currNode.right, currNodeHD + 1));
			}
		}
		
		// Print from leftmost to rightmost coordinate
		for (int i = leftMostHD; i <= rightMostHD; i++) {
			System.out.print(ourMap.get(i) + " ");
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		TreeTopView solver = new TreeTopView();
		
		// Tree structure:
		//      1
		//    /   \
		//   2     3
		//    \   /
		//     4 5
		// Top View: 2 1 3 (4 and 5 are hidden by 1)
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		
		System.out.print("Top View: ");
		solver.printTopView(root);
	}
}