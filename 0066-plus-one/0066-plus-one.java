class Solution {
    public int[] plusOne(int[] digits) {
        int d = digits.length;
        int[] ans = new int[d+1];
        ans[0] = 1;
        for(int i = d - 1; i >= 0; i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        return ans;
    }
}