// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/

public class InsertBST {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * Time Complexity: O(H) - Generally `H`. May become `N` in worst case if tree is skewed.
	 * Space Complexity: O(H) - Recursion stack depth. Generally `H`. May become `N` in worst case if tree is skewed.
	 */
	public TreeNode insertIntoBST(TreeNode currNode, int val) {
		// base case: we found a null spot, insert here.
		if (currNode == null) {
			TreeNode newNode = new TreeNode(val);
			return newNode;
		}
		
		if (val > currNode.val) {
			currNode.right = insertIntoBST(currNode.right, val);
		} else {
			currNode.left = insertIntoBST(currNode.left, val);
		}
		
		// after recursion finishes, backtracking will take place.
		// After backtracking, at the root call stack, this `currNode` will represent the `root`.
		return currNode;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		
		//        4
		//       / \
		//      2   7
		//     / \
		//    1   3
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		InsertBST myObj = new InsertBST();
		TreeNode updatedRoot = myObj.insertIntoBST(root, 5);
		return;
	}
}