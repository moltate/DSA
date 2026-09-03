class Solution {
    public boolean uniformArray(int[] nums1) {
       int minOdd = Integer.MAX_VALUE,minEven = Integer.MAX_VALUE;
       return (minOdd ==Integer.MAX_VALUE) ? true : (minEven > minOdd);
    }
}