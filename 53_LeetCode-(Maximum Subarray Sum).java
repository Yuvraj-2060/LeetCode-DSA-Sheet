// Approach-1 

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
