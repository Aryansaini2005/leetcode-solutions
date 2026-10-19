
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Reverse all edges
        for (int i = 0; i < V; i++) {
            for (int neigh : graph[i]) {
                adj.get(neigh).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Start with terminal nodes
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int cur = q.remove();
            ans.add(cur);

            for (int neigh : adj.get(cur)) {
                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
