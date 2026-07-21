//Count and Say

class Solution {
    public String countAndSay(int n) {
        String curr = "1";
        for(int i = 2; i <= n ; i++){
            StringBuilder next = new StringBuilder();
            int count = 1;
            for(int j = 0; j < curr.length(); j++){
              while( j + 1< curr.length() && curr.charAt(j) == curr.charAt(j+1)){
                count++; 
                j++;
              }
              next.append(count);
               next.append(curr.charAt(j));
              count = 1;
            }
            curr = next.toString();
        }
        return curr;
    }
}
