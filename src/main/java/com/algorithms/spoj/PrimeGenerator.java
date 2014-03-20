package com.algorithms.spoj;

import java.util.Scanner;

public class PrimeGenerator
{
    private static int max = 1000000001;
    public static boolean[] isPrime;
    public static void main(String [] args)
    {
        isPrime = new boolean[max];
        Scanner scanIn = new Scanner(System.in);
        try
        {
            prepare();

            int numOfCases = Integer.parseInt(scan(scanIn).trim());
            for(int i = 0; i < numOfCases; i++)
            {
                print(doCase(scan(scanIn)));
            }
        }
        finally
        {
            scanIn.close();
        }
    }

    private static void prepare()
    {
        for(int i = 2; i<max-1;i++)
        {
            isPrime[i] = true;
        }

        for(int i=2; i*i<max-1;i++)
        {
            if(isPrime[i])
            {
                for(int j=i; i*j<max-1;j++)
                {
                    isPrime[i*j] = false;
                }
            }
        }
    }

    private static String doCase(final String scan)
    {
        String [] input = scan.split(" ");
        int start = Integer.parseInt(input[0].trim());
        int end = Integer.parseInt(input[1].trim());
        for(int i=start; i<end+1;i++)
        {
            if(isPrime[i])
            {
                System.out.println(i);
            }
        }

        return "\n";
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
