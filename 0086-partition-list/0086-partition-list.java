class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lesserDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode slow = lesserDummy, fast = greaterDummy; 
        ListNode curr = head;
        while(curr != null){
            if(curr.val < x){
                slow.next = curr;
                slow = slow.next;
            }else{
                fast.next = curr;
                fast = fast.next;
            }
            curr = curr.next;
        }
        fast.next = null;
        slow.next = greaterDummy.next;

        return lesserDummy.next;
    }
}