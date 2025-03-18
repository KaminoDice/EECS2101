/**********************************************************
 * EECS2101A: Fundamentals of Data Structures,  Fall 2023
 * Assignment 1, Problem 1: A1.ArraySqueeze.java
 * Student Name:   Huanrui Cao
 * Student EECS account:  Saikoro
 * Student ID number:  219256809
 **********************************************************/

package A1;

/**
 * The purpose of this class is to squeeze an array of ints.
 *
 * The main method runs some tests.
 *
 * @author andy
 *
 */

public class ArraySqueeze {

    /**
     * squeeze() takes an array of ints. On completion the array contains the same numbers, but
     * wherever the array had two or more consecutive duplicate numbers, they are replaced by one
     * copy of the number. Hence, after squeeze() is done, no two consecutive numbers in the array
     * are the same.
     *
     * Any unused elements at the end of the array are set to -1.
     *
     * For example, if the input array is [ 4 , 1 , 1 , 3 , 3 , 3 , 1 , 1 ], it reads [ 4 , 1 , 3 ,
     * 1 , -1 , -1 , -1 , -1 ] after squeeze() completes.
     *
     * @param ints
     *            the input array.
     */

    public static void squeeze(int[] ints) {

        // TODO: Fill in your solution here. Ours is in-place, takes linear time, and is less than
        // 10 lines long, not counting blank/comment lines or lines already present in this file.
        int curIndex = 0;

        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] != ints[i + 1])  ints[curIndex++] = ints[i];
        }

        if (ints.length > 0) ints[curIndex++] = ints[ints.length - 1];

        while (curIndex < ints.length) {
            ints[curIndex++] = -1;
        }

    }

    /**
     * main() runs test cases on your squeeze() method. Prints summary information on basic
     * operations and halts with an error (and a stack trace) if any of the tests fail.
     */

    public static void main(String[] args) {
        String result;

        System.out.println("Let's squeeze arrays!\n");

        int[] test1 = { 3, 7, 7, 7, 4, 5, 5, 2, 0, 8, 8, 8, 8, 5 };
        System.out.println("squeezing " + TestHelper.stringInts(test1) + ":");
        squeeze(test1);
        result = TestHelper.stringInts(test1);
        System.out.println(result + "\n");
        TestHelper.verify(result.equals("[ 3 , 7 , 4 , 5 , 2 , 0 , 8 , 5 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
                "BAD SQEEZE!!!  No cookie.");

        int[] test2 = { 6, 6, 6, 6, 6, 3, 6, 3, 6, 3, 3, 3, 3, 3, 3 };
        System.out.println("squeezing " + TestHelper.stringInts(test2) + ":");
        squeeze(test2);
        result = TestHelper.stringInts(test2);
        System.out.println(result + "\n");
        TestHelper.verify(result.equals("[ 6 , 3 , 6 , 3 , 6 , 3 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
                "BAD SQEEZE!!!  No cookie.");

        int[] test3 = { 4, 4, 4, 4, 4 };
        System.out.println("squeezing " + TestHelper.stringInts(test3) + ":");
        squeeze(test3);
        result = TestHelper.stringInts(test3);
        System.out.println(result + "\n");
        TestHelper.verify(result.equals("[ 4 , -1 , -1 , -1 , -1 ]"), "BAD SQEEZE!!!  No cookie.");

        int[] test4 = { 0, 1, 2, 3, 4, 5, 6 };
        System.out.println("squeezing " + TestHelper.stringInts(test4) + ":");
        squeeze(test4);
        result = TestHelper.stringInts(test4);
        System.out.println(result + "\n");
        TestHelper.verify(result.equals("[ 0 , 1 , 2 , 3 , 4 , 5 , 6 ]"), "BAD SQEEZE!!!  No cookie.");

        System.out.println("\nAdditional tests done by the student or TA:\n");

        // Insert your additional test cases here.
        int[] test5 = { 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 };
        System.out.println("squeezing " + TestHelper.stringInts(test5) + ":");
        squeeze(test5);
        result = TestHelper.stringInts(test5);
        System.out.println(result + "\n");
        TestHelper.verify(result.equals("[ 1 , 2 , 3 , 4 , 5 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ]"),
                "BAD SQEEZE!!!  No cookie.");
    }
}