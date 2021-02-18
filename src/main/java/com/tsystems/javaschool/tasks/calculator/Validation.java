package com.tsystems.javaschool.tasks.calculator;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    static boolean fullValidation(String statement){
        boolean isValid = true;

        //Validation block for the null statement
        if (!validationForNullStatement(statement))
            isValid = false;


        //Validation block for the not null statement
        else{
            if (!validationForFirstSymbol(statement))
                isValid = false;

            else if (!validationForWrongNumberSeparator(statement))
                isValid = false;

            else if (!validationForWrongBrackets(statement))
                isValid = false;

            else if (!validationForDoubleSymbols(statement))
                isValid = false;
        }

        return isValid;
    }


    private static boolean validationForNullStatement(String statement){
        boolean isValid = true;
        if (statement == null | statement == "")
            isValid = false;

        return isValid;
    }

    private static boolean validationForFirstSymbol(String statement){
        boolean isValid = true;
        if (statement.startsWith("-")|statement.startsWith("/")|statement.startsWith("*")|statement.startsWith("+")
                |statement.startsWith(")")|statement.startsWith(" "))
            isValid = false;

        return isValid;
    }

    private static boolean validationForWrongNumberSeparator(String statement){
        boolean isValid = true;

        // Finding the wrong separator in the statement
        int indexOfSymbol = statement.indexOf(",");

        if(indexOfSymbol != - 1)
            isValid = false;

        return isValid;
    }

    private static boolean validationForWrongBrackets(String statement){
        boolean isValid = true;
        int indexOfFirstBracket = statement.indexOf("(");
        int indexOfSecondBracket = statement.indexOf(")");
        int nextIndexOfFirstBracket = statement.indexOf("(", indexOfFirstBracket+1);
        int nextIndexOfSecondBracket = statement.indexOf(")", indexOfSecondBracket+1);

        if (indexOfFirstBracket == -1 ^ indexOfSecondBracket == -1)
            isValid = false;
        else if (indexOfFirstBracket > indexOfSecondBracket)
            isValid = false;

        else {
            if (nextIndexOfFirstBracket != -1 | nextIndexOfSecondBracket != -1)
                isValid = false;
        }

        return isValid;
    }

    private static boolean validationForDoubleSymbols(String statement){
        boolean isValid = true;
        List<String> listOfSymbols = new ArrayList<>();
        listOfSymbols.add("+");
        listOfSymbols.add("-");
        listOfSymbols.add("*");
        listOfSymbols.add("/");
        listOfSymbols.add(".");
        for (int i = 0; i<listOfSymbols.size(); i++) {
            int indexOfFirstSymbol = statement.indexOf(listOfSymbols.get(i));
            int indexOfSecondSymbol = statement.indexOf(listOfSymbols.get(i), indexOfFirstSymbol + 1);
            if (indexOfFirstSymbol == indexOfSecondSymbol - 1) {
                isValid = false;
            }
        }
        return isValid;
    }

}
