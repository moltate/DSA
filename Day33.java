//Smallest Palindromic Rearrangement 1

class Solution {
    public String smallestPalindrome(String s) {

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        char[] ans = new char[s.length()];

        int left = 0;
        int right = s.length() - 1;

        for (int i = 0; i < 26; i++) {

            while (count[i] >= 2) {
                ans[left] = (char) ('a' + i);
                ans[right] = (char) ('a' + i);

                left++;
                right--;
                count[i] -= 2;
            }

            if (count[i] == 1) {
                ans[s.length() / 2] = (char) ('a' + i);
            }
        }

        return new String(ans);
    }
}

//Combination Sum

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int[] candidates, int target, int index,
                       List<Integer> list, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }
        
        list.add(candidates[index]);
        helper(candidates, target - candidates[index], index, list, ans);
        list.remove(list.size() - 1);

        helper(candidates, target, index + 1, list, ans);
    }
}

//Jump Game

class Solution {
    public boolean canJump(int[] nums) {

        int n = nums.length;
        int goal = n - 1;

        for (int i = n - 2; i >= 0; i--) {

            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}

//4Sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n - 3; i++){
            if(i > 0 && nums[i]==nums[i -1])
            continue;
            for(int j = i + 1; j < n-2; j++){
                if(j> i+1 && nums[j]==nums[j - 1])
                continue;
                int left = j + 1;
                int right = n -1;
                while(left<right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++; right--;
                        while(left<right && nums[left] == nums[left -1])
                            left++;
                            while(left<right && nums[right] == nums[right+1])
                            right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}

//Minimum Path Sum

class Solution {

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                else if (i == 0)
                    grid[i][j] += grid[i][j - 1];

                else if (j == 0)
                    grid[i][j] += grid[i - 1][j];

                else
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}