import java.util.*;//cannot resulve collision,wrong
public class Solution1{
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>(nums.length);
		for(int i=0;i<nums.length;i++){
			hm.put(nums[i],i);
		}
		System.out.println(hm);
		int index1=0,index2=0;
		int second=0;
		for(int num:nums){
			second=target-num;
			if(num!=second){
				if(hm.containsKey(second)){
					index1=hm.get(num);
					index2=hm.get(second);
					break;
				}
			}
		}
		if(index1>index2){
			int tmp=index1;
			index1=index2;
			index2=tmp;
		}
		return new int[]{index1+1,index2+1};
	}

	public static void printArray(int os[]){
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(Object o:os){
			sb.append(o);
			sb.append(",");
		}
		sb.delete(sb.length()-1,sb.length());
		sb.append("]");
		System.out.println(sb);
	}
	public static void main(String args[]){
		printArray(new Solution1().twoSum(new int[]{1,2,3,4},7));
		printArray(new Solution1().twoSum(new int[]{1,2,3,4},8));
		printArray(new Solution1().twoSum(new int[]{3,2,4},6));
		printArray(new Solution1().twoSum(new int[]{2,7,11,15},18));
	}
}