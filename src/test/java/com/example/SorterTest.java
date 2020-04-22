package com.example;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SorterTest {


    @Test(expected = IllegalArgumentException.class)
    public void testNullInputThrows() {
        Sorter sorter = new Sorter();
        sorter.sortArray(null);
    }

    @Test
    public void testEmptyInputReturnsEmpty() {
        Sorter sorter = new Sorter();
        int[] results = sorter.sortArray(new int[0]);
        assertEquals(0, results.length);
    }

    @Test
    public void testSingleOddInputReturnsItself() {
        Sorter sorter = new Sorter();
        int[] input = new int[] { 1 };
        int[] results = sorter.sortArray(input);
        assertTrue(Arrays.equals(input, results));
    }

    @Test
    public void testSingleEvenInputReturnsItself() {
        Sorter sorter = new Sorter();
        int[] input = new int[] { 2 };
        int[] results = sorter.sortArray(input);
        assertTrue(Arrays.equals(input, results));
    }

    @Test
    public void testInputOfEvensOnlyReturnsUnmodifiedArray() {
        Sorter sorter = new Sorter();
        int[] input = new int[] { 6, 12, 4, 42, 8, 24 };
        int[] results = sorter.sortArray(input);
        assertTrue(Arrays.equals(input, results));
    }

    @Test
    public void testInputOfOddsOnlyReturnsSortedArray() {
        Sorter sorter = new Sorter();
        int[] input = new int[] { 5, 17, 9, 101, 7 };
        int[] expectedOutput = Arrays.copyOf(input, input.length);
        Arrays.sort(expectedOutput);
        int[] results = sorter.sortArray(input);
        assertTrue(Arrays.equals(expectedOutput, results));
    }

    @Test
    public void testMixedInputSortsOddsButNotEvens() {
        Sorter sorter = new Sorter();
        int[] input = new int[] { 5, 3, 2, 8, 1, 4 };
        int[] expectedOutput = new int[] { 1, 3, 2, 8, 5, 4 };
        int[] results = sorter.sortArray(input);
        assertTrue(Arrays.equals(expectedOutput, results));
    }

    @Test
    public void testZerosAreHandledAsEvens() {
        Sorter sorter = new Sorter();
        int[] input = new int[] { 5, 3, 2, 8, 0, 1, 4 };
        int[] expectedOutput = new int[] { 1, 3, 2, 8, 0, 5, 4 };
        int[] results = sorter.sortArray(input);
        assertTrue(Arrays.equals(expectedOutput, results));
    }

    @Test
    public void testNegativesAreHandledCorrectly() {
        Sorter sorter = new Sorter();
        int[] input = new int[] { -7, -14, -21 };
        int[] expectedOutput = new int[] { -21, -14, -7 };
        int[] results = sorter.sortArray(input);
        assertTrue(Arrays.equals(expectedOutput, results));
    }



}
