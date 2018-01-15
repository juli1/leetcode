/*
 *  41. Maximum Subarray
 * Given an array of integers, find a contiguous
 * subarray which has the largest sum.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
        {
            return nums[0];
        }
        int max = nums[0];
        int maxSofar = nums[0];
        for (int i = 1 ; i < nums.length ; i++)
        {
            maxSofar = Math.max(maxSofar+nums[i], nums[i]);
            max = Math.max(max, maxSofar);
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
