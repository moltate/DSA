//Remove Duplicates from sorted array
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int i = 0;
        for (int j= 1; j < n ; j++){
            if (nums[i] != nums[j]){
                i++;
            nums[i] = nums[j];
        }
        }
        return i+1;
    }
}

//Contains Duplicate
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set =  new HashSet<>();
        for ( int num : nums){
            if(set.contains(num)){return true;}
            set.add(num);
        }
        return false;
    }
}

//Single Number
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0 ;
        for ( int num : nums){
            result ^= num;
        }
        return result;
}
}

//Reverse Linked list
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

//Majority Element
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0 ;
        int count = 0;

        for (int num : nums){
            if(count == 0 ){
                candidate = num;
            }
            if (num == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
