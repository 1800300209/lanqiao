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
	public int walk(int Flag,int i){
		if(Flag==0){
				currentImg=img[i][0];
				Flag++;
			}
			else if(Flag==1){
				currentImg=img[i][1];
				Flag++;
			}
			else if(Flag==2){
				currentImg=img[i][2];
				Flag++;
			}
			else if(Flag==3){
				currentImg=img[i][1];
				Flag-=3;
			}
			return Flag;
		}
	public void keyPressed(int keyCode){
	int action=getGameAction(keyCode);
	
	if(x>0&&x<=220){
		if(action==LEFT){
			leftFlag=walk(leftFlag,1);
			x-=5;
		}
	}
	if(x>=0&&x<220){
		if(action==RIGHT){
			rightFlag=walk(rightFlag,3);
			x+=5;
		}
	}
	if(y>0&&y<=265){
		if(action==UP){
			upFlag=walk(upFlag,2);
			y-=5;
		}
	}
	if(y>=0&&y<265){
		if(action==DOWN){
			downFlag=walk(downFlag,0);
			y+=5;
		}
	}
//	System.out.println(x+","+y);
	repaint();
	}
	
}