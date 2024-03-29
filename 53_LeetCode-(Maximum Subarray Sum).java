// Approach-1 (Kadane's Algorithm)

class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum>max)
                max=sum;
             if(sum<0)
                 sum=0;
                
        }
        return max;
    }
}

//Approch 2 : Dynamic Programming
Take one varibale as a global maximum , say max (To keep track maximum value)
dp[i] means max sum subarray ending at index i
If sum till i-1 is is usefull , then take it other wise take current cell as sum till i

public int maxSubArray(int[] nums) {
   int storage []=  new int[nums.length];
   int max  =  nums[0];
   storage[0 ] =  nums[0];
   for( int i=1;i<nums.length ;i++  ){
       storage[i] =  Math.max( storage[i-1]+nums[i] ,  nums[i]);
       if(storage[i]>max){
           max=  storage[i];
       }
   }
   return max;    
 }
 

//Approch 3: Divide and Conquer Approch
Split our array into two halves
case1: maxSum subaaray occur in left half ,
case2: maxSum subarray occur in right half
case3: maxSum subaaray lies about middle of array

We use here divide and conquer approch here , split array into two halves about middle
take anwer from left , right , and subArray about middle.
Let assume recusion will give us answer for left and right part , how do we calculate maxsum subarray about mid :
[-2,1,-3,4,-1,2,1,-5,4]
i = 0 , j = 8
mid = (0+8)/2 = 4
step 1) Caluate maxSum (maximum positive sum) from mid to left

     int sum = 0,leftMaxSUM = Integer.MIN_VALUE;
	for(int l =  mid;l>=i;l--){
		sum+=nums[l];
		if(sum>leftMaxSUM ){
			leftMaxSUM =  sum;
		}                                    
	}
step 2) calculate maxSum(maximum positive sum ) from mid+1 to right side

int rightMaxSUM = Integer.MIN_VALUE; 
sum = 0;    // reset sum to 0
       for (int l = mid + 1; l <=j; l++)
       {
           sum += nums[l];
           if (sum > rightMaxSUM ) {
               rightMaxSUM = sum;
           }
       }

int midSum = leftMaxSUM+rightMaxSUM

Let code it
---- divide and conquer approch -------------------

public int maxSubArray(int[] nums) {
    
        return helper(nums,0,nums.length-1);
    }
    
    public int helper(int nums[],int i,int j){

        if(i==j){
            return nums[i];
        }
                          
        int mid  =  (i+j)/2;
        int sum = 0,leftMaxSUM = Integer.MIN_VALUE;
        
        for(int l =  mid;l>=i;l--){
            sum+=nums[l];
            if(sum>leftMaxSUM){
                leftMaxSUM =  sum;
            }                                    
        }
        
     int rightMaxSUM = Integer.MIN_VALUE;
        sum = 0;    // reset sum to 0
        for (int l = mid + 1; l <=j; l++)
        {
            sum += nums[l];
            if (sum > rightMaxSUM ) {
                rightMaxSUM = sum;
            }
        }
        
       int maxLeftRight = Math.max(helper(nums, i, mid),
                                    helper(nums, mid + 1, j ));
        return Math.max(maxLeftRight, leftMaxSUM + rightMaxSUM );
        
        
    
    }
