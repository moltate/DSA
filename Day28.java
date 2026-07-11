//Rotate List 

class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k %= length;

        if (k == 0)
            return head;

        tail.next = head;

        ListNode newTail = head;

        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        newTail.next = null;

        return newHead;
    }
}

//Group Anagrams

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] arr = word.toCharArray();

            Arrays.sort(arr);

            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}

//Insertion Sort List

class Solution {

    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0);

        while (head != null) {

            ListNode next = head.next;

            ListNode prev = dummy;

            while (prev.next != null && prev.next.val < head.val) {
                prev = prev.next;
            }

            head.next = prev.next;
            prev.next = head;

            head = next;
        }

        return dummy.next;
    }
}


//Find the Difference 

class Solution {

    public char findTheDifference(String s, String t) {

        char ans = 0;

        for (char ch : s.toCharArray()) {
            ans ^= ch;
        }

        for (char ch : t.toCharArray()) {
            ans ^= ch;
        }

        return ans;
    }
}