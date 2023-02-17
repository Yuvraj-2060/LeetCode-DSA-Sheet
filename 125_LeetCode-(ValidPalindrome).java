// Approach-1

class Solution {
    public boolean isPalindrome(String s) {
    
    s=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	int start=0;
	int end=s.length()-1;
	while(start<end)
	{
		if(s.charAt(start++)!=s.charAt(end--))
				return false;
	}
        return true;
    }
}

Approach-2

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            // check if left pointer is alphanumeric
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            // check if right pointer is alphanumeric
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            // compare characters at left and right pointers
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
