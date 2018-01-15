
public class SingleNumber2 {
    public int singleNumberII(int[] A) {
        int t = 0;
        for (int n : A)
        {
            t = t ^ n;
        }
        return ~t;
    }
    
    
	public static void main(String[] args) {
		SingleNumber2 sol = new SingleNumber2();
		int[] arr = new int[] {1,2,2,2,1,3,1,3,4,3};
		int v = sol.singleNumberII(arr);
		System.out.println(v);
	}

}
