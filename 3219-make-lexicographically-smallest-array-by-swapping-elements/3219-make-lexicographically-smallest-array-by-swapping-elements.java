class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] srt = nums.clone();
        Arrays.sort(srt);

        List<List<Integer>> grps = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int id = -1;
 
        for(int i = 0; i < srt.length; i++){
            if(i == 0 || srt[i] - srt[i - 1] > limit){
                grps.add(new ArrayList<>());
                id++;
            }
            grps.get(id).add(srt[i]);
            map.put(srt[i], id);
        }       
        
        int[] idx =  new int[grps.size()];

        for(int i = 0; i < nums.length; i++){
            int curr = map.get(nums[i]);
            nums[i] = grps.get(curr).get(idx[curr]);
            idx[curr]++;
        }        
        return nums;
    }
}