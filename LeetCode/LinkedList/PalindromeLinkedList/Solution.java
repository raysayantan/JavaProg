/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
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
    private boolean done = false;
    private ListNode start = null;
    public boolean helper(ListNode head){
        if(head == null) return true;
        boolean status = true;
        if(head.next != null){
            status = helper(head.next);
        }
        
        if(done == true){
            return status;
        }
        
        if(status == false || head.val != start.val){
            return false;
        }
        
        if(start.next != head && start != head){
            start = start.next;
        } else {
            done = true;
        }
        return status;
    }
    public boolean isPalindrome(ListNode head) {
        start = head;
        return helper(head);
    }
}
