//Search Insert Position
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
           int mid = (left+right)/2;
           if(nums[mid]==target) return mid;
           if(nums[mid]<target){
            left=mid+1;
           }else{
            right=mid-1;
           }
        }
        return left;
    }
}

//First Bad Version
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=1;
        int right=n;
        while(left<right){
            int mid = left + (right - left) / 2;
          if(isBadVersion(mid)){
               right = mid;
          }else{
            left=mid+1;
          }
        }
        return left;
    }
}

//Guess Number Higher or Lower
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left =1;
        int right=n;
        while(left<=right){
            int mid =left+ (right-left)/2;
            int result=guess(mid);
            if(result==0) {
                return mid;
            }
            else if(result==-1) {
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}

//Find Peak Element
class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}