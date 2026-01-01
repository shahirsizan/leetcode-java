// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPostorderInorderTraversal {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	private int[] postorderListGlobal;
	private int postorderIndexGlobal;
	private Map<Integer, Integer> inorderIndexMap;
	
	public TreeNode buildTree(int[] inorderList, int[] postorderList) {
		postorderIndexGlobal = postorderList.length - 1;
		postorderListGlobal = postorderList;
		inorderIndexMap = new HashMap<>();
		
		// Fillup the hashmap with <value,index> from `inorderList` as <key,value> pairs
		for (int i = 0; i < inorderList.length; i++) {
			inorderIndexMap.put(inorderList[i], i);
		}
		
		return buildTreeHelper(0, inorderList.length - 1);
	}
	
	private TreeNode buildTreeHelper(int left, int right) {
		// Base case
		if (left > right) {
			return null;
		}
		
		// Just draw the tree and plot the recursive calls, you'll understand. It's easy.
		int currentRootValue = postorderListGlobal[postorderIndexGlobal];
		TreeNode root = new TreeNode(currentRootValue);
		postorderIndexGlobal--;
		
		// divide the `inorder` traversal lists current window
		int mid = inorderIndexMap.get(currentRootValue);
		
		// Important: `postorderIndexGlobal` is global variable. So for each of the iterations, it will decrease.
		// After backtracking, we'll still get the latest value.
		root.right = buildTreeHelper(mid + 1, right);
		root.left = buildTreeHelper(left, mid - 1);
		
		return root;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		BinaryTreeFromPostorderInorderTraversal myObj = new BinaryTreeFromPostorderInorderTraversal();
		
		int[] postorder = {2, 3, 1};
		int[] inorder = {2, 1, 3};
		
		TreeNode root = myObj.buildTree(inorder, postorder);
		System.out.println("Root value: " + root.val); // Should be 1
		System.out.println("Root.left: " + root.left.val); // Should be 2
		System.out.println("Root.right: " + root.right.val); // Should be 3
	}
}