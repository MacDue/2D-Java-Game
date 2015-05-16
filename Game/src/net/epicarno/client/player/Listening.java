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
 
 public class Listening
   implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
 {
   public void keyPressed(KeyEvent e)
   {
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
     case 32: 
	//EpicarnoComp.sp = true;
       EpicarnoComp.isHipideHopping = true;

       break;
     case 13: 
       EpicarnoComp.sp = true;
       break;
     case 69: 
	if(EpicarnoComp.redoplay == true){
		EpicarnoComp.redoplay = false;
	}
       if (Inventory.isOpen) {
         Inventory.isOpen = false;
       } else {
         Inventory.isOpen = true;
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


