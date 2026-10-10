class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int[] freq = new int[100001];
        int maxDiff = 0;
        long totalDiff = 0;

        for(int i = 0; i < nums1.length; i++){
            int diff =  Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            totalDiff += diff;
            maxDiff = Math.max(maxDiff,diff);
        }
        long k = (long) k1 + k2;
        if(totalDiff <= k) return 0;

        for(int d = maxDiff; d > 0 && k > 0; d--){
            int moves = (int) Math.min(k, (long) freq[d]);
            freq[d] -= moves;
            freq[d-1] += moves;
            
            k -= moves;
        }
        long ans = 0;
        for(int d = 1 ; d <= maxDiff ; d++){
            ans += (long) d*d*freq[d];
        }
        return ans;
    }
}