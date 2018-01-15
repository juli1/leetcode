import java.util.Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
    	int sumRemaining = 0; // track current remaining
    	int total = 0; // track total remaining
    	int start = 0; 
     
    	for (int i = 0; i < gas.length; i++) {
    		int remaining = gas[i] - cost[i];
     
    		//if sum remaining of (i-1) >= 0, continue 
    		if (sumRemaining >= 0) { 
    			sumRemaining += remaining;
    		//otherwise, reset start index to be current
    		} else {
    			sumRemaining = remaining;
    			start = i;
    		}
    		total += remaining;
    	}
     
    	if (total >= 0){
    		return start;
    	}else{
    		return -1;
    	}
   
    	
    	
    }
	public static void main(String[] args) {
		GasStation sol = new GasStation();
		int[] gas = new int[] {1,1,3,1};
		int[] cost = new int[] {2,2,1,1};
		System.out.println(sol.canCompleteCircuit(gas, cost));

	}

}
