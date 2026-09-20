class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i = 0; i<s.length(); i++){
            char c =s.charAt(i);
            int reverseVal = 26 -(c - 'a');
            int pos = i+1;
            sum += reverseVal * pos;
        }
        return sum;
    }
}