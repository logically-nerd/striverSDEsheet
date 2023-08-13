public class KthElementInTwoSortedArrays {
    public long kthElement(int arr1[], int arr2[], int m, int n, int k) {
        if (arr1.length < arr2.length) {
            return kthElement(arr2, arr1, n, m, k);
        }
        int low = 0;
        int high = k <= m ? k : m;
        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;
            if (cut2 > n) {
                low = cut1 + 1;
                continue;
            }
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : arr2[cut2];
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0;
    }
}
