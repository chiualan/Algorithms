package com.algorithms.spoj;


import java.math.BigInteger;
import java.util.Scanner;

public class SmallFactorial
{
    public static BigInteger[] facts = new BigInteger[100];
    public static void main(String [] args)
    {
        facts[0] = new BigInteger("1");
        for(int i = 1; i<100;i++)
        {
            facts[i] = facts[i-1].multiply(new BigInteger(String.valueOf(i + 1)));
        }
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
        int factorial = Integer.parseInt(scan);


        return facts[factorial-1].toString();
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
