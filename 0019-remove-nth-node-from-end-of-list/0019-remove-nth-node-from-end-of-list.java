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
        ListNode c = head;
        int co = 0;
        while(c != null){
            c = c.next;
            co++;
        }
        c = head;
        if(co == n) return head.next;
        for(int i = 0; i < co-n-1; i++){
            c = c.next;
        }
        c.next = c.next.next;
        return head;      
    }
}