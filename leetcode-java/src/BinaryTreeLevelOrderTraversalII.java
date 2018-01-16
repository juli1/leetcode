/*
 *  70. Binary Tree Level Order Traversal II
 *
 * Given a binary tree, return the bottom-up level order traversal
 * of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * Lintcode: http://lintcode.com/en/problem/binary-tree-level-order-traversal-ii/
 */

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
	
	public void helper(TreeNode node, List<List<Integer>> result, int level)
	{
		if (node == null)
		{
			return;
		}
		while (result.size() < level)
		{
			result.add(new ArrayList<Integer>());
		}
		
		List<Integer> current = result.get(level - 1);
		helper(node.left, result, level+1);
		current.add(node.val);
		helper(node.right, result, level+1);
	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(root, result, 1);
        Collections.reverse(result);
        return result;
    }
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII sol = new BinaryTreeLevelOrderTraversalII();
		TreeNode tn = new TreeNode(3);
		tn.left = new TreeNode(9);
		tn.right = new TreeNode(20);
		tn.right.left = new TreeNode(15);
		tn.right.right = new TreeNode(7);
		List<List<Integer>> res = sol.levelOrderBottom(tn);
		System.out.println(res);
	}

}
