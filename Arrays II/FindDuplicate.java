//https://leetcode.com/problems/find-the-duplicate-number/description/

public class FindDuplicate {
    public int findDuplicate(int[] nums) {

        // using cyclic sort
        // for (int i = 0; i < nums.length; i++) {
        // while (nums[i] - 1 != i && nums[i]-1!=nums[nums[i]-1]-1) {
        // int temp = nums[nums[i] - 1];
        // nums[nums[i] - 1] = nums[i];
        // nums[i] = temp;
        // }
        // }
        // System.out.println(Arrays.toString(nums));
        // int ans=-1;
        // for(int i=0;i<nums.length;i++){
        // if(nums[i]-1!=i){
        // ans=nums[i];
        // }
        // }
        // return ans;

        // using extra space
        // boolean[] numPresent=new boolean[nums.length];
        // for(int i:nums){
        // if(numPresent[i-1]){
        // return i;
        // }
        // numPresent[i-1]=true;
        // }
        // return 0;

        // using slow fast pointer
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // slow==fast
        // loop found
        fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
