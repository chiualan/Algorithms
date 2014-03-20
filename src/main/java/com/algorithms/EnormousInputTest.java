package com.algorithms;

import java.io.IOException;

/**
 * Created by Hawkeye on 3/15/14.
 */
public class EnormousInputTest extends Base
{
    private static final String INPUT_DELIM = " ";

    private static final String OUTPUT_RESULT_FORMAT = "%d";
    private static final String OUTPUT_FORMAT = "%s";
    private static final String DIRECTORY_NAME = "EnormousInputTest";

    private double div;
    private int totalDivsible;

    public static void main(String [] args) throws IOException
    {
        EnormousInputTest enormousInputTest = new EnormousInputTest(args);
        enormousInputTest.invoke();
    }


    public EnormousInputTest(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doProblem() throws IOException
    {
        final String [] params = reader.readLine().split(INPUT_DELIM);
        final int numberOfCases = Integer.parseInt(params[0]);
        div = Double.parseDouble(params[1]);

        for(int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++)
        {
            doCase(caseNumber);
        }

        writeOutput(OUTPUT_FORMAT, -1, String.format(OUTPUT_RESULT_FORMAT, totalDivsible));
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        final double number = Double.parseDouble(reader.readLine());

        if(number % div == 0)
        {
            totalDivsible++;
        }
    }

    @Override
    public void writeOutput(final String format, final int caseNumber, final String result) throws IOException
    {
        writer.write(String.format(format, result));
    }

    @Override
    public String getDirectory()
    {
        return DIRECTORY_NAME;
    }
}
