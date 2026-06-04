//Invert Binary Tree
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

    return root;
    }
}

//Valid Anagram
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq= new int[26];

        for(int i=0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int count : freq){
            if ( count !=0 ){
                return false;
            }
        }
        return true;
    }
}

//Binary Search
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target) return mid;
            if (nums[mid]< target){ 
                low = mid+1;
            }else{
                high = mid -1;
            }
            
        }
        return -1;
    }
}

//Linked List Cycle
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow =head;
        ListNode fast =head;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}

//Maximum Depth Of Binary Tree
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return  1 + Math.max(leftDepth, rightDepth);
    }
}
