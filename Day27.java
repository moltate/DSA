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