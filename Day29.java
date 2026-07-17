//Kth Largest Element in an Array

class Solution {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}

//Merge Intervals

class Solution {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] last = result.get(result.size() - 1);

            if (intervals[i][0] <= last[1]) {

                last[1] = Math.max(last[1], intervals[i][1]);

            } else {

                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

//Zigzag Conversions

class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char ch : s.toCharArray()) {

            rows[currentRow].append(ch);

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        StringBuilder answer = new StringBuilder();

        for (StringBuilder row : rows) {
            answer.append(row);
        }

        return answer.toString();
    }
}

//Roman to Integer

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        for (int i = 0; i< s.length(); i++){
            int curr = map.get(s.charAt(i));
            if(i< s.length()-1 && curr < map.get(s.charAt(i+1))){
                ans -= curr;
            }else{
                ans += curr;
            }
        } 
        return ans;
    }
}

//Integer to Roman

class Solution {
    public String intToRoman(int num) {
      int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

      String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

      StringBuilder ans = new StringBuilder();
      
      for(int i = 0; i < values.length ; i++){
        while(num >= values[i]){
            ans.append(romans[i]);

            num -= values[i];
        }
      }
        return ans.toString();
    }
}
