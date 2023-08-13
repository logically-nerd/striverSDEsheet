//https://www.codingninjas.com/studio/problems/median-of-a-row-wise-sorted-matrix_1115473?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

public class MatrixMedian {
    public static int findMedian(int matrix[][], int m, int n) {
        // Write your code here
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            // O(m)
            if (matrix[i][0] < low) {
                low = matrix[i][0];
            }
            if (matrix[i][n - 1] > high) {
                high = matrix[i][n - 1];
            }
        }
        int median = (m * n) / 2;
        // System.out.println("median"+median);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int numBefore = countLeft(matrix, m, n, mid);
            // O(mlog(n))
            // System.out.println(mid+" "+numBefore);
            // if(numBefore==median){
            // return mid;
            // }
            if (numBefore <= median) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static int countLeft(int[][] matrix, int m, int n, int num) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            int low = 0;
            int high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[i][mid] >= num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            count += (low);
        }
        // O(mlog(n))
        return count;
    }
}
