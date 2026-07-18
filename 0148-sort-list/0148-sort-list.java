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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return merge(leftHead,rightHead);
    }
    public ListNode findMid(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        
        }
        return slow;
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode t1 = left;
        ListNode t2 = right;
        ListNode dNode = new ListNode(-1);
        ListNode temp = dNode;
        while(t1 != null && t2 != null) {
            if(t1.val < t2.val) {
                temp.next = t1;
                temp = temp.next;
                t1 = t1.next;
            }else {
                temp.next = t2;
                temp = temp.next;
                t2 = t2.next;
            }
        }
        if(t1 != null) {
            temp.next = t1;
        }else {
            temp.next = t2;
        }
        return dNode.next;
    }
}