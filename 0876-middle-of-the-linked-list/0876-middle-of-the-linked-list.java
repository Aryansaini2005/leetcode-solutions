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
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        int size = 0;
        ListNode temp1 = head;
        while(temp1 != null) {
            temp1 = temp1.next;
            size++;
        }

        int mid = size/2 + 1;
        int cnt = 0;
        ListNode temp2 = head;
        while(temp2 != null) {
            cnt++;
            if(cnt == mid) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }
}