

import java.util.Stack;

class Main {
	
	
	public static void main(String[] args)
	{
		Main m = new Main();
		System.out.println(m.lengthLongestPath("\"dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext\""));
	}
    public String findMaxFile(String input, Stack<String> stack, int level, String max)
    {
        int idx = input.indexOf('\n');
        System.out.println("idx=" + idx+ "\n");

        if (idx == -1)
        {
            idx = input.length();
        }
                System.out.println("input=" + input+ "\n");

        System.out.println("idx=" + idx+ "\n");
        int i = 0;
        int l = 0;
        while (input.charAt(i) == '\t')
        {
            l++;
        }
        String label = input.substring(l, idx);
        if (l > level )
        {
            stack.push(label);
        }
        System.out.println("l=" + l + ";level=" + level);
        
        while (level <= l)
        {
            if (stack.size() > 0)
            {
                stack.pop();
            }
            l--;
        }
        stack.push(label);
        StringBuffer sb = new StringBuffer();
        i = 0;
        for (String s : stack)
        {
            sb.append(s);
            if (i < stack.size() - 1)
            {
                sb.append("/");
            }
            i++;
        }
        
        if (sb.toString().length() > max.length())
        {
            max = sb.toString();
        }
        if (idx == input.length())
        {
        	return max;
        }
        
        String other = findMaxFile(input.substring(idx+1, input.length()), stack, l, max);
        if (other.length() > max.length() )
        {
            return other;
        }
        return max;
    }
    public int lengthLongestPath(String input) {
        
        String s = findMaxFile(input, new Stack<String>(), 0, "");
        System.out.println("s=" + s );
        return s.length();
    }
}