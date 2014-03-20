package com.algorithms;

import java.io.IOException;

public class ATM extends Base
{
    private static final String INPUT_DIRECTORY = "ATM";

    private static final String INPUT_DELIM = " ";
    private static final double WITHDRAW_FEE = 0.50;

    public static void main(String [] args) throws IOException
    {
        final ATM atm = new ATM(args);

        atm.invoke();
    }

    public ATM(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        String [] caseInput = reader.readLine().split(INPUT_DELIM);
        double withdrawAmount = Double.parseDouble(caseInput[0]);
        double accountBalance = Double.parseDouble(caseInput[1]);
        double newBalance;

        if(validateWithdrawAmount(withdrawAmount, accountBalance))
        {
            newBalance = accountBalance - withdrawAmount - WITHDRAW_FEE;
        }
        else
        {
            newBalance = accountBalance;
        }

        writeOutput(OUTPUT_LINE_FORMAT, caseNumber, String.format("%.2f", newBalance));

    }

    private boolean validateWithdrawAmount(final double withdrawAmount, final double accountBalance)
    {
        return withdrawAmount + WITHDRAW_FEE <= accountBalance && (withdrawAmount % 5 == 0);

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
