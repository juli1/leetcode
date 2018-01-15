/*
 * Given the root and two nodes in a Binary Tree.
 * Find the lowest common ancestor(LCA) of the two nodes.
 *
 * The lowest common ancestor is the node with largest
 * depth which is the ancestor of both nodes.
 *
 * Lintcode: http://lintcode.com/en/problem/lowest-common-ancestor/
 */
public class LowestCommonAncestor {
	public class Solution {
	    /*
	     * @param root: The root of the binary search tree.
	     * @param A: A TreeNode in a Binary.
	     * @param B: A TreeNode in a Binary.
	     * @return: Return the least common ancestor(LCA) of the two nodes.
	     */

	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
	        
	        if (root == null)
	        {
	            return null;
	        }
	        
	        if (root == A)
	        {
	            return root;
	        }
	        
	        if (root == B)
	        {
	            return root;
	        }
	        
	        TreeNode findOnLeft = lowestCommonAncestor(root.left, A, B);
	        TreeNode findOnRight = lowestCommonAncestor(root.right, A, B);
	        if(findOnLeft != null && findOnRight !=null)
	        {
	            return root;
	        }
	        
	        if(findOnLeft != null)
	        {
	            return findOnLeft;
	        }
	        if(findOnRight != null)
	        {
	            return findOnRight;
	        }
	        return null;
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
