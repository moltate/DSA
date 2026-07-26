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