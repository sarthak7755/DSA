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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case handling.
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head; // Declare head as dummy.next for return statement.
        ListNode prev = dummy;
        int count = 0;

        // prev pointer's Adjustment
        while(count < left-1){
            prev = prev.next;
            count++;
        }

        ListNode curr = prev.next;
        count = 0;

        // Reversing Start
        while(count < (right - left)){
            ListNode fwd = curr.next;
            curr.next = fwd.next;
            fwd.next = prev.next;
            prev.next = fwd;
            count++;
        }
        return dummy.next;
    }
}