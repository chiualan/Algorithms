package com.algorithms.spoj;

import java.util.Scanner;
import java.util.Stack;

public class TransformExpression
{
    public static void main(String [] args)
    {
        Scanner scanIn = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scan(scanIn));
        for(int i = 0; i < numOfCases; i++)
        {
            print(doCase(scan(scanIn)));
        }

        scanIn.close();
    }

    private static String doCase(final String scan)
    {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < scan.length(); i++)
        {
            char thisGuy = scan.charAt(i);
            switch (thisGuy)
            {
                case '+':
                case '-':
                case '/':
                case '*':
                case '^':
                case '(':
                    stack.push(thisGuy);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '(')
                    {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(thisGuy);
                    break;
            }
        }
        return sb.toString();
    }

    private static void print(String s)
    {
        System.out.println(s);
    }

    private static String scan(Scanner scanIn)
    {
        return scanIn.nextLine();
    }
}
