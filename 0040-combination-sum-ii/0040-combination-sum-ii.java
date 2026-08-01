class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        f(candidates,0,target,ans,new ArrayList<>());
        return ans;
    }
    public void f(int[] candidates, int idx, int target, List<List<Integer>> ans, List<Integer> ds) {

            if(target == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }
    
     
        for(int i = idx; i < candidates.length; i++) {   
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break; 
            ds.add(candidates[i]);
            f(candidates,i+1,target-candidates[i],ans,ds);
            ds.remove(ds.size()-1);
        }       
        
    }
}