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
	int flag;
	Image nowImg;
	Image Img[][]=new Image[4][3];
	int x,y;
	public MainCanvas(){
		try{
			for(int i=0;i<4;i++){
				for(int j=0;j<3;j++){
					Img[i][j]=Image.createImage("/sayo"+j+i*2+".png");
				}
			}
			nowImg=Img[0][1];
			flag=0;
			x=100;
			y=100;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(nowImg,x,y,0);
	}
	public void walk(int i){
		if(flag==0){
			nowImg=Img[i][0];
			flag++;
		}
		else if(flag==1){
			nowImg=Img[i][1];
			flag++;
		}
		else if(flag==2){
			nowImg=Img[i][2];
			flag++;
		}
		else if(flag==3){
			nowImg=Img[i][1];
			flag-=3;
		}
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(y>0&&y<=265){
			if(action==UP){
				walk(2);
				y-=5;
			}
		}
		if(y>=0&&y<265){
			if(action==DOWN){
				walk(0);
				y+=5;
			}
		}
		if(x>0&&x<=220){
			if(action==LEFT){
				walk(1);
				x-=5;
			}
		}
		if(x>=0&&x<220){
			if(action==RIGHT){
				walk(3);
				x+=5;
			}
		}
		repaint();
	}
}