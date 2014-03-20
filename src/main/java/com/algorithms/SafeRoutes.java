package com.algorithms;

import java.io.IOException;
import java.util.*;

/**
 * buggy
 */
public class SafeRoutes extends Base
{
    private static final String INPUT_DIRECTORY = "SafeRoutes";
    private static final String INPUT_DELIM = " ";


    private static final String OUTPUT_FORMAT = "%s\n";

    private final Map<String, Town> routes;
    private int safePaths;

    public static void main(String [] args) throws IOException
    {
        SafeRoutes safeRoutes = new SafeRoutes(args);
        safeRoutes.invoke();
    }

    public SafeRoutes(final String[] args) throws IOException
    {
        super(args);

        routes = new HashMap<String, Town>();
        safePaths = 0;
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        String [] road = reader.readLine().split(INPUT_DELIM);
        insertRoad(road[0], road[1]);
        print("CASE "+ caseNumber);
        writeOutput(OUTPUT_FORMAT, -1, String.format("%d", safePaths));
    }

    private void insertRoad(final String road1, final String road2)
    {
        Town town1 = getRoad(road1);
        Town town2 = getRoad(road2);

        town1.getNeighboringTowns().add(town2);
        town2.getNeighboringTowns().add(town1);
        safePaths = safePaths + depthFirstSearch(town1);
    }

    private int depthFirstSearch(Town town)
    {
        int numberOfPaths = 0;
        Stack<Town> stack = new Stack();
        Map<String, Town> visited = new HashMap<String, Town>();

        visited.put(town.getName(), town);
        stack.addAll(town.getNeighboringTowns());

        while(!stack.isEmpty())
        {
            Town nextTown = stack.pop();

            if(visited.get(nextTown.getName()) == null)
            {
                stack.addAll(nextTown.getNeighboringTowns());
                print(nextTown.getName());

                numberOfPaths++;
                visited.put(nextTown.getName(), nextTown);
            }
        }
        return numberOfPaths;
    }

    private Town getRoad(final String road)
    {
        Town town = routes.get(road);
        if(town == null)
        {
            town = new Town(road);
            routes.put(road, town);
        }
        return town;
    }

    @Override
    public void writeOutput(final String format, final int caseNumber, final String result) throws IOException
    {
        writer.write(String.format(format, result));
    }

    @Override
    public String getDirectory()
    {
        return INPUT_DIRECTORY;
    }

    public class Town
    {
        private Collection<Town> neighboringTowns;
        private String name;


        public Town(final String name)
        {
            this.name = name;
            this.neighboringTowns = new HashSet<Town>();
        }

        public String getName()
        {
            return name;
        }

        public Collection<Town> getNeighboringTowns()
        {
            return neighboringTowns;
        }
    }
}