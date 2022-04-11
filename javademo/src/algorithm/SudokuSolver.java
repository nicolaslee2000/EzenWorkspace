package algorithm;

import java.util.Arrays;


public class SudokuSolver {
	int[][] board;
	
//	Example board
	int[][] boardExample = {
			{0,0,0,0,0,5,1,0,0},
			{0,7,4,0,0,0,0,2,0},
			{0,0,9,0,0,0,0,0,3},
			{0,0,3,0,0,0,0,0,0},
			{7,6,0,0,8,0,0,0,0},
			{4,0,0,6,0,1,0,0,0},
			{0,0,6,2,4,0,3,0,9},
			{0,0,0,7,6,3,0,0,2},
			{0,0,0,0,0,0,0,4,0}
	};
	
	int[][] original;
	boolean solved = false;

	public SudokuSolver(){
		board = boardExample;
		setOriginal();
	}
	
	public SudokuSolver(int[][] board) {
		this.board = board;
		setOriginal();
	}
	
	
	public void solve(int num, int row, int column) {	
		
		//if no num fits(>9) return one recursion
		if(num > 9) {
			return;
		}
		if(column > 8) {
			row += 1;
			column = 0;
			num = 1;
		}
		if(row > 8) {
			solved = true;
			return;
		}
	
		
		//if selected cell is original, skip
		while(true) {
			if(row>8) {
				solved = true;
				break;
			}
			if(original[row][column] == 0) break;
			if(column == 8) {
				row += 1;
				column = 0;
			} else {
				column += 1;
			}
			num = 1;
		}
		
		if(row > 8) {
			solved = true;
			return;
		}
		
		//check for given number
		if(check(num,row,column)) {
			board[row][column] = num;
			solve(1, row, column+1);
			//if no number can fit, go back one recursion and try higher num, if that does not work go back one more
			if(solved) {
				return;
			}
		} 
		solve(num+1,row,column);
		 
		//remove cell when exiting this recursion
		if(solved){
			return;
		} else {
			board[row][column] = 0;
		}
	}
	
	
	private boolean check(int num, int row, int column) {
		return checkrow(num, row)&&checkcolumn(num, column)&&checkbox(num, row, column);
			
	}
	private boolean checkcolumn(int num, int column) {
		for(int i = 0; i < 9; i++) {
			if(board[i][column] == num)
				return false;
		}
		return true;
	}
	
	private boolean checkrow(int num, int row) {
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == num)
				return false;
		}
		return true;
	}
	
	private boolean checkbox(int num, int row, int column) {
		int a = row%3;
		int b = column%3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[row-a+i][column-b+j] == num)
					return false;
			}
		}
		return true;
	}
	
	public void setOriginal() {
		original = new int[9][9];
		for(int i = 0; i< 9;i++) {
			for(int j = 0; j<9;j++) {
				original[i][j] = board[i][j];
			}
		}
		
	}
	
	public void printBoard() {
		for(int i = 0; i < 9; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	public int[][] getBoard() {
		return board;
	}
}