// https://leetcode.com/problems/delete-node-in-a-bst/description/

public class DeleteBST {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * Time Complexity: O(H) - `H` in average. Might become `N` in worst case if tree is skewed
	 * Space Complexity: O(H) - Average recursion stack depth. Might become `N` in worst case if tree is skewed
	 */
	public TreeNode deleteNode(TreeNode currentNode, int target) {
		// Base case 1: we arrived at a dead end, means target not found. Backtrack to root.
		if (currentNode == null) {
			return null;
		}
		
		// Base case 2: we're in non-leaf nodes, gotta traverse left/right
		if (target < currentNode.val) {
			currentNode.left = deleteNode(currentNode.left, target);
		} else if (target > currentNode.val) {
			currentNode.right = deleteNode(currentNode.right, target);
		}
		
		// Base case 3: Found target
		else {
			// Base case 3.1: target got one child only. Just link that child to targets parent.
			if (currentNode.left == null) {
				return currentNode.right;
			}
			if (currentNode.right == null) {
				return currentNode.left;
			}
			
			// Base case 3.2: target got two children. Have to modify the subtree.
			// Find the `smallest` node in `right` subtree rooted at `right` child
			TreeNode minNodeOfRightSubtree = findMin(currentNode.right);
			currentNode.val = minNodeOfRightSubtree.val;
			// Delete the node which we just copied. Farther modification of that subtree may be required.
			// so our new journey begins in the subtree rooted at `currentNode.right`
			currentNode.right = deleteNode(currentNode.right, minNodeOfRightSubtree.val);
		}
		return currentNode;
	}
	
	private TreeNode findMin(TreeNode currentNode) {
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		// found the leftmost node (smallest of the right subtree)
		return currentNode;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		
		//        15
		//       /   \
		//      5     16
		//     /  \    \
		//    1   10   7
		//       /  \
		//      9    11
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(5);
		root.right = new TreeNode(16);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(10);
		root.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(9);
		root.left.right.right = new TreeNode(11);
		
		DeleteBST myObj = new DeleteBST();
		TreeNode updatedRoot = myObj.deleteNode(root, 5);
		System.out.println("root->left: " + updatedRoot.left.val); // should be 9
	}
}