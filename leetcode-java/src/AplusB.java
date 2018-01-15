/*
 *  1. A + B Problem
 *
 * Write a function that add two numbers A and B. 
 * You should not use + or any arithmetic operators. 
 *
 * Lintcode: http://lintcode.com/en/problem/a-b-problem/
 */
public class AplusB {
    public int aplusb(int a, int b) {
        if (b == 0)
        {
            return a;
        }
        
        int x = a ^ b;
        int y = (a & b) << 1;
        return aplusb(x,y);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
