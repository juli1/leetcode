package leetcode;
/*
 * Given n pieces of wood with length L[i] (integer array). 
 * Cut them into small pieces to guarantee you could have 
 * equal or more than k pieces with the same length. 
 * What is the longest length you can get from the n 
 * pieces of wood? Given L & k, 
 * return the maximum length of the small pieces.
 * 
 * Lintcode: http://lintcode.com/en/problem/wood-cut/
 */
public class WoodCut {
	public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) return 0;

        int lb = 0, ub = Integer.MAX_VALUE;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (C(L, k, mid)) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb;
    }

    // whether it cut with length x and get more than k pieces
    private boolean C(int[] L, int k, int x) {
        int sum = 0;
        for (int l : L) {
            sum += l / x;
        }
        return sum >= k;
    }
	public static void main(String[] args) {
		int[] arr = new int[] {232,124,456};
		WoodCut sol = new WoodCut();
		System.out.println(sol.woodCut(arr, 7));

	}

}
