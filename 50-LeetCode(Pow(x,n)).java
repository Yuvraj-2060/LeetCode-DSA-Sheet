// Approach-1

class Solution {
    public double myPow(double x, int n) {
         if (n == 0) return 1.0;
        else if (n % 2 == 1) return x * myPow(x, n - 1);
        else if (n % 2 == 0) return myPow(x * x, n / 2);
        else return 1 / myPow(x, -n);
       
    }
}

// Approach-2

class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x,n);
    }
}

// Approach -3

class Solution {
    public double myPow(double x, int n) {
         double ans = 1.0;
    long nn = n;
    if (nn < 0) nn = -1 * nn;
    while (nn > 0) {
      if (nn % 2 == 1) {
        ans = ans * x;
        nn = nn - 1;
      } else {
        x = x * x;
        nn = nn / 2;
      }
    }
    if (n < 0) ans = (double)(1.0) / (double)(ans);
    return ans;
    }
}
