// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderInorderTraversal {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	private int[] preorderListGlobal;
	private int preorderIndexGlobal;
	private Map<Integer, Integer> inorderIndexMap;
	
	public TreeNode buildTree(int[] preorderList, int[] inorderList) {
		preorderIndexGlobal = 0;
		inorderIndexMap = new HashMap<>();
		preorderListGlobal = preorderList;
		
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
		int currentRootValue = preorderListGlobal[preorderIndexGlobal];
		TreeNode root = new TreeNode(currentRootValue);
		preorderIndexGlobal++;
		
		// divide the `inorder` traversal lists current window
		int mid = inorderIndexMap.get(currentRootValue);
		
		// Important: `preorderIndexGlobal` is global variable. So for each of the iterations, it will increase.
		// After backtracking, we'll still get the latest value.
		root.left = buildTreeHelper(left, mid - 1);
		root.right = buildTreeHelper(mid + 1, right);
		
		return root;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		BinaryTreeFromPreorderInorderTraversal myObj = new BinaryTreeFromPreorderInorderTraversal();
		
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		
		TreeNode root = myObj.buildTree(preorder, inorder);
		System.out.println("Root value: " + root.val); // Should be 3
		System.out.println("Root.left: " + root.left.val); // Should be 9
		System.out.println("Root.right: " + root.right.val); // Should be 20
	}
}