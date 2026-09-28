class Solution {
    public String convertToTitle(int cn) {
        String ans = "";
        while(cn > 0){
            cn--;
            ans = (char)('A' + cn % 26) + ans;
            cn /= 26;
        }
        return ans;
    }
}