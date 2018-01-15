/*
 * Suppose we abstract our file system by a string in the following manner:

 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext

* The directory dir contains an empty sub-directory subdir1 and a 
* sub-directory subdir2 containing a file file.ext.

The string

"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"

represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext

* The directory dir contains two sub-directories subdir1 and subdir2. 
* subdir1 contains a file file1.ext and an empty second-level 
* sub-directory subsubdir1. subdir2 contains a second-level 
* sub-directory subsubdir2 containing a file file2.ext.
* We are interested in finding the longest (number of characters) 
* absolute path to a file within our file system. For example, in 
* the second example above, the longest absolute path is 
* "dir/subdir2/subsubdir2/file2.ext", and its length is 32 
* (not including the double quotes).
* Given a string representing the file system in the above 
* format, return the length of the longest absolute path to 
* file in the abstracted file system. If there is no file in 
* the system, return 0.


 * Lintcode: http://lintcode.com/en/problem/system-longest-file-path/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;


	
public class LongestAbsolutePath {

	public int getPosition(String entry)
	{
		
		return entry.length() - entry.replaceAll("\t", "").length();
	}
	
	public int getEntrySize(String entry)
	{
		int size = 0;
		for (int i = 0 ; i < entry.length() ; i++)
		{
			if (Character.isLetterOrDigit(entry.charAt(i)))
			{
				size++;
			}
			if (entry.charAt(i) == '.')
			{
				size++;
			}
			if (entry.charAt(i) == '\t')
			{
				size++;
			}
		}
		return size;
		
	}
	
    public int lengthLongestPath(String input) {
    	String[] entries = input.split("\n");
    	Stack<Integer> size = new Stack<Integer>();
    	size.push(0);
    	int maxSize = 0;
    	for (String entry : entries)
    	{
    		System.out.println(entry);
    		int currentPosition = size.size() - 1;
    		
    		int position = getPosition(entry);
    		int entrySize = getEntrySize(entry);
    		System.out.println("entrysize"  + entrySize);
    		if (entry.indexOf('.') != -1)
    		{
    			maxSize = Math.max(maxSize, size.peek() + entrySize);
    			continue;
    		}
    		if(position > currentPosition)
    		{
    			size.push(size.peek() + entrySize + 1);
    			continue;
    		}
    		
    		while(position < currentPosition)
    		{
    			size.pop();
    			currentPosition--;
    		}
    		size.push(size.peek() + entrySize + 1);
    	}
    	
    	return maxSize;
    }
    
    
    
	public static void main(String[] args) {
		LongestAbsolutePath s = new LongestAbsolutePath();
		String path = "dir\n    file.txt";
		System.out.println(s.lengthLongestPath(path));

	}
	

}
