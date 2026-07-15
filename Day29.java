//Kth Largest Element in an Array

class Solution {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}

//Merge Intervals

class Solution {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] last = result.get(result.size() - 1);

            if (intervals[i][0] <= last[1]) {

                last[1] = Math.max(last[1], intervals[i][1]);

            } else {

                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
