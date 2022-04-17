package algorithm;

import java.util.Arrays;

public class ThermoSudoku extends SudokuSolver{
//	int[][] board = {
//			{0,0,0,0,0,0,0,0,0},
//			{0,0,0,9,0,0,0,0,0},
//			{0,0,0,0,0,0,0,0,0},
//			{0,0,0,0,0,0,0,0,0},
//			{0,0,0,0,0,0,0,0,0},
//			{0,0,0,0,0,0,0,0,0},
//			{0,0,0,0,0,0,0,0,0},
//			{0,0,0,0,0,0,0,0,0},
//			{0,0,0,0,0,0,0,0,0}
//	};
	int[][] t1 = {{1,4}, {0,3}, {1,2}, {2,3}};
	int[][] t2 = {{2,4}, {1,3}};
	int[][] t3 = {{1,6}, {2,5}, {3,4}};
	int[][] t4 = {{2,6}, {3,7}, {4,6}, {3,5}};
	int[][] t5 = {{6,6}, {7,5}, {6,4}, {5,5}};
	int[][] t6 = {{5,6}, {6,7}, {7,6}, {6,5}, {5,4}};

	int[][][] thermos = {t1,t2,t3,t4,t5,t6};

	
	
	public ThermoSudoku() {
		super();
	}
	public ThermoSudoku(int[][] board) {
		super(board);
	}
	@Override
	protected boolean check(int num, int row, int column) {
		return super.check(num, row, column) && checkThermo(num, row, column) && checkKight(num, row, column);	
	}
	private boolean checkThermo(int num, int row, int column) {
		for(int i = 0; i < thermos.length; i ++) {
			boolean b = false;
			//check going up the thermo
			for(int j = 0; j < thermos[i].length; j++) {
				int r = thermos[i][j][0];
				int c = thermos[i][j][1];
				if(b && board[r][c] <= num && board[r][c] != 0) {
					return false;
				}
				if(r == row && c == column) {
					b = true;
				}
			}
			b = false;
			//check going down the thermo
			for(int j = thermos[i].length-1; j >= 0; j--) {
				int r = thermos[i][j][0];
				int c = thermos[i][j][1]; 
				if(b && board[r][c] >= num) {
					return false;
				}
				if(r == row && c == column)
					b = true;
			}
		}
		return true;
	}
	
	private boolean checkKight(int num, int row, int column) {
		int[] arr = {
				getKight(row-1, column-2),
				getKight(row-2, column-1),
				getKight(row-2, column+1),
				getKight(row-1, column+2),
				getKight(row+1, column+2),
				getKight(row+2, column+1),
				getKight(row+2, column-1),
				getKight(row+1, column-2)
		};
		//don't want to use collection framework
		for(int i : arr) {
			if(i == num)
				return false;
		}
		return true;
	}
	
	private int getKight(int row, int column) {
		int i = 0;
		try {
			i = board[row][column];
		} catch (ArrayIndexOutOfBoundsException e) {
			i = 0;
		}
		return i;
	}
}
