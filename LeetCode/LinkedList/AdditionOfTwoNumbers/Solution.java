/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = null;
        ListNode r = null;
        int carry = 0;
        int sum = 0;
        while( l1 != null && l2 != null){
            sum = carry + l1.val + l2.val;
            carry = sum / 10;
            sum = sum % 10;
            ListNode p = new ListNode(sum);
            if(start == null){
                start = p;
                r = start;
            } else {
                r.next = p;
                r = r.next;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            sum = carry + l1.val;
            carry = sum / 10;
            sum = sum % 10;
            ListNode p = new ListNode(sum);
            r.next = p;
            r = r.next;
            l1 = l1.next;
        }
        
        while(l2 != null){
            sum = carry + l2.val;
            carry = sum / 10;
            sum = sum % 10;
            ListNode p = new ListNode(sum);
            r.next = p;
            r = r.next; 
            l2 = l2.next;
        }
        
        if(carry > 0){
            ListNode p = new ListNode(carry);
            r.next = p;
        }
        
        return start;
    }
}
