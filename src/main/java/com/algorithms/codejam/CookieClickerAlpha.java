package com.algorithms.codejam;

import java.io.IOException;

/**
 * https://code.google.com/codejam/contest/2974486/dashboard#s=p1
 */
public class CookieClickerAlpha extends GoogleCodeJamBase
{
    private static final String INPUT_DIRECTORY = "CookieClickerAlpha";
    private static final String DOUBLE_7_FORMAT = "%.7f";

    public static void main(String [] args) throws IOException
    {
        new CookieClickerAlpha(args).invoke();
    }

    public CookieClickerAlpha(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        CookieRules input = new CookieRules(reader.readLine().split(" "));
        double timeForLazyWin = input.getWinningCondition()/input.getBaseCookiesPerSec();
        double maxFactories = getMaximumFactories(input);

        double bestTime = timeForLazyWin;
        for(double i = 1.0; i < maxFactories; i = i + 1.0)
        {
            double currentTime = computeBestTime(input, i);
            if(bestTime > currentTime)
            {
                bestTime = currentTime;
            }
        }

        writeSimpleOutput(OUTPUT_LINE_FORMAT, caseNumber, String.format(DOUBLE_7_FORMAT, bestTime));

    }

    private double getMaximumFactories(final CookieRules input)
    {
        int numOfFactories = 1;
        double currentCookiePerSec = input.getBaseCookiesPerSec();
        double time = input.getFarmCosts()/currentCookiePerSec;
        currentCookiePerSec = currentCookiePerSec + input.getFarmCookiesPerSec();
        while(time < input.getWinningCondition())
        {
            time = time + input.getFarmCosts()/(currentCookiePerSec);
            currentCookiePerSec = currentCookiePerSec + input.getFarmCookiesPerSec();
            numOfFactories++;
        }

        return numOfFactories;
    }

    private double computeBestTime(final CookieRules input, final double numOfFactoriesToBuy)
    {
        // Figure out how long it takes to buy that many factories
        double currentCookiePerSec = input.getBaseCookiesPerSec();
        double time = input.getFarmCosts()/currentCookiePerSec;
        currentCookiePerSec = currentCookiePerSec + input.getFarmCookiesPerSec();
        for(double i = 1.0; i < numOfFactoriesToBuy; i = i + 1.0)
        {
            time = time + input.getFarmCosts()/(currentCookiePerSec);
            currentCookiePerSec = currentCookiePerSec + input.getFarmCookiesPerSec();
        }

        // Once we have all the factories figure out how long it takes to get to the winning condition
        time = time + input.getWinningCondition()/currentCookiePerSec;
        return time;
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



    private static class CookieRules
    {
        final double farmCosts;
        final double baseCookiesPerSec;
        final double winningCondition;
        final double farmCookiesPerSec;

        CookieRules(String [] args)
        {
            farmCosts = Double.parseDouble(args[0]);
            farmCookiesPerSec = Double.parseDouble(args[1]);
            baseCookiesPerSec = 2.0;
            winningCondition = Double.parseDouble(args[2]);
        }

        public double getFarmCosts()
        {
            return farmCosts;
        }

        public double getBaseCookiesPerSec()
        {
            return baseCookiesPerSec;
        }

        public double getWinningCondition()
        {
            return winningCondition;
        }

        public double getFarmCookiesPerSec()
        {
            return farmCookiesPerSec;
        }
    }
}
