class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums)
            max = Math.max(max, num);
        long result = 0;
        for(int num : nums) 
            result += (max - num);
        return (int) result;
    }
}