class Solution {
    static final int MOD = 1_000_000_007;
    long[][] comb;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return (int) ((solve(list) - 1 + MOD) % MOD);
    }
    long solve(List<Integer> nums) {
        int n = nums.size();
        if (n <= 2) return 1;
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int num = nums.get(i);

            if (num < root)
                left.add(num);
            else
                right.add(num);
        }
        long leftWays = solve(left);
        long rightWays = solve(right);
        long ways = comb[n - 1][left.size()];
        ways = ways * leftWays % MOD;
        ways = ways * rightWays % MOD;
        return ways;
    }
}
