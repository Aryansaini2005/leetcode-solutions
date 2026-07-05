class Solution {
    class Pair implements Comparable<Pair> {
        char ch;
        int freq;
        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair p2) {
            return p2.freq - this.freq;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<Character,Integer> entry: map.entrySet()) {
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair cur = pq.remove();
            for(int i = 0; i < cur.freq; i++) {
                ans.append(cur.ch);
            }
        }
        return ans.toString();
    }
}