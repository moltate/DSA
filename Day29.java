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

//Zigzag Conversions

class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char ch : s.toCharArray()) {

            rows[currentRow].append(ch);

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        StringBuilder answer = new StringBuilder();

        for (StringBuilder row : rows) {
            answer.append(row);
        }

        return answer.toString();
    }
}
