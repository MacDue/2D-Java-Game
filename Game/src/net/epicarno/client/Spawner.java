/*  1:   */ package net.epicarno.client;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.Random;
/*  5:   */ 
/*  6:   */ public class Spawner
/*  7:   */   implements Runnable
/*  8:   */ {
/*  9: 6 */   public boolean isRunning = true;
/* 10:   */   
/* 11:   */   public Spawner()
/* 12:   */   {
/* 13:10 */     new Thread(this).start();
/* 14:   */   }
/* 15:   */   
/* 16:   */   public void spawnMob(Mob mob)
/* 17:   */   {
/* 18:14 */     EpicarnoComp.mob.add(mob);
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void run()
/* 22:   */   {
/* 23:18 */     while (this.isRunning)
/* 24:   */     {
/* 25:19 */       if (EpicarnoComp.mob.toArray().length < EpicarnoTiles.maxMobs) {
/* 26:20 */         spawnMob(new Zombie(new Random().nextInt((EpicarnoL.worldW - 2) * EpicarnoTiles.tileSize) + EpicarnoTiles.tileSize + 30, 50, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2, EpicarnoTiles.Zombie));
/* 27:   */       }
/* 28:   */       try
/* 29:   */       {
/* 30:23 */         Thread.sleep(new Random().nextInt(15000) + 15000);
/* 31:   */       }
/* 32:   */       catch (Exception localException) {}
/* 33:   */     }
/* 34:   */   }
/* 35:   */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.Spawner
 * JD-Core Version:    0.7.0.1
 */