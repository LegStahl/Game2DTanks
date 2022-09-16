package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.*;
import IO.*;
import Main.Menu;
import model.Enemy;
import model.Items;
import model.MapGame;
import model.Player;
import model.Shot;

public class Display extends JFrame {


	
	
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MapGameView myMap;
	
	private Texture texture;
	
	private JButton menu;

	
	/**
	 * @param width
	 * @param hight
	 * @param title
	 * @param clear
	 */
	public Display(int width, int hight, String title, MapGame map, LinkedList<Shot> shots, LinkedList<Enemy> enemies,  Player player, LinkedList<Items> items) {
	
		
		super(title);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		setResizable(false);
		texture = new Texture();
		
		myMap =  new MapGameView(map, texture, this, shots, enemies, player, items) ;

		getContentPane().add(myMap);
		pack();
		setSize(width, hight);
		setLocationRelativeTo(null);
		System.out.println("Hello World");
		setVisible(true);
		

		
	}
	

	
	public void render() {
		
		myMap.repaint();
	}
	
	
	public void end(int value) {
		
		Records record = new Records(value);

		this.getContentPane().removeAll();
		
		this.setLayout(	new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		JLabel label = new JLabel("Your current result: " + value + "\n Your the best record: " + record.getTheBest());
		label.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label, BorderLayout.CENTER);
		this.add(panel, "Center");
		MyListener mouse = new MyListener();
		menu = new JButton("Go back to Menu");
		this.add("South", menu);

		menu.addActionListener(mouse);
		this.validate();
		this.repaint();
		
		
	}
	private class MyListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == menu) {
				@SuppressWarnings("unused")
				Menu newMenu = new Menu();
				Display.this.dispose();
			}
		}
	}

}
