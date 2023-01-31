// Approach -1

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==target)
                    return true;
            }
        }
      return false; 
    }
}

************ ******************* **************** ************************** ********************* ********************
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                    if (matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            
            return false;
    }
}

**********************************************************************  ********************************************************
// Using Binary Search 


int row_num = matrix.length;
	int col_num = matrix[0].length;
	
	int begin = 0, end = row_num * col_num - 1;
	
	while(begin <= end){
		int mid = (begin + end) / 2;
		int mid_value = matrix[mid/col_num][mid%col_num];
		
		if( mid_value == target){
			return true;
		
		}else if(mid_value < target){
			//Should move a bit further, otherwise dead loop.
			begin = mid+1;
		}else{
			end = mid-1;
		}
	}
	
	return false;
