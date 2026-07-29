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