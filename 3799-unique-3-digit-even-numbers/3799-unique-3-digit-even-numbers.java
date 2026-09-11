class Solution {
    public int totalNumbers(int[] digits) {
       Set<Integer> nums = new HashSet<>();

       for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                      if (i != j && j != k && i != k) {
                        int a = digits[i];
                        int b = digits[j];
                        int c = digits[k];
                        if (a != 0 && c % 2 == 0) {
                            int num = a * 100 + b * 10 + c;
                            nums.add(num);
                        }
                    }
                 }
            }
        }
          return nums.size();
    }
}