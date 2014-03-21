package com.algorithms.spoj;

import java.util.Scanner;

/**
 * Created by Hawkeye on 3/21/14.
 */
public class Hangover
{
    private static final String ANSWER_FORMAT = "%d card(s)";

    public static void main(String [] args)
    {
        Scanner scanIn = new Scanner(System.in);
        double val = 0.0;
        while((val = Double.parseDouble(scan(scanIn))) != 0.0)
        {
            doCase(val);
        }

        scanIn.close();
    }

    private static void doCase(final double val)
    {
        //int answer = (int)Math.ceil(Math.exp(val));
        int answer = 2;
        float curr = 0.0f;
        while(curr < val)
        {
            curr = curr + 1/(answer + 0.0f);
            answer++;
        }
        print(String.format(ANSWER_FORMAT, answer - 2));
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