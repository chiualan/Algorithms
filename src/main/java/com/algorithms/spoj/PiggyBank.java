package com.algorithms.spoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.min;

/**
 * http://www.spoj.com/problems/PIGBANK/
 */
public class PiggyBank
{

    private static final String VALID_OUTPUT = "The minimum amount of money in the piggy-bank is %d.";
    private static final String INVALID_OUTPUT = "This is impossible.";
    static Scanner scanIn;

    public static void main(String [] args)
    {
        scanIn = new Scanner(System.in);
        int numOfCases = Integer.parseInt(scan());
        while(numOfCases-- > 0)
        {
            int [] piggyBanks = parseIntArray(scan().split(" "));

            int numOfCoins = Integer.parseInt(scan());
            List<Coin> coins = new ArrayList<Coin>();
            for(int i = 0; i < numOfCoins; i++)
            {
                coins.add(new Coin(parseIntArray(scan().split(" "))));
            }
            print(doCase(piggyBanks[1] - piggyBanks[0], coins));
        }
        scanIn.close();
    }

    private static String doCase(final int piggyBankWeight, final List<Coin> coins)
    {
        long [] array = initDP(piggyBankWeight);
        for(Coin c : coins)
        {
            array[c.weight] = c.value;
        }

        for(int i = 0; i < piggyBankWeight + 1; i++)
        {
            long bestValue = array[i];
            for(Coin c : coins)
            {
                int prevWeight = i - c.weight;
                if(prevWeight >= 0)
                {
                    bestValue = min(bestValue, add(array[prevWeight], c.value));
                }
            }
            array[i] = bestValue;
        }

        long returnValue = array[piggyBankWeight];
        if(returnValue == MAX_VALUE)
        {
           return INVALID_OUTPUT;
        }
        else
        {
            return String.format(VALID_OUTPUT, array[piggyBankWeight]);
        }
        
    }

    private static long add(final long arrayValue, final long coinValue)
    {
        if(arrayValue == MAX_VALUE)
        {
            return arrayValue;
        }
        else
        {
            return arrayValue + coinValue;
        }
    }

    private static long [] initDP(final int piggyBankWeight)
    {
        long [] array = new long[piggyBankWeight + 1];
        for(int i = 1; i < array.length;i++)
        {
            array[i] = MAX_VALUE;
        }

        return array;
    }

    private static class Coin
    {
        int weight;
        int value;

        Coin(int[] input)
        {
            value  = input[0];
            weight = input[1];
        }

    }

    private static int[] parseIntArray(final String[] split)
    {
        int [] array = new int[split.length];
        for(int i = 0; i < split.length; i++)
        {
            array[i] = Integer.parseInt(split[i].trim());
        }

        return array;
    }

    private static void print(final String output)
    {
        System.out.println(output);
    }

    private static String scan()
    {
        return scanIn.hasNextLine() ? scanIn.nextLine().trim() : "0";
    }
}
