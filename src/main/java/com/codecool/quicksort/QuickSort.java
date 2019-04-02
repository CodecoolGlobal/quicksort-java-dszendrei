package com.codecool.quicksort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {

    /**
     * Sorts the given List in place
     *
     * @param toSort the List to sort. Throws an error if its null
     */
    public void sort(List<Integer> toSort) {
        System.out.println("Initial list: "+toSort);
        if (toSort == null) throw new IllegalArgumentException();
        if (toSort.size() < 2) return;
        List<Integer> tempList = recursiveSorting(toSort,0,toSort.size()-1);
        for (int i = 0; i < toSort.size(); i++) {
            toSort.set(i,tempList.get(i));
        }
        System.out.println("Sorted list: "+toSort);
    }

    private List<Integer> recursiveSorting(List<Integer> toSort, int leftIndex, int rightIndex) {
        System.out.println(toSort);
        if (rightIndex-leftIndex<1) return toSort;
        //Integer left = toSort.get(leftIndex);
        //Integer right = toSort.get(rightIndex);
//        if (rightIndex-leftIndex < 2) {
//            if (toSort.get(leftIndex) > toSort.get(rightIndex)) {
//                toSort.set(leftIndex, right);
//                toSort.set(rightIndex, left);
//            }
//            return toSort;
//        }
        int pivotIndex = (leftIndex+rightIndex)/2;
        //if (pivotIndex > toSort.size()-1) pivotIndex = toSort.size()-1;
        Integer pivot = toSort.get(pivotIndex);
        int initialLeftIndex = leftIndex;
        int initialRightIndex = rightIndex;
        Integer left;
        Integer right;
        while (leftIndex < rightIndex) {
            //leftWhile:
            left = toSort.get(leftIndex);
            right = toSort.get(rightIndex);
            while (left < pivot) {
                leftIndex++;
                left = toSort.get(leftIndex);
            }

            //rightWhile:
            while (right > pivot) {
                rightIndex--;
                right = toSort.get(rightIndex);
            }

            if (left > right) {
                toSort.set(leftIndex, right);
                if (leftIndex !=  rightIndex) toSort.set(rightIndex, left);
            }
        }
        recursiveSorting(toSort, initialLeftIndex, leftIndex);
        recursiveSorting(toSort, leftIndex+1, initialRightIndex);
        return toSort;
    }
}