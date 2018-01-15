/*
 *  33. N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n 
 * chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' 
 * placement, where 'Q' and '.' both indicate a queen and an empty space 
 * respectively.
 *
 * Lintcode: http://lintcode.com/en/problem/n-queens/
 */

import java.util.ArrayList;
import java.util.List;

public class Nqueens {
	public void helper(int currentQueen, int goal, char[][] board, List<List<String>> boards)
    {
        if(currentQueen == goal)
        {
            List<String> al = new ArrayList<String>();
            for (int i = 0 ; i < goal ; i++)
            {
                al.add(new String(board[i]));
               
            }
            boards.add(al);
            return;
        }
        for (int i = 0 ; i < goal ; i++)
        {
            boolean valid = true;
            for (int prev = 0 ; prev < currentQueen ; prev++)
            {
                if (board[prev][i] == 'Q')
                {
                    valid = false;
                }
            }
            int row = currentQueen;
            int colf = i;
            int colb = i;
            while (row >= 0)
            {
                if (colf<goal && board[row][colf] == 'Q')
                {
                    valid = false;
                }
                if (colb>=0 && board[row][colb] == 'Q')
                {
                    valid = false;
                }
                row--;
                colf++;
                colb--;
            }
            if (!valid)
            {
                continue;
            }
            board[currentQueen][i] = 'Q';
           
            helper(currentQueen + 1, goal, board, boards);
           
            board[currentQueen][i] = '.';
        }
       
    }
   
   
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        List<List<String>> boards = new ArrayList<List<String>>();
        StringBuilder sb = new StringBuilder();
       
        for (int i = 0 ; i < n ; i++)
        {
            for (int j = 0 ; j < n ; j++)
            {
                board[i][j] = '.';
            }
        }
        helper(0, n, board, boards);
        return boards;
       
    }
	public static void main(String[] args) {
		
		int n = 4;
		Nqueens sol = new Nqueens();
		List<List<String>> boards = sol.solveNQueens(n);
		System.out.println(boards);
	}

}
