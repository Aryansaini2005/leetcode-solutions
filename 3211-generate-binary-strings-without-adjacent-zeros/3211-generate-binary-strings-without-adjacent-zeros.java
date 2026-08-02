class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        f(0,0,n,ans,new StringBuilder());
        f(0,1,n,ans,new StringBuilder());
        return ans;
    }
    public void f(int idx, int val, int n, List<String> ans, StringBuilder ds) {
         ds.append(val);
        if(idx == n-1) {
            ans.add(ds.toString());
            ds.deleteCharAt(ds.length()-1);
            return;
        }

       

        if(val == 0) {
            f(idx+1,1,n,ans,ds);
        }else {
            f(idx+1,0,n,ans,ds);
            f(idx+1,1,n,ans,ds);
        }
        ds.deleteCharAt(ds.length()-1);
    }
}