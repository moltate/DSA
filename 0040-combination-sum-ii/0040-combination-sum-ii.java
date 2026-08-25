class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> value = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(value,new ArrayList<Integer>(), candidates, target, 0);
        return value;
    }
    public void backtrack(List<List<Integer>> value, List<Integer> ans, int[] nums, int remaining, int start){
        if(remaining<0){
             return;
        }     
        else if(remaining == 0 ){
            value.add(new ArrayList<>(ans));
        }else{
            for(int i = start; i<nums.length;i++){
               if(i>start && nums[i] == nums[i-1]) continue;
               ans.add(nums[i]);
               backtrack(value, ans, nums, remaining-nums[i], i+1);
               ans.remove(ans.size() - 1);
            }
        }
    }
}