// #Approach-1 (using predefined sort function)

class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
         System.out.println(nums[i]);
        
    }
}

// #Approach -2 (Using any sorting algorithm)   Merger Sort: [  Time Complexity : O(NlogN)  ||  Space Complexity : O(N)  ]-------> depends on the algorithms
   
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

//Approach-3          [  Time Complexity : O(NlogN)  ||  Space Complexity : O(1)    ]

import java.util.*;

public class Main {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) 
                cnt0++;
            else if (arr.get(i) == 1) 
                cnt1++;
            else
                cnt2++;
        }

        //Replace the places in the original array:
        for (int i = 0; i < cnt0; i++) arr.set(i, 0); // replacing 0's

        for (int i = cnt0; i < cnt0 + cnt1; i++) arr.set(i, 1); // replacing 1's

        for (int i = cnt0 + cnt1; i < n; i++) arr.set(i, 2); // replacing 2's
    }

    public static void main(String args[]) {
        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        sortArray(arr, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

    }

}

//Approach-4 *(Dutch National Flag)*     [  Time Complexity : O(N)  ||  Space Complexity : O(1)    ]

import java.util.*;

public class Main {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int low = 0, mid = 0, high = n - 1; // 3 pointers

        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // swapping arr[low] and arr[mid]
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                low++;
                mid++;

            } else if (arr.get(mid) == 1) {
                mid++;

            } else {
                // swapping arr[mid] and arr[high]
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);

                high--;
            }
        }
    }

    public static void main(String args[]) {
        int n = 6;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        sortArray(arr, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

    }

}
Output:
After sorting:
0 0 1 1 2 2  

Time Complexity: O(N), where N = size of the given array.
Reason: We are using a single loop that can run at most N times.

Space Complexity: O(1) as we are not using any extra space.
    
 ****************************************************   Same as above but by using Normal ARRAY    ******************************************************
 
import java.util.*;

public class Main {
    public static void sortArray(int arr[], int n) {
        int low = 0, mid = 0, high = n - 1; // 3 pointers

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;

                low++;
                mid++;

            } else if (arr[mid] == 1) {
                mid++;

            } else {
                
                int temp = arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;

                high--;
            }
        }
    }

    public static void main(String args[]) {
        int n = 6;
        int arr[]={0, 2, 1, 2, 0, 1};
        sortArray(arr, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}
