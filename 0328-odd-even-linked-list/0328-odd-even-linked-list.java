class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode odd_ptr = odd, even_ptr = even;
        int idx = 1;
        while(head!=null){
            if(idx%2 ==0){
                even_ptr.next = head;
                even_ptr = even_ptr.next;
            }else{
                odd_ptr.next = head;
                odd_ptr = odd_ptr.next;
            }
            head = head.next;
            idx++;
        }
        even_ptr.next = null;
        odd_ptr.next = even.next;
        return odd.next;
    }
}