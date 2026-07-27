//Length of Last Word

class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() -1;
        
        while(i >=0 && s.charAt(i) == ' '){
            i--;
        }
        int length = 0;
        while(i >= 0 && s.charAt(i) != ' '){
            length++;
            i--;
        }
        return length;
    }
}

//Happy Number

class Solution {

    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public int squareSum(int n) {

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}

//Maximum Product of the Numbers


class Solution {
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        return Math.max(
            nums[0] * nums[1] * nums[n - 1],
            nums[n - 1] * nums[n - 2] * nums[n - 3]
        );
    }
}

//Maximum Product of Two Elements in an Array

class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        for(int num : nums){
            if(num > max1){
                max2 = max1;
                max1 = num;
            }else if(num > max2){
                max2 = num;
            }
        }
        return (max1 -1 ) * (max2 -1);
    }
}

//Maximum Product of Two Digits

class Solution {
    public int maxProduct(int n) {
        int max1 = 0 ;
        int max2 = 0;
        
        while(n > 0){
            int num = n % 10;
            if(num > max1){
                max2 = max1;
                max1 = num;
            }else if(num> max2){
                max2 = num;
            }
            n = n/10;
        }
        return max1 * max2;
    }
}

//Excel Sheet Column Title

class Solution {
    public String convertToTitle(int columnNumber) {
        String ans = "";
        int n = columnNumber;
        
        while(n>0){
            n--;
            ans = (char)('A' + n % 26) + ans;
            n= n/26;
        }
        return ans;
    }
}