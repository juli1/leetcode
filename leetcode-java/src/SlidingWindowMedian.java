
import java.util.*;

public class SlidingWindowMedian {
	public int getMedian(int[] arr)
	{
		Arrays.sort(arr);
		int res = 0;
		if (arr.length % 2 == 0)
		{
			res = arr[arr.length / 2 - 1];
		}
		else
		{
			res = arr[arr.length / 2];
		}
		return res;
	}
	
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        int[] arr = new int[k];
        int pos;
        
        for (pos = 0 ; pos < k ; pos++)
        {
        		arr[pos] = nums[pos];
        }
        while (pos < nums.length)
        {
        		result.add(getMedian(arr));
        		for (int i = 0 ; i < k - 1; i++)
        		{
        			arr[i] = arr[i+1];
        		}
        		arr[k-1] = nums[pos];
        		pos++;
        }
        result.add(getMedian(arr));
        return result;
        
    }
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,7,8,5};
		SlidingWindowMedian sol = new SlidingWindowMedian();
		System.out.println(sol.medianSlidingWindow(arr, 3));

	}

}
