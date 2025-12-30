public class SearchBST {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * Time Complexity: O(H) - `H` is height of the tree. `H` may become `N` in worst case if tree is skewed.
	 * Space Complexity: O(H) - recursion stack depth. `H` may become `N` in worst case if tree is skewed.
	 */
	public TreeNode searchBST(TreeNode currentNode, int targetVal) {
		// base case 1: currentNode `null`, we won't find `targetVal` ever. Search terminates here.
		if (currentNode == null) {
			return null;
		}
		
		// base case 2: `targetVal` found, return it.
		if (currentNode.val == targetVal) {
			return currentNode;
		}
		
		// other cases: traverse left/right
		if (targetVal < currentNode.val) {
			return searchBST(currentNode.left, targetVal);
		} else {
			return searchBST(currentNode.right, targetVal);
			
		}
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
		
		SearchBST myObj = new SearchBST();
		TreeNode result = myObj.searchBST(root, 2);
		
		if (result != null) {
			System.out.println("Found: " + result.val);
		} else {
			System.out.println("Not found.");
		}
	}
}