package com.example;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Main application. Sorter runs based on command line.
 *
 * @author kderusso 2020-04-22
 */
public class SorterApplication {

    private final Sorter sorter;

    private SorterApplication(Sorter mySorter) {
        sorter = mySorter;
    }

    void run(int[] input) {
        int[] output = sorter.sortArray(input);
        System.out.println(String.format("Input: [%s]; Output: [%s]", getDisplayValue(input), getDisplayValue(output)));
    }

    private String getDisplayValue(int[] array) {
        return Arrays.stream(array).mapToObj(Integer::toString).collect(Collectors.joining(","));
    }

    public static void main(String[] args) throws Exception {
        SorterApplication sorterApplication = new SorterApplication(new Sorter());
        int[] input = Arrays.stream(args).map(Integer::valueOf).mapToInt(i->i).toArray();
        sorterApplication.run(input);
    }
}
