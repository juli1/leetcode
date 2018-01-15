import java.util.Arrays;

/*
 *  31. Partition Array
 *
 * Given an array nums of integers and an int k, partition the array 
 * (i.e move the elements in "nums") such that:
 *
 *   All elements < k are moved to the left
 *   All elements >= k are moved to the right
 *
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 * 
 * You should do really partition in array nums instead of just 
 * counting the numbers of integers smaller than k.
 * 
 * If all elements in nums are smaller than k, then return nums.length
 *
 * Example
 * 
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 *
 * Lintcode: http://lintcode.com/en/problem/partition-array/
 */
public class PartitionArray {
    public int partitionArray(int[] nums, int k) {
    	int left = 0;
    	int right = nums.length - 1;
    	if (nums.length == 0)
    	{
    		return 0;
    	}
    	while (left < right)
    	{
    		while(right > 0 && nums[right] >= k)
    		{
    			right--;
    		}
    		
    		while (left < nums.length && nums[left] < k)
    		{
    			left++;
    		}
    		if (right < left)
    		{
    			break;
    		}
    		
    		int tmp = nums[right];
    		nums[right] = nums[left];
    		nums[left] = tmp;
    	}
    	left = 0;
    	while (left < nums.length && nums[left] < k)
    	{
    		left++;
    	}
    	return left;
    }
	public static void main(String[] args) {
		int nums[] = new int[] {3,2,2,1};
		PartitionArray sol = new PartitionArray();
		System.out.println(sol.partitionArray(nums, 2));
		System.out.println(Arrays.toString(nums));
		nums = new int[] {7,7,9,8,6,6,8,7,9,8,6,6};
		System.out.println(sol.partitionArray(nums, 10));
		System.out.println(Arrays.toString(nums));

	}

}
