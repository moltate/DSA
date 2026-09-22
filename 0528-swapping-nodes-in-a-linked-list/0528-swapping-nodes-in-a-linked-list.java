class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head, first = head, second = head;
        for(int i = 1; i < k; i++){
            fast = fast.next;
        }
        first = fast;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        second = slow;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}