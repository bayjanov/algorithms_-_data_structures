package Stacks;

import Arrays.Array;

import java.util.Stack;

public class StackExp {
    public static void init() {
        Stack<Integer> stack = new Stack<>();

//        // Push items into the stack
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        System.out.println(stack);
//
//        // Pop items from stack
//        int top = stack.pop();
//        System.out.println(stack);
//        System.out.println(top);
//
//        // empty -> isEmpty
//        System.out.println(stack.empty());
//
//        // peek - returns the item on top of the stack WITHOUT Removing it vs pop
//        int peeked = stack.peek();
//        System.out.println(peeked);
//        System.out.println(stack);


// ====================================  Common interview questions  =====================================
        // 1. Reverse a string.
//        String str = "";
//
//        StringReverser reverser = new StringReverser();
//        String result = reverser.reverse(str);
//        System.out.println(result);



        // In this interview question, they give you String, and you should examine whether the orders of pairs of brackets are correct in the string.
        String strBalanced = "({[1]+<2>})[a]";
        String strImbalanced = "({1})[a]";

        StringBalanceCheck balanceChecker = new StringBalanceCheck();
        boolean isBalancedString = balanceChecker.balanceCheck(strImbalanced);
        System.out.println("isBalancedString: " + isBalancedString);
    }

}
