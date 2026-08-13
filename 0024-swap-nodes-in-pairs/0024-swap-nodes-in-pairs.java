class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy, curr = head;
        while(curr != null && curr.next != null){
            ListNode first = curr, second = curr.next, temp = second.next;
            prev.next = second;
            second.next = first; 
            first.next = temp;
            prev = first;
            curr = temp;
        }
        return dummy.next;
    }
}