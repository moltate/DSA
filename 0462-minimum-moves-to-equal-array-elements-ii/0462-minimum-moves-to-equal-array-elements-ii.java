class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, mid = nums[n/2];
        long moves = 0;
        for(int num:nums){
            moves += Math.abs(num - mid);
        }
        return (int) moves;
    }
}