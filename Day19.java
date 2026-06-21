//Maximum Sum Circular Subarray
class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int currMax = 0;
        int maxSum = nums[0];

        int currMin = 0;
        int minSum = nums[0];

        for (int num : nums) {

            totalSum += num;
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        } 

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}

//Maximum Absolute Sum of Any Subarray

class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int currMax = 0;
        int maxSum = 0;

        int currMin = 0;
        int minSum = 0;

        for (int num : nums) {

            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}

//K-th Largest Sum Contiguous Subarray

class Solution {
    public static int kthLargest(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += arr[j];

                if (pq.size() < k) {
                    pq.offer(sum);
                }
                else if (sum > pq.peek()) {
                    pq.poll();
                    pq.offer(sum);
                }
            }
        }

        return pq.peek();
    }
}
