// Approach : 1     [ Time Complexity: O(N*N) to linearly iterate and put it into some other matrix || Space Complexity: O(N*N) to copy it into some other matrix.] 

class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
        
        
    }
}


//Approach 2: Time Complexity: O(N*N) + O(N*N).One O(N*N) is for transposing the matrix and the other is for reversing the matrix.

            // Space Complexity: O(1).

//Step 1: Transpose the matrix. (transposing means changing columns to rows and rows to columns)
//Step 2: Reverse each row of the matrix.

class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i=0;i<matrix.length;i++){                   // step 1: tranpose the matrix
            for(int j=i;j<matrix[0].length;j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<matrix.length;i++){                  // step 2: reverse the matrix
            for(int j=0;j<matrix.length/2;j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
        
    }
}
