//Count Complete Tree Nodes

class Solution {

    public int countNodes(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1
                + countNodes(root.left)
                + countNodes(root.right);
    }

    public int leftHeight(TreeNode node) {

        int height = 0;

        while (node != null) {
            height++;
            node = node.left;
        }

        return height;
    }

    public int rightHeight(TreeNode node) {

        int height = 0;

        while (node != null) {
            height++;
            node = node.right;
        }

        return height;
    }
}


//Search a 2D Matrix II

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] > target) {

                col--;

            } else {

                row++;
            }
        }

        return false;
    }
}

//Find the Duplicate Number

class Solution {

    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}


//Intersection of Two Arrays 2

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums2) {

            if (map.getOrDefault(num, 0) > 0) {

                list.add(num);

                map.put(num, map.get(num) - 1);
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}

//Remove Element

class Solution {

    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {

                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}