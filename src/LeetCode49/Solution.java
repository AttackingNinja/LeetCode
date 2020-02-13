package LeetCode49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String strSort = new String(charArray);
            if (!map.containsKey(strSort)) {
                map.put(strSort, count);
                count++;
                results.add(new LinkedList<>());
            }
            results.get(map.get(strSort)).add(str);
        }
        return results;
    }
}
