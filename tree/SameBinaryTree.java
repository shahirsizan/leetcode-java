// https://leetcode.com/problems/same-tree/description/

package tree;

public class SameBinaryTree {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * Time Complexity: O(N); N -> number of nodes. We'll process each node only once.
	 * Average Space Complexity: O(H); H -> height of the tree (recursion stack).
	 * Worst Space Complexity: O(N); If skewed tree, then we'll need N recursion stacks
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		// if both of them null, return true
		if (p == null && q == null) {
			return true;
		}
		
		// if only one of them null, return false
		if (p == null || q == null) {
			return false;
		}
		
		// if values don't match,
		if (p.val != q.val) {
			return false;
		}
		
		// at this point, they are `non-null` AND values are `equal`
		
		// check left and right subtrees
		boolean leftSame = isSameTree(p.left, q.left);
		boolean rightSame = isSameTree(p.right, q.right);
		
		if (leftSame == true && rightSame == true) {
			return true;
		} else {
			return false;
		}
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		SameBinaryTree myObj = new SameBinaryTree();
		
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.right.right = new TreeNode(4);
		
		TreeNode t2 = new TreeNode(1);
		t2.left = new TreeNode(2);
		t2.right = new TreeNode(3);
		t2.right.right = new TreeNode(4);
		
		TreeNode t3 = new TreeNode(1);
		t3.left = new TreeNode(2);
		
		System.out.println("Are t1 and t2 the same? " + myObj.isSameTree(t1, t2)); // true
		System.out.println("Are t1 and t3 the same? " + myObj.isSameTree(t1, t3)); // false
	}
}