package com.tsystems.javaschool.tasks.calculator;

import javax.script.ScriptEngineManager;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculator {

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {
        // TODO: Implement the logic here
        String result = "result";

        // Checking for the null statement
         if (Validation.fullValidation(statement) == false){
             result = null;
         }
         else {
             Double resultInDouble = Calculator.RPNToAnswer(Calculator.ExpressionToRPN(statement));
             if (resultInDouble == Double.MIN_VALUE)
                 return null;
             else {
                 if (resultInDouble % 1 == 0) {
                     Integer resultInInteger = resultInDouble.intValue();
                     result = resultInInteger.toString();
                 } else
                     result = resultInDouble.toString();
             }
         }
        return result;
    }



    public static String ExpressionToRPN(String expression){
        String current ="";
        Stack<Character> stack = new Stack<>();
        int priority;

        for (int i = 0; i < expression.length(); i++){
            priority = getPriority(expression.charAt(i));

            if (priority == 0)
                current += expression.charAt(i);
            if (priority == 1)
                stack.push(expression.charAt(i));
            if (priority > 1){
                current += ' ';

                while (!stack.empty()){
                    if (getPriority(stack.peek()) >= priority)
                        current += stack.pop();
                    else break;
                }
                stack.push(expression.charAt(i));
            }
            if (priority == -1){
                current += ' ';
                while (getPriority(stack.peek()) != 1)
                    current += stack.pop();
                stack.pop();
            }
        }
        while (!stack.empty())
            current += stack.pop();
        return current;
    }
    public static double RPNToAnswer(String RPN){
        String operand = new String();
        Stack<Double> stack = new Stack<>();
        int priority;

        for (int i = 0; i < RPN.length(); i++){
            if (RPN.charAt(i) == ' ')
                continue;
            if (getPriority(RPN.charAt(i)) == 0){
                while (RPN.charAt(i) != ' ' && getPriority(RPN.charAt(i)) == 0)
                    operand += RPN.charAt(i++);
                if (i == RPN.length()) break;

                stack.push(Double.parseDouble(operand));
                operand = new String();
            }
            if (getPriority(RPN.charAt(i)) > 1){
                double a = stack.pop();
                double b = stack.pop();
                if (RPN.charAt(i) == '+')
                    stack.push(b+a);
                if (RPN.charAt(i) == '-')
                    stack.push(b-a);
                if (RPN.charAt(i) == '*')
                    stack.push(b*a);
                if (RPN.charAt(i) == '/')
                    if (a == 0)
                        stack.push(Double.MIN_VALUE);
                    else
                    stack.push(b/a);
            }

        }
            return stack.pop();
    }


    private static int getPriority (char token){
      if (token == '*' || token == '/')
          return 3;
      else if (token == '+' || token == '-')
          return 2;
      else if (token == '(')
          return 1;
      else if (token == ')')
          return -1;
      else return 0;
    }
}

