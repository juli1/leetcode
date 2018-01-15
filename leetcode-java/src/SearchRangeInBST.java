/*
 *  11. Search Range in Binary Search Tree
 *
 * Given two values k1 and k2 (where k1 < k2) and a
 * root pointer to a Binary Search Tree. Find all the 
 * keys of tree in range k1 to k2. i.e. print all x 
 * such that k1<=x<=k2 and x is a key of given BST. 
 * Return all the keys in ascending order.
 * 
 * Lintcode: http://lintcode.com/en/problem/search-range-in-binary-search-tree/
 * 
 */

import java.util.*;

public class SearchRangeInBST {
	
	public void findInRange(TreeNode root, int min, int max, List<Integer> result)
	{
		if (root == null)
		{
			return;
		}
		findInRange(root.left, min, max, result);
		
		if (root.val >= min && root.val <= max)
		{
			result.add(root.val);
		
		}
		
		findInRange(root.right, min, max, result);
		
	}
	
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<Integer>();
        
        findInRange(root, k1, k2, result);
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
