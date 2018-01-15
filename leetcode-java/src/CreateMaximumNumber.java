import java.util.Arrays;

/*
 * Create Maximum Number
 * 
 * Given two arrays of length m and n with digits 0-9
 * representing two numbers.
 * Create the maximum number of length k <= m + n from
 * digits of the two. The relative order of the digits
 * from the same array must be preserved. Return an
 * array of the k digits.
 * You should try to optimize your time and space complexity.
 * 
 * WARNING: too slow!
 * 
 */
public class CreateMaximumNumber {
	int max = 0;
	int[] finalresult;
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	max = 0;
    	
    	finalresult = new int[k];
        helper(nums1, nums2, 0, 0, 0, 0, k);
        int i = 0;
        while (max > 0)
        {
        	finalresult[k-1-i] = max %10;
        	max = max / 10;
        	i++;
        }
        return finalresult;
    }
    public void helper(int[] nums1, int[] nums2, int nums1idx, int nums2idx, int maxsofar, int step, int maxstep)
    {
    	if (((nums1.length - nums1idx) + (nums2.length - nums2idx)) < maxstep  - step)
    	{
    		return;
    	}
    	if (step == maxstep)
    	{
    		max = Math.max(maxsofar, max);
    		return;
    	}
    	for (int i = nums1idx; i<nums1.length ; i++)
    	{
    		helper(nums1, nums2, i + 1, nums2idx, maxsofar*10 + nums1[i], step + 1, maxstep);
    	}
    	for (int i = nums2idx; i<nums2.length ; i++)
    	{
    		helper(nums1, nums2, nums1idx , i + 1, maxsofar*10 + nums2[i], step + 1, maxstep);
    	}
    }
	
	public static void main(String[] args) {
		CreateMaximumNumber sol = new CreateMaximumNumber();
		int[] n1 = new int[] {3,4,6,5};
		int[] n2 = new int[] {9,1,2,5,8,3};
		int[] res = sol.maxNumber(n1, n2, 5);
		for (int i = 0 ; i < res.length ; i++)
		{
			System.out.print(res[i]);
		}
		System.out.println("\ndone ; max="+ sol.max);
	}

}
