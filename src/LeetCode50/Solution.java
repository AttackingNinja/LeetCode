package LeetCode50;

public class Solution {
    double recurse(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = recurse(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        double result = recurse(x, Math.abs(n));
        return (n >= 0) ? result : 1 / result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.myPow(0.00001, 2147483647);
    }
}
