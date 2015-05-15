/*  1:   */ package net.epicarno.client;
/*  2:   */ 
/*  3:   */ import java.awt.Color;
/*  4:   */ import java.awt.Dimension;
/*  5:   */ import java.awt.Graphics;
/*  6:   */ 
/*  7:   */ public class Sky
/*  8:   */ {
/*  9: 6 */   public int day = 0;
/* 10: 7 */   public int night = 1;
/* 11: 8 */   public int time = this.day;
/* 12: 9 */   public int r1 = 100;
/* 13: 9 */   public int g1 = 149;
/* 14: 9 */   public int b1 = 237;
/* 15:10 */   public int r2 = 21;
/* 16:10 */   public int g2 = 20;
/* 17:10 */   public int b2 = 20;
/* 18:11 */   public int r = this.r1;
/* 19:11 */   public int g = this.g1;
/* 20:11 */   public int b = this.b1;
/* 21:12 */   public int dayFrame = 0;
/* 22:12 */   public int dayTime = 10000;
/* 23:13 */   public int changeFrame = 0;
/* 24:13 */   public int changeTime = 4;
/* 25:   */   
/* 26:   */   public Sky()
/* 27:   */   {
/* 28:17 */     if (this.time == this.day)
/* 29:   */     {
/* 30:18 */       this.r = this.r1;
/* 31:19 */       this.g = this.g1;
/* 32:20 */       this.b = this.b1;
/* 33:   */     }
/* 34:22 */     else if (this.time == this.night)
/* 35:   */     {
/* 36:23 */       this.r = this.r2;
/* 37:24 */       this.g = this.g2;
/* 38:25 */       this.b = this.b2;
/* 39:   */     }
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void tick()
/* 43:   */   {
/* 44:33 */     if (this.dayFrame >= this.dayTime)
/* 45:   */     {
/* 46:34 */       if (this.time == this.day) {
/* 47:35 */         this.time = this.night;
/* 48:36 */       } else if (this.time == this.night) {
/* 49:37 */         this.time = this.day;
/* 50:   */       }
/* 51:40 */       this.dayFrame = 0;
/* 52:   */     }
/* 53:   */     else
/* 54:   */     {
/* 55:42 */       this.dayFrame += 1;
/* 56:   */     }
/* 57:45 */     if (this.changeFrame >= this.changeTime)
/* 58:   */     {
/* 59:46 */       if (this.time == this.day)
/* 60:   */       {
/* 61:47 */         if (this.r < this.r1) {
/* 62:48 */           this.r += 1;
/* 63:   */         }
/* 64:50 */         if (this.g < this.g1) {
/* 65:51 */           this.g += 1;
/* 66:   */         }
/* 67:53 */         if (this.b < this.b1) {
/* 68:54 */           this.b += 1;
/* 69:   */         }
/* 70:   */       }
/* 71:57 */       else if (this.time == this.night)
/* 72:   */       {
/* 73:58 */         if (this.r > this.r2) {
/* 74:59 */           this.r -= 1;
/* 75:   */         }
/* 76:61 */         if (this.g > this.g2) {
/* 77:62 */           this.g -= 1;
/* 78:   */         }
/* 79:64 */         if (this.b > this.b2) {
/* 80:65 */           this.b -= 1;
/* 81:   */         }
/* 82:   */       }
/* 83:70 */       this.changeFrame = 0;
/* 84:   */     }
/* 85:   */     else
/* 86:   */     {
/* 87:72 */       this.changeFrame += 1;
/* 88:   */     }
/* 89:   */   }
/* 90:   */   
/* 91:   */   public void render(Graphics gr)
/* 92:   */   {
	
/* 93:78 */     gr.setColor(new Color(this.r, this.g, this.b));
/* 94:79 */     gr.fillRect(0, 0, EpicarnoComp.pixel.width, EpicarnoComp.pixel.height);
/* 95:   */   }
/* 96:   */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.Sky
 * JD-Core Version:    0.7.0.1
 */