class Trie {
    
    private final TrieNode root = new TrieNode('\0');
    
    private static final char END = '*';
    private static final TrieNode END_NODE = new TrieNode(END);

    public Trie() {
        ;
    }
    
    public void insert(String word) {
        char[] letters = word.toCharArray();
        
        TrieNode currNode = root;
        for (char letter: letters) {
            TrieNode nextNode = currNode.nextLetters.get(letter);
            if (nextNode == null) {
                nextNode = new TrieNode(letter);
                currNode.nextLetters.put(letter, nextNode);
            }
            currNode = nextNode;
        }
        
        if (currNode != root) {
            currNode.nextLetters.put(END, END_NODE);
        }
    }
    
    public boolean search(String word) {
        char[] letters = word.toCharArray();
        
        TrieNode currNode = root;
        for (char letter: letters) {
            TrieNode nextNode = currNode.nextLetters.get(letter);
            if (nextNode != null && nextNode.letter == letter) {
                currNode = nextNode;
                continue;
            } else {
                return false;
            }
        }
        
        if (currNode != null && currNode.nextLetters.containsKey(END)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
        char[] letters = prefix.toCharArray();
        
        TrieNode currNode = root;
        for (char letter: letters) {
            TrieNode nextNode = currNode.nextLetters.get(letter);
            if (nextNode != null && nextNode.letter == letter) {
                currNode = nextNode;
                continue;
            } else {
                return false;
            }
        }
        
        if (currNode != null && currNode != root) {
            return true;
        } else {
            return false;
        }
    }
    
    private static class TrieNode {
        char letter;
        
        Map<Character, TrieNode> nextLetters = new HashMap<Character, TrieNode>();
        
        public TrieNode(char _letter) {
            this.letter = _letter;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */