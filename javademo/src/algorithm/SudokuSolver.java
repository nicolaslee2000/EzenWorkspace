package algorithm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class SudokuSolver {
	public static void main(String[] args) {
		Solver solver = new Solver();
		
		
	}
}

class Solver extends JFrame{
	JPanel panel;
	JPanel panel1;
	JButton btnSet;
	JButton btnSolve;
	JButton btnReset;
	JTextField[][] textfields;
	int[][] board;
	int[] num;
	
	Solver() {
		
		setNum();
		initBoard();
		this.pack();
		this.setSize(420,420);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		setBtns();
	}
	
	private void initBoard () {
		panel = new JPanel();
		panel.setLayout(new GridLayout(9, 9));
		textfields = new JTextField[9][9]; 
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				textfields[i][j] = new JTextField();
				textfields[i][j].setFont(new Font("Tahoma", Font.BOLD, 17));
				textfields[i][j].setHorizontalAlignment(JTextField.CENTER);
//				textfields[i].setText(String.valueOf(i));
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
		btnSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j < 9; j++) {
						if(!textfields[i][j].getText().isBlank()) {
							textfields[i][j].setForeground(Color.red);
							board[i][j] = Integer.parseInt(textfields[i][j].getText().strip());
						}
					}
				}

			}
		});
		btnSolve.addActionListener(e-> solve());
	}
	
	private void setNum() {
		num = new int[9];
		for(int i = 0; i < num.length; i++) 
			num[i] = i+1;
		board = new int[9][9];
	}
	
	int[][][] map = new int[9][9][9];
	
	private void solve() {
		check();
	}
	
	private void check() {
		checkcolumn();
//		checkrow();
		for(int i =0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.println(Arrays.toString(map[i][j]));
			}
		}
	}
	private void checkbox() {
		
	}
	//TODO try using stream to add array to array
	private void checkrow() {
		for(int i = 0; i < 9; i++) {
			int[] num = new int[9];
			for(int j = 0; j < 9; j++) {
				num[j] = board[j][i];	
			}
			for(int k = 0; k < 9; k++) {
				if(num[k] != 0) continue;
				for(int g = 0; g < 9; g++) {
					if(map[i][k][g] != 0) continue;
					map[i][k][g] = num[k];
				}
			}
		}
	}
	private void checkcolumn() {
		for(int i = 0; i < 9; i++) {
			int[] num = new int[9];
			for(int j = 0; j < 9; j++) {
				num[j] = board[i][j];	
			}
			for(int k = 0; k < 9; k++) {
				map[i][k] = num;
			}
		}
	}
	
}









