//Find First and Last Position of Element in Sorted Array
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] arr = new int[2];
        Arrays.fill(arr, -1);

        if(nums == null || nums.length == 0)
            return arr;

        int low = 0;
        int high = nums.length - 1;
        int mid;

        
        while(low <= high){
            mid = low + (high - low) / 2;

            if(nums[mid] > target){
                high = mid - 1;
            }
            else if(nums[mid] == target){
                arr[0] = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        low = 0;
        high = nums.length - 1;


        while(low <= high){
            mid = low + (high - low) / 2;

            if(nums[mid] > target){
                high = mid - 1;
            }
            else if(nums[mid] == target){
                arr[1] = mid;
                low = mid + 1;
            }
            else{
                low = mid + 1;
            }
        }

        return arr;
    }
}

//Median of Two Sorted Arrays

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int n1 =nums1.length,n2=nums2.length,N=n1+n2, start=0,end=n1;
        while(start<=end){
          int cut1= start + (end -start)/2;
          int cut2= N/2 -cut1;
          int l1 = (cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
          int l2 = (cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
          int r1 = (cut1==n1)?Integer.MAX_VALUE:nums1[cut1];
          int r2 = (cut2==n2)?Integer.MAX_VALUE:nums2[cut2];

          if(l1<=r2 && l2<=r1){
            if(N%2!=0){
                return (double) Math.min(r1,r2);
            }else{
                return ((Math.max(l1,l2) + Math.min(r1,r2))/2.0);
            }
          }else if(l1>r2){
            end = cut1 - 1;
          }else{
            start = cut1 + 1;
          }
        }
        return 0.0;
    }
}
