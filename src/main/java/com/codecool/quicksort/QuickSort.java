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
        Integer left = toSort.get(leftIndex);
        Integer right = toSort.get(rightIndex);
        if (rightIndex-leftIndex < 2) {
            if (toSort.get(leftIndex) > toSort.get(rightIndex)) {
                toSort.set(leftIndex, right);
                toSort.set(rightIndex, left);
            }
            return toSort;
        }
        int pivotIndex = leftIndex + (leftIndex+rightIndex)/2;
        if (pivotIndex > toSort.size()-1) pivotIndex = toSort.size()-1;
        Integer pivot = toSort.get(pivotIndex);
        int initialLeftIndex = leftIndex;
        int initialRightIndex = rightIndex;
        mainWhileLoop:
        while (!left.equals(right)) {
            if (left.equals(pivot) && rightIndex > pivotIndex) {
                System.out.println(""+1+" PIVOT INDEX: " + pivotIndex);
                if (right < left) {
                    toSort.set(leftIndex, right);
                    toSort.set(rightIndex, left);
                    pivotIndex = rightIndex;
                }
                break mainWhileLoop;
            }
            if (right.equals(pivot) && leftIndex < pivotIndex) {
                System.out.println(""+2+" PIVOT INDEX: " + pivotIndex);
                if (right < left) {
                    System.out.println(""+3+" PIVOT INDEX: " + pivotIndex);
                    toSort.set(leftIndex, right);
                    toSort.set(rightIndex, left);
                }
                break mainWhileLoop;
            }

            boolean bothOk = true;
            if((left <= pivot)) {
                leftIndex++;
                left = toSort.get(leftIndex);
                bothOk = false;
            }
            if((right >= pivot)) {
                rightIndex--;
                right = toSort.get(rightIndex);
                bothOk = false;
            }
            if(left.equals(right)) break mainWhileLoop;
            if(bothOk) {
                toSort.set(leftIndex, right);
                toSort.set(rightIndex, left);
                leftIndex++;
                rightIndex--;
                left = toSort.get(leftIndex);
                right = toSort.get(rightIndex);
            }

        }
        recursiveSorting(toSort, initialLeftIndex, pivotIndex);
        //if (pivotIndex == toSort.size()-1) pivotIndex -= 1;

        recursiveSorting(toSort, pivotIndex+1, initialRightIndex);
        return toSort;
    }
}