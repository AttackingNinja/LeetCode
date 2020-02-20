package LeetCode151;

public class Solution {
    public String reverseWords(String s) {
        String[] splits = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; i--) {
            if (!splits[i].isEmpty()) {
                stringBuilder.append(splits[i]);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(" the  sky   is    blue     "));
    }
}
