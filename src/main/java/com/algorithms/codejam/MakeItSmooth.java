package com.algorithms.codejam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://code.google.com/codejam/contest/544101/dashboard#s=p1&a=0
 */
public class MakeItSmooth extends GoogleCodeJamBase
{
    private static final String INPUT_DIRECTORY = "MakeItSmooth";

    public MakeItSmooth(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {

    }

    @Override
    public void writeOutput(final String format, final int caseNumber, final String result) throws IOException
    {

    }

    @Override
    public String getDirectory()
    {
        return INPUT_DIRECTORY;
    }

    public static class ColorList
    {
        List<Integer> colorSample;
        int smoothFactor;
        int costOfDeletion;
        int costOfInsertion;


        ColorList(int [] colorSample, int smoothFactor, int costOfDeletion, int costOfInsertion)
        {
            this.colorSample = new ArrayList<Integer>();

            for(int i = 0; i < colorSample.length; i++)
            {
                this.colorSample.add(colorSample[i]);
            }

            this.smoothFactor = smoothFactor;
            this.costOfDeletion = costOfDeletion;
            this.costOfInsertion = costOfInsertion;
        }

        int calculateBestCost(int index)
        {

            int insertion = getInsertionCost(index);
            int deletion = getDeletionCost(index);
            int modification = getModificationCost(index);

            return 0;
        }

        private int getModificationCost(final int index)
        {
            int prev = getPrev(index);
            int next = getNext(index);
            int curr = colorSample.get(index);
            if(Math.abs(prev - curr) > smoothFactor || Math.abs(next - curr) > smoothFactor)
            {
                // Not smooth

            }
            return 0;
        }

        private int getDeletionCost(final int index)
        {
            // Do we delete
            return 0;
        }

        private int getInsertionCost(final int index)
        {
            return 0;
        }

        private int getPrev(final int index)
        {
            return index == 0 ? colorSample.get(index) : colorSample.get(index - 1);
        }

        private int getNext(final int index)
        {
            return index == colorSample.size() - 1 ? colorSample.get(index) : colorSample.get(index + 1);
        }

    }
}
