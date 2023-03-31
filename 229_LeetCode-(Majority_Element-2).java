
// Approach-1            [  Time Complexity : 0(N2)    ||  Space Complexity : 0(1)  ]

class Solution {
    public List<Integer> majorityElement(int[] arr) {
    ArrayList < Integer > ans = new ArrayList < > ();
        int n=arr.length;
    for (int i = 0; i < n; i++) {
      int cnt = 1;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] == arr[i])
          cnt++;
      }

      if (cnt > (n / 3) && !ans.contains(arr[i]))
        ans.add(arr[i]);
    }

    return ans;       
    }
}

// Approach-2                       [  Time Complexity : 0(N)    ||  Space Complexity : 0(N)  ]

class Solution {
    public List<Integer> majorityElement(int[] arr) {
    int n = arr.length;
    HashMap < Integer, Integer > mp = new HashMap < > ();
    ArrayList < Integer > ans = new ArrayList < > ();

    for (int i = 0; i < n; i++) {
      mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
    }

    for (int x: mp.keySet()) {
      if (mp.get(x) > (n / 3))
        ans.add(x);
    }

    return ans;     
    }
}


