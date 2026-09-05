class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minVal = new int[n];
        minVal[n - 1] = nums[n - 1];
        for(int i = n - 2; i >=0; i--){
            minVal[i] = Math.min(minVal[i+1], nums[i]);
        }
        int maxVal = 0;
        for(int i = 0; i < n; i++){
            maxVal = Math.max(maxVal, nums[i]);
            int ans = maxVal - minVal[i];
            if(ans <= k) return i;
        }
        return -1;
    }
}