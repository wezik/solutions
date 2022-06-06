package com.demo.codewars.loopover_solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loopover {

    public static void main(String[] args) {
        String[] sortedArrA = {"ABCDEFG", "HIJKLMN", "OPQRSTU", "VWXYZ01"};
        String[] sortedArrB = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQR"};
        String[] unsortedArrA = {"RCBNOFD", "SUJZM1G", "PXHIAVL", "W0YEQTK"};
        String[] unsortedArrB = {"LPO", "EAD", "FBQ", "RMI", "NJH", "GCK"};

        solve(stringArrToBoard(unsortedArrA), stringArrToBoard(sortedArrA));
        solve(stringArrToBoard(unsortedArrB), stringArrToBoard(sortedArrB));
    }

    private static char[][] stringArrToBoard (String[] stringArr) {
        char[][] result = new char[stringArr.length][];
        for (int i = 0; i < stringArr.length; i++) {
            result[i] = stringArr[i].toCharArray();
        }
        return result;
    }

    private static void printBoard(char[][] char2D) {
        System.out.println("==========================");
        for (char[] char1D : char2D) {
            for (char c : char1D)
                System.out.print(c + " ");

            System.out.println();
        }
        System.out.println("==========================");
    }

    private static List<String> MOVES;

    public static List<String> solve(final char[][] mixedUpBoard, final char[][] solvedBoard) {
        MOVES = new ArrayList<>();
        char[][] resultBoard = Arrays.stream(mixedUpBoard).map(char[]::clone).toArray($ -> mixedUpBoard.clone());

        try {
            solveLastRow(resultBoard, solvedBoard);
            solveRowByRow(resultBoard, solvedBoard);
            solveRowBeforeLast(resultBoard, solvedBoard);
            solveLastElements(resultBoard, solvedBoard);
        } catch (Exception e) {
            return null;
        }

        if (!Arrays.deepEquals(resultBoard, solvedBoard)) {
            return null;
        }

        printBoard(resultBoard);
        return MOVES;
    }

    private static void solveLastRow(char[][] board, char[][] solvedBoard) throws Exception {
        for (int x = 0; x < solvedBoard[solvedBoard.length - 1].length - 1; x++) {
            Position pos = find(solvedBoard[solvedBoard.length - 1][x], board);
            if (pos.getY() == solvedBoard.length - 1) {
                pos = moveFromLastLine(board, pos);
            }
            pos = moveToColumn(board, pos, x);
            moveDown(board, pos.getX(), board.length - 1 - pos.getY());
        }
    }

    private static void solveRowByRow(char[][] board, char[][] solvedBoard) throws Exception {
        for (int y = 0; y < solvedBoard.length - 2; y++) {
            solveRow(board, solvedBoard, y);
        }
    }

    private static void solveRow(char[][] board, char[][] solvedBoard, int row) throws Exception {
        for (int x = 0; x < solvedBoard[row].length; x++) {
            Position pos = find(solvedBoard[row][x], board);
            if (pos.getY() == row && pos.getX() != board[row].length - 1) {
                pos = moveFromLine(board, pos);
            }
            if (pos.getX() == board[row].length - 1) {
                pos = moveFromElevator(board, pos);
            }
            moveWithElevator(board, pos, row);
            if (x != board[row].length - 1) {
                moveLeft(board, row, 1);
            }
        }
    }

    private static void solveRowBeforeLast(char[][] board, char[][] solvedBoard) throws Exception {
        int lastRowSpot = solvedBoard[solvedBoard.length - 1].length - 1;
        int beforeLastRowSpot = lastRowSpot - 1;
        Position pos = find(solvedBoard[solvedBoard.length - 2][0], board);
        if (pos.getX() == lastRowSpot && pos.getY() == board.length - 1) {
            moveFromCorner(board, pos);
        } else {
            moveToColumn(board, pos, beforeLastRowSpot);
        }
        for (int x = 1; x < lastRowSpot; x++) {
            pos = find(solvedBoard[solvedBoard.length - 2][x], board);
            if (pos.getY() == solvedBoard.length - 1) {
                moveFromCorner(board, pos);
            } else {
                moveUsingKeyhole(board, pos);
            }
        }
    }

    private static void solveLastElements(char[][] board, char[][] solvedBoard) throws Exception {
        if (isCornerSwapped(board, solvedBoard)) {
            swapCorner(board);
        }
    }

    private static boolean isCornerSwapped(char[][] board, char[][] solvedBoard) {
        int lastY = solvedBoard.length - 1;
        int lastX = solvedBoard[solvedBoard.length - 1].length - 1;
        return board[lastY][lastX] != solvedBoard[lastY][lastX];
    }

    private static void swapCorner(char[][] board) throws Exception {
        if (board[board.length - 1].length % 2 != 0) {
            if (board.length % 2 != 0) {
                throw new Exception();
            } else {
                swapCornerUsingVertical(board);
            }
        } else {
            swapCornerUsingHorizontal(board);
        }
    }

    private static void swapCornerUsingVertical(char[][] board) {
        Position corner = new Position(board[board.length - 1].length - 1, board.length - 1);
        moveLeft(board, corner.getY(), 1);
        moveDown(board, corner.getX(), 1);
        moveRight(board, corner.getY(), 1);
        moveUp(board, corner.getX(), 2);
        for (int i = 0; i <= corner.getY(); i++) {
            if (i % 2 == 0) {
                moveLeft(board, corner.getY(), 1);
            } else {
                moveRight(board, corner.getY(), 1);
            }
            moveUp(board, corner.getX(), 1);
        }
    }

    private static void swapCornerUsingHorizontal(char[][] board) {
        Position corner = new Position(board[board.length - 1].length - 1, board.length - 1);
        moveLeft(board, corner.getY(), 1);
        for (int i = 0; i <= corner.getX(); i++) {
            if (i % 2 == 0) {
                moveDown(board, corner.getX(), 1);
            } else {
                moveUp(board, corner.getX(), 1);
            }
            moveLeft(board, corner.getY(), 1);
        }
    }

    private static Position find(char c, char[][] board) throws Exception {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == c) {
                    return new Position(x, y);
                }
            }
        }
        throw new Exception();
    }

    private static void moveUsingKeyhole(char[][] board, Position pos) {
        Position laterPos = moveToColumn(board, pos, board[board.length - 1].length - 1);
        if (laterPos.getX() > pos.getX()) {
            moveUp(board, laterPos.getX(), 1);
            moveToColumn(board, laterPos, pos.getX());
            moveDown(board, laterPos.getX(), 1);
        }
        moveLeft(board, pos.getY(), 1);
    }

    private static void moveRight(char[][] board, int y, int times) {
        for (int i = 0; i < times; i++) {
            MOVES.add("R" + y);
            char buffer = board[y][board[y].length - 1];
            char nextBuffer;
            for (int x = 0; x < board[y].length - 1; x++) {
                nextBuffer = board[y][x];
                board[y][x] = buffer;
                buffer = nextBuffer;
            }
            board[y][board[y].length - 1] = buffer;
        }
    }

    private static void moveLeft(char[][] board, int y, int times) {
        for (int i = 0; i < times; i++) {
            MOVES.add("L" + y);
            char buffer = board[y][0];
            char nextBuffer;
            for (int x = board[y].length - 1; x > 0; x--) {
                nextBuffer = board[y][x];
                board[y][x] = buffer;
                buffer = nextBuffer;
            }
            board[y][0] = buffer;
        }
    }

    private static void moveDown(char[][] board, int x, int times) {
        for (int i = 0; i < times; i++) {
            MOVES.add("D" + x);
            char buffer = board[board.length - 1][x];
            char nextBuffer;
            for (int y = 0; y < board.length - 1; y++) {
                nextBuffer = board[y][x];
                board[y][x] = buffer;
                buffer = nextBuffer;
            }
            board[board.length - 1][x] = buffer;
        }
    }

    private static void moveUp(char[][] board, int x, int times) {
        for (int i = 0; i < times; i++) {
            MOVES.add("U" + x);
            char buffer = board[0][x];
            char nextBuffer;
            for (int y = board.length - 1; y > 0; y--) {
                nextBuffer = board[y][x];
                board[y][x] = buffer;
                buffer = nextBuffer;
            }
            board[0][x] = buffer;
        }
    }

    private static void moveWithElevator(char[][] board, Position pos, int row) {
        moveDown(board, board[row].length - 1, pos.getY() - row);
        pos = moveToColumn(board, pos, board[row].length - 1);
        moveUp(board, board[row].length - 1, pos.getY() - row);
    }

    private static Position moveFromCorner(char[][] board, Position pos) {
        moveUp(board, pos.getX(), 1);
        moveLeft(board, pos.getY() - 1, 1);
        moveDown(board, pos.getX(), 1);
        return new Position(pos.getX() - 1, pos.getY() - 1);
    }

    private static Position moveFromLastLine(char[][] board, Position pos) {
        moveUp(board, pos.getX(), 1);
        return new Position(pos.getX(), pos.getY() - 1);
    }

    private static Position moveFromElevator(char[][] board, Position pos) {
        if (pos.getY() == board.length - 1) {
            return moveFromCorner(board, pos);
        }
        moveLeft(board, pos.getY(), 1);
        return new Position(pos.getX() - 1, pos.getY());
    }

    private static Position moveToColumn(char[][] board, Position pos, int x) {
        int diff = x - pos.getX();
        if (diff < 0) {
            moveLeft(board, pos.getY(), diff * -1);
        } else {
            moveRight(board, pos.getY(), diff);
        }
        return new Position(pos.getX() + diff, pos.getY());
    }

    private static Position moveFromLine(char[][] board, Position pos) {
        moveDown(board, pos.getX(), 1);
        moveRight(board, pos.getY() + 1, 1);
        moveUp(board, pos.getX(), 1);
        return new Position(pos.getX() + 1, pos.getY() + 1);
    }
}

class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
