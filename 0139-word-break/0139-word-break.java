class Solution {
    class Node {
        Node[] children;
        boolean eow;
        public Node() {
            children = new Node[26];
            eow = false;
        }
    }

    Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for(int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow ==  true;
    }

    public boolean wordBreakUtil(String s, int start, Boolean[] dp) {
        if(start == s.length()) {
            return true;
        }

        if(dp[start] != null) {
            return dp[start];
        }
        for(int i = start+1; i <= s.length(); i++) {
            if(search(s.substring(start,i)) && wordBreakUtil(s,i,dp)) {
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }
        Boolean[] dp = new Boolean[s.length()];
        return wordBreakUtil(s,0,dp);
    }
}