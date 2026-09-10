class Solution {
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
        int ans = 0;
    public int[] dfs(TreeNode node){
        if(node == null) return new int[]{0,0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;
        if(sum / count == node.val) ans++;
        return new int[]{sum, count};
    }
}