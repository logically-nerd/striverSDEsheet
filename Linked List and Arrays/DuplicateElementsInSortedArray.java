public class DuplicateElementsInSortedArray {
    public int removeDuplicates(int[] nums) {
        //using two pointer approach
        int l=0,r=1;
        while(r<nums.length){
            if(nums[l]==nums[r]){
                r++;
            }else{
                nums[++l]=nums[r++];
            }
        }
        return l+1;
    }
}
