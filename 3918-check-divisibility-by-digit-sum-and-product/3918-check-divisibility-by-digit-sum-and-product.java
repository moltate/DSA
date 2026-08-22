class Solution {
    public boolean checkDivisibility(int n) {
        int num = n, digitSum = 0, digitProduct = 1;
        while (n > 0) {
            int digit = n % 10;
            digitSum += digit;
            digitProduct *= digit;
            n /= 10;
        }
        return num%(digitSum + digitProduct) == 0;
    }
}