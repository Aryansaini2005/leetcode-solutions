class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(candidates,0,target,ans,new ArrayList<>());
        return ans;
    }
    public void f(int[] candidates, int idx, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(idx == candidates.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[idx] <= target) {
            ds.add(candidates[idx]);
            f(candidates,idx,target-candidates[idx],ans,ds);
            ds.remove(ds.size()-1);
        }
        f(candidates,idx+1,target,ans,ds);
    }
}