package com.algorithms.spoj;

import java.util.Scanner;

/**
 * Created by Hawkeye on 3/18/14.
 */
public class NumberSteps
{
    public static void main(String [] args)
    {
        Scanner scanIn = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scan(scanIn));
        for(int i = 0; i < numOfCases; i++)
        {
            doCase(scan(scanIn));
        }

        scanIn.close();
    }

    private static void doCase(final String scan)
    {
        String [] input = scan.split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        if(!isValidPoint(x,y))
        {
            print("No Number");
            return;
        }

        if(x % 2 == 0)
        {
            print(x + y);
        }
        else
        {
            print(x + y - 1);
        }
    }

    private static boolean isValidPoint(int x, int y)
    {
        return x == y || y == x - 2;
    }
    private static void print(String s)
    {
        System.out.println(s);
    }

    private static void print(int s)
    {
        System.out.println(s);
    }

    private static String scan(Scanner scanIn)
    {
        return scanIn.nextLine();
    }
}
