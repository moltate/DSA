class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_00_00_00_007;
        long count = 0, even = 1, odd = 0, sum = 0;
        for(int num : arr){
            sum += num;
            if(sum % 2 == 0){
                count += odd;
                even++;
            }else{
                count += even;
                odd++;
            }
            count %= MOD;
        }
        return (int) count;
    }
}