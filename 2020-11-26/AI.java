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
	

class MainCanvas extends Canvas implements Runnable
{
	int heroX,heroY,bossX,bossY;
	Image img[][]=new Image[4][3];
	Image currentImg,bossImg;
	int leftFlag,rightFlag,downFlag,upFlag;
	Thread test=new Thread(this);
	public MainCanvas(){
		try{
			for(int i=0;i<4;i++){
				for(int j=0;j<3;j++){
					img[i][j]=Image.createImage("/sayo"+j+2*i+".png");
				}
			}
			currentImg=img[0][1];
			bossImg=Image.createImage("/bishamonten.png");
			heroX=100;
			heroY=100;
			bossX=0;
			bossY=0;
			leftFlag=0;
			rightFlag=0;
			downFlag=0;
			upFlag=0;	
			
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		test.start();
		
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);
		
		
		
	}
	public void run(){
		while(true){
			if(heroX>bossX){
				bossX++;
			}else if(heroX<bossX){
				bossX--;
			} 
			if(heroY>bossY){
				bossY++;
			}else if(heroY<bossY){
				bossY--;
			} 
			if(heroX==bossX&&heroY==bossY){
				bossX=300;bossY=300;
				//heroX=100;heroY=100;
				try{
					currentImg=Image.createImage("/sayo_yarare.png");
				}catch (IOException e){
					e.printStackTrace();
				}
				repaint();
				break;
			}
			//System.out.println(bossX+","+bossY);
			repaint();
			try{
				Thread.sleep(200);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
		
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
	
	if(heroX>0&&heroX<=220){
		if(action==LEFT){
			leftFlag=walk(leftFlag,1);
			heroX-=5;
		}
	}
	if(heroX>=0&&heroX<220){
		if(action==RIGHT){
			rightFlag=walk(rightFlag,3);
			heroX+=5;
		}
	}
	if(heroY>0&&heroY<=265){
		if(action==UP){
			upFlag=walk(upFlag,2);
			heroY-=5;
		}
	}
	if(heroY>=0&&heroY<265){
		if(action==DOWN){
			downFlag=walk(downFlag,0);
			heroY+=5;
		}
	}
//	System.out.println(heroX+","+heroY);
	if(heroX==bossX&&heroY==bossY){
		try{
			currentImg=Image.createImage("/sayo_yarare.png");
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	repaint();
	}
	
}