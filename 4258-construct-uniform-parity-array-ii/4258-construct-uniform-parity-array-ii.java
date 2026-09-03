class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd= Integer.MAX_VALUE, minEven = Integer.MAX_VALUE ;

        for(int x : nums1){
            int ans = (x % 2 == 1) ? (minOdd = Math.min(minOdd,x)) : (minEven = Math.min(minEven,x));
        }  
        return (minOdd == Integer.MAX_VALUE) ? true : (minEven > minOdd ); 
    }
}