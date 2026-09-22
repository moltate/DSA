class Solution {
    public int findNthDigit(int n) {
        long dig = 1, cnt = 9, start =1;
        while(n > cnt * dig){
            n -= cnt * dig;
            dig++;
            start *= 10;
            cnt *= 10;
        }
        long num = start + (n - 1) / dig;
        int i = (int)((n-1)%dig);
        return String.valueOf(num).charAt(i) - '0';
    }
}