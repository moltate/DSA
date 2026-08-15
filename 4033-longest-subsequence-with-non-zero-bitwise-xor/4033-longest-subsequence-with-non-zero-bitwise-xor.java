class Solution {
    public int longestSubsequence(int[] nums) {
        int val = 0;
        boolean hasNonZero = false;
        for(int x:nums){
            val ^= x; 
            if(x != 0 ) hasNonZero = true;
        }
            if(val != 0) return nums.length;
            if(hasNonZero) return nums.length - 1;
            return 0;
    }
}