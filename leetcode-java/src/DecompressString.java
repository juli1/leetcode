import java.util.Stack;

public class DecompressString {

	public String printString(String in)
	{
		String res = "";
		Stack<String> strings = new Stack<String>();
		Stack<Integer> positions = new Stack<Integer>();
		positions.add(0);
		res = helper(in, strings, positions);
		return res;
	}
	
	public String helper(String in, Stack<String> strings, Stack<Integer> positions)
	{
		int pos = positions.peek();
		String res = "";
		while(pos < in.length())
		{
			char c = in.charAt(pos);
			
			if (Character.isDigit(c))
			{
				int number = c - '0';
				positions.push(pos + 2);
				String s = helper(in,strings,positions);
				pos = positions.pop();
				strings.pop();
				for (int i = 0 ; i < number ; i++)
				{
					res = res + s;
				}
				pos++;
				continue;
			}
			if (c == ']')
			{
				if (positions.size() > 1)
				{
					strings.push(res);
					positions.pop();
					positions.push(pos);
					return res;
				}
			}
			res = res + c;
			pos++;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		DecompressString s = new DecompressString();
		System.out.println(s.printString("a2[b6[c]]"));

	}
	
}
