class Solution {
    static final long M1 = 1000000007L;
    static final long M2 = 1000000009L;
    static final long B = 911382323L;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long[] h1 = new long[n + 1], h2 = new long[n + 1], p1 = new long[n + 1], p2 = new long[n + 1];
        
        p1[0] = p2[0] = 1;
        for (int i = 0; i < n; i++) {
            p1[i + 1] = p1[i] * B % M1;
            p2[i + 1] = p2[i] * B % M2;

            h1[i + 1] = (h1[i] * B + nums[i]) % M1;
            h2[i + 1] = (h2[i] * B + nums[i]) % M2;
        }
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(nums, mid, h1, h2, p1, p2)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean check(int[] nums, int len, long[] h1, long[] h2, long[] p1, long[] p2){
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i + len <= nums.length; i++) {
            int j = i + len;
            long a = (h1[j] - h1[i] * p1[len] % M1 + M1) % M1;
            long b = (h2[j] - h2[i] * p2[len] % M2 + M2) % M2;
            long key = a * M2 + b;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int count : map.values()) {
            if (count == 1) return true;
        }
        return false;
    }
}
