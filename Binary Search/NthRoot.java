//https://www.codingninjas.com/studio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

public class NthRoot {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int low = 0, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prod = (int) Math.pow(mid, n);
            if (prod == m) {
                return mid;
            }
            if (prod < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}