#Approach - 1

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}
-------------------------------------------------------------------------------------

#Approach - 2

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length,ans=0;
        
       Arrays.sort(nums);
        
        for(int i=0,j=i+1;i<n;i++,j++)
        {
            if(nums[i]==nums[j])
            {
                ans=nums[i];
                break;
            }
        }
        
        return ans;
    }
}

------------------------------------------------------------------------------------------------
    
# Approach no:3
    
    
import java.util.* ;
import java.io.*; 
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==arr.get(i+1)){
                return arr.get(i);
            }
        }return -1;
    }
}
