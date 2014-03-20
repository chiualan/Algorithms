package com.algorithms.codility;

/**
 * Created by Hawkeye on 3/18/14.
 */
public class Stocks
{
    public static void main(String [] args)
    {
        int [] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(new Stocks().solution(A));
    }
    public int solution(int[] A) {
        // write your code in Java SE 7
        System.out.println("Eat it. O(1) space is for stingy jerks");
        int [] rMax = new int[A.length];
        int [] lMin = new int[A.length];

        System.arraycopy(A, 0, rMax, 0, A.length);
        System.arraycopy(A, 0, lMin, 0, A.length);

        lMin(lMin);
        rMax(rMax);
        int profit = rMax[0] - lMin[0];
        for(int i = 0;i < lMin.length;i++)
        {
            if(profit < rMax[i] - lMin[i])
            {
                profit = rMax[i] - lMin[i];
            }
        }
        return profit;
    }

    private void rMax(final int[] rMax)
    {
        int max = rMax[rMax.length -1];
        for(int i = rMax.length-1;i>=0;i--)
        {
            if(rMax[i] > max )
            {
                max = rMax[i];
            }
            rMax[i] = max;
        }

    }

    private void lMin(final int[] lMin)
    {

        int min = lMin[0];
        for(int i = 0;i < lMin.length;i++)
        {
            if(lMin[i] < min )
            {
                min = lMin[i];
            }
            lMin[i] = min;
        }
    }
}
