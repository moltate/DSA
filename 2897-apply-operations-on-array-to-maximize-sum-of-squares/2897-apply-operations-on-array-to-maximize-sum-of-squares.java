class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long ans = 0, mod = 1000000007;
        int[] bit = new int[30];
        for(int x : nums){
            for(int i = 0; i< 30; i++){
                if((x & (1 << i)) != 0) bit[i]++;
            }
        }
        while (k-- > 0){
            long x = 0;
            for(int i = 0; i< 30; i++){
                if(bit[i] > 0){
                    x |= 1L << i;
                    bit[i]--;
                }
            }
            ans = (ans + x * x) % mod;
        }
        return (int) ans;
    }
}