package com.algorithms.codejam;

import java.io.IOException;

/**
 * https://code.google.com/codejam/contest/351101/dashboard#s=p1
 */
public class ReverseWords extends GoogleCodeJamBase
{
    public static final String OUTPUT_FORMAT = "Case #%d: %s\n";
    private static final String INPUT_DIRECTORY = "ReverseWords";

    public static void main(String [] args) throws IOException
    {
        new ReverseWords(args).invoke();
    }

    public ReverseWords(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        String [] phrase = reader.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = phrase.length - 1; i > 0; i--)
        {
            sb.append(phrase[i].trim());
            sb.append(" ");
        }
        sb.append(phrase[0]);

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
