class Solution {
    public boolean uniformArray(int[] nums1) {
        int ans = Integer.MAX_VALUE;
        int min = ans;
        for(int x : nums1){
            if(x % 2 == 1){
                min = Math.min(min,x);
            }
        }
        for(int x : nums1){
            if(x % 2 == 0 && min != ans && x < min){
                return false;
            }
        }
        return true;        
    }
}