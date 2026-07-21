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

//String Compression

class Solution {
    public int compress(char[] chars) {
        int read = 0, write = 0 ;
        while(read<chars.length){
            char curr = chars[read];
            int count = 0;
            while(read<chars.length && chars[read] == curr){
                count++;
                read++;
            }
            chars[write++] = curr;
            if(count>1){
                for(char c : String.valueOf(count).toCharArray()){
                    chars[write++]=c;
                }
            }
        }
        return write;
    }
}
