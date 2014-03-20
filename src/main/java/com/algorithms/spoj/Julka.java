package com.algorithms.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class Julka
{
    private static BigInteger BIG_TWO = new BigInteger("2");
    private static BigInteger BIG_ONE = new BigInteger("1");
    public static void main(String [] args)
    {

        Scanner scanIn = new Scanner(System.in);
        int numOfCases = 10;
        for(int i = 0; i < numOfCases; i++)
        {
            BigInteger numTotal = new BigInteger(scan(scanIn));
            BigInteger kMore = new BigInteger(scan(scanIn));
            doCase(numTotal, kMore);
        }

        scanIn.close();
    }

    private static void doCase(final BigInteger numTotal, final BigInteger kMore)
    {
        BigInteger klaudia = numTotal.add(kMore).divide(BIG_TWO);
        BigInteger natalia = numTotal.subtract(klaudia);

        print(klaudia.toString());
        print(natalia.toString());
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