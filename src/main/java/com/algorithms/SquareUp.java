package com.algorithms;

import java.util.HashMap;
import java.util.Map;

public class SquareUp
{
    private static String[] DICTIONARY = new String[] {"hell", "hello", "heaven", "goodbye"};
    private static Node root;

    public static void main(String[] args) {
        root = buildTree();
        for (String word : DICTIONARY) {
            test(word);
        }
    }

    private static void test(String word) {
        System.out.println("Test "+word + ": " + numKeystrokes(word));
    }

    private static int numKeystrokes(String word) {
        Node cursor = root.children.get(word.charAt(0));

        int num = 1;
        for(int i = 1; i<word.length(); i++)
        {

            if(cursor == null)
            {
                return num + word.length() - i + 1 ;
            }
            if(cursor.children.size() == 1 && !cursor.isEnd)
            {
                cursor = cursor.children.get(word.charAt(i));
            }
            else
            {
                num++;
                cursor = cursor.children.get(word.charAt(i));
            }
        }
        return num;
    }

    private static Node buildTree()
    {
        Node root = new Node(' ');
        Node curr = root;
        for(String word : DICTIONARY)
        {
            curr = root;
            for(int i=0; i<word.length();i++)
            {
                Node n = new Node(word.charAt(i));
                if(i == word.length() - 1)
                {
                    n.isEnd = true;
                }
                if (curr.children.get(n.c) == null)
                {
                    curr.children.put(n.c, n);
                    curr = n;
                }
                else
                {
                    curr = curr.children.get(n.c);
                }

            }
        }
        return root;
    }

    public static class Node
    {
        public char c;
        public Map<Character, Node> children;
        public boolean isEnd = false;

        public Node(char c)
        {
            this.c = c;
            children = new HashMap<Character, Node>();
        }

        @Override
        public String toString()
        {
            return c + " " + children.size();
        }
    }
}
