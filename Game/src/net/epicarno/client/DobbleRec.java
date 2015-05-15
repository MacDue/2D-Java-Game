/*  1:   */ package net.epicarno.client;
/*  2:   */ 
/*  3:   */ public class DobbleRec
/*  4:   */ {
/*  5:   */   public double x;
/*  6:   */   public double y;
/*  7:   */   public double width;
/*  8:   */   public double height;
/*  9:   */   
/* 10:   */   public DobbleRec()
/* 11:   */   {
/* 12: 7 */     setBounds(0.0D, 0.0D, 0.0D, 0.0D);
/* 13:   */   }
/* 14:   */   
/* 15:   */   public DobbleRec(double x, double y, double width, double height)
/* 16:   */   {
/* 17:12 */     setBounds(x, y, width, height);
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setBounds(double x, double y, double width, double height)
/* 21:   */   {
/* 22:16 */     this.x = x;
/* 23:17 */     this.y = y;
/* 24:18 */     this.width = width;
/* 25:19 */     this.height = height;
/* 26:   */   }
/* 27:   */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.DobbleRec
 * JD-Core Version:    0.7.0.1
 */