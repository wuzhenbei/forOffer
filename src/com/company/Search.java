package com.company;

public class Search {
    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0)
            return -1;

        int start = 0;
        int end = array.length - 1;
        int midIndex, midData;
        while (start <= end) {
            midIndex = start + (end-start)/2;
            midData = array[midIndex];

            if (midData == target)
                return midIndex;
            else if (midData < target)
                start = midIndex + 1;
            else
                end = midIndex - 1;
        }

        return -1;
    }
}
