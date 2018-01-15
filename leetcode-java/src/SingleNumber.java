/*
 *  82. Single Number
 * Given 2*n + 1 numbers, every numbers occurs twice except one, find it.
 * 
 * Lintcode: http://lintcode.com/en/problem/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int t = 0;
        for (int n : A)
        {
            t = t ^ n;
        }
        return t;
    }
    
    
	public static void main(String[] args) {
		SingleNumber sol = new SingleNumber();
		int[] arr = new int[] {1,2,2,1,3,4,3};
		int v = sol.singleNumber(arr);
		System.out.println(sol.singleNumber(arr));
	}

}
