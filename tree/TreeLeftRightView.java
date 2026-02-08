// https://leetcode.com/problems/binary-tree-right-side-view/description/
// https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=24&pp=iAQB0gcJCZEKAYcqIYzv

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLeftRightView {
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	// LeetCode 199: Right Side View
	// https://leetcode.com/problems/binary-tree-right-side-view/description/
	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		
		List<Integer> resultList = new ArrayList<>();
		Queue<TreeNode> ourQueue = new LinkedList<>();
		ourQueue.add(root);
		
		while (!ourQueue.isEmpty()) {
			// currLevelSize -> number of nodes in this particular level
			int currLevelSize = ourQueue.size();
			
			for (int i = 0; i < currLevelSize; i++) {
				TreeNode currNode = ourQueue.poll();
				
				// `last node` of this level will be the part of the `right view`
				if (i == currLevelSize - 1) {
					resultList.add(currNode.val);
				}
				
				if (currNode.left != null) {
					ourQueue.add(currNode.left);
				}
				if (currNode.right != null) {
					ourQueue.add(currNode.right);
				}
			}
		}
		return resultList;
	}
	
	// Left Side View logic
	public List<Integer> leftSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		
		List<Integer> resultList = new ArrayList<>();
		Queue<TreeNode> ourQueue = new LinkedList<>();
		ourQueue.add(root);
		
		while (!ourQueue.isEmpty()) {
			int currLevelSize = ourQueue.size();
			
			for (int i = 0; i < currLevelSize; i++) {
				TreeNode currNode = ourQueue.poll();
				
				// `first node` of this level will be the part of the `left view`
				if (i == 0) {
					resultList.add(currNode.val);
				}
				
				if (currNode.left != null) {
					ourQueue.add(currNode.left);
				}
				if (currNode.right != null) {
					ourQueue.add(currNode.right);
				}
			}
		}
		return resultList;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		TreeLeftRightView myObj = new TreeLeftRightView();
		
		//        1
		//       / \
		//      2   3
		//       \   \
		//        4   5
		// Right View: [1, 3, 5]
		// Left View:  [1, 2, 4]
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		System.out.println("Right View: " + myObj.rightSideView(root));
		System.out.println("Left View:  " + myObj.leftSideView(root));
	}
}