//https://leetcode.com/problems/single-element-in-a-sorted-array/

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        // //xor
        // int xor=0;
        // for(int i:nums){
        // xor^=i;
        // }
        // return xor;

        // int ans=0;
        // boolean flag=false;
        // for(int i:nums){
        // if(flag){
        // ans-=i;
        // flag=false;
        // }else{
        // ans+=i;
        // flag=true;
        // }
        // }
        // return ans;

        // using binary search
        // breakpoint:
        // at starting the first occurance of the element is at even
        // after the break, the first occurance of the element is at odd

        int low = 0, high = nums.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // System.out.println(low+" "+high+" "+mid);
            if (mid % 2 == 0) {
                // even index
                if (nums[mid] == nums[mid + 1]) {
                    // left half
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // odd index
                if (nums[mid] == nums[mid + 1]) {
                    // right half
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return nums[low];
    }
}
