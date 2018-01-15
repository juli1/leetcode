import java.util.Arrays;

/*
 * 

Given a boolean expression with following symbols.

Symbols
    'T' ---> true 
    'F' ---> false 

And following operators filled between symbols

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR 

Count the number of ways we can parenthesize the expression 
so that the value of expression evaluates to true.

Let the input be in form of two arrays one contains the symbols 
(T and F) in order and other contains operators (&, | and ^}

 * Lintcode: http://lintcode.com/en/problem/boolean-parenthesization/
 *
 */

public class BooleanParanthesization {
	public boolean parseBoolean(char c)
	{
		if (c == 'T')
		{
			return true;
		}
		return false;
	}
	
	public int helper(char[] symb, char[] oper, int start, int end, boolean expect, int[][][] cache)
    {
    	
    	int res = 0;
    	
    	int temp = expect ? 1 : 0;
    	if (cache[start][end][temp] != -1)
    	{
    		return cache[start][end][temp];
    	}
    	
    	if (end - start == 1)
    	{
    		//System.out.println("check symbol" + symb[start]);
    		return parseBoolean(symb[start]) == expect ? 1 : 0;
    	}
    	
    	for (int i = start; i < end - 1 ; i++)
    	{
    		
    
    		char operator = oper[i];
    		if (operator == '|')
    		{
    			if (expect)
    			{
	    			res += helper(symb,oper,start,i+1, true, cache) * helper(symb,oper,i+1,end, true, cache);
	    			res += helper(symb,oper,start,i+1, true, cache) * helper(symb,oper,i+1,end, false, cache);
	    			res += helper(symb,oper,start,i+1, false, cache) * helper(symb,oper,i+1,end, true, cache);
    			}
    			else
    			{
    				res += helper(symb,oper,start,i+1, false, cache) * helper(symb,oper,i+1,end, false, cache);
    			}
    		}
    		if (operator == '^')
    		{
    			if (expect)
    			{

    				res += helper(symb,oper,start,i+1, false, cache) * helper(symb,oper,i+1,end, true, cache);
    				res += helper(symb,oper,start,i+1, true, cache) * helper(symb,oper,i+1,end, false, cache);
    			}
    			else
    			{
    				res += helper(symb,oper,start,i+1, true, cache) * helper(symb,oper,i+1,end, true, cache);
    				res += helper(symb,oper,start,i+1, false, cache) * helper(symb,oper,i+1,end, false, cache);
    			}
    		}
    		if (operator == '&')
    		{
    			if (expect)
    			{
	    			res += helper(symb,oper,start,i+1, true, cache) * helper(symb,oper,i+1,end, true, cache);
    			}
    			else
    			{
    				res += helper(symb,oper,start,i+1, false, cache) * helper(symb,oper,i+1,end, false, cache);
    				res += helper(symb,oper,start,i+1, false, cache) * helper(symb,oper,i+1,end, true, cache);
    				res += helper(symb,oper,start,i+1, true, cache) * helper(symb,oper,i+1,end, false, cache);
    			}
    		}
    	}
    	cache[start][end][temp] = res;
    	return res;
    }
    
    public int countParenth(char[] symb, char[] oper) {
    	int[][][] cache = new int[symb.length + 1][symb.length+1][2];
    	for (int i = 0 ; i <= symb.length ; i++)
    	{
    		for (int j = 0 ; j <= symb.length ; j++)
        	{
        		Arrays.fill(cache[i][j], -1);
        	}
    	}
    	
        return helper(symb, oper, 0, symb.length, true, cache);
    }
    
    
	public static void main(String[] args) {
		BooleanParanthesization sol = new BooleanParanthesization();
		char[] symb = new char[] {'T', 'F', 'F'};
		char[] oper = new char[] {'^', '|'};
		System.out.println(sol.countParenth(symb, oper));

	}

}
