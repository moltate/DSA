class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int left = 0, right = n-1;
        arr[left++] = nums[0];
        arr[right--] = nums[1];
        for(int i = 2; i< n; i++){
            if(arr[left - 1] > arr[right + 1]){
                arr[left++]=nums[i];
            }else{
                arr[right--]=nums[i];
            }
        }
        int l = right + 1, r = n-1;
        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return arr;
    }
}