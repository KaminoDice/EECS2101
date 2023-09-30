/**********************************************************
 * EECS2101A: Fundamentals of Data Structures,  Fall 2023
 * Assignment 1, Problem 2: A1.ArrayLongestPlateau.java
 * Student Name:   Huanrui Cao
 * Student EECS account:  Saikoro
 * Student ID number:  219256809
 **********************************************************/

package A1;

/**
 * The purpose of this class is to find the longest plateau of an array of ints.
 *
 * The main method runs some tests.
 *
 * @author andy
 *
 */

public class ArrayLongestPlateau {

    /**
     * longestPlateau() returns the longest plateau of an array of ints.
     *
     * @return an array int[3] of the form {value, start, len} representing the longest plateau of
     *         ints[] as a length len contiguous subarray starting at index start with common
     *         element values value.
     *
     *         For example, on the input array [2, 3, 3, 3, 3, 6, 6, 1, 1, 1], it returns [6, 5, 2],
     *         indicating the longest plateau of this array is the subarray [6, 6]; it starts at
     *         index 5 and has length 2.
     *
     * @param ints
     *            the input array.
     */

    public static int[] longestPlateau(int[] ints) {

        // TODO: Replace the following one line stub with your solution. Ours is in-place, takes linear time,
        // and is less than 25 lines long, not counting blank/comment lines or lines already present in this file.
        int value = 0, startIndex = 0, len = 0;
        int curIndex = 0, curLen = 1;

        for (int i = 1; i < ints.length; i++) {
            if ( ints[i] == ints[i - 1] && (i - curLen == 0 || ints[i - curLen] > ints[i - curLen - 1])) {
                curLen++;
            } else {
                if (curLen > len && ints[i] < ints[i - 1]) {
                    value = ints[i - 1];
                    startIndex = curIndex;
                    len = curLen;
                }
                curIndex = i;
                curLen = 1;
            }
        }

        if (curLen > len && (ints.length - curLen == 0 || ints[ints.length - curLen] > ints[ints.length - curLen - 1]  )) {
            value = ints[ints.length - 1];
            startIndex = curIndex;
            len = curLen;
        }

        return new int[] { value, startIndex, len };
    }

    /**
     * main() runs test cases on your longestPlateau() method. Prints summary information on basic
     * operations and halts with an error (and a stack trace) if any of the tests fail.
     */

    public static void main(String[] args) {
        String result;

        System.out.println("Let's find longest plateaus of arrays!\n");

        int[] test1 = { 4, 1, 1, 6, 6, 6, 6, 1, 1 };
        System.out.println("longest plateau of " + TestHelper.stringInts(test1) + ":");
        result = TestHelper.stringInts(longestPlateau(test1));
        System.out.println("[ value , start , len ] = " + result + " \n");
        TestHelper.verify(result.equals("[ 6 , 3 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

        int[] test2 = { 3, 3, 1, 2, 4, 2, 1, 1, 1, 1 };
        System.out.println("longest plateau of " + TestHelper.stringInts(test2) + ":");
        result = TestHelper.stringInts(longestPlateau(test2));
        System.out.println("[ value , start , len ] = " + result + " \n");
        TestHelper.verify(result.equals("[ 3 , 0 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

        int[] test3 = { 3, 3, 1, 2, 4, 0, 1, 1, 1, 1 };
        System.out.println("longest plateau of " + TestHelper.stringInts(test3) + ":");
        result = TestHelper.stringInts(longestPlateau(test3));
        System.out.println("[ value , start , len ] = " + result + " \n");
        TestHelper.verify(result.equals("[ 1 , 6 , 4 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

        int[] test4 = { 3, 3, 3, 4, 1, 2, 4, 4, 0, 1 };
        System.out.println("longest plateau of " + TestHelper.stringInts(test4) + ":");
        result = TestHelper.stringInts(longestPlateau(test4));
        System.out.println("[ value , start , len ] = " + result + " \n");
        TestHelper.verify(result.equals("[ 4 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

        int[] test5 = { 7, 7, 7, 7, 9, 8, 2, 5, 5, 5, 0, 1 };
        System.out.println("longest plateau of " + TestHelper.stringInts(test5) + ":");
        result = TestHelper.stringInts(longestPlateau(test5));
        System.out.println("[ value , start , len ] = " + result + " \n");
        TestHelper.verify(result.equals("[ 5 , 7 , 3 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

        int[] test6 = { 4 };
        System.out.println("longest plateau of " + TestHelper.stringInts(test6) + ":");
        result = TestHelper.stringInts(longestPlateau(test6));
        System.out.println("[ value , start , len ] = " + result + " \n");
        TestHelper.verify(result.equals("[ 4 , 0 , 1 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

        int[] test7 = { 4, 4, 4, 5, 5, 5, 6, 6 };
        System.out.println("longest plateau of " + TestHelper.stringInts(test7) + ":");
        result = TestHelper.stringInts(longestPlateau(test7));
        System.out.println("[ value , start , len ] = " + result + " \n");
        TestHelper.verify(result.equals("[ 6 , 6 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

        System.out.println("\nAdditional tests done by the student or TA:\n");

        // Insert your additional test cases here.
        int[] test8 = { 0, 4, 4, 0, 4, 4, 0 };
        System.out.println("longest plateau of " + TestHelper.stringInts(test8) + ":");
        result = TestHelper.stringInts(longestPlateau(test8));
        System.out.println("[ value , start , len ] = " + result + " \n");
        TestHelper.verify(result.equals("[ 4 , 1 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

        int[] test9 = { 8, 1, 1, 0, 9, 9, 0 };
        System.out.println("longest plateau of " + TestHelper.stringInts(test9) + ":");
        result = TestHelper.stringInts(longestPlateau(test9));
        System.out.println("[ value , start , len ] = " + result + " \n");
        TestHelper.verify(result.equals("[ 9 , 4 , 2 ]"), "Wrong: that's not the longest plateau!!!  No chocolate.");

    }
}