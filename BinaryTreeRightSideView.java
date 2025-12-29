// https://leetcode.com/problems/binary-tree-right-side-view/description/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * Time Complexity: O(N) - We visit every node.
	 * Average Space Complexity: O(H) - Recursion stack depth, generally the height of the tree.
	 * Worst Space Complexity: O(N) - For skewed tree, recursion stack depth will be equal to N.
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		rightSideViewHelper(root, 0, resultList);
		return resultList;
	}
	
	private void rightSideViewHelper(TreeNode node, int depth, List<Integer> resultList) {
		if (node == null) {
			return;
		}
		
		// If resultList.size() == current depth,
		// Means we are visiting this depth for the first time. Insert the current node val to `resultList`
		// Else means, the current depth is less than the lowest depth visited so far in `other branches`. So current node will be shadowed.
		if (resultList.size() == depth) {
			resultList.add(node.val);
		}
		
		rightSideViewHelper(node.right, depth + 1, resultList);
		rightSideViewHelper(node.left, depth + 1, resultList);
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		// example tree:
		//        1
		//       / \
		//      2   3
		//     /  \   \
		//    15   5   4
		//        /
		//      125
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.left.left = new TreeNode(15);
		root.left.right.left = new TreeNode(125);
		root.right.right = new TreeNode(4);
		
		BinaryTreeRightSideView myObj = new BinaryTreeRightSideView();
		List<Integer> result = myObj.rightSideView(root);
		
		System.out.println("Right Side View: " + result); // Expected: [1, 3, 4, 125]
	}
}