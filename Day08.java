//Richest Customer Wealth
class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth=0;

        for ( int[] customer: accounts){
            int wealth=0;
            for(int bank: customer){
                wealth+=bank;
            }
            maxWealth = Math.max(maxWealth,wealth);
        }
        return maxWealth;

    }
}

//Search in a Binary Search Tree
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
      while(root != null && root.val != val){
        root= val< root.val ? root.left : root.right;
      }
      return root;
    }
}

//Search in Rotated Sorted Array
class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        while (left<=right){
            int mid= left+ (right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[left] <= nums[mid]){
                if(nums[left]<=target && target < nums[mid])
                right = mid-1;
            else
                left =mid +1;
            }else{
                if(nums[mid] <target && target<= nums[right])
              left =mid + 1;
            else
                right =mid-1;
            }
        }
    return -1;
}
}

//Find Minimum in Rotated Sorted Array
class Solution {
    public int findMin(int[] nums) {
        int left =0, right = nums.length-1;
        while (left<right){
         int mid= left + (right-left)/2;
         if(nums[mid] > nums[right]){
            left = mid +1;
         }else{
            right =mid;
         }
        }
        return nums[left];
    }
}
//Koko Eating Bananas
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1, right=0;
        for(int pile: piles) right =Math.max(right,pile);
        while(left<right){
            int mid = left + ( right - left) / 2;
            long hours = 0;
            for ( int pile : piles){
                hours += (pile + mid -1) / mid;
            }
            if(hours <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
