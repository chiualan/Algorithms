package com.algorithms.codility;

import java.util.Arrays;

/**
 * Created by Hawkeye on 3/18/14.
 */
public class Peaks
{
    public static void main(String [] args)
    {
        int [] A =  {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(new Peaks().solution(A));
    }
    public int solution(int [] A) {
        int num = 1;
        boolean [] peaks = new boolean[A.length];
        for(int i = 1; i<A.length-1; i++)
        {
            if(A[i-1] < A[i] && A[i] > A[i+1])
            {
                peaks[i] = true;
            }
        }

        for(int i = (int)Math.sqrt(A.length); i>0;i--)
        {
            if(A.length % i == 0)
            {
                num = divide(peaks, i) ? i : num;
            }
        }

        System.out.println(Arrays.toString(peaks));

        return A.length/num;
    }

    private boolean divide(final boolean[] peaks, final int i)
    {
        boolean ret = false;
        int index = 0;
        for(int j = 0; j < peaks.length/i ; j++)
        {
            boolean seg = false;
            for(int k = 0; k < i; k++)
            {
                System.out.println(peaks[index]);
                seg = seg || peaks[index];
                index++;
            }
            System.out.println(" ");
            ret = ret || seg;
        }
        return ret;
    }
}
