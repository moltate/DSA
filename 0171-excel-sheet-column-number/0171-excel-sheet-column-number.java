class Solution {
    public int titleToNumber(String columnTitle) {
        long ans = 0;
        int c = columnTitle.length();
        for(int i =0; i< c; i++){
            ans = ans * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return (int) ans;
    }
}