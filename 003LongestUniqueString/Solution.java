/*
Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
import java.util.*;
public class Solution {//StackOverflowError
    public int lengthOfLongestSubstring(String s) {
    	if(s.length()==0){
    		return 0;
    	}
        char[] str=s.toCharArray();
        return lengthOfLongestSubChar(str,0,str.length-1);
    }
    public int lengthOfLongestSubChar(char[] str, int low, int high){
    	if(high==low){
    		return 1;
    	}else{
    		int middle=(low+high)/2;
    		int leftLength=lengthOfLongestSubChar(str,low,middle);
    		int rightLength=lengthOfLongestSubChar(str,middle,high);
    		HashMap<Character,Integer> hml=new HashMap<Character,Integer>();
    		int ll,lr,rl,rr;
    		for(ll=middle;ll>=low;ll--){
    			if(hml.containsKey(str[ll])){
    				break;//(ll,lr)
    			}else{
    				hml.put(str[ll],ll);
    			}
    		}
    		for(lr=middle+1;lr<=high;lr++){
    			if(hml.containsKey(str[lr])){
    				break;
    			}else{
    				hml.put(str[lr],lr);
    			}
    		}

    		HashMap<Character,Integer> hmr=new HashMap<Character,Integer>();
    		for(rr=middle+1;rr<=high;rr++){
    			if(hmr.containsKey(str[rr])){
    				break;
    			}else{
    				hmr.put(str[rr],rr);
    			}
    		}
    		for(rl=middle;rl>=low;rl--){
    			if(hmr.containsKey(str[rl])){
    				break;
    			}else{
    				hmr.put(str[rl],rl);
    			}
    		}

    		int llength=lr-ll-1;
    		int rlength=rr-rl-1;
    		int m1=(llength>rlength)?llength:rlength;
    		int m2=(leftLength>rightLength)?leftLength:rightLength;
    		return (m1>m2)?m1:m2;
    	}
    }
}