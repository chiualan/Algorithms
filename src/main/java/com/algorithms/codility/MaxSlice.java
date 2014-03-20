package com.algorithms.codility;

/**
 * Created by Hawkeye on 3/18/14.
 */
public class MaxSlice
{
    public static void main(String [] args)
    {
        int [] A = {-3, -2, -29, -4, -2};
        System.out.println(new MaxSlice().solution(A));
    }
    public int solution(int[] A) {
        int curr = 0;
        int max = 0;
        int bestItem = A[0];
        for(int i=0; i<A.length; i++)
        {
            if(curr + A[i] > max)
            {
                max = curr + A[i];
            }

            curr = curr + A[i];

            // If stuff doesnt work out, let's reset
            if(curr < 0)
            {
                curr = 0;
            }

            if(bestItem < A[i])
            {
                bestItem = A[i];
            }
        }
        return max == 0 ? bestItem : max;
    }

}
