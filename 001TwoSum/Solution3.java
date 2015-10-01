import java.util.*;
public class Solution3{//accepted
	public int[] twoSum(int[] nums, int target){
		HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
		int index1=-1,index2=-1;
		for(int i=0;i<nums.length;i++){
			int second=target-nums[i];
			if(hm.containsKey(second)){
				index2=i;
				index1=hm.get(second);
				break;
			}
			hm.put(nums[i],i);
		}
		return new int[]{index1+1,index2+1};
	}
}