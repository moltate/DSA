class Solution {
    public boolean isRectangleOverlap(int[] A, int[] B) {
        if(A[0] == A[2] || A[1] == A[3] || B[0] == B[2] || B[1] == B[3]) return false;
        return !(A[2] <= B[0] || A[3] <= B[1] || A[0] >= B[2] || A[1] >= B[3]);
    }
}