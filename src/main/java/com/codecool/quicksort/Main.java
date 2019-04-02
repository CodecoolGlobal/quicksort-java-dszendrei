package com.codecool.quicksort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(Arrays.asList(3,2,1));
        System.out.println();
        quickSort.sort(Arrays.asList(5,3,2,1,6));
        System.out.println();
        quickSort.sort(Arrays.asList(5, 3, 1, 12, 9));
        System.out.println();
        quickSort.sort(Arrays.asList(5, 3, 1, 12, 9, 110, 2, 45, 78, 56, 42));
        System.out.println();
        quickSort.sort(Arrays.asList(5, 3, 1, 5, 9));
    }

}
