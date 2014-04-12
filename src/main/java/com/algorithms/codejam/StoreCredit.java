package com.algorithms.codejam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://code.google.com/codejam/contest/351101/dashboard#s=p0
 */
public class StoreCredit extends GoogleCodeJamBase
{
    private static final String INPUT_DIRECTORY = "StoreCredit";
    public static final String OUTPUT_FORMAT = "Case #%d: %s\n";

    public static void main(String [] args) throws IOException
    {
        new StoreCredit(args).invoke();
    }

    public StoreCredit(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        int credit = Integer.parseInt(reader.readLine());
        int numOfItems = Integer.parseInt(reader.readLine()); // Dead read since this is java
        Item [] items = parseIntArray(reader.readLine());

        HashMap<Integer, Integer> itemCountMap = new HashMap<Integer, Integer>(); // Used to figure out if there is an item in the list
        HashMap<Integer, List<Integer>> itemPositionMap = new HashMap<Integer, List<Integer>>(); // Used to figure out the item positon

        for(Item item : items)
        {

            Integer count = itemCountMap.get(item.getCost());
            if(count == null)
            {
                itemCountMap.put(item.getCost(), 1);
            }
            else
            {
                itemCountMap.put(item.getCost(), count+1);
            }

            List<Integer> positions = itemPositionMap.get(item.getCost());
            if(positions == null)
            {
                List<Integer> listOfPositions = new ArrayList<Integer>();
                listOfPositions.add(item.getPosition());
                itemPositionMap.put(item.getCost(), listOfPositions);
            }
            else
            {
                positions.add(item.getPosition());
                itemPositionMap.put(item.getCost(), positions);
            }
        }

        for(Item item : items)
        {
            int targetCost = credit - item.getCost();
            Integer targetCount = itemCountMap.get(targetCost);

            if(targetCount != null)
            {

                // Possible candidate
                if(targetCost != item.getCost() || targetCount.intValue() > 1)
                {
                    // We found something and it's not the same index
                    generateOutput(itemPositionMap.get(targetCost), itemPositionMap.get(item.getCost()), caseNumber);
                    return;
                }
            }
        }
    }

    private void generateOutput(List<Integer> itemPosition1, List<Integer> itemPosition2, final int caseNumber) throws IOException
    {
        int position1;
        int position2;
        if(itemPosition1.equals(itemPosition2))
        {
            position1 = itemPosition1.get(0) + 1;
            position2 = itemPosition2.get(1) + 1;
        }
        else
        {
            position1 = itemPosition1.get(0) + 1;
            position2 = itemPosition2.get(0) + 1;

        }
        String outputString = position1 > position2
                ? position2 + " " + position1
                : position1 + " " + position2 ;
        writeOutput(OUTPUT_FORMAT, caseNumber, outputString);
    }

    private Item[] parseIntArray(final String input)
    {
        String [] stringArray = input.split(" ");
        Item [] itemArray = new Item[stringArray.length];
        for(int i = 0; i < stringArray.length; i++)
        {
            itemArray[i] = new Item(Integer.parseInt(stringArray[i]), i);
        }
        return itemArray;
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

    private static class Item
    {
        int cost;
        int position;

        public Item(int cost, int position)
        {
            this.cost = cost;
            this.position = position;
        }

        public int getCost()
        {
            return cost;
        }

        public int getPosition()
        {
            return position;
        }
    }
}