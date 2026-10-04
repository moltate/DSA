class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int prev, curr;
        for(int i = 1; i <= rowIndex; i++){
            prev = 1;
            for(int j = 1; j < i; j++){
                curr = list.get(j);
                list.set(j, prev + curr);
                prev = curr;
            }
            list.add(1);
        }
        return list;
    }
}