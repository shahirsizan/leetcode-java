// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

public class KthSmallestBST {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	private int k;
	private int result;
	private boolean found;
	
	public KthSmallestBST(int k, int result, boolean found) {
		this.k = k;
		this.result = result;
		this.found = found;
	}
	
	
	/**
	 * Time Complexity: O(N) - Might have to traverse all 'N' nodes
	 * Space Complexity: O(H) - Average recursion stack depth. Might become `N` if tree is skewed.
	 */
	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		// We'll do `in-order` traversal. It will by default give us sorted list.
		// The very end of the left-recursion points at the `1st` smallest element.
		// We'll reduce `count` upto `k` times to get to the `kth` call stack which will contain `kth` smallest element
		inOrderTraverse(root);
		return this.result;
	}
	
	private void inOrderTraverse(TreeNode node) {
		if (node == null) {
			return;
		}
		
		if (this.found) {
			return;
		}
		
		// ↙️ traverse left
		inOrderTraverse(node.left);
		
		// 🎯 process current node
		this.k--;
		if (this.k == 0) {
			this.result = node.val;
			this.found = true;
			return;
		}
		
		// ↘️ traverse right
		inOrderTraverse(node.right);
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		
		//        3
		//       / \
		//      1   4
		//     / \   \
		//    0   2  125
		//   /
		// -125
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.right.right = new TreeNode(125);
		root.left.left.left = new TreeNode(-125);
		
		int k = 1;
		KthSmallestBST myObj = new KthSmallestBST(k, -1, false);
		
		if (k < 1) {
			System.out.println("k must be greater than 0");
		}
		int result = myObj.kthSmallest(root, k);
		if (!myObj.found) {
			System.out.println("The " + k + "th smallest element not found!");
		} else {
			System.out.println("The " + k + "th smallest element: " + myObj.kthSmallest(root, k));
		}
		
	}
}