// https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=26

package tree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public List<Integer> findPath(TreeNode root, int target) {
		if (root == null) {
			return new ArrayList<>();
		}
		
		List<Integer> answerPath = new ArrayList<>();
		findPathRecursive(root, target, answerPath);
		return answerPath;
	}
	
	private boolean findPathRecursive(TreeNode curr, int target, List<Integer> answerPath) {
		if (curr == null) {
			return false;
		}
		
		answerPath.add(curr.val);
		
		if (curr.val == target) {
			return true;
		}
		
		// search in children nodes
		boolean foundInLeftSubtree = findPathRecursive(curr.left, target, answerPath);
		boolean foundInRightSubtree = findPathRecursive(curr.right, target, answerPath);
		if (foundInLeftSubtree || foundInRightSubtree) {
			// if found anywhere in subtrees, return `true` along with the `answerPath`.
			// `answerPath` does not change during returning `true`
			return true;
		}
		
		// backtrack
		answerPath.remove(answerPath.size() - 1);
		return false;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		RootToNodePath myObj = new RootToNodePath();
		
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
		
		int target = 5;
		List<Integer> result = myObj.findPath(root, target);
		System.out.println("Path to " + target + ": (Expected: [1, 2, 5]): " + result);
	}
}