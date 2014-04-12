package com.algorithms.codejam;

import java.io.IOException;
import java.util.Arrays;

/**
 * https://code.google.com/codejam/contest/2974486/dashboard#s=p3
 */
public class DeceitfulWar extends GoogleCodeJamBase
{
    private static final String INPUT_DIRECTORY = "DeceitfulWar";
    private static final String OUTPUT_CASE_FORMAT = "%d %d";

    public static void main(String [] args) throws IOException
    {
        new DeceitfulWar(args).invoke();
    }

    public DeceitfulWar(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        String numOfBlocks = reader.readLine(); // we don't care about this

        double [] naomiBlocks = parseToDoubleArray(reader.readLine().split(" "));
        double [] stinkyKenBlocks = parseToDoubleArray(reader.readLine().split(" "));

        print(caseNumber);
        print(Arrays.toString(naomiBlocks));
        print(Arrays.toString(stinkyKenBlocks));

        int numOfDeceitfulWins = determineDecietfulWins(naomiBlocks, stinkyKenBlocks);
        int numOfVanillaWins = determineVanillaWins(naomiBlocks, stinkyKenBlocks);

        writeSimpleOutput(OUTPUT_LINE_FORMAT, caseNumber, String.format(OUTPUT_CASE_FORMAT, numOfDeceitfulWins, numOfVanillaWins));
    }

    private int determineVanillaWins(final double[] naomi, final double[] ken)
    {
        double [] naomiBlocks = Arrays.copyOf(naomi, naomi.length);
        double [] stinkyKenBlocks = Arrays.copyOf(ken, ken.length);

        int kenCursor = 0;
        for(int i = 0; i < naomiBlocks.length && kenCursor < stinkyKenBlocks.length; i++)
        {
            while(naomiBlocks[i] > stinkyKenBlocks[kenCursor] && kenCursor < stinkyKenBlocks.length - 1)
            {
                kenCursor++;
            }

            stinkyKenBlocks[kenCursor] = -1; // sacrifice this
        }

        int kensWins = 0;
        for(int i = 0; i < stinkyKenBlocks.length; i++)
        {
            if(stinkyKenBlocks[i] == -1)
            {
                kensWins++;
            }
        }

        return stinkyKenBlocks.length - kensWins;
    }

    private int determineDecietfulWins(final double[] naomi, final double[] ken)
    {
        double [] naomiBlocks = Arrays.copyOf(naomi, naomi.length);
        double [] stinkyKenBlocks = Arrays.copyOf(ken, ken.length);

        int kenStartCursor = 0;
        int naomiStartCursor = 0;
        int kenEndCursor = stinkyKenBlocks.length - 1;
        int naomiEndCursor = naomiBlocks.length - 1;
        while(naomiStartCursor < naomiBlocks.length
                && kenStartCursor < stinkyKenBlocks.length
                && kenEndCursor >= 0
                && naomiEndCursor >= 0)
        {
            if(naomiBlocks[naomiStartCursor] > stinkyKenBlocks[kenStartCursor])
            {
                // Bluff big so Ken uses his smallest block
                stinkyKenBlocks[kenStartCursor] = -1;  // Ken loses, set to -1
                naomiStartCursor++;
                kenStartCursor++;
            }
            else
            {
                // Buff kind of big and offer as sacrifice since this block is smaller than all of kens blocks
                naomiStartCursor++;
                kenEndCursor--;
            }
        }

        int numOfKenLosses = 0;
        for(int i = 0; i < stinkyKenBlocks.length; i++)
        {
            if(stinkyKenBlocks[i] == -1)
            {
                numOfKenLosses++;
            }
        }

        return numOfKenLosses; // Ken's losses is the same as Naomi's wins
    }

    private double [] parseToDoubleArray(final String[] values)
    {
        double [] doubleValues = new double[values.length];
        for(int i = 0; i < values.length; i++)
        {
            doubleValues[i] = Double.parseDouble(values[i]);
        }

        Arrays.sort(doubleValues);
        return doubleValues;
    }

    @Override
    public void writeOutput(final String format, final int caseNumber, final String result) throws IOException
    {
        // do nothing
    }

    @Override
    public String getDirectory()
    {
        return INPUT_DIRECTORY;
    }
}
