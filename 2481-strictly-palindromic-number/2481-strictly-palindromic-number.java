class Solution {
    public boolean isStrictlyPalindromic(int n) {
        boolean value = true;
        for(int i=2;i<n-1;i++){
            if(!check(Integer.toString(n,i))){
               value = false;
               break;
            }
        }
        return value;
    }
    public boolean check(String n){
        int left = 0, right = n.length()-1;
        while(left<right){
            if(n.charAt(left) != n.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
}