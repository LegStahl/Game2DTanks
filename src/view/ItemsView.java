package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import IO.Texture;
import model.Game;
import model.Items;

public class ItemsView {
	
	private BufferedImage defend;
	
	
	
	private LinkedList<Items> items;
	
	public ItemsView(LinkedList<Items> items) {
		
		this.items = items;
		
		Texture texture = new Texture();
		
		defend = texture.defendSend();
		
	}
	
	public void drawItems(Graphics g) {
			for(int i = 0; i < items.size(); i++) {
				if(!(items.get(i).getTook())) {
						g.drawImage(defend, items.get(i).getX(),items.get(i).getY(),null);
				}else {
					items.remove(i);
					Game.currentItems--;
				}
			}
		
	}
	
	}
