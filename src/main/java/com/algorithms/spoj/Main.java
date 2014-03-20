package com.algorithms.spoj;

import java.util.*;
public class Main
{
    public static void main(String [] args)
    {
        Scanner scanIn = new Scanner(System.in);
        String in = scan(scanIn);
        while(!in.equals("42"))
        {
            System.out.println(in);
            in = scan(scanIn);
        }
        scanIn.close();
    }

    private static String scan(Scanner scanIn)
    {
        return scanIn.nextLine();
    }
}



