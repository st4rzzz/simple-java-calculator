import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

//importing needed methods etc from swing (i think i imported some unneeded ones but doesn't matter nonetheless

public class GUI extends DocumentFilter implements ActionListener {
	
        	static int extra = 0;
        	static int num1;
        	static int num2;
        	static char operation = 0; //declaring variables
	
        	static CalculateCount calculate = new CalculateCount(); //Importing user defined class and methods
	
        	static Scanner scanner = new Scanner(System.in);
	
        	private int count = 0;
	
                //declaring panel, frame and labels
        	private JFrame frame;
        	private JPanel panel;
        	static JLabel[] label = new JLabel[3];
	
        	static JFormattedTextField[] fld = new JFormattedTextField[2]; //declaring a text field which ill hopefully use in the future
	
	JButton calc = new JButton("Calculate");
	JButton plus = new JButton("+"); //buttons for calculations 
	JButton minus = new JButton("-");
	JButton times = new JButton("x");
	JButton divide = new JButton("/"); 
	static JButton submit = new JButton("Submit"); {
	
		label[0] = new JLabel("Result: ");
		label[1] = new JLabel("Enter your first number: ");
		label[2] = new JLabel("Enter your second number: "); //telling the user what to do
		
		fld[0] = new JFormattedTextField();
		fld[1] = new JFormattedTextField();
	
     }
	
	public GUI() {
		JFrame frame = new JFrame(); //setting the frame and panel
		JPanel panel = new JPanel();
		
		calc.addActionListener(this); //making the buttons actually do stuff using action listener
		plus.addActionListener(this);
		minus.addActionListener(this);
		times.addActionListener(this);
		divide.addActionListener(this);
		submit.addActionListener(this);
		fld[0].addActionListener(this);
		fld[1].addActionListener(this);
		
		panel.add(plus, BorderLayout.EAST); //implementing the buttons
		panel.add(minus, BorderLayout.EAST);
		panel.add(times, BorderLayout.EAST);
		panel.add(divide, BorderLayout.EAST);
		panel.add(label[1]);
		panel.add(fld[0]);
		panel.add(label[2]);
		panel.add(fld[1]);
		panel.add(submit);
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30)); //setting the base of the UI
		panel.setLayout(new GridLayout(0, 1));
		panel.add(calc); //adding button + label
		panel.add(label[0]);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.pack();
		frame.setVisible(true); //setting up frame
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		final Object source = e.getSource();
		
		if(source == submit) {
			num1 = Integer.parseInt(fld[0].getText()); // converting the text input from field to a number
			num2 = Integer.parseInt(fld[1].getText());
		}
		if(source == calc) {
			label[0].setText("Result: " + count); 
		} else if(source == plus) {
			count = num1 + num2;
		} else if(source == minus) {
			count = num1 - num2;
		} else if(source == times) { 
			count = num1 * num2;
		} else if(source == divide) {
			count = num1 / num2;    //making the buttons actually do something if pressed
					
		}
	}
	
		public static void main(String[]args) {
			new GUI();
			
			while(extra == 0) {  // loop to make the program run indefinitely
			label[1].setText("Enter your first number: "); 
			label[2].setText("Enter your second number: ");
			
			
			if(operation == '+') {
				calculate.plus();
			} else if (operation == '-') {
				calculate.minus(); //using the user-defined methods to do the calculations.
			} else if (operation == 'x') {
				calculate.times();
			} else if (operation == '/') {
				calculate.division(); 	//decision statement used to know when to do which operation
			} 
		}
		}
}