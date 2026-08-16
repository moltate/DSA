class Solution {
    public int stoneGameVIII(int[] stones) {
        int sum = 0;
        for(int stone:stones){
            sum+=stone;
        }
        int diff = sum;
        for(int i =stones.length-1;i>=2;i--){
            sum -= stones[i];
            diff= Math.max(diff,sum-diff);
        }
        return diff;
    }
}