/*
 *  56. Two Sum
 *
 * Given an array of integers, find two numbers such that they
 * add up to a specific target number.
 * The function twoSum should return indices of the two numbers
 * such that they add up to the target, where index1 must be
 * less than index2. 
 * Please note that your returned answers (both index1 and index2) are zero-based.
 *
 * Lintcode: http://lintcode.com/en/problem/two-sum/
 * 
 */


import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> numberPosition = new HashMap<Integer,Integer>();
        for (int i = 0 ; i < numbers.length ; i++)
        {
            if (numberPosition.containsKey(target - numbers[i]))
            {
                return new int[]{numberPosition.get(target-numbers[i]),i};
            }
            numberPosition.put(numbers[i], i);
        }
        return null;
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
