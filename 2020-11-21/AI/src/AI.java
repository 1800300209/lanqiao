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
	int x,y;
	Image img[][]=new Image[4][3];
	Image currentImg;
	int leftFlag,rightFlag,downFlag,upFlag;
	public MainCanvas(){
		try{
			for(int i=0;i<4;i++){
				for(int j=0;j<3;j++){
					img[i][j]=Image.createImage("/sayo"+j+2*i+".png");
				}
			}
			currentImg=img[0][1];
			x=100;
			y=100;
			leftFlag=0;
			rightFlag=0;
			downFlag=0;
			upFlag=0;	
			
		}
		catch (IOException e){
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
	
	if(x>0&&x<220){
		if(action==LEFT){
			if(leftFlag==0){
				currentImg=img[1][0];
				leftFlag++;
			}
			else if(leftFlag==1){
				currentImg=img[1][1];
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=img[1][2];
				leftFlag++;
			}
			else if(leftFlag==3){
				currentImg=img[1][1];
				leftFlag-=3;
			}
			x-=5;
		}
		if(action==RIGHT){
			if(rightFlag==0){
				rightFlag++;
				currentImg=img[3][0];
			}
			else if(rightFlag==1){
				currentImg=img[3][1];
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=img[3][2];
				rightFlag++;
			}
			else if(rightFlag==3){
				currentImg=img[3][1];
				rightFlag-=3;
			}
			x+=5;
		}
	}
	if(y>0&&y<265){
		if(action==UP){
			if(upFlag==0){
				currentImg=img[2][0];
				upFlag++;
			}
			else if(upFlag==1){
				currentImg=img[2][1];
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=img[2][2];
				upFlag++;
			}
			else if(upFlag==3){
				currentImg=img[2][1];
				upFlag-=3;
			}
			y-=5;
		}
		if(action==DOWN){
			if(downFlag==0){
				currentImg=img[0][0];
				downFlag++;
			}
			else if(downFlag==1){
				currentImg=img[0][1];
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=img[0][2];
				downFlag++;
			}
			else if(downFlag==3){
				currentImg=img[0][1];
				downFlag-=3;
			}
			y+=5;
		}
	}
	if(x==0){
		if(action==RIGHT){
			if(rightFlag==0){
				rightFlag++;
				currentImg=img[3][0];
			}
			else if(rightFlag==1){
				currentImg=img[3][1];
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=img[3][2];
				rightFlag++;
			}
			else if(rightFlag==3){
				currentImg=img[3][1];
				rightFlag-=3;
			}
			x+=5;
		}
	}
	if(x==220){
		if(action==LEFT){
			if(leftFlag==0){
				currentImg=img[1][0];
				leftFlag++;
			}
			else if(leftFlag==1){
				currentImg=img[1][1];
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=img[1][2];
				leftFlag++;
			}
			else if(leftFlag==3){
				currentImg=img[1][1];
				leftFlag-=3;
			}
			x-=5;
		}
	}
	if(y==0){
		if(action==DOWN){
			if(downFlag==0){
				currentImg=img[0][0];
				downFlag++;
			}
			else if(downFlag==1){
				currentImg=img[0][1];
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=img[0][2];
				downFlag++;
			}
			else if(downFlag==3){
				currentImg=img[0][1];
				downFlag-=3;
			}
			y+=5;
		}
	}
	if(y==265){
		if(action==UP){
			if(upFlag==0){
				currentImg=img[2][0];
				upFlag++;
			}
			else if(upFlag==1){
				currentImg=img[2][1];
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=img[2][2];
				upFlag++;
			}
			else if(upFlag==3){
				currentImg=img[2][1];
				upFlag-=3;
			}
			y-=5;
		}
	}
//	System.out.println(x+","+y);
	repaint();
	}
}