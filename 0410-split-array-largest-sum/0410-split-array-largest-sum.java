class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0; i < nums.length; i++) {
            low = Math.max(low,nums[i]);
            high += nums[i];
        }
        int ans = high;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isPossible(nums,k,mid)) {
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }
    boolean isPossible(int[] nums, int k, int allowed) {
        int sum = 0;
        int cnt = 1;

        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > allowed) {
                cnt++;
                sum = nums[i];
            }else {
                sum += nums[i];
            }
        }
        return cnt <= k;
    }
}