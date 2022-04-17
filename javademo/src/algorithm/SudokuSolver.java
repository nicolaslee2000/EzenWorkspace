package algorithm;

import java.util.Arrays;


public class SudokuSolver {
	protected int[][] board;
	private final int SIZE = 9;
//	Example board
	private final int[][] BOARD_EXAMPLE = {
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
	
	private int[][] original;
	private boolean solved = false;
	
	public SudokuSolver(){
		board = BOARD_EXAMPLE;
		setOriginal();
	}
	
	public SudokuSolver(int[][] board) {
		this.board = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
		setOriginal();
	}
	public void solve() {
		Outer:
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(board[i][j] == 0) {
					solve(1,i,j);
					break Outer;
				}
			}
		}
		//checking if solvable
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(board[i][j] == 0) {
//					board = original;
					System.out.println("UNSOLVABLE BOARD");
					return;
				}
			}
		}
	}
	
	private void solve(int num, int row, int column) {	
		System.out.println(Arrays.toString(board[0]));
		//if no num fits(>SIZE) return one recursion
		if(num > SIZE) {
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
	
	
	protected boolean check(int num, int row, int column) {
		return checkrow(num, row)&&checkcolumn(num, column)&&checkbox(num, row, column);
			
	}
	private boolean checkcolumn(int num, int column) {
		for(int i = 0; i < SIZE; i++) {
			if(board[i][column] == num)
				return false;
		}
		return true;
	}
	
	private boolean checkrow(int num, int row) {
		for(int i = 0; i < SIZE; i++) {
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
	
	private void setOriginal() {
		original = new int[SIZE][SIZE];
		for(int i = 0; i< SIZE;i++) {
			for(int j = 0; j<SIZE;j++) {
				original[i][j] = board[i][j];
			}
		}
		
	}
	
	public void printBoard() {
		for(int i = 0; i < SIZE; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	public int[][] getBoard() {
		return board;
	}
}