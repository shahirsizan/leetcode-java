public class LowestCommonAncestorBinaryTree {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int x) {
			val = x;
		}
	}
	
	/**
	 * Time Complexity: O(N) - We visit every node once.
	 * Average Space Complexity: O(H) - Recursion stack depth, generally the height of the tree.
	 * Worst Space Complexity: O(N) - For skewed tree, recursion stack depth will be equal to N.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/**
		 * Special case: `p=7` and `q=8`; `q` is below somewhere in the subtree rooted at `p`.
		 * The recursion eventually reaches `p`.
		 * The function returns value of `p` to its parent immediately as it is one of the targets.
		 * The code never reaches to `q`.
		 * Problem constraints state that `p and q will exist in the tree`.
		 * So if we can't find the other target `q` in other branches, then we can assume that
		 * `q` is situated down inside the subtree rooted at `p`, so `p` is logically the LCA.
		 * */
		
		// base case: we reached the dead end
		if (root == null) {
			return null;
		}
		
		// base case: we found a `target`
		if (root == p || root == q) {
			return root;
		}
		
		// 👇 non-null AND also not target, traverse down 👇
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		// if both null, return null
		if (left == null && right == null) {
			return null;
		}
		
		// If both non-null, means we got to the common node for both the targets. This is the LCA
		if (left != null && right != null) {
			return root;
		}
		
		// one is null, other is non-null, return whichever is non-null
		return (left != null) ? left : right;
	}
	
	// ✅ main() method ✅
	public static void main(String[] args) {
		// Constructing the tree:
		//        3
		//       / \
		//      5   1
		//     / \ / \
		//    6  2 0  8
		//      / \
		//     7   4
		
		TreeNode root = new TreeNode(3);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		
		root.left = p;
		root.right = q;
		root.left.left = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		root.left.right = node2;
		node2.left = new TreeNode(7);
		node2.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		LowestCommonAncestorBinaryTree myObj = new LowestCommonAncestorBinaryTree();
		
		// Example 1: LCA of 5 and 1 is 3
		TreeNode result1 = myObj.lowestCommonAncestor(root, p, q);
		System.out.println("LCA of 5 and 1: " + result1.val);
		
		// Example 2: LCA of 5 and 4 is 5 (node can be ancestor of itself)
		TreeNode target4 = node2.right;
		TreeNode result2 = myObj.lowestCommonAncestor(root, p, target4);
		System.out.println("LCA of 5 and 4: " + result2.val);
	}
}