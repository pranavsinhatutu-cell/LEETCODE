import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        // Push -1 as a base index for boundary length calculations
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // Push the index of '(' onto the stack
                stack.push(i);
            } else {
                // Pop the top index for matching ')'
                stack.pop();

                if (stack.isEmpty()) {
                    // Stack is empty, set current index as the new base boundary
                    stack.push(i);
                } else {
                    // Valid substring length = current index - last unmatched boundary index
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}