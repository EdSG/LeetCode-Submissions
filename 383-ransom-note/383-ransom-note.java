class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> charCounters = new HashMap<Character, Integer>(ransomNote.length());
        
        for(Character ransomChar: ransomNote.toCharArray()) {
            Integer counter = charCounters.getOrDefault(ransomChar, 0);
            
            charCounters.put(ransomChar, counter + 1);
        }
        
        boolean construct = false;
        for (Character magazineChar: magazine.toCharArray()) {
            Integer counter = charCounters.get(magazineChar);
            
            if (counter != null) {
                counter -= 1;
                if (counter == 0) {
                    charCounters.remove(magazineChar);
                } else {
                    charCounters.put(magazineChar, counter);
                }
                
                if (charCounters.isEmpty()) {
                    construct = true;
                    break;
                }
            }
        }
        
        return construct;
    }
}