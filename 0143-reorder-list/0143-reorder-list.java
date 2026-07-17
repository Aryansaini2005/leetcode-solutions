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
    public ListNode reverse(ListNode cur) {
        ListNode prev = null;
        while(cur != null) {
            ListNode front = cur.next;
            cur.next = prev;
            prev = cur;
            cur = front;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        slow.next = null;
        
        ListNode t1 = head;
        ListNode t2 = newHead;
        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;

        while(t1 != null && t2 != null) {
            ListNode next1 = t1.next;
            ListNode next2 = t2.next;
            
            temp.next = t1;
            temp = temp.next;

            temp.next = t2;
            temp = temp.next;

            t1 = next1;
            t2 = next2;
        }
        if(t1 != null) {
            temp.next = t1;
        }
        if(t2 != null) {
            temp.next = t2;
        }
       

    }
}