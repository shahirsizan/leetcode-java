// https://www.youtube.com/watch?v=0FtVY6I4pB8&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=23

package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreeBottomView {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	static class Pair {
		TreeNode node;
		int horizontalDist;
		
		Pair(TreeNode node, int horizontalDist) {
			this.node = node;
			this.horizontalDist = horizontalDist;
		}
	}
	
	public void printBottomView(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Queue<Pair> ourQueue = new LinkedList<>();
		Map<Integer, TreeNode> ourMap = new HashMap<>();
		ourQueue.add(new Pair(root, 0));
		
		int leftMostHD = 0, rightMostHD = 0;
		
		while (!ourQueue.isEmpty()) {
			Pair currPair = ourQueue.poll();
			TreeNode currNode = currPair.node;
			int currNodeHD = currPair.horizontalDist;
			
			// Put new key-values into hashmap.
			// Also overwrite the hashmap every time we encounter existing key
			// Ensures the node at the deepest level at this particular horizontalDist is stored in hashmap
			ourMap.put(currNodeHD, currNode);
			
			leftMostHD = Math.min(leftMostHD, currNodeHD);
			rightMostHD = Math.max(rightMostHD, currNodeHD);
			
			if (currNode.left != null) {
				ourQueue.add(new Pair(currNode.left, currNodeHD - 1));
			}
			if (currNode.right != null) {
				ourQueue.add(new Pair(currNode.right, currNodeHD + 1));
			}
		}
		
		for (int i = leftMostHD; i <= rightMostHD; i++) {
			// each time we get a `node`. Extract its `val`
			System.out.print(ourMap.get(i).val + " ");
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		TreeBottomView mtObj = new TreeBottomView();
		
		//        1
		//       / \
		//      2   3
		//     / \ / \
		//    4  5 6  7
		// Bottom View: 4 2 6 3 7 OR 4 2 5 3 7 depending on overlap
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		System.out.print("Bottom View: ");
		mtObj.printBottomView(root);
	}
}