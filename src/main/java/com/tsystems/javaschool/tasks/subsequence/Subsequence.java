package com.tsystems.javaschool.tasks.subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        // TODO: Implement the logic here
        boolean isPossible = false;
        boolean isCorrectOrder = false;

        validationOfIllegalArgument(x, y);

        if (checkingIdentityOfElements(x, y) == true){
            isCorrectOrder = validationOfOrder(x, y, createListOfIndexesXElementInY(x, y));
            if (isCorrectOrder == true)
                isPossible = true;
        } else
            isPossible = false;

        return isPossible;
    }

    // If size of List x = size of List of indexes x elements in the List y  - it's could be needed subsequence
    public static boolean checkingIdentityOfElements (List x, List y){
        // Create list of indexes x in the List y
        List indexOfElementInY = createListOfIndexesXElementInY(x, y);

        if (indexOfElementInY.size() == x.size())
            return true;
        else
            return false;
    }

    public static List createListOfIndexesXElementInY (List x, List y) {
        List indexOfElementInY = new ArrayList<>();
        for (Object o : x){
            if (y.indexOf(o) >= 0)
                indexOfElementInY.add(y.indexOf(o));
        }
        return indexOfElementInY;
    }


    // If sorted order equals unsorted - it's needed subsequence
    public static boolean validationOfOrder (List x, List y, List indexOfElementInY){
        // List of indexes of elements
        List order = indexOfElementInY;

        // Create new list which is the copy of order list
        List sortedOrder = new ArrayList();
        sortedOrder.addAll(0, order);

        //Sorting the copy
        Collections.sort(sortedOrder);


        if (order.equals(sortedOrder))
            return true;
        else
            return false;
    }

    private static void validationOfIllegalArgument (List x, List y) {
        if (x == null | y == null)
            throw new IllegalArgumentException();
    }
}
