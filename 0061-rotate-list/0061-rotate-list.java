class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int length = 1;
        ListNode dummy = head;
        while (dummy.next != null) {
            dummy = dummy.next;
            length++;
        }
        int pos = k % length;
        if (pos == 0) return head;
        ListNode curr = head;
        for (int i = 1; i < length - pos; i++) {
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        dummy.next = head;

        return newHead;
    }
}