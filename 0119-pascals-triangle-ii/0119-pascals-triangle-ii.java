class Solution {
    public List<Integer> getRow(int rowIndex) {
        int r = rowIndex + 1 ;
        List<Integer> list =new ArrayList<>();
        long ans=1;
        list.add(1);
        for ( int c=1 ; c<r ; c++){
            ans = ans * (r-c) ;
            ans = ans/c;
            list.add((int)ans);
        }
        return  list;
    }
}