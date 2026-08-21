class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return f(nums,0,dp);
    }
    public int f(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length-1) return 0;
        if(dp[idx] != -1) return dp[idx];

        int minJump = Integer.MAX_VALUE;
        for(int i = idx+1; i <= idx+nums[idx] && i < nums.length; i++) {
            int result = f(nums,i,dp);
            if(result != Integer.MAX_VALUE) {
                minJump = Math.min(minJump,1+result);
            }
        }
        return dp[idx] = minJump;
    }
}