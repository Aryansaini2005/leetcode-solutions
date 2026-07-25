class Solution {
    public String triangleType(int[] nums) {
        int[] s = nums.clone();
        Arrays.sort(s);
        int a = s[0], b = s[1], c = s[2];

        // Triangle inequality: smallest two sides must sum to more than the largest
        if (a + b <= c) return "none";

        if (a == b && b == c) return "equilateral";
        if (a == b || b == c) return "isosceles";
        return "scalene";
    }
}
