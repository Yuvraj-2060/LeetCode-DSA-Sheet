#Approach-1 (using predefined sort function)

class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
         System.out.println(nums[i]);
        
    }
}

#Approach -2
   
 class Solution {
    public void sortColors(int[] nums) {
        int temp;
        //Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {   if(nums[j]<nums[i])
                {   temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                
                }
            
            }  
        }
        
        for(int i=0;i<nums.length;i++)
         System.out.println(nums[i]);
        
    }
}
