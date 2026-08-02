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

//Maximum Matching of Players with Trainers

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int player = 0;
        int trainer = 0;

        while (player < players.length && trainer < trainers.length) {

            if (trainers[trainer] >= players[player]) {
                player++;
                trainer++;
            } else {
                trainer++;
            }
        }

        return player;
    }
}


//Coin Change

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
        for(int coin : coins){
            if(coin <= i){
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        } 
      }
      return(dp[amount] > amount ? -1 : dp[amount]);
    }
}


//Permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>() , nums);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
          result.add(new ArrayList<>(temp));
          return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(result, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}

//Permutations II

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used =  new boolean[nums.length];
        backtrack(result, new ArrayList<>() , nums, used);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int  i = 0; i< nums.length; i++){
            if(used[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(result, temp, nums, used);
            temp.remove(temp.size() - 1);
            used[i]= false;
        }
    }
}
