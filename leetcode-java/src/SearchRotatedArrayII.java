import java.util.Arrays;

/*
 *  63. Search in Rotated Sorted Array II
 *
 * Follow up for Search in Rotated Sorted Array:
 * 
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 * Write a function to determine if a given target is in the array.
 * Lintcode: http://lintcode.com/en/problem/search-in-rotated-sorted-array-ii/
 */
public class SearchRotatedArrayII {
	public boolean helper(int[] array, int target, int start, int end) {
		if (end - start  == 1)
		{
			if( (array[start] == target) || (array[end] == target))
			{
				return true;
			}
			return false;
		}
		int mid = start + ((end - start) / 2);
		
		if (array[mid] == target)
		{
			return true;
		}
		if (array[start] == target)
		{
			return true;
		}
		if (array[end] == target)
		{
			return true;
		}
		
		if (array[start] < array[mid])
		{
			if (array[start] <= target && target <= array[mid])
			{
				return helper(array, target, start, mid);
			}
			else
			{
				return helper(array, target, mid, end);
			}
			
		}
		else if (array[start] > array[mid])
		{
			if (array[mid] < target && target < array[end])
			{
				return helper(array, target, mid, end);
			}
			else
			{
				return helper(array, target, start, mid);
			}
		}
		else
		{
			return helper(array, target, start + 1, end);
		}
		
	}
    public boolean search(int[] A, int target) {
    	if (A.length == 0)
    	{
    		return false;
    	}
        return helper (A, target, 0, A.length - 1);
    }
	public static void main(String[] args) {
		SearchRotatedArrayII sol = new SearchRotatedArrayII();
		
		int[] nums;
		
//		nums = new int[] {1, 1, 0, 1, 1, 1};
//		
//		System.out.println(sol.search(nums, 0));
//		
//		nums = new int[] {1, 1, 1, 1, 1, 1};
//
//		System.out.println(sol.search(nums, 0));
		
		nums = new int[] {4,4,4,5,1,4};
		System.out.println(sol.search(nums, 5));
	}

}
