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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            int a = temp.val;
            int b = temp.next.val;
            int num = gcd(a,b);

            ListNode nn = new ListNode(num);
            ListNode front = temp.next;

            temp.next = nn;
            nn.next = front;
            temp = front;
        }
        return head;
    }
    private int gcd(int a , int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}