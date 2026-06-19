//Find the Highest Altitude
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;
        for (int g : gain){
             curr += g;
             max = Math.max(curr, max);
        }
        return max;
    }
}

//Sliding Window Maximum
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length, index = 0;
        int[] res =  new int[n - k + 1];
        while(index<k){
          while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[index]){
            deque.pollLast();
          }
          deque.offerLast(index);
          index++;
        }
        res[0] = nums[deque.peekFirst()];
        for(int i = 1; i < n - k + 1; i++){
          if(!deque.isEmpty() && deque.peekFirst() <= (i - 1)){
            deque.pollFirst();
          }
          while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i+k-1]){
            deque.pollLast();
          }
          deque.offerLast(i+k-1);
          res[i] = nums[deque.peekFirst()];
        }
        return res;
    }
}

//Find Middle Index in an Array
class Solution {
    public int findMiddleIndex(int[] nums) {
        int tS = 0;
        for (int num: nums){
            tS+=num;
       }
       int lS=0,n=nums.length;
       for (int i=0; i<n; i++){
        int rS = tS-lS-nums[i];
        if(lS==rS) return i;
        lS+=nums[i];
       }
       return -1;
    }
}

//Subarray Sums Divisible by K
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int prefix = 0, count = 0;

        for (int num: nums){
             prefix += num;
             int rem = ((prefix % k)+ k) % k;
             count += map.getOrDefault(rem, 0);
             map.put(rem, map.getOrDefault(rem,0)+1);
        }
       return count;
    }
}

//Maximum Product Subarray in an Array
class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd= nums[0], ans = nums[0];
        for (int i = 1 ; i<nums.length; i++){
            if(nums[i]<0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);
            ans = Math.max(ans,maxProd);
        }  
        return ans;      
    }
}
