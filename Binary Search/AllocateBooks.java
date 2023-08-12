//https://www.codingninjas.com/studio/problems/ayush-gives-ninjatest_1097574?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

public class AllocateBooks {
    public static void main(String[] args) {
        long ans = ayushGivesNinjatest(3, 5, new int[] { 1, 2, 2, 3, 1 });
        System.out.println(ans);
    }

    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        // Write your code here.
        long low = -1;// time can't be negative
        long high = 0;
        for (int i : time) {
            if (i > low) {
                low = i;
            }
            high += i;
        }
        // one day will be assigned by chapter with max time=>low=max(time)
        // worst case: all chapters to be read in one day=>high=sum(time)
        while (low <= high) {
            long mid = low + (high - low) / 2;
            // time limit for a day
            long days = 1;
            long tempMax = 0;
            for (int i : time) {
                tempMax += i;
                if (tempMax > mid) {
                    tempMax = i;
                    days++;
                } else if (tempMax == mid) {
                    tempMax = 0;
                    days++;
                }
            }
            if (tempMax == 0) {
                // if new day does not have any time used
                days--;
            }
            if (days <= n) {
                // taking less days
                // reduce the max time of a day
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
