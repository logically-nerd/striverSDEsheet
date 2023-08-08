public class TripletSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //sorting the array to keep hold of the unique elements
        //using two pointers
        int i=0;
        boolean flag=false;
        List<List<Integer>> ans=new ArrayList<>();
        while(i<nums.length-2){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> triplet=new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ans.add(triplet);
                    flag=true;
                }
                if(flag || nums[i]+nums[j]+nums[k]<0){
                    flag=false;
                    int jump=1;
                    while(jump+j<k && nums[jump+j]==nums[j]){
                        jump++;
                    }
                    if(jump+j==k){
                        break;
                    }
                    j=jump+j;
                }
                if(flag || nums[i]+nums[j]+nums[k]>0){
                    flag=false;
                    int jump=1;
                    while(k-jump>j && nums[k-jump]==nums[k]){
                        jump++;
                    }
                    if(k-jump==j){
                        break;
                    }
                    k-=jump;
                }
            }
            int jump=1;
            while(i+jump<nums.length && nums[i+jump]==nums[i]){
                jump++;
            }
            if(jump+i==nums.length){
                break;
            }
            i+=jump;
        }
        return ans;
    }
}
