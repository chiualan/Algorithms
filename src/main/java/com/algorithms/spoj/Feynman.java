package com.algorithms.spoj;

import java.util.Scanner;

public class Feynman
{

    public static void main(String [] args)
    {
        Scanner scanIn = new Scanner(System.in);
        Long problem;
        while((problem = Long.parseLong(scan(scanIn))) != 0)
        {
            doCase(problem);
        }

        scanIn.close();
    }

    private static void doCase(final long scan)
    {
        long n = scan;
        print(n*(n + 1)*(2*n + 1) / 6);
    }

    private static void print(long s)
    {
        System.out.println(s);
    }

    private static String scan(Scanner scanIn)
    {
        return scanIn.nextLine();
    }
}
