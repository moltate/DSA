class Solution {
    public ListNode sortList(ListNode head) {
         if (head == null || head.next == null) return head;
         ListNode mid = FindMid(head), midNext =  mid.next;
         mid.next = null;
         ListNode left = sortList(head), right = sortList(midNext);
         return merge(left,right);
    }
    ListNode FindMid(ListNode head){
         ListNode slow = head, fast = slow.next;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
    }
    ListNode merge(ListNode left,ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        if(left.val < right.val){
         left.next = merge(left.next,right);
         return left;
        }else{
         right.next = merge(left,right.next);
         return right;
        }
    }
}