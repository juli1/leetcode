/*
 *  189. First Missing Positive
 *
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * Lintcode: http://lintcode.com/en/problem/first-missing-positive/
 */
public class FindMissingPositive {
    public int firstMissingPositive(int[] A) {
    	int n = A.length;
    	for (int i = 0; i < n; i++) {
    		// when the ith element is not i
    		while (A[i] != i) {
    			// no need to swap when ith element is out of range [0,n]
    			if (A[i] < 0 || A[i] >= n)
    				break;
     
    			//handle duplicate elements
    			if(A[i]==A[A[i]])
                        		break;
    			// swap elements
    			int temp = A[i];
    			A[i] = A[temp];
    			A[temp] = temp;
    		}
    	}
     
    	for (int i = 0; i < n; i++) {
    		if (A[i] != i)
    			return i;
    	}
     
    	return n;
    }
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,0};
		FindMissingPositive sol = new FindMissingPositive();
		System.out.println(sol.firstMissingPositive(arr));
	}

}
