public class KthLargestBST {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	private static boolean found = false;
	private static int count = 0;
	private static int result = -1;
	
	/**
	 * Time Complexity: O(N) - Might have to traverse all 'N' nodes
	 * Space Complexity: O(H) - Average recursion stack depth. Might become `N` if tree is skewed.
	 */
	public int kthLargest(TreeNode root, int k) {
		count = k;
		// We'll do `reverse-in-order` traversal. It will by default give us sorted list.
		// in reverse order. The very end of the right-recursion points at the `1st` largest element.
		// We'll reduce `count` upto `k` times to get to the `kth` call stack which will contain `kth` largest element
		reverseInorderTraverse(root);
		return result;
	}
	
	private void reverseInorderTraverse(TreeNode node) {
		if (node == null) {
			return;
		}
		
		if (found) {
			return;
		}
		
		// ↘️ traverse right
		reverseInorderTraverse(node.right);
		
		// 🎯 process current node
		count--;
		if (count == 0) {
			result = node.val;
			found = true;
			return;
		}
		
		// ↙️ traverse left
		reverseInorderTraverse(node.left);
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		// Constructing BST:
		//        5
		//       / \
		//      3   6
		//     / \
		//    2   4
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		KthLargestBST myObj = new KthLargestBST();
		int k = 2;
		System.out.println("The " + k + "th largest element: " + myObj.kthLargest(root, k));
	}
}