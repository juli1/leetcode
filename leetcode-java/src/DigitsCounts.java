/*
 *  3. Digit Counts
 *
 * Count the number of k's between 0 and n. k can be 0 - 9.
 * if n = 12, k = 1 in
 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
 * we have FIVE 1's (1, 10, 11, 12)
 *
 * Lintcode: http://lintcode.com/en/problem/digit-counts/
 */

public class DigitsCounts {
	
	public int countKs(int initial_number, int digit)
	{
		if (initial_number == 0 && digit == 0)
		{
			return 1;
		}
		
		int count = 0;
		int number = initial_number;
		while (number != 0)
		{
			int d = number % 10;
			if (d == digit)
			{
				System.out.println("initial number = " + initial_number);
				count++;
			}
			number = number / 10;
		}
		
		
		return count;
	}
	
    public int digitCounts(int k, int n) {
    	int count = 0;
        for (int i= 0 ; i <= n ; i++)
        {
        	count += countKs(i, k);
        }
        return count;
    }
    
    
	public static void main(String[] args) {
		DigitsCounts sol = new DigitsCounts();
		System.out.println(sol.digitCounts(0, 19));
	}

}
