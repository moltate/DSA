class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int i = 0;
        for(int n : arr1){
            if(isValid(n, arr2, d)) i++;
        }
        return i;
    }
    public boolean isValid(int n, int[] arr, int d){
        for(int j : arr){
            if(Math.abs(j - n) <= d) return false;
        }
        return true;
    }
}