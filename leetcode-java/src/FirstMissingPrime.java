

/*
 *  681. First Missing Prime Number
 *  
 * Given a list of integers and find the smallest prime number that doesn't appear in this list.
 *
 * Given a list [2,3,5,7,11,13,17,23,29]
 * return 19
 * 
 * Lintcode: http://lintcode.com/en/problem/first-missing-prime-number/
 * 
 */

import java.util.Arrays;

public class FirstMissingPrime {
	public int firstMissingPrime(int[] nums) {
    	if (nums.length == 0)
	{
		return 2;
	}
    int lastprime = nums[nums.length -1] * 2;
    boolean[] primes = new boolean[lastprime + 1];
    Arrays.fill(primes, true);
    primes[0] = false;
    primes[1] = false;
    for (int i = 2 ; i <= lastprime / 2 ; i++)
    {
    	int n = i + i;
    	
    	while (n < lastprime)
    	{
    		primes[n] = false;
    		n+=i;
    	}
    }
    for (int n : nums)
    {
    	primes[n] = false;
    }
    for (int i = 2 ; i <= lastprime ; i++)
    {
    	if (primes[i])
    	{
    		return i;
    	}
    }
    return 0;
}
    
    
	public static void main(String[] args) {
		FirstMissingPrime sol = new FirstMissingPrime();
		int[] arr = new int[] {3,5,7};
		System.out.println(sol.firstMissingPrime(arr));
	}

}
