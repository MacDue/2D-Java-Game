 package net.epicarno.client.player;
 import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.MsgProcessor;
 
 public class Listening
   implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
 {
   public String msg = "";
   public String LastMsg = "";
   public boolean Typing = false;
   public MsgProcessor MsgP= new MsgProcessor();

@SuppressWarnings("deprecation")
public void keyPressed(KeyEvent e)
   {
	EpicarnoComp.msg = msg;
	if(Typing == true){
		if( e.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
			String AllowedChars = "..,+=-_:;/\\*'()*&^%$£!¬`~#@:{}[]?<>|\"";
			if( (Character.isDigit(e.getKeyChar())) ||  (Character.isLetter(e.getKeyChar())) || (Character.isSpace(e.getKeyChar()))  || (AllowedChars.indexOf(e.getKeyChar()   )
					>0)){
	msg = msg + e.getKeyChar();
			}
		}else{
			//msg = msg -
		if(msg.length() > 0){msg = msg.substring(0, msg.length()-1);}			
		}
	EpicarnoComp.msg = msg;
	if( e.getKeyCode()==KeyEvent.VK_UP){
		if(LastMsg.length() > 0){
		msg = LastMsg;
		}
		EpicarnoComp.msg = msg;
		
		
	}
	if( e.getKeyCode()==KeyEvent.VK_ENTER){
		Typing = false;
		//System.out.print(msg.length());
		
		MsgP.MsgType(msg);
		LastMsg = msg = msg.substring(0, msg.length()-1);;
		msg = "";
		
		
		
	}

	
	}
	
	if( e.getKeyCode()==KeyEvent.VK_T){
		
		if(!EpicarnoComp.invent.isOpen){
		Typing = true;
		}
		//msg = "";
		//break;
		
	}
	EpicarnoComp.typing = Typing;
//	System.out.println(msg);
     int key = e.getKeyCode();
     switch (key)
     {
     case 68: 
	//EpicarnoComp.sp = true;
       EpicarnoComp.isMoving = true;
     EpicarnoComp.dir = EpicarnoComp.player.movingSpeed;

       break;
     case 65: 
       EpicarnoComp.isMoving = true;
//EpicarnoComp.sp = true;
      EpicarnoComp.dir = -EpicarnoComp.player.movingSpeed;
       
       break;
     case 84: 
        // EpicarnoComp.isMoving = true;
    
    	 
    	 break;
    	 
  //EpicarnoComp.sp = true;
    	 
       // EpicarnoComp.dir = -EpicarnoComp.player.movingSpeed;
         
        
   
     case 32: 
	//EpicarnoComp.sp = true;
       EpicarnoComp.isHipideHopping = true;

       break;
       
     case 49: 
	//EpicarnoComp.sp = true;
    	 Inventory.soming = 0;

       break;
       
     case 50: 
	//EpicarnoComp.sp = true;
    	 Inventory.soming =1;

       break;
       
     case 51: 
	//EpicarnoComp.sp = true;
    	 Inventory.soming = 2;

       break;
       
     case 52: 
	//EpicarnoComp.sp = true;
    	 Inventory.soming = 3;

       break;
       
     case 53: 
	//EpicarnoComp.sp = true;
    	 Inventory.soming =4;

       break;
       
     case 54: 
	//EpicarnoComp.sp = true;
    	 Inventory.soming =5;

       break;
       
     case 55: 
	//EpicarnoComp.sp = true;
    	 Inventory.soming = 6;

       break;
       
     case 56: 
	//EpicarnoComp.sp = true;
    	 Inventory.soming =7;

       break;

     case 69: 
	if(EpicarnoComp.redoplay == true){
		EpicarnoComp.redoplay = false;
	}
	if(!Typing){
       if (Inventory.isOpen) {
         Inventory.isOpen = false;
       } else {
         Inventory.isOpen = true;
       }
	}
       break;
     }
   }
   
   public void keyReleased(KeyEvent e)
   {
     int key = e.getKeyCode();
     switch (key)
     {
     case 68: 
       if (EpicarnoComp.dir == EpicarnoComp.player.movingSpeed) {
         EpicarnoComp.isMoving = false;
       }
       break;
     case 65: 
       if (EpicarnoComp.dir == -EpicarnoComp.player.movingSpeed) {
         EpicarnoComp.isMoving = false;
       }
       break;
     case 32: 
       EpicarnoComp.isHipideHopping = false;
     }
   }
   
   public void keyTyped(KeyEvent e) {}
   
   public void mouseWheelMoved(MouseWheelEvent e)
   {
	Player.fallingspeed = 1.5D;

     if (e.getWheelRotation() > 0)
     {
       if (Inventory.soming < EpicarnoTiles.invLength - 1) {
         Inventory.soming += 1;
       } else {
         Inventory.soming = 0;
       }
     }
     else if (e.getWheelRotation() < 0) {
       if (Inventory.soming > 0) {
         Inventory.soming -= 1;
       } else {
         Inventory.soming = EpicarnoTiles.invLength - 1;
       }
     }
   }
   
   public void mouseDragged(MouseEvent e)
   {
     EpicarnoComp.mse.setLocation(e.getX(), e.getY());
   }
   
   public void mouseMoved(MouseEvent e)
   {
     EpicarnoComp.mse.setLocation(e.getX(), e.getY());
   }
   
   public void mouseClicked(MouseEvent e) {}
   
   public void mouseEntered(MouseEvent e) {}
   
   public void mouseExited(MouseEvent e) {}
   
   public void mousePressed(MouseEvent e)
   {
     if (e.getButton() == 1) {
       EpicarnoComp.isLeftyDown = true;
     } else if (e.getButton() == 3) {
       EpicarnoComp.isRightyDown = true;
     }
     Inventory.click(e);
   }
   
   public void mouseReleased(MouseEvent e)
   {
     if (e.getButton() == 1) {
       EpicarnoComp.isLeftyDown = false;
     } else if (e.getButton() == 3) {
       EpicarnoComp.isRightyDown = false;
     }
   }
 }


