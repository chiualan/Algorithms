package com.algorithms.codejam;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://code.google.com/codejam/contest/635101/dashboard#s=p0
 */
public class FileFixIt extends GoogleCodeJamBase
{
    private static final String INPUT_DIRECTORY = "FileFixIt";

    public static void main(String [] args) throws IOException
    {
        new FileFixIt(args).invoke();
    }

    public FileFixIt(final String[] args) throws IOException
    {
        super(args);
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        ArgHelper inputLine = new ArgHelper(reader.readLine().split(" "));

        DirTrie trie = new DirTrie();

        // Create the 'free' dirs first
        for(int i = 0; i < inputLine.numOfPathsThatExists; i++)
        {
            trie.makeDir(reader.readLine().split("/"));
        }

        int numOfMkDir = 0;
        for(int i = 0; i < inputLine.numOfPathsToCreate; i++)
        {
            numOfMkDir = numOfMkDir + trie.makeDir(reader.readLine().split("/"));
        }
        writeOutput(OUTPUT_LINE_FORMAT, caseNumber, String.format("%d", numOfMkDir));
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

    public static class ArgHelper
    {
        int numOfPathsThatExists;
        int numOfPathsToCreate;

        ArgHelper(String [] inputArg)
        {
            numOfPathsThatExists = Integer.parseInt(inputArg[0]);
            numOfPathsToCreate = Integer.parseInt(inputArg[1]);
        }
    }

    public static class DirTrie
    {
        final Node root;

        DirTrie()
        {
            root = new Node("ROOT_DIR");
        }

        int makeDir(String [] directory)
        {
            int directoryCursor = 1;
            Node curr = root.getChild(directory[directoryCursor]);
            Node prev = root;

            // Traverse through to find the created directories
            while(curr != null && ++directoryCursor < directory.length)
            {
                prev = curr;
                curr = curr.getChild(directory[directoryCursor]);
            }

            // Create new directories
            curr = prev;
            for(int i = directoryCursor; i < directory.length; i++)
            {
                Node newNode = new Node(directory[i]);
                curr.addChild(newNode);
                curr = newNode;
            }

            return directory.length - directoryCursor;
        }
    }

    public static class Node
    {
        final String dirName;
        final Map<String, Node> children;

        Node(final String dirName)
        {
            this.dirName = dirName;
            children = new HashMap<String, Node>();
        }

        void addChild(Node newNode)
        {
            children.put(newNode.dirName, newNode);
        }

        Node getChild(String subDirName)
        {
            return children.get(subDirName);
        }
    }
}
