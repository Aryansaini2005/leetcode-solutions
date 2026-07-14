class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs) {
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if(!map.containsKey(key)) {
                map.put(key,new ArrayList<>());
            }

            map.get(key).add(str);
        }
        List<List<String>> ans= new ArrayList<>();
        ans.addAll(map.values());
        return ans;
    }
}