//Reverse Words in a String
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length -1; i>=0; i--){
            result.append(words[i]);
            if (i !=0){
                result.append(" ");
            }
        }
        return result.toString();
    }
}

//Container With Most Water
class Solution {
    public int maxArea(int[] height) {
        int i = 0 ;
        int j = height.length -1;
        int maxWater = 0;
        while (i < j) {
            int w = j - i;
            int area = w * Math.min(height[i],height[j]);
            maxWater = Math.max(maxWater,area);
           if (height[i]<height[j]){
            i++;
            }else{
                j--;
            }
        }
        return maxWater;
    }
}
//3Sum
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i< nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1] ){
                continue;
            }
            int L = i +1;
            int R = nums.length -1;
            while (L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum==0){
                  List<Integer> triplet = new ArrayList<>();
                  triplet.add(nums[i]);
                  triplet.add(nums[L]);
                  triplet.add(nums[R]);
                  result.add(triplet);
                  while (L < R && nums[L] == nums[L+1]){
                    L++;
                  }
                  while(L < R && nums[R] == nums[R-1]){
                    R--;
                  }
                  L++;
                  R--;
                }
                else if(sum<0){
                  L++;
                }else{
                    R--;
                }
            }
        }
        return result;
    }
}

//Trapping Rain Water
class Solution {
    public int trap(int[] height) {
        int left=0 ;
        int right = height.length -1;
        int leftMax=0;
        int rightMax=0;
        int water=0;
        while(left<right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax=height[left];
                }else{
                    water+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax=height[right];
                }else{
                    water+=rightMax-height[right];
                }
                right--;
            }
        }
        return water;
    }
}
