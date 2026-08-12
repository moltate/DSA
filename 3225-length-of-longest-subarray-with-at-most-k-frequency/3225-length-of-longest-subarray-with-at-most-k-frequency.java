class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        int left = 0, ans = 0, n = nums.length;
        for(int right = 0; right < n; right++){
             freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
             while(freq.get(nums[right]) > k){
                  freq.put(nums[left], freq.get(nums[left]) - 1);
                  left++;
             }
             ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}