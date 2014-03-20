package com.algorithms.codility;

import java.util.Arrays;

/**
 * Created by Hawkeye on 3/18/14.
 */
public class Dominator
{
    public static void main(String [] args)
    {
        int [] A = {0, 0, 1, 1, 1};
        System.out.println(new Dominator().solution(A));
    }
    public int solution(int[] A) {
        // write your code in Java SE 7
        int [] B = new int[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int candidateCount = 1;
        int candidate = A[0];
        int currentCandidate = A[0];
        int currentCount = 1;
        for(int i = 1; i < A.length; i++)
        {
            if(currentCandidate == A[i])
            {
                currentCount ++;
            }
            else
            {
                if(currentCount > candidateCount)
                {
                    candidate = currentCandidate;
                    candidateCount = currentCount;
                }

                currentCandidate = A[i];
                currentCount = 1;
            }
        }
        if(currentCount > candidateCount)
        {
            candidate = currentCandidate;
            candidateCount = currentCount;
        }

        if(candidateCount > A.length/2)
        {
            for(int i = 0; i < A.length; i++)
            {
                if(candidate == B[i])
                {
                    return i;
                }
            }
        }
        return -1;
    }
}
