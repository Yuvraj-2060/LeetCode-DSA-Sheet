
//Method 1: (Brute force)
//-using another matrix (let's say it matrix2)
//
//we can copy all the elements of given matrix to matrix2
//while traversing given matrix whenever we encounter 0, we will make the entire row and column of the matrix2 to 0
//finally we can again copy all the elements of matrix2 to given matrix
//-Time: O((mn)*(m+n)), Space: O(mn)

public class AddZero_1 {

	public static void main(String[] args) {
		int arr[][]= {{1,0,1},{1,1,0},{1,1,1}};
		int temp[][]= {{1,0,1},{1,1,0},{1,1,1}};
		
		int r=arr.length;
		int c=arr[0].length;
		
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j]==0)
				{
					for(int k=0;k<r;k++)
						temp[i][k]=0;
					
					for(int k=0;k<c;k++)
						temp[k][j]=0;				}
			}
		}
		System.out.println("\n: New Matrix Is :\n");
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++)
			{
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
	}

}

//Method 2: (Better)
//
//we can use two separate arrays one for rows (rowsArray) and one for columns (colsArray) and initialize them to 1
//while traversing the given matrix whenever we encounter 0 at (i,j), we will set rowsArray[i]=0 and colsArray[j]=0
//After completion of step 2, again iterate through the matrix and for any (i,j), if rowsArray[i] or colsArray[j] is 0 then update matrix[i][j] to 0.
//-Time: O(mn), Space: O(m+n)

package LeetCode;
import java.util.Arrays;
public class AddZero_2 {
	public static void main(String[] args) {
		int arr[][]= {{1,0,1},{1,1,0},{1,1,1}};
		int m=arr.length,n=arr[0].length;
		int []r=new int[m];
		int []c=new int[n];
		//1.Printing matrix
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n**** New Matrix ***\n");
		
		Arrays.fill(r,1);
		Arrays.fill(c,1);
		//2.Adding zeroes to row and column array where ever you encounter zero in matrix. 
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==0) {
					r[i]=0;	c[j]=0;
				}
			}
		}
		//3.Adding zeros to your matrix taking help from rows and column array
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(r[i]==0 || c[j]==0)
					arr[i][j]=0;
			}
		}
		//4.Printing new matrix
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

//I have submitted the second approach :
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        
        int r[]=new int[m];
        int c[]=new int[n];
        Arrays.fill(r,1);
		Arrays.fill(c,1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    r[i]=0; c[j]=0;
                }
             }   
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(r[i]==0 || c[j]==0){
                   matrix[i][j]=0;
               }
            }
        }         
    }
}
