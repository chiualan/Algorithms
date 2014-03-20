package com.algorithms;

/**
 * Created by Hawkeye on 3/19/14.
 */
public class LinkedIn
{
//    gbayer@linkedin.com
//    hramacha@linkedin.com - hari
//
//    The interface is given below:
//    /** Convert the given number to roman numerals and return as a String. */
//    public String toRomanNumerals(int number);
//    /** Parse the String of roman numerals and return its int value. */
//    public int parseRomanNumerals(String roman);
//
//
//    Letter = Value
//        I = 1
//    V = 5
//    X = 10
//    L = 50
//    C = 100
//    D = 500
//    M = 1000
//
//    I, II, III, IV, V, VI, VII, VIII, IX, X ( 1 to 10 )
//    17 would be XVII
//    45 = VL
//    55 = LV
//
///**
// * IV =4
// * IX = 9
// * IL =49
// * VL = 45
// * IIII -> 4
// * IIIII -> -1
// * VV -> -1
// * LL, CC, DD -> -1
// * VC -> 95
// * LXXXXV - > 95
// * CV -> 105
// */
//
//        input = 1934
//    sb.append("M"); // 934
//    sb.append("D"); // 434
//    sb.append("C"); // 334
//    sb.append("C"); // 234
//    sb.append("C"); // 134
//    sb.append("C"); // 34
//    sb.append("X"); // 24
//    sb.append("X"); // 14
//    sb.append("X"); // 4
//    sb.append("I") ...
//
//    public class AlanTranslator implements Translator {
//
//        private final Map<Integer, String> romanNumerals;
//
//        public AlanTranslator() {
//            romanNumerals = new HashMap<Integer, String>();
//            romanNumerals.put(1, "I");
//            romanNumerals.put(5, "V");
//            romanNumerals.put(10, "X");
//            romanNumerals.put(50, "L");
//            romanNumerals.put(100, "C");
//            romanNumerals.put(500, "D");
//            romanNumerals.put(1000, "M");
//        }
//
//        /**
//         * -1 -> "", 0 -> "", 4 -> "IIII", 10,000 -> "MMMMMMMMMM", 15 -> "XV"
//         */
//        @Override
//        public String toRomanNumerals(int number) {
//            StringBuilder sb = new StringBuilder();
//            int remaining = number;
//            while(remaining > 0) {
//                if(remaining > 1000) {
//                    sb.append(checkRoman(remaining, 1000);
//                }
//                else if(remaining > 500){
//                    sb.append(checkRoman(remaining, 500);
//                }
//                else if(remaining > 100) {
//                    sb.append(checkRoman(remaining, 100);
//                }
//                else if(remaining > 50) {
//                    sb.append(checkRoman(remaining, 50 );
//                }
//                else if(remaining > 10) {
//                    sb.append(checkRoman(remaining, 10 );
//                }
//                else if(remaining > 5) {
//                    sb.append(checkRoman(remaining, 5);
//                }
//                else {
//                    sb.append(checkRoman(remaining, 1);
//                }
//            }
//            return sb.toString();
//        }
//
//        private String checkRoman(int input, int romanInt) {
//            if(input > romanInt) {
//                input - romanInt;
//                return romanNumberals.get(romanInt);
//            }
//            return null;
//        }
//
//
//        @Override
//        public int parseRomanNumerals(String roman) {
//
//        }
//    }
//
//
//
//    public interface Triangle {
//
//        /**
//         * Three segments of lengths A, B, C form a triangle iff
//         *
//         *      A + B > C
//         *      B + C > A
//         *      A + C > B
//         *
//         * e.g.
//         *  6, 4, 5 can form a triangle
//         * 10, 2, 7 can't
//         *
//         * Given a list of segments lengths algorithm should find at least one triplet of segments that form a triangle (if any).
//         *
//         * Method should return an array of either:
//         * - 3 elements: segments that form a triangle (i.e. satisfy the condition above)
//         * - empty array if there are no such segments
//         */
//        int[] getTriangleSides(int[] segments);
//    }
//
//    /**
//     * {1 ,2} -> empty
//     * {1} -> empty
//     * {} -> empty
//     * {2, 7, 10} -> empty
//     * {6, 4, 5} -> {6, 4 ,5}
//     *
//     */
//    public class AlanTriangle implements Triangle {
//
//        @Override
//        public int[] getTriangleSides(int [] segments) {
//            Arrays.sort(segments); // Sorts the array O(nlogn) time
//
//            int [] returnValue = new int [3];
//            for(int i=0; i < segments.length-2; i++) { // O(n) time
//                if(segments[i] + segments[i+1] > segments[i+2]) {
//                    returnValue[0] = segments[i];
//                    returnValue[1] = segments[i+1];
//                    returnValue[2] = segments[i+2];
//                    return returnValue;
//
//                }
//            }
//
//            return new int[0];
//        }
//    }
}
