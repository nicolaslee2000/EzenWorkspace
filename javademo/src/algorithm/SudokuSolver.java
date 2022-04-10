//package algorithm;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Arrays;
//import java.util.Collections;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//
//
//public class SudokuSolver {
//	public static void main(String[] args) {
//		Solver solver = new Solver();
//		
//	}
//}
//
//class Solver extends JFrame{
//	JPanel panel;
//	JPanel panel1;
//	JButton btnSet;
//	JButton btnSolve;
//	JButton btnReset;
//	JTextField[][] textfields;
//	int[][] board;
//	int[] nums;
//	
//	Solver() {
//		
//		setNum();
//		initBoard();
//		this.pack();
//		this.setSize(420,420);
//		this.setLocationRelativeTo(null);
//		this.setVisible(true);
//		setBtns();
//	}
//	
//	private void initBoard () {
//		panel = new JPanel();
//		panel.setLayout(new GridLayout(9, 9));
//		textfields = new JTextField[9][9]; 
//		for(int i = 0; i < 9; i++) {
//			for(int j = 0; j < 9; j++) {
//				textfields[i][j] = new JTextField();
//				textfields[i][j].setFont(new Font("Tahoma", Font.BOLD, 17));
//				textfields[i][j].setHorizontalAlignment(JTextField.CENTER);
////				textfields[i][j].setText(String.valueOf(i+j*9));
//				panel.add(textfields[i][j]);
//				textfields[i][j].getDocument().addDocumentListener(new Doclistener(i,j));
//			}
//		}
//		getContentPane().add(panel, BorderLayout.CENTER);
//		panel1 = new JPanel();
//		btnSet = new JButton("Set");
//		panel1.add(btnSet);
//		btnSolve = new JButton("Solve");
//		panel1.add(btnSolve);
//		btnReset = new JButton("Reset");
//		panel1.add(btnReset);
//		getContentPane().add(panel1, BorderLayout.SOUTH);
//	}
//	
//	class Doclistener implements DocumentListener {
//		int i;
//		int j;
//		Doclistener(int i, int j) {
//			this.i = i;
//			this.j = j;
//		}
//		@Override
//		public void insertUpdate(DocumentEvent e) {
//			update(e);
//		}
//		@Override
//		public void removeUpdate(DocumentEvent e) {
//			update(e);
//		}
//		@Override
//		public void changedUpdate(DocumentEvent e) {
//			update(e);
//		}
//		void update(DocumentEvent e) {
//			if(e.getDocument().getLength()>0){
//				if(j==8) {
//					if(i==8) return;
//					textfields[i+1][0].requestFocus();
//					return;
//				} 
//				textfields[i][j+1].requestFocus();
//			}
//		}
//	}
//	
//	private void setBtns() {
//		btnSet.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				for(int i = 0; i < 9; i++) {
//					for(int j = 0; j < 9; j++) {
//						if(!textfields[i][j].getText().isBlank()) {
//							textfields[i][j].setForeground(Color.red);
//							board[i][j] = Integer.parseInt(textfields[i][j].getText().strip());
//						}
//					}
//				}
//
//			}
//		});
//		btnSolve.addActionListener(e-> solve());
//	}
//	
//	private void setNum() {
//		nums = new int[9];
//		for(int i = 0; i < nums.length; i++) 
//			nums[i] = i+1;
//		board = new int[9][9];
//	}
//	//map[][][] and num[] length should be 10 to support 1-9 and 0 as indication of no data
//	int[][][] map = new int[9][9][10];
//	
//	private void solve() {
//		check();
//	}
//	
//	private void test() {
//		//number of possibilities
//		int index = 9;
//		int a = 0;
//		int b = 0;
//		for(int i = 0; i < 9; i++) {
//			for(int j = 0; j < 9; j++) {
//				reverseSort(map[i][j]);
//				if(Arrays.binarySearch(map[i][j], 0)<index) {
//					index = Arrays.binarySearch(map[i][j], 0);
//					a = i;
//					b = j;
//				}
//			}
//		}
//		
//		
//	}
//	
//	private void check() {
//		//column should be first since this method does not check for 0
//		checkcolumn();
//		checkrow();
//		checkbox();
//		for(int i =0; i < 9; i++) {
//			for(int j = 0; j < 9; j++) {
//				System.out.println(Arrays.toString(map[i][j]));
//			}
//		}
//	}
//	private void checkbox() {
//
//		for(int k = 0; k < 3; k++) {
//			for(int h = 0; h < 3; h++) {
//				int num[] = new int[10];
//				for(int i = 0; i < 3; i++) {
//					for(int j = 0; j < 3; j++) {
//						num[board[i+k*3][j+h*3]] = board[i+k*3][j+h*3];
//					}
//				}
//				for(int i = 0; i < 3; i++) {
//					for(int j = 0; j < 3; j++) {
//						for(int g = 0; g < 10; g++) {
//							if(map[i+k*3][j+h*3][g] == 0 ) {
//								map[i+k*3][j+h*3][g] = num[g];
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//	//TODO try using stream to add array to array
//	private void checkrow() {
//		for(int i = 0; i < 9; i++) {
//			int[] num = new int[10];
//			for(int j = 0; j < 9; j++) {
//				num[board[j][i]] = board[j][i];	
//			}
//			//Arrays.sort(num, Collections.reverseOrder()); does not work because array is of primitive type
//			//manually sorting array to descending order
//			for(int k = 0; k < 9; k++) {
//				//can't do map[k][i] = num because num reference will be copied 
//				for(int g = 0; g < 10; g++) {
//					if(map[k][i][g] == 0 ) {
//						map[k][i][g] = num[g];
//					}
//				}
//			}
//		}
//	}
//	private void checkcolumn() {
//		for(int i = 0; i < 9; i++) {
//			int[] num = new int[10];
//			for(int j = 0; j < 9; j++) {
//				num[board[i][j]] = board[i][j];	
//			}
//			for(int k = 0; k < 9; k++) {
//				for(int g = 0; g < 10; g++) {
//					map[i][k][g] = num[g];
//				}
//			}
//		}
//	}
//	
//	
//	private void reverseSort(int[] array) {
//		for(int i = 0; i < array.length-1; i++) {
//			for(int j = 0; j < array.length-1; j++) {
//				if(array[j] < array[j+1]) {
//					int a = array[j+1];
//					array[j+1] = array[j];
//					array[j] = a;
//				}
//			}
//		}
//	}
//	
//}
//
//
//
//
//
//
//
//
//
