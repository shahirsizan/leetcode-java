// https://leetcode.com/problems/balanced-binary-tree/description/

package tree;

public class BalancedBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * Time Complexity: O(N)
	 * Space Complexity: O(H) where H is tree height
	 */
	public boolean isBalanced(TreeNode root) {
		// If isBalancedHelper returns -1, it means the tree is unbalanced
		return isBalancedHelper(root) == -1 ? false : true;
	}
	
	private int isBalancedHelper(TreeNode node) {
		// base case: null nodes have height 0
		if (node == null) {
			return 0;
		}
		
		// Get height of left subtree
		int leftHeight = isBalancedHelper(node.left);
		// If left subtree is already unbalanced, the entire tree is also unbalanced, propagate -1 up
		if (leftHeight == -1) {
			return -1;
		}
		
		// Get height of right subtree
		int rightHeight = isBalancedHelper(node.right);
		// If right subtree is already unbalanced, the entire tree is also unbalanced, propagate -1 up
		if (rightHeight == -1) {
			return -1;
		}
		
		// Check balance of current node
		// If height difference is > 1, return -1 (unbalanced)
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		// else balanced. return the actual height of this node
		else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		BalancedBinaryTree myObj = new BalancedBinaryTree();
		
		// balanced tree
		//        3
		//       / \
		//      9  20
		//        /  \
		//       15   7
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println("Example 1: " + myObj.isBalanced(root)); // Expected: true
		
		// skewed tree
		//       1
		//      /
		//     2
		//    /
		//   3
		TreeNode unbalancedRoot = new TreeNode(1);
		unbalancedRoot.left = new TreeNode(2);
		unbalancedRoot.left.left = new TreeNode(3);
		
		System.out.println("Example 2: " + myObj.isBalanced(unbalancedRoot)); // Expected: false
	}
}