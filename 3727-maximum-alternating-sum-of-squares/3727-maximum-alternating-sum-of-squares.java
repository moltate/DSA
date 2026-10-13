class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] a = new long[nums.length];
        //Squaring every number into an array 
        for(int i = 0; i < nums.length; i++) a[i] = (long) nums[i] * nums[i];
        //Sort (small on left , big on right)
        Arrays.sort(a);
        long ans = 0;
        //Counting minus place
        int k = nums.length/2;
        for(int i = 0; i< k; i++)
        //Subtract the first k square
           ans -= a[i];
        for(int i = k; i < nums.length; i++)
        //Adding all the other squares
           ans += a[i];
           
        return ans;
    }
}