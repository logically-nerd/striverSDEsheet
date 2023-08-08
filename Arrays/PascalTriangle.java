//https://leetcode.com/problems/pascals-triangle/

import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri=new ArrayList<>();
        for(int i=0;i<numRows;i++){
                List<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    temp.add(1);
                }
                else{
                    temp.add(tri.get(i-1).get(j)+tri.get(i-1).get(j-1));
                }
            }
            tri.add(temp);
        }
        return tri;
    }
}
