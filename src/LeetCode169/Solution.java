package LeetCode169;

public class Solution {

    int find(int i, int j, int[] nums) {
        if (i == j)
            return nums[i];
        int leftMajor = find(i, (i + j) / 2, nums);
        int rightMajor = find((i + j) / 2 + 1, j, nums);
        if (leftMajor == rightMajor)
            return leftMajor;
        int leftMajorSum = 0;
        int rightMajorSum = 0;
        for (int k = i; k <= j; k++) {
            if (nums[k] == leftMajor)
                leftMajorSum++;
            if (nums[k] == rightMajor)
                rightMajorSum++;
        }
        return leftMajorSum > rightMajorSum ? leftMajor : rightMajor;
    }

    public int majorityElement(int[] nums) {
        return find(0, nums.length - 1, nums);
    }
}
