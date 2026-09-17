class Solution {
    public int minSumOfLengths(int[] arr, int k) {
        int n = arr.length;
        int ans = n+1, sum = 0, i = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        for(int j = 0; j< n; j++){
            sum += arr[j];
            while(sum>k)
                sum -= arr[i++];
                dp[j+1] = dp[j];
                if(sum == k){
                    ans = Math.min(ans, dp[i]+j -i+1);
                    dp[j+1] = Math.min(dp[j], j-i+1);
                }
        }
        return ans == n+1 ? -1 : ans;
    }
}