package LeetCode33;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                if (nums[left] < nums[mid] || left == mid || (nums[left] == nums[mid] && nums[mid - 1] == nums[mid]))
                    left = mid + 1;
                else {
                    if (nums[right] < target)
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            } else if (nums[mid] > target) {
                if (nums[left] < nums[mid] || left == mid || (nums[left] == nums[mid] && nums[mid - 1] == nums[mid])) {
                    if (nums[left] > target)
                        left = mid + 1;
                    else
                        right = mid - 1;
                } else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{5, 5, 5, 5, 1, 2, 3}, 5));
    }
}
