/*  1:   */ package net.epicarno.client;
/*  2:   */ 
/*  3:   */ import java.awt.Graphics;
/*  4:   */ 
/*  5:   */ public class Zombie
/*  6:   */   extends Mob
/*  7:   */ {
/*  8:   */   public Zombie(int x, int y, int width, int height, int[] id)
/*  9:   */   {
/* 10: 7 */     super(x, y, width, height, id);
/* 11:   */   }
/* 12:   */   
/* 13:   */   public void tick()
/* 14:   */   {
/* 15:12 */     super.tick();
/* 16:   */   }
/* 17:   */   
/* 18:   */   public void render(Graphics g)
/* 19:   */   {
/* 20:16 */     super.render(g);
/* 21:   */   }
/* 22:   */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.Zombie
 * JD-Core Version:    0.7.0.1
 */