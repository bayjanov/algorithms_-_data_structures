package Stacks;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if(input == null) {
            throw new IllegalArgumentException();
        }

        Stack<Character> stack = new Stack<>();

//        for(int i = 0; i < input.length(); i++) {
//            stack.push(input.charAt(i));
//        }

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

//        String reversed = ""; // This is gonna be expensive if we are gonna loop by adding new value to this. Each time it is concatted, a new memory allocated to it, since Strings are immutable.
        StringBuffer reversed =  new StringBuffer(); // This is more efficient than using String. StringBuffer is mutable and is used when we have a lot of string manipulation to do.
        while(!stack.empty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
