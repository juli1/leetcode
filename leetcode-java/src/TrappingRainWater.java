

import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int[] maxleft = new int[height.length];
        int[] maxright = new int[height.length];
        maxleft[0] = height[0];
        maxright[height.length - 1] = height[height.length - 1];
        	for (int i = 1 ; i < height.length ; i++)
        	{
        		maxleft[i] = Math.max(maxleft[i-1], height[i]);
        	}
        	for (int i = height.length -2 ; i >=0 ; i--)
        	{
        		maxright[i] = Math.max(maxright[i+1], height[i]);
        	}
        	
        	for (int i = 0 ; i < height.length ; i++)
        	{
        		result += Math.min(maxleft[i], maxright[i]) - height[i];
        	}
        	
        	return result;
    }
    
    
	public static void main(String[] args) {
		int[] lines = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		TrappingRainWater sol = new TrappingRainWater();
		System.out.println(sol.trap(lines));

	}

}
