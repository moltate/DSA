//3Sum Closest
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int rs = nums[0] + nums[1] + nums[2];
        int minDiff = Integer.MAX_VALUE;
       for(int i=0; i<nums.length-2; i++){
              int left = i + 1, right= nums.length-1;
              while(left<right){
              int sum = nums[i] + nums[left] + nums[right];
        
              if(sum==target) return target;
              else if(sum< target) left++;
              else right--;

              int diffToTarget= Math.abs(sum-target);
              if(diffToTarget<minDiff){
                rs = sum;
                minDiff = diffToTarget;
              }
              }
       }
       return rs;
    }

}
//Subarrays With K Different Integers
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return atMost(nums,k)-atMost(nums,k-1);
    }
    public int atMost(int[] nums, int k){
        Map<Integer,Integer> Map = new HashMap<>();
        int left =0 , right = 0 , count = 0 ,n= nums.length;
        while(right<n){
            //expand
            Map.put(nums[right],Map.getOrDefault(nums[right],0)+1);
            //shrink
            while(Map.size()>k){
                Map.put(nums[left],Map.get(nums[left])-1);
                if(Map.get(nums[left])==0){
                    Map.remove(nums[left]);
                }
                left++;
            }
            count += (right - left + 1);
            right++;
        }
        return count;
    }
}
