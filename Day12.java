//Longest Harmonious Subsequence
class Solution {
    public int findLHS(int[] nums) {
      int result = 0;
      Map<Integer,Integer> count = new HashMap<>();
      for (int i : nums){
        count.put(i,count.getOrDefault(i,0) + 1);
      }
      for(int i : count.keySet()){
        if(count.containsKey(i+1)){
            result = Math.max(result,count.get(i) + count.get(i+1));
        }
      }
      return result;
    }
}


//Largest Positive Integer That Exists WIth Its Negative
class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int max = -1;
        for(int element: nums){
            if(Math.abs(element)> max){
                if(seen.contains(-element))
                 max = Math.abs(element);
                else
                seen.add(element);
            }
        }
        return max;
    }
}

//Find All Numbers Disappeared in an Array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]*= -1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}

//Summary Ranges
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int start = nums[i];
            while(i+1 <nums.length && nums[i+1] == nums[i] + 1){
                i++;
            }
            int end = nums[i];
            if(start == end){
                ans.add(String.valueOf(start));
            }else{
                ans.add(start+"->"+end);
            }
            i++;
        }
        return ans;
    }
}

//Find Missing Positive
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i=0;i<n ; i++){
            if(nums[i]<=0 || nums[i]>(n+1)){
                nums[i] = n + 1;
            }
        }
        for(int i =0 ;i<n; i++){
            int element = Math.abs(nums[i]);
            if(element ==n+1){
                continue;
            }
            int seat = element -1;
            if(nums[seat]>0){
                nums[seat] = -nums[seat];
            }
        }
        for (int i=0;i<n ; i++){
            if(nums[i]>0){
                return i +1;
            }
        }
        return (n+1);
    }
}
