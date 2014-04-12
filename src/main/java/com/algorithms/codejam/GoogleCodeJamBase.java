package com.algorithms.codejam;

import java.io.*;

public abstract class GoogleCodeJamBase
{

    public static final String OUTPUT_LINE_FORMAT = "Case #%d: %s\n";

    private final String inputFile;
    private final String outputFile;

    public final BufferedReader reader;
    public final BufferedWriter  writer;


    public GoogleCodeJamBase(String[] args) throws IOException
    {
        inputFile = getInputFile(args);
        outputFile = getOutputFile(args);

        reader = getBufReader(inputFile);
        writer = getBufWriter(outputFile);
    }

    public static void main(final String [] args) throws IOException
    {
        // main function should just call new BaseImplementation.invoke()
        System.out.println("Write the main function, dummy.");
    }

    public void invoke() throws IOException
    {
        try
        {
            doProblem();
        }
        finally
        {
            reader.close();
            writer.close();
        }
    }

    public abstract void doCase(int caseNumber) throws IOException;

    public abstract void writeOutput(final String format, int caseNumber, final String result) throws IOException;

    public void writeSimpleOutput(final String format, final int caseNumber, final String result) throws IOException
    {
        final String outputLine = String.format(
                format, caseNumber, result);
        writer.write(outputLine);
    }

    public void doProblem() throws IOException
    {
        final int numberOfCases = getNumberOfCases();

        for(int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++)
        {
            doCase(caseNumber);
        }
    }

    private int getNumberOfCases() throws IOException
    {
        try
        {
            return Integer.parseInt(reader.readLine());
        }
        catch (final NumberFormatException e)
        {
            return 1;
        }
    }

    /**
     *
     * Possibly reusable stuff
     */
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String INPUT_OUTPUT_DIR_IN = "%s/src/main/results/%s/%s.in";
    private static final String INPUT_OUTPUT_DIR_OUT = "%s/src/main/results/%s/%s.out";

    public abstract String getDirectory();

    private BufferedWriter getBufWriter(final String fileName) throws IOException
    {
        return new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"));
    }

    private BufferedReader getBufReader(final String fileName) throws FileNotFoundException
    {
        return new BufferedReader(new FileReader(fileName));
    }

    private String getOutputFile(final String[] arg)
    {
        return String.format(INPUT_OUTPUT_DIR_OUT, USER_DIR, getDirectory(), "results");
    }

    private String getInputFile(final String[] arg)
    {
        return String.format(INPUT_OUTPUT_DIR_IN, USER_DIR, getDirectory(), getDirectory());
    }

    protected void print(Object ...listOfObjects)
    {
        for(Object singleObject : listOfObjects )
        {
            System.out.print(singleObject);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    protected void print(int i)
    {
        System.out.println(i);
    }
}
