/*
 *  95. Validate Binary Search Tree
 *  
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 *   The left subtree of a node contains only nodes with keys less than the node's key.
 *   The right subtree of a node contains only nodes with keys greater than the node's key.
 *   Both the left and right subtrees must also be binary search trees.
 *   A single node tree is a BST
 * 
 * Lintcode: http://lintcode.com/en/problem/validate-binary-search-tree/
 *
 */

public class ValidateBinarySearchTree {
	
	public boolean validateNode(TreeNode node, long min, long max)
	{
		if (node == null)
			return true;
		
		if (node.val <= min || node.val >= max)
			return false;
		
		return validateNode(node.left, min, node.val) &&
				validateNode(node.right, node.val, max);
	}
	
    public boolean isValidBST(TreeNode root) {
    	return validateNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		ValidateBinarySearchTree sol = new ValidateBinarySearchTree();
		System.out.println(sol.isValidBST(root));
		
		root = new TreeNode(-1);
		System.out.println(sol.isValidBST(root));
		
 	}

}
