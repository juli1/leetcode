import java.util.*;
/*
 * Given a string that contains only digits 0-9 and a target value, 
 * return all possibilities to add binary operators (not unary) +,
 *  -, or * between the digits so they evaluate to the target value. 
 * 
 * Leetcode: https://leetcode.com/problems/expression-add-operators/description/
 * Lintcode: http://lintcode.com/en/problem/add-operators/
 */
public class AddOperators {
    public void helper(List<Long> numbers, int idx, int target, long sum, long previous, boolean mult, String current, List<String> result)
    {
    	
    	if (idx >= numbers.size())
    	{
    		if(sum == target)
    		{
    			result.add(current);
    		}
    		return;
    	}
    	
    	long number = numbers.get(idx);
    	helper(numbers, idx+1, target, sum + number, number, false, current+"+" + number, result);
    	helper(numbers, idx+1, target, sum - number, (-1) * number, false, current+"-" + number, result);
    	if (idx == 1)
    	{
    		helper(numbers, idx+1, target, sum * number, sum * number, true, current+"*" + number, result);
    	}
    	else
    	{
    		if (mult)
    		{
    			helper(numbers, idx+1, target, sum - previous + previous * number, number * previous, true, current+"*" + number, result);
    		}
    		else
    		{
    			helper(numbers, idx+1, target, sum - previous + previous * number, number * previous, true, current+"*" + number, result);	
    		}
    		
    	}	
    }
    
    public void generateCombinations(String nums, Stack<Long> stack, List<List<Long>> allCombinations)
    {
    	if (nums.length() == 0)
    	{
    		allCombinations.add(new ArrayList<Long>(stack));
    		return;
    	}
    	for (int i = 1 ; i <= nums.length() ; i++)
    	{
    		if (nums.charAt(0) == '0' && i > 1)
    		{
    			return;
    		}
    		stack.push(Long.parseLong(nums.substring(0, i)));
    		
    		
    		generateCombinations(nums.substring(i), stack, allCombinations);
    		stack.pop();
    	}
    }
	
    
    // Here, for each list of numbers, we find the output that sums to our target
	public List<String> addOperators(String nums, int target) {
        List<String> result = new ArrayList<String>();
        List<List<Long>> allCombinations = new ArrayList<List<Long>>();
        
        generateCombinations(nums, new Stack<Long>(), allCombinations);
        System.out.println(allCombinations);
        for (List<Long> numbers : allCombinations)
        {
        	if (numbers.size() > 0)
        	{
        		helper(numbers, 1, target, numbers.get(0), 1, false, "" + numbers.get(0), result);	
        	}
        		
        }
        return result;
    }
    
    
    
    
	public static void main(String[] args) {
		AddOperators ao = new AddOperators();
		String s = "123"; 
				
				
		int n = 6;
		System.out.println(ao.addOperators(s, n));

	}

}
