class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length, minPrice = Integer.MAX_VALUE;
        int[] freq = new int[n + 1];

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }
        int[] count = new int[n + 1];
        for (int factor = 1; factor <= n; factor++) {
            for (int j = factor; j <= n; j += factor) {
                count[factor] += freq[j];
            }
            count[factor]--;
        }
        List<int[]> deals = new ArrayList<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (count[factor] > 0 && (long) price < 2L * minPrice) {
                deals.add(new int[]{price, count[factor]});
            }
        }
        deals.sort((a, b) -> Integer.compare(a[0], b[0]));
        int answer = 0;
        for (int[] deal : deals) {
            int price = deal[0];
            int available = deal[1];
            int buy = Math.min(available, budget / price);
            answer += buy * 2;
            budget -= buy * price;
        }
        answer += budget / minPrice;
        return answer;
    }
}