import java.util.*;

/*
 *  61. Search for a Range
 *
 * Given a sorted array of n integers, 
 * find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * Example
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * Lintcode: http://lintcode.com/en/problem/search-for-a-range/
 */

public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[] { -1, -1};
        
        if (A.length == 0)
        {
        	return result;
        }
        
        
    	
    	int start = 0;
        int end = A.length;
        int pos = -1;
        while (start < end)
        {
        	if (end - start == 1)
        	{
        		if (A[start] == target)
        		{
        			pos = start;
        			break;
        			
        		}
        		if (A[end - 1] == target)
        		{
        			pos = end - 1;
        			break;
        			
        		}
        		break;
        	}
        	int mid = start + (end-start) / 2;
        	if (A[mid] == target)
        	{
        		pos = mid;
        		break;
        	}
        	if (A[mid] < target)
        	{
        		start = mid;
        	}
        	else
        	{
        		end = mid;
        	}
        }
        
        if (pos == -1)
        {
        	return result;
        }
        
        start = end = pos;
        while (start >= 0 && A[start] == target)
        {
        	start--;
        }
        while (end <=A.length - 1 && A[end] == target)
        {
        	end++;
        }
        if (end == A.length)
        {
        	end--;
        }
        if(start < 0)
        {
        	start++;
        }
        if (A[end] != target)
        	end--;
        if (A[start] != target)
        	start++;
        
        result[0] = start;
        result[1] = end;
        return result;
    }
    
	public static void main(String[] args) {
		SearchRange sol = new SearchRange();
		int[] nums = new int[] {5, 7, 7, 8, 8, 10};
		int[] res = sol.searchRange(nums, 8);
		System.out.println(Arrays.toString(res));
		
		nums = new int[] {1,3,5,6,8,9};
		res = sol.searchRange(nums,7);
		System.out.println(Arrays.toString(res));
		
		nums = new int[] {1};
		res = sol.searchRange(nums,1);
		System.out.println(Arrays.toString(res));
	}

}
