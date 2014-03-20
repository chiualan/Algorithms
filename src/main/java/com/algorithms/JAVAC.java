package com.algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * http://www.spoj.com/problems/JAVAC/
 */
public class JAVAC extends Base
{
    private static final String INPUT_DIRECTORY = "JAVAC";
    private static final String OUTPUT_RESULT_FORMAT = "%s\n";

    private static final String JAVA_REGEX = "^[a-z]+([A-Z][a-z]*)*";

    private static final String CPP_REGEX = "^[a-z]+(_[a-z]+)*";

    private static final Pattern javaRegex = Pattern.compile(JAVA_REGEX);
    private static final Pattern cppRegex = Pattern.compile(CPP_REGEX);
    private static final String BAD_PATTERN_RETURN = "Error!";

    private final IPattern [] listOfPatterns = {new JavaPattern(), new CppPattern()};

    public JAVAC(final String[] args) throws IOException
    {
        super(args);
    }

    public static void main(String [] args) throws IOException
    {
        JAVAC javac = new JAVAC(args);
        javac.invoke();
    }

    @Override
    public void doCase(final int caseNumber) throws IOException
    {
        String phrase = reader.readLine();
        String translatedPhrase = null;

        // Check if the translation is good
        boolean isValid = false;
        for(IPattern pattern : listOfPatterns)
        {
            if(pattern.isValid(phrase))
            {
               translatedPhrase = pattern.translate(phrase);
            }
        }
        translatedPhrase = translatedPhrase == null ? BAD_PATTERN_RETURN : translatedPhrase;

        writeOutput(OUTPUT_RESULT_FORMAT, -1, translatedPhrase);
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

    private class JavaPattern implements IPattern
    {
        Pattern javaPattern = javaRegex;
        String splittingString = "((^[a-z]+)|([0-9]+)|([A-Z]{1}[a-z]+)|([A-Z]+(?=([A-Z][a-z])|($)|([0-9]))))";
        static final String DELIM = " $0";

        @Override
        public Pattern getPattern()
        {
            return javaPattern;
        }

        @Override
        public String getSplittingString()
        {
            return splittingString;
        }

        @Override
        public String translate(final String phrase)
        {
            if(!isValid(phrase))
            {
                return null;
            }

            String filteredString = phrase.replaceAll(getSplittingString(), DELIM);
            String [] split = filteredString.split(" ");
            print(Arrays.toString(split));

            StringBuilder sb = new StringBuilder();
            sb.append(split[1]);
            for(int i = 2; i < split.length; i++)
            {
                sb.append("_");
                sb.append(split[i].toLowerCase());
            }

            return sb.toString();
        }

        @Override
        public boolean isValid(final String phrase)
        {
            return getPattern().matcher(phrase).matches();
        }
    }

    private class CppPattern implements IPattern
    {
        Pattern cppPattern = cppRegex;
        String splittingString = "_";

        @Override
        public Pattern getPattern()
        {
            return cppPattern;
        }

        @Override
        public String getSplittingString()
        {
            return splittingString;
        }

        @Override
        public String translate(final String phrase)
        {
            if(!isValid(phrase))
            {
                return null;
            }

            String [] split = phrase.split(getSplittingString());
            StringBuilder sb = new StringBuilder();
            sb.append(split[0]);
            for(int i = 1; i < split.length; i++)
            {
                sb.append(split[i].substring(0,1).toUpperCase());
                sb.append(split[i].substring(1));
            }
            return sb.toString();
        }

        @Override
        public boolean isValid(final String phrase)
        {
            return getPattern().matcher(phrase).matches();
        }
    }

    private interface IPattern
    {
        Pattern getPattern();
        String getSplittingString();
        String translate(String phrase);
        boolean isValid(String phrase);
    }
}