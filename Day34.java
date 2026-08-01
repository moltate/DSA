//Minimum Number of Pushes to Type Word II


class Solution {

    public int minimumPushes(String word) {

        int[] freq = new int[26];

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int position = 0;

        for (int i = 25; i >= 0; i--) {

            if (freq[i] == 0)
                break;

            ans += freq[i] * ((position / 8) + 1);

            position++;
        }

        return ans;
    }
}


//Predict the Winner

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int left = nums[i] - dp[i + 1][j];
                int right = nums[j] - dp[i][j - 1];
                dp[i][j] = Math.max(left, right);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
