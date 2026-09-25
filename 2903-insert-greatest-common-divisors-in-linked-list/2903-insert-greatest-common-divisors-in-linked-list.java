class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null ){
            int gcdVal = calGCD(slow.val, fast.val);
            ListNode gcd = new ListNode(gcdVal);
            slow.next = gcd;
            gcd.next = fast;

            slow = fast;
            fast = fast.next;
        }
        return head;
    }
    public int calGCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a% b;
            a = temp;
        }
        return a;
    }
}