class Solution {
    int[] price, count;
    int[][] memo;
    int minPrice, n;
    public int maximumSaleItems(int[][] items, int budget) {
        n = items.length;
        price = new int[n];
        count = new int[n];
        minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int factor = items[i][0];
            price[i] = items[i][1];
            minPrice = Math.min(minPrice,price[i]);
            for(int j = 0; j < n; j++){
                if(items[j][0] % factor == 0) count[i]++;
            }
        }
        memo = new int[n+1][budget+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        return solve(0,budget);
    }
    int solve(int index, int remainingBudget){
        if(index == n) return remainingBudget/minPrice;
        if(memo[index][remainingBudget] != -1) return memo[index][remainingBudget];
        int skip = solve(index+1, remainingBudget);
        int take= 0; 
        if (price[index] <= remainingBudget) {
            take = count[index] + solve(index + 1, remainingBudget - price[index]);
        }
        return memo[index][remainingBudget] = Math.max(skip,take);
    }
}