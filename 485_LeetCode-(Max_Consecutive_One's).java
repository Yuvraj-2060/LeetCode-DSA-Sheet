#Approach-1
 
 class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int cnt=0,maxcnt=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
                maxcnt = Math.max(cnt,maxcnt);
            }
            else if(nums[i]==0)
                cnt=0;
        }
        return maxcnt;
    }
}

#Approach-2
  
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
       Stack stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                stack.push(nums[i]);
                if(max < stack.size())
                {
                    max = stack.size();
                }
            }
            else
                while(!stack.isEmpty())
                    stack.pop();
        }
        return max;
    }
}
