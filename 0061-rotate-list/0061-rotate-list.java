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
    public ListNode findKNode(ListNode head,int k) {
        int cnt = 1;
        while(head != null) {
            if(cnt == k) return head;
            head = head.next;
            cnt++;
        }
        return null;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int n = 1;
        ListNode tail = head;
        while(tail.next != null) {
            n++;
            tail = tail.next;
        }
        k = k%n;
        if(k == 0) return head;
        tail.next = head;
        ListNode temp = findKNode(head,n-k);
        head = temp.next;
        temp.next = null;
        return head;
        
    }
}