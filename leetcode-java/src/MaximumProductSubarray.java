/*
 *  191. Maximum Product Subarray
 * 
 * Find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Lintcode: http://lintcode.com/en/problem/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
    	if (nums.length == 0)
    	{
    		return 0;
    	}
    	
    	if (nums.length == 1)
    	{
    		return nums[0];
    	}
    	
    	int minEndingThere = 1;
    	int maxEndingThere = 1;
    	int max = 0;
    	
    	for (int i  = 0 ; i < nums.length ; i++)
    	{
    		if (nums[i] == 0)
    		{
    			minEndingThere = 1;
    			maxEndingThere = 1;
    			continue;
    		}
    		
    		if (nums[i] < 0)
    		{
    			int t = maxEndingThere;
    			maxEndingThere = Math.max(minEndingThere * nums[i], 1);
    			minEndingThere = nums[i] * t;
    			
    			
    		}
    		else
    		{
    			minEndingThere = Math.min(1, minEndingThere * nums[i]);
    			maxEndingThere = maxEndingThere * nums[i];
    		}
    		max = Math.max(max, maxEndingThere);
    	}
    	return max;
    }
    
	public static void main(String[] args) {
		//int[] array = new int[] {2,3,-2,4};
		int[] array = new int[] {-4,-3};
		MaximumProductSubarray sol = new MaximumProductSubarray();
		System.out.println(sol.maxProduct(array));

	}

}
