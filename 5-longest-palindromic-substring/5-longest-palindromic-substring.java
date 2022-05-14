class Solution {
    public String longestPalindrome(String s) {
        char[] sChars = s.toCharArray();
        int longest = Integer.MIN_VALUE;
        int longestStart = -1;
        int longestEnd = -1;
        
        for (int start = 0 ; start < sChars.length ; start++) {
            for (int end = sChars.length - 1 ; end >= start ; end--) {
                if (end - start + 1 > longest) {
                    int left = start;
                    int right = end;
                    while (left <= right) {
                        if (sChars[left] == sChars[right]) {
                            left++; right--;
                        } else {
                            break;
                        }
                    }
                    if (left >= right && end - start + 1 > longest) {
                        longest = end - start + 1;
                        longestStart = start;
                        longestEnd = end;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        
        String longestString = "";
        if (longestStart >= 0 && longestStart <= longestEnd) {
            longestString = new String(sChars, longestStart, longestEnd - longestStart + 1);
        }
        
        return longestString;
    }
}