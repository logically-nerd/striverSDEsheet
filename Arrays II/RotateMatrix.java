public class RotateMatrix {
    public void rotate(int[][] matrix) {
        //transpose the matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                //swap the elements across the diagonal
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse each row
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=temp;
            }
        }
    }
}
