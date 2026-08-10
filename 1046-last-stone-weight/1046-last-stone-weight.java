class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }

        while(pq.size() >= 2) {
            int y = pq.remove();
            int x = pq.remove();

            if(y > x) {
                pq.add(y-x);
            }
        }

        if(pq.isEmpty()) {
            return 0;
        }
        return pq.peek();
    }
}