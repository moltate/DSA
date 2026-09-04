class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = nums[i];
            for(int j = i; j<nums.length; j++)
            min = Math.min(min,nums[j]);
            int ans = max - min;
            if(ans<=k) return i;
        }
        return -1;
    }
}