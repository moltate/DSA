class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewels = new boolean[128];
        for(char ch: jewels.toCharArray()){
            isJewels[ch] = true;
        }
        int count = 0;
        for(char ch: stones.toCharArray()){
            if(isJewels[ch]) count++;
        }
        return count;
    }
}