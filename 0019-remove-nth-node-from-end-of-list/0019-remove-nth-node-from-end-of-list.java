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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        if(size-n+1 == 1) {
            head = head.next;
            return head;
        }
        int cnt = 0;
        ListNode prev = null;
        temp = head;
        while(temp != null) {
            cnt++;
            if(cnt == size-n+1) {
                prev.next = prev.next.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }
}