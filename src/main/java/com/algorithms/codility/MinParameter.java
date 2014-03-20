package com.algorithms.codility;

/**
 * Created by Hawkeye on 3/18/14.
 */
public class MinParameter
{
    public static void main(String [] args)
    {
        int N =  982451653;
        System.out.println(new MinParameter().solution(N));
    }
    public int solution(int N) {
        int x = 0;
        for(int i = (int) Math.sqrt(N); i>0;i--)
        {
            if(N % i == 0)
            {
                x = i;
                break;
            }
        }
        return 2*x + 2*(N/x);
    }
}
