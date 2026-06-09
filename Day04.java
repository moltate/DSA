//Missing Number
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}

//Reverse String
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}

//Diameter of Binary Tree
class Solution {
    int diameter = 0 ;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }
    private int longestPath(TreeNode root){
        if (root == null) return 0;
      int leftPath = longestPath(root.left);
      int rightPath = longestPath(root.right);
      diameter = Math.max(leftPath + rightPath,diameter);
      return Math.max(leftPath,rightPath)+1;
    }
}


//Middle of Linked List
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

//Convert Sorted Array to Binary Search Tree
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length== 0) return null;
        return getBST(nums, 0, nums.length - 1);
    }

    public TreeNode getBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left+right) / 2;

        TreeNode bst = new TreeNode(nums[mid]);

        bst.left = getBST(nums, left, mid - 1);
        bst.right = getBST(nums, mid + 1, right);

        return bst;
    }
}
