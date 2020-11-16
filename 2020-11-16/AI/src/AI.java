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
	int x=100;
	int y=100;
	Image imgRight,imgLeft,imgUp,imgDown,currentImg;
	public MainCanvas(){
	try{
		imgDown=Image.createImage("/sayo10.png");
		imgLeft=Image.createImage("/sayo12.png");
		imgRight=Image.createImage("/sayo16.png");
		imgUp=Image.createImage("/sayo14.png");
		currentImg=imgDown;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	
	if(action==LEFT){
		currentImg=imgLeft;
	}
	if(action==RIGHT){
		currentImg=imgRight;
	}
	if(action==UP){
		currentImg=imgUp;
	}
	if(action==DOWN){
		currentImg=imgDown;
	}

	if(action==LEFT&&currentImg==imgLeft){
		x-=10;
		System.out.println(x);
	}
	if(action==RIGHT&&currentImg==imgRight){
		x+=10;
		System.out.println(x);
	}
	if(action==UP&&currentImg==imgUp){
		y-=10;
		System.out.println(y);
	}
	if(action==DOWN&&currentImg==imgDown){
		y+=10;
		System.out.println(y);
	}
	
	repaint();
	}
}