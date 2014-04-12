package com.algorithms.codejam;

import java.io.IOException;
import java.util.Arrays;

/**
 * https://code.google.com/codejam/contest/32016/dashboard#s=p0
 */
public class MinScalarProduct extends GoogleCodeJamBase
{
    public static final String OUTPUT_FORMAT = "Case #%d: %s\n";
    private static final String INPUT_DIRECTORY = "MinScalarProduct";

    public MinScalarProduct(final String[] args) throws IOException
    {
        super(args);
    }

    public static void main(String [] args) throws IOException
    {
        new MinScalarProduct(args).invoke();
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        String scalarLength = reader.readLine(); //Throwaway

        long [] vector1 = parseIntArray(reader.readLine());
        long [] vector2 = parseIntArray(reader.readLine());
        reverse(vector2); // Reverse the second vector

        writeOutput(OUTPUT_FORMAT, caseNumber, scalarProduct(vector1, vector2));
    }

    private String scalarProduct(final long[] vector1, final long[] vector2)
    {
        long result = 0;
        for(int i = 0; i < vector1.length; i++)
        {
            result = result + vector1[i]*vector2[i];
        }
        return String.format("%d", result);
    }

    private void reverse(long [] array)
    {
        for(int i = 0; i < array.length/2; i++)
        {
            array[i] = array[i]^array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i]^array[array.length - 1 - i];
            array[i] = array[i]^array[array.length - 1 - i];
        }
    }

    private long[] parseIntArray(final String input)
    {
        String [] stringArray = input.split(" ");
        long [] intArray = new long[stringArray.length];
        for(int i = 0; i < stringArray.length; i++)
        {
            intArray[i] = Long.parseLong(stringArray[i]);
        }
        Arrays.sort(intArray);

        return intArray;
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
