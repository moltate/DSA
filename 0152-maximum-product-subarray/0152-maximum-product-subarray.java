class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for(int i = 1; i<nums.length; i++){
            int x = nums[i], oldMax = max, oldMin = min;
            max = Math.max(x, Math.max(x*oldMax,x*oldMin));
            min = Math.min(x,Math.min(x*oldMax,x*oldMin));
            result = Math.max(result, max);
        }
        return result;
    }
}