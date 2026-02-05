package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeBFS {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	// Level Order Traversal using while + for
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			// Capture the number of nodes at the current level
			int levelSize = queue.size();
			List<Integer> currentLevelNodes = new ArrayList<>();
			
			// The 'for' loop processes exactly one level
			for (int i = 0; i < levelSize; i++) {
				TreeNode curr = queue.poll();
				currentLevelNodes.add(curr.val);
				
				// Add children to the queue for the NEXT level
				if (curr.left != null) queue.add(curr.left);
				if (curr.right != null) queue.add(curr.right);
			}
			
			// Add the completed level to our final result
			result.add(currentLevelNodes);
		}
		return result;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		BinaryTreeBFS solver = new BinaryTreeBFS();
		
		// Constructing the following tree:
		//        1
		//       / \
		//      2   3
		//     / \   \
		//    4   5   6
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		System.out.println("BFS Level Order Traversal (while + for):");
		List<List<Integer>> levels = solver.levelOrder(root);
		
		for (int i = 0; i < levels.size(); i++) {
			System.out.println("Level " + i + ": " + levels.get(i));
		}
	}
}