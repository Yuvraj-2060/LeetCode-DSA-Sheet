// Approach-1 

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
        
    }
}
******************************************************(1)************************************************************
// Time Complexity: The time comp[lexity of this recursive solution is exponential.

// Space Complexity: As we are using stack space for recursion so the space complexity will also be exponential.

class Solution {
    public int countPaths(int i,int j,int n,int m)
    {
        if(i==(n-1)&&j==(m-1)) return 1;
        if(i>=n||j>=m) return 0;
        else return countPaths(i+1,j,n,m)+countPaths(i,j+1,n,m);
    }
    public int uniquePaths(int m, int n) {
       return countPaths(0,0,m,n);
    }
}
********************************************************************************************************************
// Approach-2

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 || j == n - 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];   
    }
}

**************************************************************(2)****************************************************************************
// Approach-3 same DP Solution [ Time Complexity: O(n*m) because at max there can be n*m number of states. || Space Complexity : O(n*m)    ]
class Solution {
     public int countPaths(int i, int j, int n, int m, int[][] dp) {
        if (i == (n - 1) && j == (m - 1)) return 1;
        if (i >= n || j >= m) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        else return dp[i][j] = countPaths(i + 1, j, n, m, dp) + countPaths(i, j + 1, n, m, dp);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        int num = countPaths(0, 0, m, n, dp);
        if (m == 1 && n == 1) {
            return num;
        }
        return dp[0][0];
    }
}

**********************************************************************(3)*******************************************************************************************
// Approach-4  [ Time Complexity: The time complexity of this solution will be O(n-1) or  O(m-1) depending on the formula we are using || Space Complexity : O(n)   ]

class Solution {
     public int uniquePaths(int m, int n) {
        int N = n + m - 2;
            int r = m - 1; 
            double res = 1;
            
            for (int i = 1; i <= r; i++)
                res = res * (N - r + i) / i;
            return (int)res;
    }
}
