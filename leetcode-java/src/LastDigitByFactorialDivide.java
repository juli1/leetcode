/*
 *  729. Last Digit By Factorial Divide
 * We are given two numbers A and B such that B >= A. 
 * We need to compute the last digit of this resulting F 
 * such that F = B! / A! where 1 <= A, B <= 10^18 (A and B are very large)
 *
 * Lintcode: http://lintcode.com/en/problem/last-digit-by-factorial-divide/
 */
public class LastDigitByFactorialDivide {
    public int computeLastDigit(long A, long B) {
        
        long diff = B - A;
        if (diff >= 5)
        {
            return 0;
        }
        long res =1;
        A++;
        while (A <=B)
        {
            res = (res *( A %10))%10;
            A++;
        }
        int n = (int)(res % 10);
        return n;
    }
	public static void main(String[] args) {
		LastDigitByFactorialDivide sol = new LastDigitByFactorialDivide();
		System.out.println(sol.computeLastDigit(107, 109));
	}
}
