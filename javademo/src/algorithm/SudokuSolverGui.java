package algorithm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class SudokuSolverGui {
	public static void main(String[] args) {
		new SudokuGui();
	}
}

class SudokuGui extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel1;
	private JButton btnSet;
	private JButton btnSolve;
	private JButton btnReset;
	private JTextField[][] textfields;
	private final int SIZE = 9;
	private int[][] board = new int[SIZE][SIZE];
	SudokuSolver solver;
	
	
	SudokuGui() {
		initBoard();
	}
	
	private void initBoard() {
		initPanel();
		initBtn();
		this.pack();
		this.setSize(420,420);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private void initPanel () {
		panel = new JPanel();
		panel.setLayout(new GridLayout(SIZE, SIZE));
		textfields = new JTextField[SIZE][SIZE]; 
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				textfields[i][j] = new JTextField();
				textfields[i][j].setFont(new Font("Tahoma", Font.BOLD, 17));
				textfields[i][j].setHorizontalAlignment(JTextField.CENTER);
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
	
	private boolean isSet = false;
	private void initBtn() {
		btnSolve.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(!isSet) return;
				solver.solve(1,0,0);
				board = solver.getBoard();
				for(int k = 0; k < SIZE; k++) {
					for(int g = 0; g < SIZE; g++) {
						textfields[k][g].setText(String.valueOf(board[k][g]));
					}
				}
			}
		});
		
		btnSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isSet) return;
				for(int i = 0; i < SIZE; i++) {
					for(int j = 0; j < SIZE; j++) {
						if(!textfields[i][j].getText().isBlank()) {
							textfields[i][j].setForeground(Color.red);
							board[i][j] = Integer.parseInt(textfields[i][j].getText().strip());
						}
					}
				}
				solver = new SudokuSolver(board);
				isSet = true;
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				board = new int[SIZE][SIZE];
				for(int i = 0; i < SIZE; i++) {
					for(int j = 0; j < SIZE; j++) {
						textfields[i][j].setText("");
						textfields[i][j].setForeground(Color.black);
					}
				}
				isSet = false;
			}
		});
	}
}