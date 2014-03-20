package com.algorithms.spoj;

import java.util.Scanner;

/**
 * Created by Hawkeye on 3/19/14.
 */
public class ToAndFro
{
    public static void main(String [] args)
    {
        Scanner scanIn = new Scanner(System.in);
        Integer key;
        String message;
        while((key = Integer.parseInt(scan(scanIn))) != 0)
        {
            message = scan(scanIn);
            doCase(key, message);
        }

        scanIn.close();
    }

    private static void doCase(final int key, final String message)
    {
        if(message.length() % key != 0)
        {
        }
        char [] messageArray = message.toCharArray();
        for(int i = key; i < messageArray.length; i = i + 2*key)
        {
            for(int j = i; j < i + key/2; j++)
            {

                char tmp = messageArray[j];
                messageArray[j] = messageArray[i + key - 1 - j + i];
                messageArray[i + key - 1 - j + i] = tmp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j<key; j++)
        {
            for(int i = j; i < messageArray.length; i = i + key)
            {
                sb.append(messageArray[i]);
            }
        }
        print(sb.toString());
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