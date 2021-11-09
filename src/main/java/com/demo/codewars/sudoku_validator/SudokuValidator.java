package com.demo.codewars.sudoku_validator;

/*
Sudoku Background
Sudoku is a game played on a 9x9 grid. The goal of the game is to fill all cells of the grid with digits from 1 to 9, so
that each column, each row, and each of the nine 3x3 sub-grids (also known as blocks) contain all of the digits from
1 to 9.
(More info at: http://en.wikipedia.org/wiki/Sudoku)

Sudoku Solution Validator
Write a function validSolution/ValidateSolution/valid_solution() that accepts a 2D array representing a Sudoku board,
and returns true if it is a valid solution, or false otherwise. The cells of the sudoku board may also contain 0's,
which will represent empty cells. Boards containing one or more zeroes are considered to be invalid solutions.

The board is always 9 cells by 9 cells, and every cell only contains integers from 0 to 9.

Examples
validSolution([
  [5, 3, 4, 6, 7, 8, 9, 1, 2],
  [6, 7, 2, 1, 9, 5, 3, 4, 8],
  [1, 9, 8, 3, 4, 2, 5, 6, 7],
  [8, 5, 9, 7, 6, 1, 4, 2, 3],
  [4, 2, 6, 8, 5, 3, 7, 9, 1],
  [7, 1, 3, 9, 2, 4, 8, 5, 6],
  [9, 6, 1, 5, 3, 7, 2, 8, 4],
  [2, 8, 7, 4, 1, 9, 6, 3, 5],
  [3, 4, 5, 2, 8, 6, 1, 7, 9]
]); // => true
validSolution([
  [5, 3, 4, 6, 7, 8, 9, 1, 2],
  [6, 7, 2, 1, 9, 0, 3, 4, 8],
  [1, 0, 0, 3, 4, 2, 5, 6, 0],
  [8, 5, 9, 7, 6, 1, 0, 2, 0],
  [4, 2, 6, 8, 5, 3, 7, 9, 1],
  [7, 1, 3, 9, 2, 4, 8, 5, 6],
  [9, 0, 1, 5, 3, 7, 2, 1, 4],
  [2, 8, 7, 4, 1, 9, 6, 3, 5],
  [3, 0, 0, 4, 8, 1, 1, 7, 9]
]); // => false
 */

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    public static boolean check(int[][] sudoku) {
        return validateAllGrids(sudoku) && validateRows(sudoku) && validateColumns(sudoku);
    }

    private static boolean validateRows(int[][] sudoku) {
        for (int y=0; y<9; y++) {
            Set<Integer> values = new HashSet<>();
            for (int x=0; x<9; x++) {
                int value = sudoku[x][y];
                if (value > 0 && value < 10 && !values.contains(value)) values.add(value);
                else return false;
            }
        }
        return true;
    }

    private static boolean validateColumns(int[][] sudoku) {
        for (int x=0; x<9; x++) {
            Set<Integer> values = new HashSet<>();
            for (int y=0; y<9; y++) {
                int value = sudoku[x][y];
                if (value > 0 && value < 10 && !values.contains(value)) values.add(value);
                else return false;
            }
        }
        return true;
    }

    private static boolean validateAllGrids(int[][] sudoku) {
        for (int x=0; x<=6; x+=3) {
            for (int y=0; y<=6; y+=3) {
                if (!validateGrid(sudoku,x,y)) return false;
            }
        }
        return true;
    }

    private static boolean validateGrid(int[][] sudoku, int x, int y) {
        Set<Integer> values = new HashSet<>();
        for (int xOffset=0; xOffset<3; xOffset++) {
            for (int yOffset=0; yOffset<3; yOffset++) {
                int value = sudoku[x+xOffset][y+yOffset];
                if (value > 0 && value < 10 && !values.contains(value)) values.add(value);
                else return false;
            }
        }
        return true;
    }

}
