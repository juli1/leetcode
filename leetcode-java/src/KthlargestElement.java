/*
 *  5. Kth Largest Element
 *
 * Find K-th largest element in an array.
 * 
 * You can swap elements in the array
 * 
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 * 
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 * 
 * Lintcode: http://lintcode.com/en/problem/kth-largest-element/
 */

import java.util.Arrays;

public class KthlargestElement {
    public int kthLargestElement(int k, int[] nums) {
        if(k > nums.length)
        {
        	return 0;
        }
        Arrays.sort(nums);
        
        return nums[nums.length-k];
    }
    
    
	public static void main(String[] args) {
		KthlargestElement sol = new KthlargestElement();
		int[] nums = new int[] {9,3,2,4,8};
		System.out.println(sol.kthLargestElement(3, nums));
		nums = new int[] {1,2,3,4,5};
		System.out.println(sol.kthLargestElement(1, nums));
	}

}
