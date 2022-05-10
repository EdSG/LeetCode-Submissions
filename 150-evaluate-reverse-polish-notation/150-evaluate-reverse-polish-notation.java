class Solution {
    
    private static final String ADD = "+";
    private static final String SUBSTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<Integer>();
        
        Integer operand1, operand2;
        for (String token: tokens) {
            if (token.equals(ADD)) {
                operand2 = operands.pop();
                operand1 = operands.pop();
                
                operands.push(operand1 + operand2);
            } else if (token.equals(SUBSTRACT)) {
                operand2 = operands.pop();
                operand1 = operands.pop();
                
                operands.push(operand1 - operand2);
            } else if (token.equals(MULTIPLY)) {
                operand2 = operands.pop();
                operand1 = operands.pop();
                
                operands.push(operand1 * operand2);
            } else if (token.equals(DIVIDE)) {
                operand2 = operands.pop();
                operand1 = operands.pop();
                
                operands.push(operand1 / operand2);
            } else {
                operands.push(Integer.valueOf(token));
            }
        }
        
        return operands.pop();
    }
}