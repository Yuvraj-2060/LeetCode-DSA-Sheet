//Approach : 1                [     Time Complexity : O(N2)   ||  Space Complexity:  O(1)  ]

class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((long)nums[i]> (long)2*nums[j])
                    cnt++;
            }
        }
     return cnt;   
    }
}

//Approach : 2                [     Time Complexity : O(nlogn) + O(n) {for counting reverse pairs}   ||  Space Complexity:  O(n)  ]

class Solution {
    int count = 0;
    void merge(int[] arr, int l, int mid, int r) {
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]
        int n1 = (int)(mid - l + 1);
        int n2 = (int)(r - mid);    // r - (mid + 1) + 1
        
        // create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l+i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid+1+j];
            
        /* Code to count reverse pairs */
        int j = 0;
        for (int i = 0; i < n1; i++) {
            while (j < n2 && L[i] > (2 * (long)R[j]))
                j++;
            count += j;
        }
        
        // Merge temp arrays
        int i = 0, k = (int)l; j = 0;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];

            else
                arr[k++] = R[j++];
        }
        
        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];

    }
    void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r-l)/2;
            
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            
            merge(arr, l, mid, r);
        }
    }
    public int reversePairs(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
        return count;
    }
}


//Approach : 3                [     Time Complexity :  O( N log N ) + O (N) + O (N)      ||  Space Complexity:  O(n)  ]

import java.util.*;
 public class Main{
  static int merge(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1; 
        for(int i = low;i<=mid;i++) {
            while(j<=high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low, right = mid+1; 
        while(left <= mid && right<=high) {
            if(nums[left]<=nums[right]) {
                temp.add(nums[left++]); 
            }
            else {
                temp.add(nums[right++]); 
            }
        }
        
        while(left<=mid) {
            temp.add(nums[left++]); 
        }
        while(right<=high) {
            temp.add(nums[right++]); 
        }
        
        for(int i = low; i<=high;i++) {
            nums[i] = temp.get(i - low); 
        }
        return cnt; 
    }
    static int mergeSort(int[] nums, int low, int high) {
        if(low>=high) return 0; 
        int mid = (low + high) / 2;
        int inv = mergeSort(nums, low, mid); 
        inv += mergeSort(nums, mid+1, high); 
        inv += merge(nums, low, mid, high); 
        return inv; 
    }
   static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1); 
    }

    public static void main(String args[])
    {
        int arr[]={1,3,2,3,1};
        System.out.println("The Total Reverse Pairs are "+reversePairs(arr));
    }
 }
