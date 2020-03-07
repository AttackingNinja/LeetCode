package LeetCode69;

public class Solution {
    public int mySqrt(int x) {
        int sqrt = 0;
        long boundary = x >= 2 ? x / 2 : x;
        long left = 0;
        long right = boundary;
        while (left <= right) {
            long mid = (left + right) / 2;
            long square = mid * mid;
            long nextSquare = (mid + 1) * (mid + 1);
            if (square <= x && nextSquare > x) {
                sqrt = (int) mid;
                break;
            } else if (square < x) {
                left = mid + 1;
            } else if (square > x) {
                right = mid - 1;
            }
        }
        return sqrt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mySqrt(4);
    }
}
