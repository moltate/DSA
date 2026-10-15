class Solution {
    public int sumCounts(List<Integer> nums) {
        int result = 0;
        for(int i = 0; i < nums.size();i++){
            Set<Integer> ans = new HashSet<>(); // storing collection of element
            for(int j = i; j < nums.size(); j++){
                ans.add(nums.get(j));
                int count = ans.size();
                result += count*count; //squaring
            }
        }
        return result;
    }
}