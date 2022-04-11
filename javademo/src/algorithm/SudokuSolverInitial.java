package algorithm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class SudokuSolverInitial {
	public static void main(String[] args) {
		new Solver();
	}
}
class Solver extends JFrame{
	JPanel panel;
	JPanel panel1;
	JButton btnSet;
	JButton btnSolve;
	JButton btnReset;
	JTextField[][] textfields;
	//FIXME
//	int[][] board;
	int[][] setNum;
	
	int[][] board = {
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
	
	Solver() {
		
		initBoard();
		initPanel();
		this.pack();
		this.setSize(420,420);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		setBtns();
	}
	
	private void initPanel () {
		panel = new JPanel();
		panel.setLayout(new GridLayout(9, 9));
		textfields = new JTextField[9][9]; 
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				textfields[i][j] = new JTextField();
				textfields[i][j].setFont(new Font("Tahoma", Font.BOLD, 17));
				textfields[i][j].setHorizontalAlignment(JTextField.CENTER);
//				textfields[i][j].setText(String.valueOf(i+j*9));
				panel.add(textfields[i][j]);
				textfields[i][j].getDocument().addDocumentListener(new Doclistener(i,j));
			}
		}
		getContentPane().add(panel, BorderLayout.CENTER);
		panel1 = new JPanel();
		btnSet = new JButton("Set");
		panel1.add(btnSet);
		btnSolve = new JButton("Solve");
		panel1.add(btnSolve);
		btnReset = new JButton("Reset");
		panel1.add(btnReset);
		getContentPane().add(panel1, BorderLayout.SOUTH);
	}
	
	class Doclistener implements DocumentListener {
		int i;
		int j;
		Doclistener(int i, int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			update(e);
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			update(e);
		}
		@Override
		public void changedUpdate(DocumentEvent e) {
			update(e);
		}
		void update(DocumentEvent e) {
			if(e.getDocument().getLength()>0){
				if(j==8) {
					if(i==8) return;
					textfields[i+1][0].requestFocus();
					return;
				} 
				textfields[i][j+1].requestFocus();
			}
		}
	}
	
	private void setBtns() {
		//FIXME
//		btnSet.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int a = 0;
//				for(int i = 0; i < 9; i++) {
//					for(int j = 0; j < 9; j++) {
//						if(!textfields[i][j].getText().isBlank()) {
//							textfields[i][j].setForeground(Color.red);
//							board[i][j] = Integer.parseInt(textfields[i][j].getText().strip());
//							setNum[a][0] = i;
//							setNum[a][1] = j;
//							a++;
//						}
//					}
//				}
//
//			}
//		});
		int a = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != 0) {
					setNum[a][0] = i;
					setNum[a][1] = j;
					a++;
				}
			}
		}
		btnSolve.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				complete:
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j < 9; j++) {
						if(board[i][j] == 0) 
							solve(0, i, j);
						break complete;
					}
				}
				for(int k = 0; k < 9; k++) {
					for(int g = 0; g < 9; g++) {
						textfields[k][g].setText(String.valueOf(board[k][g]));
					}
				}
				
			}
		});
	}
	private void solve(int num, int row, int column) {	
		//check if solved
		if(isSolved()) return;
		//check if row or column at maximum, reset if true
		if(row > 8 && column > 8) {
			solve(num,0,0);
		}
		if(num > 9) {
			solve(0, row, column +1);
		} 
		if(column > 8) {
			solve(0, row + 1, column);
		} 
		if(row > 8) {
			solve(0, row+1, 0);
		}
		//check if coordinate is changeable TODO
		for(int i = 0; i < 80; i++) {
			if(setNum[i][0] == row&& setNum[i][1] == column)
				solve(0, row, column + 1);
		}
		
		//check for given number
		if(check(num,row,column)) {
			board[row][column] = num;
			solve(0, row, column+1);
		} else {
			solve(num+1, row, column);
		}
	}
	private void initBoard() {
		//FIXME
//		board = new int[9][9];
		setNum = new int[80][2];
		//FIXME
		for(int i = 0; i < 80; i++) {
			Arrays.fill(setNum[i], -1);
		}
		
		
	}
	private boolean isSolved() {
		int solved = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != 0)
					solved += 1;
				if(solved > 80)
					return true;
			}
		}
		return false;
	}
	private boolean check(int num, int row, int column) {
		if(checkrow(num, row)&&checkcolumn(num, column)&&checkbox(num, row, column))
			return true;
		return false;
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
}