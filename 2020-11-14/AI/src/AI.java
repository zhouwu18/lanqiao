import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image img,img1,img2,img3,currentImg;
	public MainCanvas(){
	try{
		img=Image.createImage("/sayo10.png");
		img1=Image.createImage("/sayo12.png");
		img2=Image.createImage("/sayo16.png");
		img3=Image.createImage("/sayo14.png");
		currentImg=img;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	if(action==LEFT){
		currentImg=img1;
		System.out.println("����ת");
		
	}
	if(action==RIGHT){
		currentImg=img2;
		System.out.println("����ת");
		
	}
	if(action==UP){
		currentImg=img3;
		System.out.println("����ת");
		
	}
	if(action==DOWN){
		currentImg=img;
		System.out.println("����ת");
		
	}
	repaint();
	}
}