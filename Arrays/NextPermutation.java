//https://leetcode.com/problems/next-permutation/

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int flag = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                flag = i - 1;
                break;
            }
        }
        if (flag == -1) {
            // last permutation
            // reverse and return
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // finding next max
        int max = flag + 1;
        for (int i = flag + 1; i < nums.length; i++) {
            if (nums[i] > nums[flag] && nums[i] <= nums[max]) {
                max = i;
            }
        }
        // swap(flag,max)
        int temp = nums[flag];
        nums[flag] = nums[max];
        nums[max] = temp;
        flag++;
        //reverse the rest part of array to make it in ascending order
        reverse(nums, flag, nums.length - 1);
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
}
