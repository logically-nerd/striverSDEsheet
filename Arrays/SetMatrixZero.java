//https://leetcode.com/problems/set-matrix-zeroes/

class Solution {
    public void setZeroes(int[][] matrix) {
        int col0=1;
        //marking the initial row and column
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    if(j==0){
                        col0=0;
                    }else{
                        matrix[0][j]=0;
                    }
                    matrix[i][0]=0;
                }
            }
        }
        //checking the mark and altering the matrix
        //changing row elements
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<matrix[i].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        //changing column elements
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j=0;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        //changing the first row and column
        if(matrix[0][0]==0){
            if(col0==0){
                for(int i=0;i<matrix.length;i++){
                    matrix[i][0]=0;
                }
            }
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        if(col0==0){
                for(int i=0;i<matrix.length;i++){
                    matrix[i][0]=0;
                }
        }
    }
}