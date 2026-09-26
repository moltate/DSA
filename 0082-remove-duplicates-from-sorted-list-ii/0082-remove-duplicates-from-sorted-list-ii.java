class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while(fast !=null && fast.next != null){
            if(fast.val == fast.next.val){
                while(fast.next!=null && fast.val == fast.next.val){
                    fast = fast.next;
                }
                slow.next = fast.next;
            }else{
                slow = slow.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}