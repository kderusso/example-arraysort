package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Sorts arrays based on specified rules.
 *
 * @author kderusso 2020-04-22
 */
public class Sorter {

    public Sorter() { }

    /**
     * Sorts ascending odd numbers in the input array, leaving even numbers and zero's in their place.
     *
     * @param input Input array, not null, may be empty.
     * @return Modified array, not null, may be empty.
     * @throws IllegalArgumentException on null input
     */
    public int[] sortArray(int[] input) {
        if (input == null) {
            throw new IllegalArgumentException("required: input");
        } else if (input.length < 2) {
            return input;
        }

        List<Integer> sortedValues = new ArrayList<>(input.length);
        List<Integer> sortedIndices = new ArrayList<>(input.length);
        int[] output = Arrays.copyOf(input, input.length);

        for (int i=0; i<input.length; i++) {
            int value = input[i];
            if (isSortable(value)) {
                sortedValues.add(value);
                sortedIndices.add(i);
            }
        }

        Collections.sort(sortedValues);

        for (int i=0; i<sortedIndices.size(); i++) {
            int index = sortedIndices.get(i);
            int sortedValue = sortedValues.get(i);
            output[index] = sortedValue;
        }

        return output;
    }

    private boolean isSortable(int input) {
        return input != 0 && input % 2 != 0;
    }
}
