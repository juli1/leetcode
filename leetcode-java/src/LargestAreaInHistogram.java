
import java.util.Stack;

/*
 *  122. Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * Lintcode: http://lintcode.com/en/problem/largest-rectangle-in-histogram/#
 */

public class LargestAreaInHistogram {
	public int largestRectangleArea(int[] hist) {

		int n = hist.length;
		Stack<Integer> stack = new Stack<Integer>();
		int max_area = 0;
		int position = 0;
		while (position < n)
		{
			// the current bar is higer than the previous one
			if (stack.isEmpty() || hist[position] > hist[stack.peek()])
			{
				stack.push(position);
				position++;
			}
			else
			{
				// the current building is smaller than previous one, time to 
				// update the max building size

				int otherposition = stack.pop();
				int height = hist[otherposition];
				max_area = Math.max(max_area, height * (stack.isEmpty()?  position : position - stack.peek()-1));

			}
		}
		while(! stack.isEmpty())
		{
			int otherposition = stack.pop();
			int height = hist[otherposition];
			max_area = Math.max(max_area, height * (stack.isEmpty()?  position : position - stack.peek()-1));

		}
		return max_area;
	}

	// Driver program to test above function
	public static void main(String[] args) 
	{
		//int hist[] = {0,2,0 };
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		LargestAreaInHistogram sol = new LargestAreaInHistogram();
		System.out.println("Maximum area is " + sol.largestRectangleArea(hist));
	}

}


