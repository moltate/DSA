class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        List<Integer> index = new ArrayList<>();

        int idx = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {

            ListNode next = curr.next;

            boolean isMax = curr.val > prev.val && curr.val > next.val;
            boolean isMin = curr.val < prev.val && curr.val < next.val;

            if (isMax || isMin) {
                index.add(idx);
            }

            prev = curr;
            curr = next;
            idx++;
        }

        if (index.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDist = Integer.MAX_VALUE;

        for (int i = 1; i < index.size(); i++) {
            int distance = index.get(i) - index.get(i - 1);
            minDist = Math.min(minDist, distance);
        }

        int maxDist = index.get(index.size() - 1) - index.get(0);

        return new int[]{minDist, maxDist};
    }
}