class Solution {
    
    private static Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();
    
    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<Integer>();
        
        Integer operand1, operand2;
        for (String token: tokens) {
            if (OPERATIONS.containsKey(token)) {
                operand2 = operands.pop();
                operand1 = operands.pop();
                operands.push(OPERATIONS.get(token).apply(operand1, operand2));
            } else {
                operands.push(Integer.valueOf(token));
            }
        }
        
        return operands.pop();
    }
}