class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, p = 0;
        for(int i =0; i < n; i++){
            if (nums[i] == 0) {
                p = i;
                break;
            }
        }
        boolean increase = true, decrease = true;
        for(int i = 0; i<n; i++){
            int next = nums[(i+1) % n];
            if(next != (nums[i] + 1) % n) increase = false;
            if(next != (nums[i] - 1 + n) % n) decrease = false;
        }
        int ans = Integer.MAX_VALUE;
        if(increase)
            ans = Math.min(ans, Math.min(p, n - p + 2));
        if(decrease)
            ans = Math.min(ans, Math.min(p+2, n - p));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}