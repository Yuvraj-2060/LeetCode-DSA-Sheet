//Approach-1 : Using HashMap
class Solution {
    public int lengthOfLongestSubstring(String s) {
       if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max; 
    }
}


//Approach-2 : Using HashSet
class Solution {
    public int lengthOfLongestSubstring(String s) {
       int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }
    
    return max;
    }
}

//Approach-3
class Solution {
    public int lengthOfLongestSubstring(String s) {
      int i=0,j=0,res=0;
        while(j<s.length())
        {
            if(s.substring(i,j).contains(s.charAt(j)+""))
            {
                if(res<j-i)res=j-i;
                while(s.charAt(i++)!=s.charAt(j));
            }
            j++;
        }
        if(res<j-i)res=j-i;
        return res;
    }
}
