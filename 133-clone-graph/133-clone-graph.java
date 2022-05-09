/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    private HashMap<Node, Node> clonedNodes = new HashMap<Node, Node>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        if (clonedNodes.containsKey(node)) {
            return clonedNodes.get(node);
        }
        
        Node clone = new Node(node.val);
        clonedNodes.put(node, clone);
        
        for (Node neighbor: node.neighbors) {
            Node clonedNeighbor = cloneGraph(neighbor);
            
            clone.neighbors.add(clonedNeighbor);
        }
        
        return clone;
    }
}