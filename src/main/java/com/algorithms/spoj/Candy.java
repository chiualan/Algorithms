package com.algorithms.spoj;

import java.util.Scanner;

/**
 * Created by Hawkeye on 3/20/14.
 */
public class Candy
{
    public static void main(String [] args)
    {

        Scanner scanIn = new Scanner(System.in);
        int candies = 0;
        while(-1 != (candies = Integer.parseInt(scan(scanIn))))
        {
            int [] candyArray = new int[candies];
            for(int i = 0; i < candies; i++)
            {
                candyArray[i] = Integer.parseInt(scan(scanIn));
            }
            print(doCase(candyArray));
        }

        scanIn.close();
    }

    private static int doCase(final int [] candies)
    {
        int total = 0;
        for(int i = 0; i < candies.length; i++)
        {
            total = total + candies[i];
        }

        if(total % candies.length == 0)
        {
            int average = total/candies.length;
            int diff = 0;
            for(int i = 0; i < candies.length; i++)
            {
                diff = diff + Math.abs(candies[i] - average);
            }
            return diff/2;
        }
        else
        {
            return -1;
        }
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