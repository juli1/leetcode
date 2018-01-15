import java.util.*;

/*
 *  18. Subsets II
 *
 * Given a list of numbers that may has duplicate 
 * numbers, return all possible subsets
 * 
 * Lintcode: http://lintcode.com/en/problem/subsets-ii/
 */
public class SubsetsII {
	
	public void helper(int[] nums, boolean[] used, int pos, Stack<Integer> stack, List<List<Integer>> result)
	{
		result.add(new ArrayList<Integer>(stack));
		
		for (int i = pos ; i < nums.length ; i++)
		{
			if (!used[pos])
			{
				if (i>0 && nums[i]==nums[i-1] && ! used[i-1])
				{
					continue;
				}
				stack.push(nums[i]);
				used[i] = true;
				helper(nums, used, i+1, stack, result);
				stack.pop();
				used[i] = false;
			}
		}
	}
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        helper(nums, used, 0, new Stack<Integer>(), result);
        
        return result;
    }
    
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,2};
		SubsetsII sol = new SubsetsII();
		System.out.println(sol.subsetsWithDup(nums));
	}

}
