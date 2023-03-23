// Approach-1
[ Time Complexity 3*O(N) ~= O(N)     ||   Space Complexity = O(1) since no extra space is used..!  ]

class Solution {
    
     public void reverse(int A[],int i,int j){
        while(i<j){
            swap(A,i,j); i++; j--;
        }
    }
        
    public void swap(int A[],int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) 
            return;
        
        int i = A.length - 2;
        
        while(i >= 0 && A[i] >= A[i + 1]) 
            i--; 
        
        if(i >= 0) {                           
            int j = A.length - 1;              
            while(A[j] <= A[i])
                j--;      
            swap(A, i, j);                     
        }
        
        reverse(A, i + 1, A.length - 1); 
    }
    
}

// Approach-2
[ Time Complexity 3*O(N) ~= O(N)     ||   Space Complexity = O(1) since no extra space is used..!  ]

class Solution {
    
     public void reverse(int A[],int i,int j){
        while(i<j){
            swap(A,i++,j--);
        }
    }
        
    public void swap(int A[],int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    public void nextPermutation(int[] A) {
        int ind=-1,n=A.length;
        
        if(A == null || n <= 1) 
            return;
        
        for(int i=n-2;i>=0;i--){
            if(A[i]<A[i+1]){
                ind=i;  
                break;
            }
        }
            
        if(ind==-1){
            reverse(A,0,n-1);
            return;    
        }
            
        for(int i=n-1;i>=ind;i--){
            if(A[i]>A[ind]){
                swap(A,i,ind);
                break;
            }
        }
        reverse(A,ind+1,n-1);
    }
    
}
