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

==========================================================(0-sum)=====================================================================
	
class GfG
{
    int maxLen(int arr[], int n)
    {
          HashMap<Integer, Integer> map = new HashMap<>();
             int sum = 0, maxLen = 0;
 
             // traverse the given array
             for (int i = 0; i < n; i++) {
                 
                  // accumulate sum
                  sum += arr[i];
                 
                  // when subarray starts from index '0'
                  if (sum == 0)
                      maxLen = i + 1;
 
                  // make an entry for 'sum' if it is
                  // not present in 'map'
                  if (!map.containsKey(sum)) {
                      map.put(sum, i);
                  }
 
                  // check if 'sum-k' is present in 'map'
                  // or not
                  if (map.containsKey(sum)) {
                       
                      // update maxLength
                      if (maxLen < (i - map.get(sum)))
                          maxLen = i - map.get(sum );
                  }
             }
              
             return maxLen;        
    }
}

-----------------------------------------------------------(K-Sum)--------------------------------------------------------
	
public class Largest_SubArray_K_Sum_2 {
    static int lenOfLongSubarr(int[] arr, int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;
            // make an entry for 'sum' if it is not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - k)) {
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }
    public static void main(String args[])
    {
        int[] arr = {5,-2,2,-8,1,7,10,23};
        int n = arr.length;
        int k = 10;
        System.out.println("Length = " +lenOfLongSubarr(arr, n, k));
    }
}


--------------------------------------------------------------------------------------------------------------------------------------
	
class Largest_SubArray_K_Sum_1 {

    static int maxLen(int[] arr, int n, int k)
    {
        int maxlength = 0;

        for (int i = 0; i < n; i++) {
            int Sum = 0;
            for (int j = i; j < n; j++) {
                Sum += arr[j];
                if (Sum == k)
                    maxlength = Math.max(maxlength, j - i + 1);
            }
        }
        return maxlength;
    }
    public static void main(String args[])
    {
        int[] arr = {5,-2,2,-8,1,7,10,23};
        int n = arr.length;
        int k = 0;
        System.out.println("Length = " +
                maxLen(arr, n, k));
    }
}
