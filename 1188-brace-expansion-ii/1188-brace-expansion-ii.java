class Solution {
    TreeSet<String> ans = new TreeSet<>();
    void backtrack(String s){
        int r = s.indexOf('}');
        if(r == -1){
            ans.add(s);
            return;
        }
        int l = s.lastIndexOf('{' , r);
        String left = s.substring(0, l);
        String right = s.substring(r + 1);
        String inside = s.substring(l + 1, r);

        for(String part: inside.split(",")){
            backtrack(left + part + right);
        }
    }
    public List<String> braceExpansionII(String expression) {
        backtrack(expression);
        return new ArrayList<>(ans);

    }
}