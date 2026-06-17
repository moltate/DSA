//Fruit Into Baskets
class Solution {
    public int totalFruit(int[] fruits) {
      Map<Integer,Integer> basket = new HashMap<>();
        int max = 0, left = 0; 
      for(int right =0 ; right<fruits.length; right++){
             basket.put(fruits[right], basket.getOrDefault(fruits[right],0) + 1);
        while (basket.size()>2){
             basket.put(fruits[left],basket.get(fruits[left]) - 1);
             if(basket.get(fruits[left]) == 0){
                basket.remove(fruits[left]);
            }
            left++;
        }
           max=Math.max(max, right - left + 1);
      }
      return max;
    }
}

//Minimize Size Subarray Sum
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1 , window = 0, left = 0;
        for (int right  = 0 ; right <nums.length; right++){
              window += nums[right];
              while ( window >= target){
                min =  Math.min(min, right - left + 1);
                window -= nums[left++];
              }
        }
         return min == nums.length + 1 ? 0 : min; 
    }
}
