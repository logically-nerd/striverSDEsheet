//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchInSortedRotatedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                // left half sorted
                if (nums[low] <= target && target < nums[mid]) {
                    // target in left half
                    high = mid - 1;
                } else {
                    // target in right half
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    // target in right half
                    low = mid + 1;
                } else {
                    // target in left half
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
