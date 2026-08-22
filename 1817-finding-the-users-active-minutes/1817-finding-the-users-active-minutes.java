class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();

        for(int[] log : logs) {
            int user = log[0];
            int minutes = log[1];

            map.putIfAbsent(user,new HashSet<>());
            map.get(user).add(minutes);

        }

        int ans[] = new int[k];

        for(HashSet<Integer> set: map.values()) {
            int uam = set.size();
            ans[uam-1]++;
        }
        return ans;
    }
}