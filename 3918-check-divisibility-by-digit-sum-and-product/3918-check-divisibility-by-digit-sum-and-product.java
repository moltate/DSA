class Solution {
    public boolean checkDivisibility(int n) {
        int num = n, digitSum = 0, digitProduct = 1;
        while (n > 0) {
            digitSum += n % 10;
            digitProduct *= n % 10;
            n /= 10;
        }
        return num%(digitSum + digitProduct) == 0;
    }
}