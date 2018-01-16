

import java.util.Arrays;

public class ConstructRectangle {
    public int[] constructRectangle(int area) {
    	if (area == 1)
    	{
    		return new int[]{1,1};
    	}
        int n = (int)Math.sqrt(area);
        while(area % n !=0)
        {
        		n--;
        }
        int m = area / n;
        return n > m ? new int[] {n,m} : new int[] {m,n};
    }
	public static void main(String[] args) {
		ConstructRectangle sol = new ConstructRectangle();
		System.out.println(Arrays.toString(sol.constructRectangle(4)));

	}

}
