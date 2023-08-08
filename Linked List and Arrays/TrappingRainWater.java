public class TrappingRainWater {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int quan=0;
        int lMax=0,rMax=0;
        while(l<r){
            if(height[l]<=height[r]){
                //bigger right wall exist
                if(lMax<=height[l]){
                    //water can't be stored bcz bigger left wall doesn't exist
                    lMax=height[l];
                }else{
                    quan+=lMax-height[l];
                }
                l++;
            }else{
                //bigger left wall exist
                if(rMax<=height[r]){
                    //water can't be stored bcz bigger right wall doesn't exist
                    rMax=height[r];
                }else{
                    quan+=rMax-height[r];
                }
                r--;
            }
        }
        return quan;
    }
}
