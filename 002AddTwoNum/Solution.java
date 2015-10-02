/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=null;
        ListNode ll1=l1;
        ListNode ll2=l2;
        int carry=0;
        int tmp=0;
        while(ll1!=null && ll2!=null){
        	tmp=ll1.val+ll2.val+carry;
        	carry=tmp/10;
        	ListNode current=new ListNode(tmp%10);
        	current.next=result;
        	result=current;
        	ll1=ll1.next;
        	ll2=ll2.next;
        }

        ListNode left=null;
        if(ll1!=null){
        	left=ll1;
        }else if(ll2!=null){
        	left=ll2;
        }else{
        	left=null;
        }
        while(left!=null){
        	tmp=left.val+carry;
        	carry=tmp/10;
        	ListNode current=new ListNode(tmp%10);
        	current.next=result;
        	result=current;
        	left=left.next;
        }
        if(carry>0){
        	ListNode current=new ListNode(carry);
        	current.next=result;
        	result=current;
        }

        left=null;
        ListNode tmpNode=null;
        while(result!=null){
        	tmpNode=result.next;
        	result.next=left;
        	left=result;
        	result=tmpNode;
        }

        return left;
    }
}