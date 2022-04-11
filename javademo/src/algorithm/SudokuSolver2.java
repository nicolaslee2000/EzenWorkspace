package algorithm;

import java.util.Arrays;


public class SudokuSolver2 {
	public static void main(String[] args) {
		new Test();
		
	}
}

class Test{
	
	int[][] board;
	int[] nums;
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
	
	Test() {
		board = boardExample;
		setNum();
		
	}
	

	private void setNum() {
		nums = new int[9];
		for(int i = 0; i < nums.length; i++) 
			nums[i] = i+1;
		board = new int[9][9];
	}
	//map[][][] and num[] length should be 10 to support 1-9 and 0 as indication of no data
	int[][][] map = new int[9][9][10];
	
	private void solve() {
		check();
	}
	
	private void test() {
		//number of possibilities
		int index = 9;
		int a = 0;
		int b = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(Arrays.binarySearch(map[i][j], 0)<index) {
					index = Arrays.binarySearch(map[i][j], 0);
					a = i;
					b = j;
				}
			}
		}
		
		
	}
	
	private void check() {
		//column should be first since this method does not check for 0
		checkcolumn();
		checkrow();
		checkbox();
		for(int i =0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.println(Arrays.toString(map[i][j]));
			}
		}
	}
	private void checkbox() {

		for(int k = 0; k < 3; k++) {
			for(int h = 0; h < 3; h++) {
				int num[] = new int[10];
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						num[board[i+k*3][j+h*3]] = board[i+k*3][j+h*3];
					}
				}
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						for(int g = 0; g < 10; g++) {
							if(map[i+k*3][j+h*3][g] == 0 ) {
								map[i+k*3][j+h*3][g] = num[g];
							}
						}
					}
				}
			}
		}
	}
	//TODO try using stream to add array to array
	private void checkrow() {
		for(int i = 0; i < 9; i++) {
			int[] num = new int[10];
			for(int j = 0; j < 9; j++) {
				num[board[j][i]] = board[j][i];	
			}
			//Arrays.sort(num, Collections.reverseOrder()); does not work because array is of primitive type
			//manually sorting array to descending order
			for(int k = 0; k < 9; k++) {
				//can't do map[k][i] = num because num reference will be copied 
				for(int g = 0; g < 10; g++) {
					if(map[k][i][g] == 0 ) {
						map[k][i][g] = num[g];
					}
				}
			}
		}
	}
	private void checkcolumn() {
		for(int i = 0; i < 9; i++) {
			int[] num = new int[10];
			for(int j = 0; j < 9; j++) {
				num[board[i][j]] = board[i][j];	
			}
			for(int k = 0; k < 9; k++) {
				for(int g = 0; g < 10; g++) {
					map[i][k][g] = num[g];
				}
			}
		}
	}

}









