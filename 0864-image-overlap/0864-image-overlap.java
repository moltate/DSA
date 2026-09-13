class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> a1 = new ArrayList<>();
        List<int[]> b1 = new ArrayList<>();

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j <A[0].length; j++){
                if(A[i][j] == 1){
                    a1.add(new int[]{i, j});
                }
                if(B[i][j] == 1){
                    b1.add(new int[]{i,j});
                }
            }
        }
        Map<String, Integer> d = new HashMap<>();
        int ans = 0;
          for (int[] a : a1) {
            for (int[] b : b1) {

                int dx = b[0] - a[0];
                int dy = b[1] - a[1];

                String translation = dx + "," + dy;

                d.put(translation, d.getOrDefault(translation, 0) + 1);

                ans = Math.max(ans, d.get(translation));
            }
        }

        return ans;
    }
}