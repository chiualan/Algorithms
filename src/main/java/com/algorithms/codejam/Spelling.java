package com.algorithms.codejam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * https://code.google.com/codejam/contest/351101/dashboard#s=p2
 */
public class Spelling extends GoogleCodeJamBase
{
    public static final String OUTPUT_FORMAT = "Case #%d: %s\n";
    private static final String INPUT_DIRECTORY = "Spelling";

    private static Map<Character, String> characterStringMap = new HashMap<Character, String>();
    private static Map<Character, String> characterNumberMap = new HashMap<Character, String>();

    public Spelling(final String[] args) throws IOException
    {
        super(args);
    }

    public static void main(String [] args) throws IOException
    {
        Spelling spelling = new Spelling(args);
        spelling.init();
        spelling.invoke();
    }
    private void init()
    {
        characterStringMap.put('A', "2");
        characterStringMap.put('B', "22");
        characterStringMap.put('C', "222");
        characterStringMap.put('D', "3");
        characterStringMap.put('E', "33");
        characterStringMap.put('F', "333");
        characterStringMap.put('G', "4");
        characterStringMap.put('H', "44");
        characterStringMap.put('I', "444");
        characterStringMap.put('J', "5");
        characterStringMap.put('K', "55");
        characterStringMap.put('L', "555");
        characterStringMap.put('M', "6");
        characterStringMap.put('N', "66");
        characterStringMap.put('O', "666");
        characterStringMap.put('P', "7");
        characterStringMap.put('Q', "77");
        characterStringMap.put('R', "777");
        characterStringMap.put('S', "7777");
        characterStringMap.put('T', "8");
        characterStringMap.put('U', "88");
        characterStringMap.put('V', "888");
        characterStringMap.put('W', "9");
        characterStringMap.put('X', "99");
        characterStringMap.put('Y', "999");
        characterStringMap.put('Z', "9999");
        characterStringMap.put(' ', "0");

        characterNumberMap.put('A', "2");
        characterNumberMap.put('B', "2");
        characterNumberMap.put('C', "2");
        characterNumberMap.put('D', "3");
        characterNumberMap.put('E', "3");
        characterNumberMap.put('F', "3");
        characterNumberMap.put('G', "4");
        characterNumberMap.put('H', "4");
        characterNumberMap.put('I', "4");
        characterNumberMap.put('J', "5");
        characterNumberMap.put('K', "5");
        characterNumberMap.put('L', "5");
        characterNumberMap.put('M', "6");
        characterNumberMap.put('N', "6");
        characterNumberMap.put('O', "6");
        characterNumberMap.put('P', "7");
        characterNumberMap.put('Q', "7");
        characterNumberMap.put('R', "7");
        characterNumberMap.put('S', "7");
        characterNumberMap.put('T', "8");
        characterNumberMap.put('U', "8");
        characterNumberMap.put('V', "8");
        characterNumberMap.put('W', "9");
        characterNumberMap.put('X', "9");
        characterNumberMap.put('Y', "9");
        characterNumberMap.put('Z', "9");
        characterNumberMap.put(' ', "0");

    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        String phrase = reader.readLine().toUpperCase();
        StringBuilder sb = new StringBuilder();
        sb.append(characterStringMap.get(phrase.charAt(0)));
        for(int i = 1; i < phrase.length(); i++)
        {
            char curr = phrase.charAt(i);
            char prev = phrase.charAt(i - 1);


            if(characterNumberMap.get(curr).equals(characterNumberMap.get(prev)))
            {
                sb.append(" ");
            }

            sb.append(characterStringMap.get(curr));
        }

        writeOutput(OUTPUT_FORMAT, caseNumber, sb.toString());
    }

    @Override
    public void writeOutput(final String format, final int caseNumber, final String result) throws IOException
    {
        writer.write(String.format(format, caseNumber, result));
    }

    @Override
    public String getDirectory()
    {
        return INPUT_DIRECTORY;
    }
}
