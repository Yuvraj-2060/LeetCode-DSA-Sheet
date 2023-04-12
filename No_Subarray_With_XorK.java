// Approach-1   ****************** Time Complexity: O(N2)     Space Complexity: O(1) ************************************

public int solve(int[] A, int B) {
        int c=0;
        for(int i=0;i<A.length;i++){
            int current_xor = 0;
            for(int j=i;j<A.length;j++){
                current_xor^=A[j];
                if(current_xor==B) c++;
            }
        }
        return c;
}

// Approach-2   ****************** Time Complexity: O(N)     Space Complexity: O(N) ************************************


public int solve(int[] A, int B) {
     HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>(); 
        int c = 0; 
        int cpx = 0;
        int n = A.length;
        for(int i = 0;i<n;i++) {
            cpx = cpx ^ A[i]; 
            if(visited.get(cpx^B) != null) 
                c += visited.get(cpx ^ B); 
            if(cpx == B) {
                c++; 
            }
            if(visited.get(cpx) != null) 
                visited.put(cpx, visited.get(cpx) + 1); 
            else 
                visited.put(cpx, 1); 
        }
        return c; 
    }

-------------------------------------------------------(Better Solution Using HashMap)-------------------------------------------------------------------------------------
	
ublic class Solution {
    public int solve(int[] A, int B) {
       int c = 0;
        int currentXOR = 0;
        HashMap<Integer, Integer> xorCount = new HashMap<>();
        xorCount.put(0, 1); // Initialize with 0 XOR count
        
        for (int i = 0; i < A.length; i++) {
            currentXOR ^= A[i]; // Update current XOR
            
            int targetXOR = currentXOR ^ B; // Calculate the target XOR
            
            if (xorCount.containsKey(targetXOR)) {
                c += xorCount.get(targetXOR); // Increment count by the target XOR count
            }
            
            if (xorCount.containsKey(currentXOR)) {
                xorCount.put(currentXOR, xorCount.get(currentXOR) + 1); // Update current XOR count
            } else {
                xorCount.put(currentXOR, 1);
            }
        }
        
        return c;
    }
}

