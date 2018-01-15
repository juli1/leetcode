/*
 *  94. Binary Tree Maximum Path Sum
 *
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * Lintcode: http://lintcode.com/en/problem/binary-tree-maximum-path-sum/
 */
public class BinaryTreePathSum {
	
	class ReturnType {
		int pathValue;
		int maxPath;
		
		public ReturnType (int pv, int mv)
		{
			this.pathValue = pv;
			this.maxPath = mv;
		}
	}
	
	public ReturnType helper(TreeNode node)
	{
		if(node == null)
		{
			return new ReturnType(0,Integer.MIN_VALUE);
		}
		
		ReturnType fromLeft = helper(node.left);
		ReturnType fromRight = helper(node.right);
		
		
		int maxFromLeaves = Math.max(0, Math.max(fromLeft.pathValue, fromRight.pathValue) + node.val) ;
		
		int maxCombined = Math.max(
				fromLeft.pathValue + fromRight.pathValue + node.val, Math.max(fromLeft.maxPath, fromRight.maxPath)
				);
				
		return new ReturnType(maxFromLeaves, maxCombined);
		
	}
	
    public int maxPathSum(TreeNode root) {
    	if (root == null)
    		return 0;
    	
    	ReturnType ret = helper(root);
    	return ret.maxPath;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
