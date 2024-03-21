package com.example.calculatorproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolynomialParser {

    public static Map<Integer, Integer> parsePolynomial(String polynomial) {
        Map<Integer, Integer> polynomialMap = new HashMap<>();
        polynomial = polynomial.replaceAll("\\s+", "");
        String[] terms = polynomial.split("(?=[+-])");
        for (String term : terms) {
            int coefficient;
            int exponent;
            if (term.contains("x")) {
                int xIndex = term.indexOf("x");
                if (xIndex == 0) {
                    coefficient = 1;
                } else if (term.substring(0, xIndex).equals("-")) {
                    coefficient = -1;
                } else {
                    coefficient = Integer.parseInt(term.substring(0, xIndex));
                }
                if (term.contains("^")) {
                    int caretIndex = term.indexOf("^");
                    exponent = Integer.parseInt(term.substring(caretIndex + 1));
                } else {
                    exponent = 1;
                }
            } else {
                coefficient = Integer.parseInt(term);
                exponent = 0;
            }
            polynomialMap.put(exponent, coefficient);
        }
        return polynomialMap;
    }

    public static String constructPolynomialString(Map<Integer, ?> polynomialMap) {
        StringBuilder resultBuilder = new StringBuilder();
        List<Integer> exponents = new ArrayList<>(polynomialMap.keySet());
        Collections.sort(exponents, Collections.reverseOrder());
        for (int exponent : exponents) {
            Object coefficient = polynomialMap.get(exponent);
            if (coefficient instanceof Integer) {
                int intCoefficient = (int) coefficient;
                if (intCoefficient != 0) {
                    String term = Integer.toString(intCoefficient);
                    if (exponent == 1) term += "x";
                    else if (exponent != 0) term += "x^" + exponent;
                    if (intCoefficient > 0 && resultBuilder.length() > 0) resultBuilder.append("+");
                    resultBuilder.append(term);
                }
            } else if (coefficient instanceof Double) {
                double doubleCoefficient = (double) coefficient;
                if (doubleCoefficient != 0) {
                    String term = Double.toString(doubleCoefficient);
                    if (exponent == 1) term += "x";
                    else if (exponent != 0) term += "x^" + exponent;
                    if (doubleCoefficient > 0 && resultBuilder.length() > 0) resultBuilder.append("+");
                    resultBuilder.append(term);
                }
            }
        }
        return resultBuilder.toString();
    }
}
