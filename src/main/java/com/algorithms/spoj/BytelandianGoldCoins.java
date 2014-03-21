package com.algorithms.spoj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Hawkeye on 3/21/14.
 */
public class BytelandianGoldCoins
{
    private static Map<Long, Long> memoizer = new HashMap<Long, Long>();
    public static void main(String [] args)
    {
        Scanner scanIn = new Scanner(System.in);
        memoizer.put(0L,0L);
        long coinValue;
        while(scanIn.hasNextLine())
        {
            coinValue = Long.parseLong(scan(scanIn));
            doCase(coinValue);
        }

        scanIn.close();
    }

    private static void doCase(final long coinValue)
    {
        print(getAmericanValue(coinValue));
    }

    private static long getAmericanValue(final long coinValue)
    {
        Long memValue = memoizer.get(coinValue);
        if(memValue == null)
        {
            if(coinValue != 0)
            {
                long exchangeValue = getAmericanValue(coinValue/2)
                        + getAmericanValue(coinValue/3)
                        + getAmericanValue(coinValue/4);

                long ret = coinValue < exchangeValue ? exchangeValue : coinValue;

                memoizer.put(coinValue, ret);
                return ret;
            }
            else
            {
                return coinValue;
            }
        }
        else
        {
            return memValue;
        }
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
