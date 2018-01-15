import java.util.Arrays;
/*
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag 
 * pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed 
 * font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and 
 * make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 * 
 * Leetcode: https://leetcode.com/problems/zigzag-conversion/description/
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
       if (numRows == 1)
       {
    	   return s;
       }
       String[] strings = new String[numRows];
       Arrays.fill(strings, "");
       int pos = 0;
       int rowIndex = 0;

	   int direction = 1;
       while (pos < s.length())
       {
    	
    	   strings[rowIndex] += s.charAt(pos);
    	   
    	   if (direction == 1)
    	   {
    		   if (rowIndex == numRows - 1)
    		   {
    			   direction = -1;
    			   rowIndex--;
    		   }
    		   else
    		   {
    			   rowIndex++;
    		   }
    		   
    	   }
    	   else
    	   {
    		   if (rowIndex == 0)
    		   {
    			   direction = 1;
    			   rowIndex++;
    		   }
    		   else
    		   {
    			   rowIndex--;
    		   }
    	   }
    	   pos++;
       }
       String result = "";
       for (String tmp : strings)
       {
    	   result += tmp;
       }
       return result;  
    }
	public static void main(String[] args) {
		String str = "AB";
		int nrows = 1;
		ZigZagConversion sol = new ZigZagConversion();
		System.out.println(sol.convert(str, nrows));
				
	}

}
