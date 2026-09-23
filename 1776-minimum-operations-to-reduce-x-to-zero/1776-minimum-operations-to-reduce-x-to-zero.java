class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length, total = 0;
        for(int a : nums) total+= a;
        int goal = total - x;
        if(goal < 0) return -1;
        if(goal == 0) return n;
        int l = 0, sum = 0, big = -1;
        for(int r = 0; r < n; r++){
            sum += nums[r];
            while(l <= r && sum>goal) sum -= nums[l++];
            if(sum == goal)
            big = Math.max(big, r - l + 1);
        }
        return big == -1 ? -1:n - big;
    }
}