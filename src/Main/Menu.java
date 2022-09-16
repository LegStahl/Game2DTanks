package Main;







import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import IO.Records;
import model.Game;



public class Menu extends JFrame  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton buttonStart;
	
	private JButton buttonExit;
	
	private JButton buttonRecords;
	
	private JPanel window;
	
	private JButton buttonBack;

	private JPanel records;
	
	MyListener listen;
	
	public Menu() {
		super("Tanks");
		window = new JPanel();
		window.setLayout(new GridLayout(5, 1) );
		JLabel label = new JLabel("TANKS");
		label.setHorizontalAlignment(JLabel.CENTER);
		this.setLayout(new BorderLayout());
		window.add(label);
		buttonStart = new JButton("START");
		buttonStart.setBackground(new Color(245, 222, 179));
		buttonExit = new JButton("EXIT"); 
		buttonExit.setBackground(new Color(245, 222, 179));
		buttonRecords = new JButton("RECORDS"); 
		buttonRecords.setBackground(new Color(245, 222, 179));
		
		window.add(buttonStart);
		window.add(buttonRecords);
		window.add(buttonExit);
		window.setBackground(new Color(211, 211, 211));
		this.add("Center", window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.pack();
		this.setLocation(450, 170);
		this.setSize(500, 500);
		//this.pack();
		this.setVisible(true);		
		
		listen = new MyListener();
		
		buttonExit.addActionListener(listen);	
		buttonStart.addActionListener(listen);
		buttonRecords.addActionListener(listen);
		buttonBack = new JButton("BACK");
		buttonBack.addActionListener(listen);
		}
	
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == buttonStart) {
				Game a = new Game();
				System.out.println("Pressed");
				a.start();
				Menu.this.dispose();
			}
			if(e.getSource() == buttonRecords) {
				System.out.println("Pressed");
				Menu.this.getContentPane().removeAll();
				

				Menu.this.repaint();
				records = new JPanel();
				records.setLayout(new GridLayout(5, 1) );
				JLabel a[] = new JLabel[4];
				Records record = new Records();
				for(int i = 0; i < 4; i++) {
					records.add(a[i] = new JLabel(" " +  (i + 1) + ". " + record.getResult(i)));
				}
				buttonBack.setBackground(new Color(245, 222, 179));
				records.add(buttonBack);

				records.setBackground(new Color(211, 211, 211));
				Menu.this.add(records);
				Menu.this.validate();
				Menu.this.repaint();
				
				
			}if(e.getSource() == buttonExit) {
				System.exit(0);
			}
			if(e.getSource() == buttonBack) {
				System.out.println("Pressed");
				Menu.this.getContentPane().removeAll();
				Menu.this.add(window);
				Menu.this.validate();
				Menu.this.repaint();
			}
			
		}
		
	}
}
