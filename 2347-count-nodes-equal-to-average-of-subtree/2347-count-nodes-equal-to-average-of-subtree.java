class Solution {
    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        trav(root);
        return ans;
    }

    private int[] trav(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = trav(root.left);
        int[] right = trav(root.right);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        if (sum / count == root.val) ans++;
        return new int[]{sum,count};
    }
}