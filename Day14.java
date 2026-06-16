//Maximum Sum of Distinct Subarray with length k
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans =0, cs=0;
        int begin = 0,end = 0;
        Map<Integer,Integer> ls = new HashMap<>();
        while (end<nums.length){
           int curr = nums[end];
           int j = ls.getOrDefault(curr, -1);

           while(j>=begin || (end-begin+1)>k){
             cs -=nums[begin++];
           }
           cs+=nums[end];
           ls.put(curr,end);
           if(end-begin+1 == k ){
            ans=Math.max(ans,cs);
           }
           end++;
        }
        return ans;
    }
}

//Max Consecutive Ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            if(nums[i]==0 || i == nums.length-1){
                max = Math.max(max,count);
                count = 0;
            }
        }
        return max;
    }
}

//Max Consecutive Ones III
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, ans=0, sum =0, n = nums.length;

        for(int right=0;right<nums.length;right++){
            sum += nums[right];
            while(sum+k<right-left+1){
                sum -= nums[left];
                left++;
            }
            ans = Math.max(ans,right -left + 1);
        }
        return ans;
    }
}

//Subarray Product Less Than K
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1, count = 0, start = 0,end = 0, n= nums.length;
        if(k <= 1) return 0;

        while(end < n){
              prod *= nums[end];
              while(prod>=k){
                prod /= nums[start]; 
                start++;
              }
              count += (end - start + 1); 
              end++;
        }
        return count;
    }
}
