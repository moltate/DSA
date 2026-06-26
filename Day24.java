//Rotated Array
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums, int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right]= temp;

            left++;
            right--;
        }
    }
    }

//Find Kth Rotation
class Solution {
    public int findKRotation(int arr[]) {
        int low = 0, high= arr.length -1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(arr[mid] <= arr[high]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}

//Find First and Last Position of Element in Sorted Array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            first(nums,target) , last(nums,target)
        };  
    }
    public int first(int[] nums,int target){
        int low = 0, high= nums.length-1,ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
           if(nums[mid]==target){
            ans = mid;
            high = mid -1;
           }else if(nums[mid]<target){
            low = mid + 1;
           }else{
            high = mid -1;
           }

        }
        return ans;
    }
    public int last(int[] nums, int target){
         int low = 0, high= nums.length-1,ans = -1;
         while(low<=high){
            int mid = low + (high - low)/2;
           if(nums[mid]==target){
            ans = mid;
            low = mid + 1;
           }else if(nums[mid]<target){
            low = mid + 1;
           }else{
            high = mid -1;
           }
    }
    return ans;
    }
}

//Find Target Indices After Sorting Array

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i < nums.length; i++){
            if(nums[i] == target){
                ans.add(i);
            }
        }
        return ans;
    }
}

//Find Words Containing Character

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for(int i =0; i< words.length; i++){
                if(words[i].indexOf(x) != -1){
                    ans.add(i);
                }
        }
        return ans;
    }
}
