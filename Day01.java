// TWO SUM (Easy) 
class Solution {
    public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length ; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
             map.put(nums[i], i);
        }
        return new int[]{};
}
}

//MOVE ZEROES(Easy)

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i=0; i<nums.length ; i++){
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}

//VALID PALINDROME(Easy)

class Solution {
    public boolean isPalindrome(String s) {
        int left =0;
        int right =s.length() -1; 
        while (left < right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left  < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
              return false;
            }
            left ++; right--;
        }
        return true;
    }
}

//Merge Sorted Array(Easy)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1; //last element of num1
        int j = n-1; //last element of num1
        int k = m+n-1 ;  //last position in nums1
        while(i>=0 && j>=0){
          if (nums1[i] > nums2[j]){
            nums1[k]=nums1[i];
            i--;
          }else{
            nums1[k]= nums2[j];
            j--;
          }
          k--;
        }
        while (j >=0){
            nums1[k]= nums2[j];
            j--;
            k--;
        }
    }
}

//Merge Two Sorted list

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode dummy = new ListNode(-1);
      ListNode tail = dummy;

      while(list1 != null && list2 != null){
        if (list1.val <= list2.val){
            tail.next = list1;
            list1 = list1.next;
        }else{
            tail.next = list2;
            list2 = list2.next;
        }
        tail=tail.next;
      }
      if (list1 != null){
        tail.next = list1;
      }
      if (list2 != null){
        tail.next = list2;
      }
      return dummy.next;
    }
}
