// https://leetcode.com/problems/symmetric-tree/description/

package tree;

public class SymmetricTree {
	
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
	public boolean isSymmetric(TreeNode root) {
		// number of nodes in the tree will be in the range [1, 1000]
		// so no need to check for null root
		
		return isSymmetricHelper(root.left, root.right);
	}
	
	private boolean isSymmetricHelper(TreeNode leftChild, TreeNode rightChild) {
		// base case 1
		if (leftChild == null && rightChild == null) {
			return true;
		}
		
		// base case 2
		if (leftChild == null || rightChild == null || leftChild.val != rightChild.val) {
			return false;
		}
		
		// the left-right childs are same, time to recursively check their left-right child combinations
		boolean isSymmetric = isSymmetricHelper(leftChild.left, rightChild.right) && isSymmetricHelper(leftChild.right, rightChild.left);
		return isSymmetric;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		SymmetricTree myObj = new SymmetricTree();
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(4);
		root1.right.left = new TreeNode(4);
		root1.right.right = new TreeNode(3);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(2);
		root2.left.right = new TreeNode(3);
		root2.right.right = new TreeNode(3);
		
		System.out.println("Tree 1 result: " + myObj.isSymmetric(root1)); // true
		System.out.println("Tree 2 result: " + myObj.isSymmetric(root2)); // false
	}
}