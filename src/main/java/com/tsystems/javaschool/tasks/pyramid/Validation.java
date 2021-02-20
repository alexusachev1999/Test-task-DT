package com.tsystems.javaschool.tasks.pyramid;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    static void fullValidation(List<Integer> input){

        if (!validationForNullElement(input))
            throw new CannotBuildPyramidException();

        if (!validationForNumberOfElement(input))
            throw new CannotBuildPyramidException();
    }


    private static boolean validationForNullElement(List<Integer> input){
        boolean isValid = true;
        if (input.lastIndexOf(null) != -1)
            isValid = false;

        return isValid;
    }

    private static boolean validationForNumberOfElement(List<Integer> input){
        boolean isValid = true;
        if (input.size() > 250)
            isValid = false;

        return isValid;
    }
}
