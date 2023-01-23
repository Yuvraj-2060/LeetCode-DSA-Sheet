// Approach -1  Time Complexity : O(log(n))

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            if(nums[i]==target)
                return i;
            if(nums[i]>target)
                return i;
            
        }
        return n;
    }
}

// Approach -2 ************( Using Binary Search)***********

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length-1;
        
        int L=0,H=n;
        
        while(L<=H){

            int mid=(L+H)/2;
            
            if(target<nums[mid])
                H=mid-1;
            else if(target>nums[mid])
                L=mid+1;
            else
                return mid;
        }
        return L;
    }
}
