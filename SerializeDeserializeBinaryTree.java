// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
	
	static class TreeNode {
		int val;
		TreeNode left, right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}
	
	private void serializeHelper(TreeNode root, StringBuilder sb) {
		// base case 1: current node is null. Append `#` to string
		if (root == null) {
			sb.append("#,");
			return;
		}
		
		// base case 2: current node has a value. Append `value` to string
		sb.append(root.val).append(",");
		
		// other cases: recursive pre-order traversal: Root -> Left -> Right
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}
	
	public TreeNode deserialize(String serializedString) {
		/**
		 * In Java, Deque is an interface. To work with deque, you must use one of its implementation classes.
		 * The two most common implementations: `ArrayDeque` and `LinkedList`.
		 * We'll use LinkedList because we need to store `null` elements (which ArrayDeque does not allow)
		 * */
		
		// serializedString -> "1,2,#,#,3,4,6,#,#,7,#,#,5,#,#"
		String[] serializedWordsList = serializedString.split(",");
		Queue<String> ourLinkedList = new LinkedList<>(Arrays.asList(serializedWordsList));
		return deserializeHelper(ourLinkedList);
	}
	
	private TreeNode deserializeHelper(Queue<String> ourLinkedList) {
		/** serializedString: "1,2,#,#,3,4,6,#,#,7,#,#,5,#,#"
		 Tree to be constructed:
		 *        1
		 *      /  \
		 *    2     3
		 *         / \
		 *        4   5
		 *       / \
		 *      6   7
		 * */
		
		String currentVal = ourLinkedList.poll();
		
		if (currentVal.equals("#")) {
			return null;
		}
		
		// just draw the tree and you'll understand the execution flow. It's easy.
		
		TreeNode node = new TreeNode(Integer.parseInt(currentVal));
		// recursively reconstruct the tree following pre-order sequence
		node.left = deserializeHelper(ourLinkedList);
		node.right = deserializeHelper(ourLinkedList);
		return node;
	}
	
	// ✅ main() ✅
	public static void main(String[] args) {
		SerializeDeserializeBinaryTree myObj = new SerializeDeserializeBinaryTree();
		
		/**
		 *        1
		 *      /  \
		 *    2     3
		 *         / \
		 *        4   5
		 *       / \
		 *      6   7
		 * */
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		
		// serialize
		String serializedString = myObj.serialize(root);
		System.out.println("Serialized String: " + serializedString);
		// output -> "1,2,#,#,3,4,6,#,#,7,#,#,5,#,#"
		
		// deserialize. Input -> "1,2,#,#,3,4,6,#,#,7,#,#,5,#,#"
		TreeNode deserializedRoot = myObj.deserialize(serializedString);
		System.out.println("Deserialized Root: " + deserializedRoot.val);
	}
}