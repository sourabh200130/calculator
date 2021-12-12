package calculator;
//Java program to create a simple calculator
//with basic +, -, /, * using java swing elements

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class Calculator extends JFrame implements ActionListener {
	// create a frame
	static JFrame f;

	// create a textfield
	static JTextField l;

	// main function
	public static void main(String args[])
	{
		// create a frame
		f = new JFrame("calculator");

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		Calculator c = new Calculator();

		// create a textfield
		l = new JTextField(16);

		// set the textfield to non editable
		l.setEditable(false);

		// create number buttons and some operators
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

		// create number buttons
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		// equals button
		beq1 = new JButton("=");

		// create operator buttons
		ba = new JButton("+");
		bs = new JButton("-");
		bd = new JButton("/");
		bm = new JButton("*");
		beq = new JButton("C");

		// create . button
		be = new JButton(".");

		// create a panel
		JPanel p = new JPanel();

		// add action listeners
		bm.addActionListener(c);
		bd.addActionListener(c);
		bs.addActionListener(c);
		ba.addActionListener(c);
		b9.addActionListener(c);
		b8.addActionListener(c);
		b7.addActionListener(c);
		b6.addActionListener(c);
		b5.addActionListener(c);
		b4.addActionListener(c);
		b3.addActionListener(c);
		b2.addActionListener(c);
		b1.addActionListener(c);
		b0.addActionListener(c);
		be.addActionListener(c);
		beq.addActionListener(c);
		beq1.addActionListener(c);

		// add elements to panel
		p.add(l);
		p.add(ba);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bs);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bm);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bd);
		p.add(be);
		p.add(b0);
		p.add(beq);
		p.add(beq1);

		// set Background of panel
		p.setBackground(Color.blue);

		// add panel to frame
		f.add(p);

		f.setSize(200, 220);
		f.show();
	}
	 public void actionPerformed(ActionEvent e) {
	      String s = e.getActionCommand();
	      if (s.charAt(0) == 'C') {                      
	         l.setText("");
	      }else if (s.charAt(0) == '=') {                    
	         l.setText(evaluate(l.getText()));
	      }else {                                
	         l.setText(l.getText() + s);
	      }
	   }
	 
	   public static String evaluate(String expression) {
	      char[] arr = expression.toCharArray();
	      String s1 = "";String s2 = "";String s0 = "";
	      double result = 0;

	      for (int i = 0; i < arr.length; i++) {
	         if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
	            if(s0.isEmpty()){
	               s1 += arr[i];
	            }else{
	               s2 += arr[i];
	            }
	         }  

	         if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*') {
	            s0 += arr[i];
	         }
	      }

	      if (s0.equals("+"))
	         result = (Double.parseDouble(s1) + Double.parseDouble(s2));
	      else if (s0.equals("-"))
	         result = (Double.parseDouble(s1) - Double.parseDouble(s2));
	      else if (s0.equals("/"))
	         result = (Double.parseDouble(s1) / Double.parseDouble(s2));
	      else
	         result = (Double.parseDouble(s1) * Double.parseDouble(s2));          
	      return s1 + s0 + s2 + "=" +result;
	   }    
}
