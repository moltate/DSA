class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0; 
        while( l1 != null || l2 != null || carry != 0){
            int dig1 = (l1 != null) ? l1.val : 0;
            int dig2 = (l2 != null) ? l2.val : 0;

            //new digit
            int val =  dig1 + dig2 + carry;
            int num = val % 10;
            carry = val/10;
            curr.next = new ListNode(num);

            //update pointers
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}