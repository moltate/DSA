//Smallest Missing Multiple of K
class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> value = new HashSet<>();
        for(int num : nums){
            value.add(num);
        }
        int curr = k;
        while(value.contains(curr)){
            curr += k;
        }
        return curr;
    }
}
