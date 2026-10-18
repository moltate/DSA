class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x, root =0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(mid <= x/mid){
                root = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return root;
    }
}