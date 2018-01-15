/*
 *  655. Big Integer Addition
 *
 * Given two non-negative integers num1 and num2 represented as string,
 * return the sum of num1 and num2.
 * 
 * http://lintcode.com/en/problem/big-integer-addition/
 * 
 */
public class BigIntegerAddition {
    public String addStrings(String num1, String num2) {
        
    	StringBuffer sb = new StringBuffer ();
        int toadd = 0;
        
        // Make sure num1 if the biggest string
        if (num1.length() < num2.length())
        {
        	String t = num1;
        	num1 = num2;
        	num2 = t;
        }
        
        int n2len = num2.length();
        int n1len = num1.length();
        int diff = n1len - n2len;
        for (int i = 0 ; i < n2len ; i++)
        {
        	int sum = (num1.charAt(diff+n2len - i - 1) - '0') + (num2.charAt(n2len - i - 1) - '0') + toadd;
        	toadd = sum / 10;
        	sb.append(sum % 10);
        }
        for (int i = n2len ; i < n1len ; i++)
        {
        	int sum = (num1.charAt(n1len - i - 1) - '0') + toadd;
        	toadd = sum / 10;
        	sb.append(sum % 10);
        }
        if (toadd == 1)
        {
        	sb.append(1);
        }
        
        return sb.reverse().toString();
    }
    
	public static void main(String[] args) {
		BigIntegerAddition sol = new BigIntegerAddition();
		System.out.println(sol.addStrings("3","3"));
		System.out.println(sol.addStrings("14","6"));
		System.out.println(sol.addStrings("5","6"));
		

	}

}
