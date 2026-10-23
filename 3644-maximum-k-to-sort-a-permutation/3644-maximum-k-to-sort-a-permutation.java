class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length, res =-1;
        for(int i =0; i <n; i++){
            if(nums[i] == i) continue;
            if(res == -1) res = nums[i];
            res = res & nums[i];
        }
        if(res==-1) return 0;
        return res;
    }
}