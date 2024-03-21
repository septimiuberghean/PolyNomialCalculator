package com.example.calculatorproject;
import java.util.HashMap;
import java.util.Map;
public class PolynomialOperations {
    public static Map<Integer, Integer> add(Map<Integer, Integer> firstPolynomial, Map<Integer, Integer> secondPolynomial) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : firstPolynomial.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.put(exponent, coefficient);
        }
        for (Map.Entry<Integer, Integer> entry : secondPolynomial.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.put(exponent, result.getOrDefault(exponent, 0) + coefficient);
        }
        return result;
    }

    public static Map<Integer, Integer> subtract(Map<Integer, Integer> firstPolynomial, Map<Integer, Integer> secondPolynomial) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : firstPolynomial.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.put(exponent, coefficient);
        }
        for (Map.Entry<Integer, Integer> entry : secondPolynomial.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            result.put(exponent, result.getOrDefault(exponent, 0) - coefficient);
        }
        return result;
    }

    public static Map<Integer, Integer> multiply(Map<Integer, Integer> firstPolynomial, Map<Integer, Integer> secondPolynomial) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry1 : firstPolynomial.entrySet()) {
            int exp1 = entry1.getKey();
            int coeff1 = entry1.getValue();
            for (Map.Entry<Integer, Integer> entry2 : secondPolynomial.entrySet()) {
                int exp2 = entry2.getKey();
                int coeff2 = entry2.getValue();
                int productExp = exp1 + exp2;
                int productCoeff = coeff1 * coeff2;
                result.put(productExp, result.getOrDefault(productExp, 0) + productCoeff);
            }
        }
        return result;
    }

    public static Map<Integer, Double> integrate(Map<Integer, Integer> polynomial) {
        Map<Integer, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : polynomial.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            double newCoefficient = (double) coefficient / (exponent + 1);
            result.put(exponent + 1, newCoefficient);
        }
        return result;
    }

    public static Map<Integer, Integer> derive(Map<Integer, Integer> polynomial) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : polynomial.entrySet()) {
            int exponent = entry.getKey();
            int coefficient = entry.getValue();
            if (exponent != 0) {
                result.put(exponent - 1, coefficient * exponent);
            }
        }
        return result;
    }

    public static Map<Integer, Integer> divide(Map<Integer, Integer> firstPolynomial, Map<Integer, Integer> secondPolynomial) {
        Map<Integer, Integer> quotient = new HashMap<>();
        Map<Integer, Integer> copy= new HashMap<>(firstPolynomial);
        while (degree(copy) >= degree(secondPolynomial)) {
            int leadingTermDegree = degree(copy) - degree(secondPolynomial);
            int leadingTermCoefficient = copy.get(degree(copy)) / secondPolynomial.get(degree(secondPolynomial));
            Map<Integer, Integer> subtractedTerm = new HashMap<>();
            subtractedTerm.put(leadingTermDegree, leadingTermCoefficient);
            Map<Integer, Integer> subtractedResult = multiply(subtractedTerm, secondPolynomial);
            copy = subtract(copy, subtractedResult);
            quotient.put(leadingTermDegree, leadingTermCoefficient);
        }
        return quotient;
    }

    public static int degree(Map<Integer, Integer> polynomial) {
        int maxDegree = 0;
        for (int exponent : polynomial.keySet()) {
            if (exponent > maxDegree) {
                maxDegree = exponent;
            }
        }
        return maxDegree;
    }

}
