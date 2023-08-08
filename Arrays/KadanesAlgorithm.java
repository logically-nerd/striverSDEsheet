//https://leetcode.com/problems/maximum-subarray/

public class KadanesAlgorithm {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sumCurr = 0;
        for (int element : nums) {
            sumCurr += element;
            if (maxSum < sumCurr) {
                maxSum = sumCurr;
            }
            if (sumCurr < 0) {
                sumCurr = 0;
            }
        }
        return maxSum;
    }
}