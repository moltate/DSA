class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        for(int i = 1 ; i < n; i++){
            if(nums[i] < nums[left]) left = i;
            if(nums[i] > nums[right]) right = i;
        }
        int leftIdx = Math.min(left, right);
        int rightIdx = Math.max(left, right);
        
        int front =  rightIdx + 1, back = n - leftIdx;
        int both = (leftIdx + 1) + (n - rightIdx);

        return Math.min(front, Math.min(back, both));
    }
}