package com.algorithms.spoj;

import java.util.Scanner;
public class ReversedNumbers
{
    public static void main(String [] args)
    {
        Scanner scanIn = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scan(scanIn));

        for(int i = 0; i<numOfCases;i++)
        {
            String [] ints = scan(scanIn).split(" ");
            int x = getReverse(ints[0]);
            int y = getReverse(ints[1]);
            print(reverse(x+y));
         }

        scanIn.close();
    }

    private static String reverse( int i)
    {
        int ret = 0;
        while(i > 0)
        {
            ret = ret*10 + i%10;
            i = i /10;
        }
        return String.format("%d",ret);
    }

    private static int getReverse(String s)
    {
        int rev = 0;
        int pow = 0;
        for(int i=0; i<s.length();i++)
        {
            rev = (int) (Integer.parseInt(s.substring(i,i+1))*Math.pow(10,pow) + rev);
            pow++;
        }
        return rev;
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
