class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        int i = 1, n = nums.length;

        while(i<n && nums[i] == nums[i - 1] + 1){
            sum += nums[i];
            i++;
        }

        Set<Integer> set =new HashSet<>(n);
        
        for(int num : nums){
            set.add(num);
        }
        while(set.contains(sum)){
            sum++;
        }
        return sum;
    }
}