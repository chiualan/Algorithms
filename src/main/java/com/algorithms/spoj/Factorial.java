package com.algorithms.spoj;

import java.util.Scanner;

public class Factorial
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

    private static int doCase(final String scan)
    {
        int factorial = Integer.parseInt(scan);
        int currPower = 1;
        int count = 0;
        while(factorial >= currPower)
        {
            currPower = currPower*5;
            count = count + factorial/currPower;
        }

        return count;
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
