/*   1:    */ package net.epicarno.client;
/*   2:    */ 
/*   3:    */ import java.awt.Point;
/*   4:    */ import java.awt.event.KeyEvent;
/*   5:    */ import java.awt.event.KeyListener;
/*   6:    */ import java.awt.event.MouseEvent;
/*   7:    */ import java.awt.event.MouseListener;
/*   8:    */ import java.awt.event.MouseMotionListener;
/*   9:    */ import java.awt.event.MouseWheelEvent;
/*  10:    */ import java.awt.event.MouseWheelListener;
/*  11:    */ 
/*  12:    */ public class Listening
/*  13:    */   implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
/*  14:    */ {
/*  15:    */   public void keyPressed(KeyEvent e)
/*  16:    */   {
/*  17:  7 */     int key = e.getKeyCode();
/*  18:  9 */     switch (key)
/*  19:    */     {
/*  20:    */     case 68: 
	//EpicarnoComp.sp = true;
/*  21: 11 */       EpicarnoComp.isMoving = true;
/*  22: 12 */     EpicarnoComp.dir = EpicarnoComp.player.movingSpeed;

/*  23: 13 */       break;
/*  24:    */     case 65: 
/*  25: 15 */       EpicarnoComp.isMoving = true;
//EpicarnoComp.sp = true;
/*  26: 16 */      EpicarnoComp.dir = -EpicarnoComp.player.movingSpeed;
/*  27:    */       
/*  28: 18 */       break;
/*  29:    */     case 32: 
	//EpicarnoComp.sp = true;
/*  30: 20 */       EpicarnoComp.isHipideHopping = true;

/*  31: 21 */       break;
/*  29:    */     case 13: 
/*  30: 20 */       EpicarnoComp.sp = true;
/*  31: 21 */       break;
/*  32:    */     case 69: 
	if(EpicarnoComp.redoplay == true){
		EpicarnoComp.redoplay = false;
	}
/*  33: 23 */       if (Inventory.isOpen) {
/*  34: 24 */         Inventory.isOpen = false;
/*  35:    */       } else {
/*  36: 26 */         Inventory.isOpen = true;
/*  37:    */       }
/*  38:    */       break;
/*  39:    */     }
/*  40:    */   }
/*  41:    */   
/*  42:    */   public void keyReleased(KeyEvent e)
/*  43:    */   {
/*  44: 37 */     int key = e.getKeyCode();
/*  45: 39 */     switch (key)
/*  46:    */     {
/*  47:    */     case 68: 
/*  48: 41 */       if (EpicarnoComp.dir == EpicarnoComp.player.movingSpeed) {
/*  49: 42 */         EpicarnoComp.isMoving = false;
/*  50:    */       }
/*  51: 44 */       break;
/*  52:    */     case 65: 
/*  53: 46 */       if (EpicarnoComp.dir == -EpicarnoComp.player.movingSpeed) {
/*  54: 47 */         EpicarnoComp.isMoving = false;
/*  55:    */       }
/*  56: 50 */       break;
/*  57:    */     case 32: 
/*  58: 52 */       EpicarnoComp.isHipideHopping = false;
/*  59:    */     }
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void keyTyped(KeyEvent e) {}
/*  63:    */   
/*  64:    */   public void mouseWheelMoved(MouseWheelEvent e)
/*  65:    */   {
	Player.fallingspeed = 1.5D;

/*  66: 70 */     if (e.getWheelRotation() > 0)
/*  67:    */     {
/*  68: 71 */       if (Inventory.soming < EpicarnoTiles.invLength - 1) {
/*  69: 72 */         Inventory.soming += 1;
/*  70:    */       } else {
/*  71: 74 */         Inventory.soming = 0;
/*  72:    */       }
/*  73:    */     }
/*  74: 77 */     else if (e.getWheelRotation() < 0) {
/*  75: 78 */       if (Inventory.soming > 0) {
/*  76: 79 */         Inventory.soming -= 1;
/*  77:    */       } else {
/*  78: 81 */         Inventory.soming = EpicarnoTiles.invLength - 1;
/*  79:    */       }
/*  80:    */     }
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void mouseDragged(MouseEvent e)
/*  84:    */   {
/*  85: 90 */     EpicarnoComp.mse.setLocation(e.getX(), e.getY());
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void mouseMoved(MouseEvent e)
/*  89:    */   {
/*  90: 97 */     EpicarnoComp.mse.setLocation(e.getX(), e.getY());
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void mouseClicked(MouseEvent e) {}
/*  94:    */   
/*  95:    */   public void mouseEntered(MouseEvent e) {}
/*  96:    */   
/*  97:    */   public void mouseExited(MouseEvent e) {}
/*  98:    */   
/*  99:    */   public void mousePressed(MouseEvent e)
/* 100:    */   {
/* 101:124 */     if (e.getButton() == 1) {
/* 102:125 */       EpicarnoComp.isLeftyDown = true;
/* 103:126 */     } else if (e.getButton() == 3) {
/* 104:127 */       EpicarnoComp.isRightyDown = true;
/* 105:    */     }
/* 106:130 */     Inventory.click(e);
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void mouseReleased(MouseEvent e)
/* 110:    */   {
/* 111:137 */     if (e.getButton() == 1) {
/* 112:138 */       EpicarnoComp.isLeftyDown = false;
/* 113:139 */     } else if (e.getButton() == 3) {
/* 114:140 */       EpicarnoComp.isRightyDown = false;
/* 115:    */     }
/* 116:    */   }
/* 117:    */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.Listening
 * JD-Core Version:    0.7.0.1
 */