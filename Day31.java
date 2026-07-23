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

//Letter Combinations of a Phone Number

class Solution {
     List<String> ans = new ArrayList<>();

    String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)   return ans;
        backtrack(digits,0,"");
        return ans;
    }
    public void backtrack(String digits, int index, String curr){
        if(index == digits.length()){
            ans.add(curr);
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++){
            backtrack(digits, index + 1, curr + letters.charAt(i));
        }
    }
}

//Subsets

class Solution {
     List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>>  subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }
    
    public void backtrack(int[] nums, int index, List<Integer>curr){
        if(index == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        backtrack(nums, index +1, curr);
        curr.remove(curr.size()-1);
        backtrack(nums, index +1, curr);
    }
}

//Multiply Strings

class Solution {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') *
                          (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int num : result) {

            if (!(ans.length() == 0 && num == 0)) {
                ans.append(num);
            }
        }

        return ans.toString();
    }
}