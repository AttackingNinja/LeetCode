package LeetCode461;

public class Solution {
    int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(1, 4));
    }
}
