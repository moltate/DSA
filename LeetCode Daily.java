//Smallest Missing Multiple of K
class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> value = new HashSet<>();
        for(int num : nums){
            value.add(num);
        }
        int curr = k;
        while(value.contains(curr)){
            curr += k;
        }
        return curr;
    }
}

//Climbing stairs II

class Solution {
    public int climbStairs(int n, int[] costs) {
        costs = IntStream.concat(IntStream.of(0), Arrays.stream(costs)).toArray();
        int a = costs[n], b = Integer.MAX_VALUE / 2, c = Integer.MAX_VALUE / 2;
        for (int i = n - 1; i >= 0; i--) {
            int cur = costs[i] + Math.min(a + 1, Math.min(b + 4, c + 9));  
            c = b;
            b = a;
            a = cur;
        }
        return a;
    }
}