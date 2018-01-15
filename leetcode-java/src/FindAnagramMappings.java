import java.util.*;

/*
 * 760. Find Anagram Mappings
 * Given two lists Aand B, and B is an anagram of A. B 
 * is an anagram of A means B is made by randomizing 
 * the order of the elements in A.
 * We want to find an index mapping P, from A to B. 
 * A mapping P[i] = j means the ith element in A appears in B at index j.
 * These lists A and B may contain duplicates. 
 * If there are multiple answers, output any of them.
 * 
 * Leetcode: https://leetcode.com/contest/weekly-contest-66/problems/find-anagram-mappings/
 */

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] result = new int [A.length];
        Map<Integer, List<Integer>> positions = new HashMap<Integer, List<Integer>>();
        for (int posb = 0 ; posb < B.length ; posb++)
        {
            if(!positions.containsKey(B[posb]))
            {
                positions.put(B[posb], new ArrayList<Integer>());
            }
            List<Integer> pos = positions.get(B[posb]);
            pos.add(posb);
        }
        for (int posa = 0 ; posa < A.length ; posa++)
        {
            List<Integer> positionsb = positions.get(A[posa]);
            int n = positionsb.get(positionsb.size() - 1);
            positionsb.remove(positionsb.size() - 1);
            result[posa] = n;
        }
        return result;
    }
	public static void main(String[] args) {
		FindAnagramMappings sol = new FindAnagramMappings();
		int[] a = new int[] {12, 28, 46, 32, 50};
		int[] b = new int[] {50, 12, 32, 46, 28};
		int[] result = sol.anagramMappings(a, b);
		System.out.println(Arrays.toString(result));

	}

}
