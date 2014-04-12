package com.algorithms.codejam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://code.google.com/codejam/contest/32016/dashboard#s=p1
 * TODO: DONT WANT TO FINISH, N^2 SOLUTION SUCKS
 */
public class Milkshakes extends GoogleCodeJamBase
{
    private static final String INPUT_DIRECTORY = "Milkshakes";

    public static void main(String [] args) throws IOException
    {
        new Milkshakes(args).invoke();
    }

    public Milkshakes(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        int numOfFlavors = Integer.parseInt(reader.readLine());
        int numOfCustomers = Integer.parseInt(reader.readLine());
        List<Customer> customerList = new ArrayList<Customer>();
        for(int i = 0; i < numOfCustomers; i++)
        {
            int [] rawCustomerInputs = parseIntArray(reader.readLine());
            customerList.add(Customer.factory(rawCustomerInputs));
        }

        int [] milkshakeBatch = new int[numOfFlavors];
        for(Customer customer : customerList)
        {
            for(Customer otherCustomers : customerList)
            {

            }

        }

    }

    @Override
    public void writeOutput(final String format, final int caseNumber, final String result) throws IOException
    {

    }

    private int[] parseIntArray(final String input)
    {
        String [] stringArray = input.split(" ");
        int [] intArray = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++)
        {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;
    }

    private static class Milkshake
    {
        int flavor;
        boolean isMalted;

        Milkshake(final int flavor, final int isMalted)
        {
            this.flavor = flavor;
            this.isMalted = isMalted == 1;
        }

        @Override
        public String toString()
        {
            return String.format("Milkshake:[Flavor : %d, isMalted : %s]", flavor, isMalted);
        }

        public int getFlavor()
        {
            return flavor;
        }

        public boolean isMalted()
        {
            return isMalted;
        }
    }
    private static class Customer
    {
        int numOfLikes = 0;
        List<Milkshake> milkshakeList;

        Customer(int numOfLikes, ArrayList<Milkshake> milkshakeList)
        {
            this.numOfLikes = numOfLikes;
            this.milkshakeList = milkshakeList;
        }

        static Customer factory(int [] rawInput)
        {
            int numOfLikes = rawInput[0];
            ArrayList<Milkshake> milkshakes = new ArrayList<Milkshake>();
            for(int i = 1; i < rawInput.length; i = i + 2)
            {
                milkshakes.add(new Milkshake(rawInput[i], rawInput[i+1]));
            }
            return new Customer(numOfLikes, milkshakes);
        }

        @Override
        public String toString()
        {
            return String.format("Customer:[Number of likes : %d, MilkShake list : %s", numOfLikes, milkshakeList);
        }

        public List<Milkshake> getMilkshakeList()
        {
            return milkshakeList;
        }

        public int getNumOfLikes()
        {
            return numOfLikes;
        }
    }

    @Override
    public String getDirectory()
    {
        return INPUT_DIRECTORY;
    }
}
