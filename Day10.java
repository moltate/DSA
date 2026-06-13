//Count Negative Numbers in a Sorted Matrix
class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] row : grid){
            for(int num : row){
                if(num < 0)
                count++;
            }
        }
        return count;
    }
}

//Next Permutation
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length -2;
        while(i >= 0  && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length -1 ;
            while(j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums,i,j);
        }
        reverse (nums, i+1);
    }
    public void swap(int[] nums, int i, int j ){
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse (int[] nums, int start){
        int end = nums.length -1;
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}

//Longest Consecutive Sequence
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int currentNum = num;
                int length = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}

//Largest Number
class Solution{
    public String largestNumber(int[] nums){
        int n = nums.length;
        String[] elements = new String[n];
        for(int i =0 ; i< n; i++){
            elements[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(elements, new Comparator<String>(){
            public int compare(String a, String b){
                String first = a + b;
                String sec = b + a;
                return sec.compareTo(first);
            }
        });
        if(elements[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String val : elements){
            sb.append(val);
        }
        return sb.toString();
   }
}


