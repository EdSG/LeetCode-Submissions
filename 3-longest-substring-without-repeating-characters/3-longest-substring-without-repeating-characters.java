class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexes = new HashMap<Character, Integer>();
        
        int longest = 0;
        int currLongest = 0;
        int start = 0;
        int currIdx = 0;
        for (Character curr: s.toCharArray()) {
            Integer lastIdx = charIndexes.put(curr, currIdx);
            if (lastIdx != null) {
                longest = Math.max(currLongest, longest);
                start = Math.max(start, lastIdx + 1);
                currLongest = currIdx - start + 1;
            } else {
                charIndexes.put(curr, currIdx);
                currLongest++;
            }
            longest = Math.max(currLongest, longest);
            currIdx++;
        }
        
        return longest;
    }
}