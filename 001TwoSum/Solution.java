import java.util.*;
public class Solution {//accepted
    public int[] twoSum(int[] nums, int target) {
        int size=nums.length;
        TreeSet<Integer> ts=new TreeSet<Integer>();
        for(int num:nums){
            ts.add(num);
        }
        int first=0,second=0;
        for(int num:ts){
            first=num;
            second=target-num;
            if(ts.contains(second)){
                break;//排序了，先找不同的，最后才可能找到两个相同的
            }
        }
        int i;
        int index1=-1,index2=-1;
        boolean find1=false,find2=false;
        for(i=0;i<size;i++){
            if(!find1 && first==nums[i]){
                index1=i;
                find1=true;
                if(find2){
                    break;
                }
            }else if(!find2 && second==nums[i]){//两个相同解，此处区分
                index2=i;
                find2=true;
                if(find1){
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
}