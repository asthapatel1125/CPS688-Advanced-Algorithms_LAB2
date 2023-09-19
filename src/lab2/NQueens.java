package lab2;

import java.util.Arrays;
import java.util.Scanner;

public class NQueens {

	/* 1. Ask user input for the matrix(board) size
	 * 2. Initialize the matrix to 0, meaning the queen cannot be placed here.
	 * 3. Queen is safe in this index if board[i][j] = 1, and unsafe otherwise.
	 * 4. Use the Depth First Search (DFS) to see if placing a queen at index board[i][j] is safe
	 * 5.  
	 * 
	 * */
	private int size;
	private int[][] board;
	
	
	public NQueens(int size)
	{
		this.size = size;
		setMatrix();
	}

	
	//return matrix size
	public int getMatSize()
	{	return this.size;}
	
	//initialize all indices as 0. 
	public void setMatrix()
	{
		board = new int[this.size][this.size];//create an array
		
		for(int i= 0;i<this.size ; i++)
		{
			for(int j = 0 ; j< this.size; j++)
			{
				this.board[i][j] = 0;
			}
		}
	}
	
	//check whether the given column is safe for the queen to be placed in that
	public boolean isSafe(int row, int col)
	{
		int i,j;
		
		//verify if there is a queen present in the respective row
		for(i = 0;i<col ; i++)
		{
			if(this.board[row][i] == 1)
				return false;
		}
		
		//verify for the left diagonal
		for(i = row, j = col; i>=0 && j >=0; i--,j--)
		{
			if(this.board[i][j] == 1)
				return false;
		}
		
		//verify for the right diagonal
		for(i = row, j= col; i<this.size && j >= 0 ; i++,j--)
		{
			if(this.board[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	//solve for queen on the board(matrix) using DFS
	public boolean solveNQueens(int col)
	{
		if(col >= this.size)
			return true; 
		
		for(int i = 0; i< this.size ; i++)
		{
			if(isSafe(i , col))//checks if the queen is safe at this index
			{
				this.board[i][col] = 1;
				
				if(solveNQueens(col+1))
					return true;
				
				//backtrack if the recursive call is false
				this.board[i][col] = 0;
			}
		}
			
		return false;
	}
	
	
	public void printSol()
	{
		for(int i = 0 ; i<this.size ; i++)
		{
			solveNQueens(i); //build the board of N queens by inserting a queen in each column until the queen is safe
		}
		
		for(int i = 0; i<this.size ; i++)
		{
			for(int j = 0 ; j <this.size ; j++)
			{
				System.out.print(" " + this.board[i][j] +" ");
			}
			System.out.println(); //next row
		}
	}
	
}
