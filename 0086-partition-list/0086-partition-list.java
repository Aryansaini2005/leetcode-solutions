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
    public ListNode partition(ListNode head, int x) {
        ListNode greatDummy = new ListNode(-1);
        ListNode lessDummy = new ListNode(-1);

        ListNode great = greatDummy;
        ListNode less = lessDummy;

        while(head != null) {
            if(head.val < x) {
                less.next = head;
                less = less.next;
            }else {
                great.next = head;
                great = great.next;
            }
            head = head.next;
        }

        great.next = null;
        less.next = greatDummy.next;

        return lessDummy.next;
    }
}