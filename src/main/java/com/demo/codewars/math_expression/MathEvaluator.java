package com.demo.codewars.math_expression;

public class MathEvaluator {

    public double calculate(String input) {
        String expression = input.replaceAll(" ","");
        System.out.println(expression);
        while (containsParenthesis(expression)) {
            expression = solveExtractedParenthesis(extractParenthesis(expression), expression);
        }
        return Double.parseDouble(solve(expression));
    }

    private boolean containsParenthesis(String expression) {
        return expression.contains("(") || expression.contains(")");
    }

    private String solve(String expression) {
        String result = expression.replaceAll("\\+-", "-").replaceAll("--", "+");
        while (containsUnsolvedOperator(result)) {
            int operatorIndex = findPriorityOperatorIndex(result);
            result = applyOperator(result, operatorIndex);
        }
        return result;
    }

    private String solveExtractedParenthesis(String parenthesis, String expression) {
        return expression.replace(parenthesis, solve(parenthesis.substring(1, parenthesis.length()-1)));
    }

    private String extractParenthesis(String expression) {
        int beginIndex = -1;
        int endIndex = -1;
        for (int i=expression.length()-1; i>=0 && beginIndex < 0; i--) {
            if (expression.charAt(i) == '(') {
                beginIndex = i;
                for (int j=i+1; j<expression.length() && endIndex < 0; j++) {
                    if (expression.charAt(j) == ')') {
                        endIndex = j+1;
                    }
                }
            }
        }
        return expression.substring(beginIndex, endIndex);
    }

    private boolean containsUnsolvedOperator(String expression) {
        if (expression.contains("-")) {
            int index = expression.indexOf('-');
            if (index > 0 && Character.isDigit(expression.charAt(index-1))) {
                return true;
            }
        }
        return expression.contains("*") || expression.contains("/") || expression.contains("+");
    }

    private int findPriorityOperatorIndex(String expression) {
        for (int i=0; i<expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                return i;
            }
        }
        for (int i=0; i<expression.length(); i++) {
            if (expression.charAt(i) == '+') {
                return i;
            } else if (i>0 && expression.charAt(i) == '-' && Character.isDigit(expression.charAt(i-1))) {
                return i;
            }
        }
        return -1;
    }

    private String applyOperator(String expression, int operatorIndex) {
        char operator = expression.charAt(operatorIndex);
        StringBuilder x = new StringBuilder();
        boolean found = false;
        for (int i=operatorIndex-1; i>=0 && !found; i--) {
            char expressionChar = expression.charAt(i);
            if (Character.isDigit(expressionChar) || expressionChar == '.') {
                x.insert(0, expressionChar);
            } else if (expressionChar == '-' && i == 0) {
                x.insert(0, expressionChar);
            } else if (expressionChar == '-' && !Character.isDigit(expression.charAt(i-1))) {
                x.insert(0, expressionChar);
            } else {
                found = true;
            }
        }
        StringBuilder y = new StringBuilder();
        found = false;
        for (int i=operatorIndex+1; i<expression.length() && !found; i++) {
            char expressionChar = expression.charAt(i);
            if (Character.isDigit(expressionChar) || expressionChar == '.') {
                y.append(expressionChar);
            } else if (expressionChar == '-' && i == operatorIndex+1) {
                y.append(expressionChar);
            } else {
                found = true;
            }
        }
        StringBuilder result = new StringBuilder();
        switch (operator) {
            case('*'):
                result.append(Double.parseDouble(x.toString()) * Double.parseDouble(y.toString()));
                break;
            case('/'):
                result.append(Double.parseDouble(x.toString()) / Double.parseDouble(y.toString()));
                break;
            case('+'):
                result.append(Double.parseDouble(x.toString()) + Double.parseDouble(y.toString()));
                break;
            case('-'):
                result.append(Double.parseDouble(x.toString()) - Double.parseDouble(y.toString()));
                break;
        }
        System.out.println("Solving from:" + expression);
        System.out.println("Solving: "+ x + operator + y);
        System.out.println("Result: "+ result);
        System.out.println("Final output: " + expression.replace(x.toString() + operator + y, result.toString()));
        return expression.replace(x.toString() + operator + y, result.toString());
    }

}
