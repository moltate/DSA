//Capacity To Ship Packages Within D Days
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int w : weights){
           left = Math.max(left,w);
           right +=w;
        }
        while(left<right){
            int mid = left + (right-left)/2;
            if(canShip(weights, mid, days))
            right = mid;
            else
            left = mid +1;
        }
        return left;

    }
public boolean canShip(int[] weights, int capacity, int days){
         int daysNeeded =1, currentLoad = 0;
         for (int w : weights){
            if(currentLoad + w > capacity){
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += w;
         }
         return daysNeeded<= days;
}
}

//Climbing Stairs
class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int prev2 = 1, prev1 =2;
        for(int i = 3; i<=n ; i ++){
            int curr = prev1 + prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;    
    }
}

//Symmetric Tree
class Solution {
    public boolean isSymmetric(TreeNode root) {
     if( root == null ) return true;
      return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode left, TreeNode right){
        if( left == null && right == null) return true;
        if( left == null || right == null) return false;

        return left.val==right.val && isMirror(left.left,right.right) && isMirror(left.right, right.left);
    }
}

// Best Time to Buy and Sell Stock II
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0 ;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit +=  prices[i] - prices[i-1] ;
            }
        }
        return profit;
    }
}
