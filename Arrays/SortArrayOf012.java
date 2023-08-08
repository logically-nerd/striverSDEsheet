//https://leetcode.com/problems/sort-colors/

public class SortArrayOf012 {
    public void sortColors(int[] nums) {
        // applying three pointers
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        // 0:low-1
        // have 0
        // low:mid-1
        // have 1
        // mid:high
        // have unsorted array
        // high:n
        // have 2
        while (mid <= high) {
            switch (nums[mid]) {
                case 0 -> {
                    // System.out.println(0);
                    nums[mid] = nums[low];
                    nums[low] = 0;
                    low++;
                    mid++;
                }
                case 1 -> {
                    // System.out.println(1);
                    mid++;
                }
                case 2 -> {
                    // System.out.println(2);
                    nums[mid] = nums[high];
                    nums[high] = 2;
                    high--;
                }
            }
            // System.out.println(Arrays.toString(nums));
        }
    }
}
