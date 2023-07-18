import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 1, 2, 0, 5 };
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }

    static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> maxList = new ArrayDeque<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (!maxList.isEmpty() && maxList.peek() == i - k) {
                maxList.poll();
            }
            if (maxList.isEmpty()) {
                maxList.add(i);
            } else {
                if (!maxList.isEmpty() && nums[maxList.peekLast()] > nums[i]) {
                    maxList.add(i);
                } else {
                    while (!maxList.isEmpty() && nums[maxList.peekLast()] < nums[i]) {
                        maxList.rLast();
                    }
                    maxList.add(i);
                }
            }
            if (!maxList.isEmpty() && (i+1) / k > 0) {
                ans[j++] = nums[maxList.peek()];
            }
            System.out.println(i + "\n" + maxList + "\n" + Arrays.toString(ans));
        }
        return ans;
    }
}