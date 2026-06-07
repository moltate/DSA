//Maximum Subarray
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0; 
        int max = Integer.MIN_VALUE;
        for(int i =0 ;  i< nums.length ; i++ ){
            currentSum = currentSum + nums[i];
            if(currentSum > max){
                max = currentSum;
           }
           if(currentSum < 0){
            currentSum=0;
           }
        }
        return max;
    }
}

//Intersection of Two Arrays
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int n2 : nums2){
            set.add(n2);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int n1:nums1){
           if(set.contains(n1)){
            list.add(n1);
            set.remove(n1);
           }
        }
           int[] res= new int[list.size()];
           for(int i =0; i < list.size(); i++){
            res[i] = list.get(i);
           }
           return res;
        }
}

//Find Pivot Index
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0 ;
        for (int num:nums){
            totalSum+=num;
        }
        int leftSum=0;
        for (int i =0; i<nums.length;i++){
           int rightSum= totalSum-leftSum-nums[i];
        
        if(leftSum==rightSum){
            return i;
        }
        leftSum+=nums[i];
        }
    return -1;
    }
}

//Product of Array Except Self
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0]= 1;

        for(int i =1; i<n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int rightProduct=1;
        for (int i=n-1; i>=0; i--){
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return ans;

    }
}
