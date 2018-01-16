package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class MajorityNumberII {
    public int majorityNumber(List<Integer> nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int n : nums)
        {
        		map.put(n, map.getOrDefault(n,0) + 1);
        		if (map.get(n) > nums.size() / 3)
        		{
        			return n;
        		}
        			
        }
        return 0;
    }
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(1);
		nums.add(2);
		nums.add(1);
		nums.add(3);
		nums.add(4);
		MajorityNumberII sol = new MajorityNumberII();
		System.out.println("majority=" + sol.majorityNumber(nums));

	}

}
