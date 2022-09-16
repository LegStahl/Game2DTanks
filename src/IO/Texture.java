package IO;

import javax.imageio.*;





import java.awt.image.*;



import java.io.*;


public class Texture {
	
	private BufferedImage imageFULL;
	

	
	private static final String PATH = "res/";
	
	private static final String NAMEPICTURE = "picture.jpg";
	


	public Texture()  {
		try{
			imageFULL = ImageIO.read(new File(PATH + NAMEPICTURE));
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	public BufferedImage goUpDefend() {
		return  imageFULL.getSubimage(0, 48, 16, 16);
	}
	
	public BufferedImage goDownDefend() {
		return  imageFULL.getSubimage(64, 48, 16, 16);
	}
	
	public BufferedImage goLeftDefend() {
		return imageFULL.getSubimage(32, 48, 16, 16);
	}
	
	public BufferedImage goRightDefend() {
		return  imageFULL.getSubimage(96, 48, 16, 16);
	
	}
	
	public BufferedImage defendSend() {
		return imageFULL.getSubimage(256, 112, 16, 16);
	}
	
	public BufferedImage goUp() {
		return  imageFULL.getSubimage(0, 0, 16, 16);
	}
	
	public BufferedImage goDown() {
		return  imageFULL.getSubimage(64, 0, 16, 16);
	}
	
	public BufferedImage goLeft() {
		return imageFULL.getSubimage(32, 0, 16, 16);
	}
	
	public BufferedImage goRight() {
		return  imageFULL.getSubimage(96, 0, 16, 16);
	
	}
	
	public BufferedImage sendGrass() {
		return imageFULL.getSubimage(272,32,8,8);
	}
	
	public BufferedImage sendBlock() {
		return imageFULL.getSubimage(256, 0, 8, 8);
	}
	
	public BufferedImage sendMetall() {
		return imageFULL.getSubimage(256, 16, 8, 8);
	}
	
	public BufferedImage sendEmpty() {
		return imageFULL.getSubimage(256, 192, 8, 8);
	}
	
	public BufferedImage sendShoot() {
		return imageFULL.getSubimage(320, 100, 8, 8);
	}

	public BufferedImage sendShootRight() {
		return imageFULL.getSubimage(344, 100, 8, 8);
	}
	
	public BufferedImage sendShootLeft() {
		return imageFULL.getSubimage(330, 100, 8, 8);
	}
	
	public BufferedImage sendShootDown() {
		return imageFULL.getSubimage(336, 100, 8, 8);
	}
	
	public BufferedImage sendEnemyUp() {
		return imageFULL.getSubimage(128, 129, 16, 15);
	}
	
	public BufferedImage sendEnemyDown() {
		return imageFULL.getSubimage(192, 128, 16, 16);
	}
	
	public BufferedImage sendEnemyRight() {
		return imageFULL.getSubimage(224, 128, 16, 16);
	}
	
	public BufferedImage sendEnemyLeft() {
		return imageFULL.getSubimage(160, 128, 16, 16);
	}
	
	public BufferedImage sendWater() {
		return imageFULL.getSubimage(256, 42, 8, 8);
	}
	
}
