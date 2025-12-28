public class BinaryTreeDiameter {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	private int maxDiameter = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		calculateHeight(root);
		return maxDiameter;
	}
	
	private int calculateHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		// Recursively find the leftHeight and rightHeight of each of the subtrees.
		// This problem is kind of similar to finding height of a tree
		// but in this case, we have to do extra task:
		// `(leftHeight+rightHeight)` before sending back the `max(leftHeight,rightHeight)`
		int leftHeight = calculateHeight(node.left);
		int rightHeight = calculateHeight(node.right);
		
		maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
		
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		// example tree:
		//        1
		//       / \
		//      2   3
		//     / \
		//    4   5
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		BinaryTreeDiameter myObj = new BinaryTreeDiameter();
		int result = myObj.diameterOfBinaryTree(root);
		
		System.out.println("The diameter of the binary tree is: " + result);
		// Path: 4 -> 2 -> 5 (Length 2) or 4 -> 2 -> 1 -> 3 (Length 3)
		// Note: Length is often defined as number of edges.
	}
}