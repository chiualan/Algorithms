package com.algorithms;

import java.util.*;

//    I = 1
//    V = 5
//    X = 10
//    L = 50
//    C = 100
//    D = 500
//    M = 1000
public class RomanNumerals
{
    private final Map<Character, Integer> romToInt;
    private final Map<Integer, String> intToRom;

    public static void main(String [] args)
    {
        RomanNumerals rn = new RomanNumerals();
        System.out.println(rn.toRoman(2565));
        System.out.println(rn.fromRoman("LC"));
        boolean x = true;
        for(int i = 0; i<10000; i++)
        {
            x = x && rn.fromRoman(rn.toRoman(i)) == i;
        }
        System.out.println(x);
    }

    public RomanNumerals()
    {
        romToInt = new HashMap<Character, Integer>();
        romToInt.put('I', 1);
        romToInt.put('V', 5);
        romToInt.put('X', 10);
        romToInt.put('L', 50);
        romToInt.put('C', 100);
        romToInt.put('D', 500);
        romToInt.put('M', 1000);

        intToRom = new HashMap<Integer, String>();
        intToRom.put(1, "I");
        intToRom.put(5, "V");
        intToRom.put(10, "X");
        intToRom.put(50, "L");
        intToRom.put(100, "C");
        intToRom.put(500, "D");
        intToRom.put(1000, "M");
    }
    public int fromRoman(String roman)
    {
        int num = 0;
        RomanQueue rq = new RomanQueue(roman);
        while(!rq.isEmpty())
        {
            if(rq.size() == 1)
            {
                Integer next = romCharToInt(rq.pop());
                if(next == -1)
                {
                    return -1;
                }
                else
                {
                    num = num + next;
                }
            }
            else
            {
                Integer next = romCharToInt(rq.pop());
                Integer nextPeek = romCharToInt(rq.peek());
                if(next == -1 || nextPeek == -1)
                {
                    return -1;
                }
                else
                {
                    if(next < nextPeek)
                    {
                        num = num + nextPeek - next;
                        rq.pop();
                    }
                    else
                    {
                        num = num + next;
                    }
                }
            }
        }
        return num;
    }


    private int romCharToInt(Character c)
    {
        Integer ret = romToInt.get(c);
        if(ret == null)
        {
            return -1;
        }
        else
        {
            return ret;
        }
    }

    public class RomanQueue
    {
        private final Queue<Character> queue;

        public RomanQueue(String string)
        {
            queue = new LinkedList<Character>();
            for(int i=0; i<string.length(); i++)
            {
                queue.add(string.charAt(i));
            }
        }

        public char peek()
        {
            return queue.peek();
        }

        public char pop()
        {
            return queue.remove();
        }

        public boolean isEmpty()
        {
            return queue.isEmpty();
        }

        public int size()
        {
            return queue.size();
        }

    }

        public String toRoman(int number) {
            StringBuilder sb = new StringBuilder();
            int remaining = number;
            while(remaining > 0) {
                if(remaining >= 1000) {
                    remaining = checkRoman(remaining, 1000, sb);
                }
                else if(remaining >= 500){
                    remaining = checkRoman(remaining, 500, sb);
                }
                else if(remaining >= 100) {
                    remaining = checkRoman(remaining, 100, sb);
                }
                else if(remaining >= 50) {
                    remaining = checkRoman(remaining, 50, sb);
                }
                else if(remaining >= 10) {
                    remaining = checkRoman(remaining, 10, sb);
                }
                else if(remaining >= 5) {
                    remaining = checkRoman(remaining, 5, sb);
                }
                else {
                    remaining = checkRoman(remaining, 1, sb);
                }
            }
            return sb.toString();
        }

        private int checkRoman(int input, int romanInt, StringBuilder sb) {
            String s = intToRom.get(romanInt);
            if(input >= romanInt && s != null) {
                sb.append(s);
                return input - romanInt;
            }
            return 0;
        }
}
