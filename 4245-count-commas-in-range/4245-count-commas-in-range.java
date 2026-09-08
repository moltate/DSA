class Solution {
    public int countCommas(int n) {
      int ans = 0;
      for(int i = 0; i <= n; i++){
          if(i > 999){
            ans += 1;
          }
      }  
      return ans;
    }
}