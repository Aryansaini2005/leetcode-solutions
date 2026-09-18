class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        int mod = 1000000000+7;
        int maxH = 0;
        int maxW = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        maxH = Math.max(maxH,horizontalCuts[0]);
        maxW = Math.max(maxW,verticalCuts[0]);

        for(int i = 0; i < n-1; i++) {
            maxH = Math.max(maxH,horizontalCuts[i+1]-horizontalCuts[i]);
        }

        for(int i = 0; i < m-1; i++) {
            maxW = Math.max(maxW,verticalCuts[i+1]-verticalCuts[i]);
        }

        maxH = Math.max(maxH,h-horizontalCuts[n-1]);
        maxW = Math.max(maxW,w-verticalCuts[m-1]);

        long maxArea = ((long)maxH*maxW)%mod;

        return (int)maxArea;
    }
}