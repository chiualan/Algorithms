package com.algorithms;

import java.io.IOException;

/**
 * buggy
 */
public class Factorial extends Base
{
    private static final String DIRECTORY_NAME = "Factorial";
    private static final String OUTPUT_LINE_FORMAT = "%s\n";

    public static void main(String [] args) throws IOException
    {
        Factorial factorial = new Factorial(args);
        factorial.invoke();
    }

    public Factorial(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        double toFactorial = Double.parseDouble(reader.readLine());
        double power = 1.0;
        double numberOfZeros = 0;
        double num = 0;
        double currentDivision = Math.pow(5.0, power);
        print(toFactorial);
        print(currentDivision);
        while(toFactorial > currentDivision)
        {

            num = toFactorial/currentDivision;

            power++;
            currentDivision = Math.pow(5.0, power);
            numberOfZeros = numberOfZeros + num;
        }
        print(power);
        writeOutput(OUTPUT_LINE_FORMAT, -1, String.format("%d", (int) numberOfZeros));
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
