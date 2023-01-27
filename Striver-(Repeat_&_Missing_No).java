public class Solution {
    
    public int[] repeatedNumber(final int[] A) {
        int res[] = new int[2];
        Map<Integer, Boolean> numberMap
            = new HashMap<>();
 
        int max = A.length;
 
        for (Integer i : A) {
 
            if (numberMap.get(i) == null) {
                numberMap.put(i, true);
            }
            else {
                    res[0]=i;
            }
        }
        for (int i = 1; i <= max; i++) {
            if (numberMap.get(i) == null) {
                res[1]=i;
            }
        }
        return res;
    }
}
