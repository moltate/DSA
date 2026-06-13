//Set Matrix Zeroes
class Solution {
    public void setZeroes(int[][] matrix) {
         int m = matrix.length;
         int n = matrix[0].length;

         ArrayList<Integer> r = new ArrayList<>();
         ArrayList<Integer> c = new ArrayList<>();

         for(int i = 0; i < m ; i++){
            for(int j = 0; j< n; j++){
                if(matrix[i][j] == 0){
                    r.add(i);
                    c.add(j);
                }
            }
         }
         for(int i=0; i< r.size(); i++){
            int index = r.get(i);
            for (int j = 0 ; j < n ; j++){
                matrix[index][j] = 0;
            }
         }
         for(int i=0; i< c.size(); i++){
            int index = c.get(i);
            for(int j = 0 ; j < m; j++){
                matrix[j][index] = 0;
            }
         }
    }
}

//Sort Colors
class Solution {
    public void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int index = 0;
        while(index<=end){
            if(nums[index] == 0){
                swap(nums,index,start);
                index++;
                start++;
                }else if(nums[index] == 2){
                    swap(nums,index,end);
                    end--;
                }else{
                    index++;
                }
            }
        }
    }

//Subarray Sum Equals to K
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); 

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

//Binary Subarrays With Sum
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); 

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - goal)) {
                count += map.get(prefixSum - goal);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

//Count Number of Nice Subarray
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); 

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num % 2;
            count += map.getOrDefault(prefixSum - k, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

//Continuous Subarray Sum
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = (prefixSum % k);
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}

//Contiguous Array
class Solution {
    public int findMaxLength(int[] nums) {
        int length =0;
        int sum =0;
        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0,-1);
        for (int i=0; i<nums.length; i++){
            if(nums[i]==0){
                sum--;
            }else{
                sum++;
            }
            if(map.containsKey(sum)){
                length = Math.max(length, i - map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return length;
    }
}
