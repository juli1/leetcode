/*
 * Remove Node in Binary Search Tree
 *
 * Given a root of Binary Search Tree with unique value for each node. 
 * Remove the node with given value. If there is no such a node with
 * given value in the binary search tree, do nothing. 
 * You should keep the tree still a binary search tree after removal.
 * 
 * Lintcode: http://lintcode.com/en/problem/remove-node-in-binary-search-tree/
 * 
 */
public class RemoveNodeBST {
	public TreeNode removeNode(TreeNode root, int value) {
        if (root == null)
        {
            return null;
        }
        
        if(root.val == value)
        {
            if (root.left == null && root.right == null)
            {
                return null;
            }
            if (root.left == null)
            {
                return root.right;
            }
            if (root.right == null)
            {
                return root.left;
            }
            TreeNode temp = root.right;
            TreeNode prev = root;
            while(temp != null)
            {
                prev = temp;
                temp = temp.left;
            }
            root.val = prev.val;
            root.right = removeNode(root.right, root.val);
            return root;
        }
        
        if(value < root.val)
        {
            root.left = removeNode(root.left, value);
        }   
        else
        {
            root.right = removeNode(root.right, value);
        }
        return root;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
