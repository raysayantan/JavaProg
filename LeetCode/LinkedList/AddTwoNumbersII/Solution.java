/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
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
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        while(l1 != null){
            st1.push(l1);
            l1 = l1.next;
        }
        
        while(l2 != null){
            st2.push(l2);
            l2 = l2.next;
        }
        
        ListNode result = null;
        int carry = 0;
        int sum = 0;
        while(!st1.isEmpty() && !st2.isEmpty()){
            ListNode e1 = st1.pop();
            ListNode e2 = st2.pop();
            sum = carry + e1.val + e2.val;
            carry = sum / 10;
            sum = sum % 10;
            ListNode temp = new ListNode(sum, result);
            result = temp;
        }
        
        while(!st1.isEmpty()){
            ListNode e1 = st1.pop();
            sum = carry + e1.val;
            carry = sum / 10;
            sum = sum % 10;
            ListNode temp = new ListNode(sum, result);
            result = temp;
        }
        
        while(!st2.isEmpty()){
            ListNode e2 = st2.pop();
            sum = carry + e2.val;
            carry = sum / 10;
            sum = sum % 10;
            ListNode temp = new ListNode(sum, result);
            result = temp;
        }
        
        if(carry > 0){
            ListNode temp = new ListNode(carry, result);
            result = temp;
        }
        
        return result;
    }
}
