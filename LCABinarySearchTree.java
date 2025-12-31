public class LCABinarySearchTree {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	/**
	 * Time Complexity: O(H) - `H` -> Height if tree is balanced. `N` in worst case if tree skewed.
	 * Space Complexity: O(1) - using `while` loop, no call stack required. If recursion used, then avg:O(H)/worst:O(N)
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode currNode = root;
		
		// As long as `p` and `q` both are lesser or greater than `currNode`, we traverse left or right respectively
		// As soon as BOTH of them part their way (OR) we find one of the targets and the other one parts its way left/right
		// this is the LCA.
		
		while (currNode != null) {
			if (p.val > currNode.val && q.val > currNode.val) {
				currNode = currNode.right;
			} else if (p.val < currNode.val && q.val < currNode.val) {
				currNode = currNode.left;
			}
			// they part their way here, this is the LCA
			else {
				return currNode;
			}
		}
		
		// at this point, we have reached at a dead end and couldn't find `p` or `q`
		return null;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		//        6
		//       /  \
		//      2    8
		//     / \  / \
		//    0  4  7  9
		//      / \
		//     3   5
		
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		LCABinarySearchTree myObj = new LCABinarySearchTree();
		
		// LCA of 2 and 8: 6
		TreeNode res1 = myObj.lowestCommonAncestor(root, root.left, root.right);
		System.out.println("LCA of 2 and 8: " + res1.val);
		
		// LCA of 2 and 4: 2
		TreeNode res2 = myObj.lowestCommonAncestor(root, root.left, root.left.right);
		System.out.println("LCA of 2 and 4: " + res2.val);
	}
}