class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, aS = 0;
        int eS = n*(n + 1)/2;
        for(int num: nums){
            aS += num;
        }
        return eS-aS;
    }
}