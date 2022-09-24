class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        
        Map<Character, Integer> s1Count = new HashMap<Character, Integer>();
        
        for (Character c: s1Chars) { // Calculate the initial character counts
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }
        
        int totalCount = 0;
        int start = 0;
        for (int end = 0 ; end < s2Chars.length ; end++) {
            char cur = s2Chars[end];
            
            if (end - start > s1Chars.length - 1) {
                char head = s2Chars[start];
               if (s1Count.containsKey(head)) {
                   int curCount = s1Count.get(head);
                   s1Count.put(head, curCount + 1);
                   if (curCount + 1 <= 0) {
                       totalCount += 1;
                   } else {
                       totalCount -= 1;
                   }   
               }
               start++;
            }
            
            if (s1Count.containsKey(cur)) {
                int curCount = s1Count.get(cur);
                s1Count.put(cur, curCount - 1);
                if (curCount - 1 < 0) {
                    totalCount -= 1;
                } else {
                    totalCount += 1;
                }
                
                if (totalCount == s1Chars.length) {
                    return true;
                }
            }
            
        }
        
        return false;
        
    }
}