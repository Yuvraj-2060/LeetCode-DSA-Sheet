(1).--------------------------------------------------------------------------------------------------------
  
class GfG
{
    int maxLen(int a[], int n)
    {
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1); // Initialize the map with sum 0 at index -1 (before the array)

        for (int i = 0; i < n; i++) {
            sum += a[i];

            if (sumMap.containsKey(sum)) {
                // If the current sum is already present in the map, update the max length
                max = Math.max(max, i - sumMap.get(sum));
            } else {
                // If the current sum is not present in the map, add it with the current index
                sumMap.put(sum, i);
            }
        }

        return max;
    }
}

(2).-------------------------------------------------------------------------------------------------------
  
class GfG
{
    int maxLen(int a[], int n)
    {
        int  max = 0;
      	for(int i = 0; i < a.length; ++i){
	      	int sum = 0;
		      for(int j = i; j < a.length; ++j){
			      sum += a[j];
			      if(sum == 0){
				      max = Math.max(max, j-i+1);
			      }
		    }
	    }
	    return max;
   }
}


(3).-------------------------------------------------------------------------------------------------------
  
  class GfG
{
    int maxLen(int arr[], int n)
    {
        int max_len=0,zcnt=0;
		for(int i=0;i<n;i++) {
			int cur_sum=0;
			for(int j=i;j<n;j++) {
				cur_sum=cur_sum+arr[j];
				if (cur_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
				if(arr[j]==0)
					zcnt++;
			}
			
		}
		if(zcnt>0 && max_len==0)
			return 1;
			
		return max_len;
    }
}
