/*
 * 
 * Given an unsorted array nums, reorder it in-place such that
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * Lintcode: http://lintcode.com/en/problem/wiggle-sort/
 */
public class WiggleSort {
    public void swap(int[] nums, int i, int j)
    {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public void wiggleSort(int[] nums) {
      for (int i = 1; i < nums.length; i++)
      {
            if (i % 2 != 0 && nums[i] < nums[i - 1])
            {
            	swap(nums, i, i - 1);
            }
            
            if (i % 2 == 0 && nums[i] > nums[i - 1]) {
            	swap(nums, i, i - 1);
            }
        }

    }
    
	public static void main(String[] args) {
		int[] nums = new int[] {3,5,3,1,6,4};
		WiggleSort sol = new WiggleSort();
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0 ; i < nums.length ; i++)
		{
			sb.append(nums[i] + " ");
		}
		System.out.println(sb.toString());

		sol.wiggleSort(nums);
		sb = new StringBuffer();
		
		for (int i = 0 ; i < nums.length ; i++)
		{
			sb.append(nums[i] + " ");
		}
		System.out.println(sb.toString());
	}

}
