package com.tsystems.javaschool.tasks.pyramid;

import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        // TODO : Implement your solution here
//        String a = null;
//        if (Validation.fullValidation())
//            throw new CannotBuildPyramidException();
        Validation.fullValidation(inputNumbers);

        // To count size of massive
        int countOfRows = countOfRows(inputNumbers);
        int countOfColumns = countOfColumns(countOfRows);

        // Sort the input list to the natural order
        Collections.sort(inputNumbers);

        // This method made the pyramid without side zeros
        int [][] massive = pyramidWithoutSideZeros(inputNumbers, countOfRows, countOfColumns);

        //Create massive with zero elements
        int[][] zero = buildZeroMassive(countOfRows, countOfColumns);

        // Change zero massive to needed pyramid by merging
        int [][] result = merging(massive, zero);

        return result;
    }

    public static int countOfRows(List<Integer> inputNumbers) {
        int countOfRows;

        // Use triangular number to count numbers of rows
        // (Tn = 0.5n * (n+1)     ==     n^2 + n - inputNumbers.size() * 2
        countOfRows = solutionOfSquareEquation(inputNumbers);

        return countOfRows;
    }

    public static int countOfColumns(int countOfRows) {
        int countOfColumns = 1;

        if (countOfRows == 1)
            return countOfColumns;

        countOfColumns = countOfColumns(countOfRows - 1) + 2;
        return countOfColumns;
    }

    public static int[][] buildZeroMassive(int countOfRows, int countOfColumns) {
        int [][] massive = new int [countOfRows][countOfColumns];

        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                massive [i][j] = 0;
            }
        }
        return massive;
    }

    public static void printMassive(int[][] massive) {
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[i].length; j++) {
                System.out.print(massive [i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int solutionOfSquareEquation (List<Integer> inputNumbers) {
        double a = 1, b = 1, c = inputNumbers.size() * - 2;
        double D;
        double result = 0;

        D = b * b - 4 * a * c;
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            if (x1 > 0)
                result = x1;
            else if (x2 > 0)
                result = x2;
            //Return -1 to catch exception in main method
            else
                result = -1;
        } else if (D == 0) {
            double x;
            x = -b / (2 * a);
            if (x > 0)
                result = x;
            else
                result = -1;
        } else
            result = -1;
        return (int) result;
    }

    private static int[][] pyramidWithoutSideZeros(List<Integer> inputNumbers, int countOfRows, int countOfColumns) {
        int indexOfElementInInput = inputNumbers.size() - 1;

        int [][] massive = new int[countOfRows][];
        for (int i = countOfRows - 1; i >= 0; i--) {
            int [] newColumn = new int[countOfColumns];
            for (int j = newColumn.length - 1; j >= 0; j = j-2) {
                newColumn[j] = inputNumbers.get(indexOfElementInInput);
                indexOfElementInInput--;
            }
            countOfColumns -= 2;
            massive[i] = newColumn;
        }
        return massive;
    }
    private static int[][] merging(int [][] massive, int [][] zero) {
        int startIndex = massive[massive.length -1].length / 2;
        for (int i = 0; i < zero.length; i++){
            int x = 0;
            for (int j = startIndex; j < startIndex+massive[i].length; j++){
                zero[i][j] = massive[i][x];
                x++;
            }
            startIndex--;
        }
        return zero;
    }
}
