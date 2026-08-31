class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int idx = 1, first = -1, last = -1;
        int minDist = Integer.MAX_VALUE;

        while (curr.next != null) {
            ListNode next = curr.next;
            boolean isMax = curr.val > prev.val && curr.val > next.val;
            boolean isMin = curr.val < prev.val && curr.val < next.val;

            if (isMax || isMin) {
                if(last == -1){
                    first = idx;
                }else{
                    minDist = Math.min(minDist, idx -  last);
                }
                last = idx;
            }

            prev = curr;
            curr = next;
            idx++;
        }

        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        int maxDist = last - first;

        return new int[]{minDist, maxDist};
    }
}