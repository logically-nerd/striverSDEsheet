//https://www.codingninjas.com/studio/problems/aggressive-cows_1082559?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1

import java.util.Arrays;

public class AggresiveCows {
    public static int aggressiveCows(int[] stalls, int k) {
        // Write your code here.
        Arrays.sort(stalls);
        int high = stalls[stalls.length - 1] - stalls[0];
        int low = Integer.MAX_VALUE;
        for (int i = 1; i < stalls.length; i++) {
            if (low > stalls[i] - stalls[i - 1]) {
                low = stalls[i] - stalls[i - 1];
            }
        }
        // System.out.println(low+" "+high);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // first cow placed at 1st position
            int cow = 1;
            int prev = 0;
            for (int i = 1; i < stalls.length; i++) {
                if (stalls[i] - stalls[prev] >= mid) {
                    cow++;
                    prev = i;
                }
            }
            if (cow >= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
