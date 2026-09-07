class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        for(int j = 0; j < list2.length; j++) {
            if(map.containsKey(list2[j])) {
                min = Math.min(min,map.get(list2[j])+j);
            }
        }

        for(int j = 0; j < list2.length; j++) {
            if(map.containsKey(list2[j]) && map.get(list2[j])+j == min) {
                ans.add(list2[j]);
            }
        }
        String[] res = new String[ans.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;

    }
}