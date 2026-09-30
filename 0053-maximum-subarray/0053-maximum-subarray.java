class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currMax = 0;

        for(int i = 0; i < nums.length; i++){
            currMax = Math.max(nums[i],nums[i]+currMax);
            maxSum = Math.max(maxSum,currMax);
        }
        return maxSum;
    }
}