/*
 *  57. 3Sum
 *
 * Given an array S of n integers, are there elements 
 * a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * Lintcode: http://lintcode.com/en/problem/3sum/
 */
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
    	Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numbers.length < 3)
        {
        	return result;
        }
        
        for (int i = 0 ; i < numbers.length - 2 ; i++)
        {
        	int j = i + 1;
        	int k = numbers.length - 1;
        	int sum = numbers[i] + numbers[j] + numbers[k];
        	while (j<k)
        	{
        		if (sum == 0)
        		{
        			List<Integer> r = new ArrayList<Integer>();
        			r.add(numbers[i]);
        			r.add(numbers[j]);
        			r.add(numbers[k]);
        			if(!result.contains(r))
        			{
        				result.add(r);
        			}
        		}
        		if (sum < 0)
        		{
        			sum = sum - numbers[j];
        			j++;
        			sum = sum + numbers[j];
        			continue;
        		}
        		else
        		{
        			sum = sum - numbers[k];
        			k--;
        			sum = sum + numbers[k];
        			continue;
        		}
        	}
        	
        }
        return result;
    }
	public static void main(String[] args) {
		ThreeSum sol = new ThreeSum();
		int[] arr = new int[] {-1,0,1,2,-1,-4};
		List<List<Integer>> result = sol.threeSum(arr);
		System.out.println(result);

	}

}
