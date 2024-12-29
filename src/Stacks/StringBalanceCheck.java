package Stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringBalanceCheck {
    private final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
    private final List<Character>  rightBrackets = Arrays.asList(')', '}', ']', '>');
    public boolean balanceCheck(String input) {
        Stack<Character> stack =  new Stack<>();

//        for (char ch : input.toCharArray()) {
//            if (ch == '(')
//                stack.push(')');
//            else if (ch == '{')
//                stack.push('}');
//            else if (ch == '[')
//                stack.push(']');
//            else if (ch == '<')
//                stack.push('>');
//            else if (stack.empty() || ((ch == ')' || ch == '}' || ch == ']' || ch == '>') && stack.pop() != ch))
//                return false;
//        }
//        return stack.empty();


        //        for (char ch : input.toCharArray()) {
//            if(ch == '(' || ch == '{' || ch == '[' || ch == '<')
//                stack.push(ch);
//            else if (ch == ')' || ch == '}' || ch == ']' || ch == '>') {
//                if (stack.isEmpty()) return false;
//
//                char top = stack.peek();
//                if(
//                        (ch == ')' && top == '(') ||
//                        (ch == '}' && top == '{')  ||
//                        (ch == ']' && top == '[')  ||
//                        (ch == '>' && top == '<')) {
//                    stack.pop();
//                } else {
//                    return false;
//                }
//            }
//        }

//        return stack.isEmpty();


        // Refactoring
        for (char ch : input.toCharArray()) {
            if(isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if(bracketsMatch(top, ch))
                    stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isLeftBracket(char ch) {

        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
