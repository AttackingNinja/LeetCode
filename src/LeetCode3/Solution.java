package LeetCode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s.length() != 0) {
            Set<Character> set = new HashSet<>();
            int i = 0;
            int j = 0;
            while (j < s.length()) {
                while (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(s.charAt(j));
                result = Math.max(result, j - i + 1);
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("jbpnbwwd"));
    }
}
