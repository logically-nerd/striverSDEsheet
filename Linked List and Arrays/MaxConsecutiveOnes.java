//https://leetcode.com/problems/max-consecutive-ones/

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
       int maxFreq=0;
       int i=0;
       while(i<nums.length){
           int tempMax=0;
           while(nums[i]==1){
               tempMax++;
               i++;
               if(i==nums.length){
                    return tempMax>maxFreq?tempMax:maxFreq;
               }
           }
           if(tempMax>maxFreq){
               maxFreq=tempMax;
           }
           i++;
       } 
       return maxFreq;
    }
}
