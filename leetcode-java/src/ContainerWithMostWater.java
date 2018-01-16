package leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
    		int start = 0;
    		int end = height.length - 1;
    		int quantity = 0;
    		while (start < end)
    		{
    			quantity = Math.max(quantity, (end - start) * Math.min(height[start], height[end]));
    			if (height[start] < height[end])
    			{
    				start++;
    			}
    			else
    			{
    				end--;
    			}
    		}
    		
    		return quantity;
    }
	
	
	public static void main(String[] args) {
		ContainerWithMostWater sol = new ContainerWithMostWater();
		int[] array = new int[] {2,3,4,5,18,17,6};
		System.out.println(sol.maxArea(array));
	}

}
