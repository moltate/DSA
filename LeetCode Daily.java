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


// Minimum Cost to Acquire Required items

class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        return Math.max(bound(need1, cost1, need2, cost2, costBoth), bound(need2, cost2, need1, cost1, costBoth));
    }

    private long bound(long needA, int costA, long needB, int costB, int costBoth) {
        int pA = Math.min(costA, costBoth);  
        int pB = Math.min(costB, costBoth - pA);  
        return needA * pA + needB * pB;
    }
}


//Longest Strictly Increasing or Strictly Decreasing Subarray

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int best = 1, up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            up = nums[i - 1] < nums[i] ? up + 1 : 1; 
            down = nums[i - 1] > nums[i] ? down + 1 : 1; 
            best = Math.max(best, Math.max(up, down));
        }
        return best;
    }
}
