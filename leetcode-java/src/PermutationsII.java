
import java.util.*;

/*
 *  16. Permutations II
 *
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * 
 * Lintcode: http://lintcode.com/en/problem/permutations-ii/
 */
public class PermutationsII {
    public void helper(int[] nums, int pos, Stack<Integer> current, boolean[] used, List<List<Integer>> result)
    {
    		if(current.size() == nums.length)
    		{
    			result.add(new ArrayList<Integer>(current));
    			return;
    		}
    			
    		for (int i = 0 ; i < nums.length ; i++)
    		{
    			if (used[i])
    			{
    				continue;
    			}
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1])
            	{
            		continue;
            	}
    			used[i] = true;
    			current.push(nums[i]);
    			helper(nums, pos+1, current, used,result);
    			current.pop();
    			used[i] = false;
    		}
    }
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
    		helper(nums, 0, new Stack<Integer>(), used, result);
    		return result;
	}
    
	public static void main(String[] args) {
		int [] array = new int[] {1,2,2,2};
		PermutationsII sol = new PermutationsII();
		List<List<Integer>> result = sol.permuteUnique(array);
		System.out.println(result);

	}

}
