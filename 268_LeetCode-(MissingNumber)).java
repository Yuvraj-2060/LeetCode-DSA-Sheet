// In Java :
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
    for (int i = 0; i < nums.length; i++)
        sum += nums[i] - i;
    return nums.length - sum;
    }
}

// In java 

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return total - sum;
    }
}
************************* OR *****************************************
// In C++ :

class Solution {
public:
    int missingNumber(vector<int>& nums) { // find the missing number in a array
        int sum = 0; // sum of all numbers initially 0
        int total = nums.size()*(nums.size() + 1)/2; // total is the sum of all numbers in the array
        for (auto number : nums) { // iterate through the array
            sum += number; // add the number to the sum
        }
        return total - sum; // return the difference between the sum and the total that is the missing number
    }
};

