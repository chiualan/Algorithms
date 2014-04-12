package com.algorithms.codejam;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * https://code.google.com/codejam/contest/2974486/dashboard#s=p0
 */
public class MagicTrick extends GoogleCodeJamBase
{
    private static final String INPUT_DIRECTORY = "MagicTrick";

    private static final String BAD_MAGICIAN = "Bad magician!";
    private static final String VOLUNTEER_CHEATED = "Volunteer cheated!";

    public static void main(String [] args) throws IOException
    {
        new MagicTrick(args).invoke();

    }

    public MagicTrick(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        Set<Integer> firstSet = getPossibilities();
        Set<Integer> secondSet = getPossibilities();

        String result = determinResult(firstSet, secondSet);

        writeOutput(OUTPUT_LINE_FORMAT, caseNumber, result);

    }

    private String determinResult(final Set<Integer> firstSet, final Set<Integer> secondSet)
    {
        int counter = 0;
        Integer potentialCard = null;
        for(Integer i : firstSet)
        {
            if(secondSet.contains(i))
            {
                potentialCard = i;
                counter++;
            }
        }

        if(counter == 1)
        {
            // Write the card
            return potentialCard.toString();
        }
        else if(counter > 1)
        {
            // Write bad magician
            return BAD_MAGICIAN;
        }
        else
        {
            // Volunteer cheated
            return VOLUNTEER_CHEATED;
        }
    }

    private Set<Integer> getPossibilities() throws IOException
    {
        int firstChosenRow = Integer.parseInt(reader.readLine());
        String importantLine = "";

        // Skip the lines we don't care about
        for(int i = 1; i <= 4; i++)
        {
            String currentLine = reader.readLine();
            if(i == firstChosenRow)
            {
                importantLine = currentLine;
            }
        }

        return parseToSet(importantLine);
    }

    private Set<Integer> parseToSet(final String input)
    {
        String [] row = input.split(" ");
        Set<Integer> returnedSet = new HashSet<Integer>();
        for(String i : row)
        {
            returnedSet.add(Integer.parseInt(i));
        }

        return returnedSet;
    }

    @Override
    public void writeOutput(final String format, final int caseNumber, final String result) throws IOException
    {
        writeSimpleOutput(format, caseNumber, result);
    }

    @Override
    public String getDirectory()
    {
        return INPUT_DIRECTORY;
    }
}
