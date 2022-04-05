package algorithm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

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
	JTextField[] textfields;
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
		textfields = new JTextField[81]; 
		for(int i = 0; i < textfields.length; i++) {
			textfields[i] = new JTextField();
			textfields[i].setFont(new Font("Tahoma", Font.BOLD, 17));
			textfields[i].setHorizontalAlignment(JTextField.CENTER);
			textfields[i].setText(String.valueOf(i));
			panel.add(textfields[i]);
			textfields[i].getDocument().addDocumentListener(new Doclistener(i));
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
		Doclistener(int i) {
			this.i = i;
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
				if(i==textfields.length) return;
				textfields[i+1].requestFocus();
			}
		}
	}
	
	private void setBtns() {
		btnSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < textfields.length; i++) {
					if(!textfields[i].getText().isBlank()) {
						textfields[i].setForeground(Color.red);
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
	}
	
	Map<Integer, Integer> map = new HashMap<>();
	
	private void solve() {
		
	}
	
	private void checkbox() {
		
	}
}









