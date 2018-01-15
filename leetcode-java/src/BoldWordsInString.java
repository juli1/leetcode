import java.util.*;
/*
 * 758. Bold Words in String
 *  Given a set of keywords words and a string S, make all appearances of all keywords in S bold. Any letters between <b> and </b> tags become bold.

The returned string should use the least number of tags possible, and of course the tags should form a valid combination.

For example, given that words = ["ab", "bc"] and S = "aabcd", we should return "a<b>abc</b>d". Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect. 
 *
 */
public class BoldWordsInString {
	
	class TrieNode
	{
		char c;
		boolean finish;
		Map<Character,TrieNode> subnodes;
		public TrieNode() {
			subnodes = new HashMap<Character,TrieNode>();
		}
		public void putNode(char c)
		{
			subnodes.put(c, new TrieNode());
		}
		
		public TrieNode get(char c)
		{
			return subnodes.get(c);
		}
		
		
	}
	
	class Trie {
		TrieNode root;
		public Trie ()
		{
			root = new TrieNode();
		}
		public void addWord(String s)
		{
			TrieNode r = root;
			for (int i = 0 ; i < s.length() ; i++)
			{
				char c = s.charAt(i);
				if (r.get(c) == null)
				{
					r.putNode(c);
					
				}
				r = r.get(c);
				r.c = c;
			}
			r.finish = true;
		}
		public TrieNode getRoot ()
		{
			return this.root;
		}
	}
	
    public String boldWords(String[] words, String S) {
    	Trie trie = new Trie();
    	StringBuffer sb = new StringBuffer();
    	for (String word : words)
    	{
    		trie.addWord(word);
    	}
    	TrieNode root = trie.getRoot();
    	int pos = 0;
    	
    	while (pos < S.length())
    	{
    		TrieNode previous = null;
    		TrieNode r = root;
    		int pos2 = pos;
    		while (pos2 < S.length() && r != null && r.get(S.charAt(pos2)) != null)
    		{
    			char c = S.charAt(pos2);
    			System.out.println("C=" +c);
    			
    			r = r.get(c);
    			previous = r;
    			pos2++;
    			if (r.finish && r.get(S.charAt(pos2)) == null)
    			{
    				r = root;
    				pos2--;
    			}
    		}
    		if (pos == pos2)
    		{
    			sb.append(S.charAt(pos));
    			pos++;
    			continue;
    		}
    		if (r != null  && r.finish)
    		{
    			sb.append("<b>" + S.substring(pos, pos2) + "</b>");
    			pos = pos2;
    			continue;
    		}
    		else
    		{
    			sb.append( S.substring(pos, pos2));
    			pos = pos2;
    			continue;
    		}
    	}
    	
    	
    	
    	
    	return sb.toString();
    }
    
	public static void main(String[] args) {
		String[] words = {"ab","bc"};
		String sentence = "aabcd";
		BoldWordsInString sol = new BoldWordsInString();
		System.out.println("sol=" + sol.boldWords(words, sentence));
	}

}
