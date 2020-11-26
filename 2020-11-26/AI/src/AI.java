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

	/*
	0  : left
	1  :down
	2  :up	
	3  :right
	*/

	int x,y,m,n;
	Image img[][]=new Image[4][3];
	Image currentImg,titleImg,bossImg,dieImg;
	int flag;
	public MainCanvas(){
		try{
			for(int i=0;i<4;i++){
				for(int j=0;j<3;j++){
					img[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
				
			}
			dieImg=Image.createImage("/die.png");
			bossImg=Image.createImage("/yun.png");
			titleImg=Image.createImage("/title.png");
			currentImg=img[1][0];
			x=100;
			y=100;
			flag=1;
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
		g.drawImage(titleImg,70,0,0);
		g.drawImage(bossImg,x-2,y+19,0);
		if(x>220&&x<0&&y<0&&y>265){
			g.drawImage(dieImg,100,100,0);
			repaint();
		}
	}
	public void changePicAndDirect(int direction){
	if (flag==1)
	{
		currentImg=img[direction][0];
			flag++;
	}
	else if (flag==2)
	{
		currentImg=img[direction][1];
			flag++;
	}
	else if (flag==3)
	{
		currentImg=img[direction][0];
			flag++;
	}
	else if (flag==4)
	{
		currentImg=img[direction][2];
			flag=1;
	}
	repaint();
	}
	
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
			if(action==LEFT){
				changePicAndDirect(0);
				x=x-8;
			}
			if(action==RIGHT){
				changePicAndDirect(3);
				x=x+8;
			}
			if(action==DOWN){
				changePicAndDirect(1);
				y=y+8;
			}
			if(action==UP){
				changePicAndDirect(2);
				y=y-8;
			}
		}
}