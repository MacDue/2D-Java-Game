/*  1:   */ package net.epicarno.client;
/*  2:   */ 
/*  3:   */ import java.awt.Color;
import java.awt.Graphics;
/*  4:   */ import java.awt.Rectangle;
import java.awt.image.RescaleOp;
/*  5:   */ 
/*  6:   */ public class GameBlocksEpicarno
/*  7:   */   extends Rectangle
/*  8:   */ {
/*  9:   */   private static final long serialVersionUID = 1L;
/* 10: 9 */   public int[] id = { -1, -1 };
               //  public int lightLevel = 16;
/* 11:   */   
/* 12:   */   public GameBlocksEpicarno(Rectangle size, int[] id)
/* 13:   */   {
/* 14:12 */     setBounds(size);
/* 15:13 */     this.id = id;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public void render(Graphics g)
/* 19:   */   {
/* 20:17 */     if (this.id != EpicarnoTiles.air) {
	  float scaleFactor = 0.5f;
	 
	  RescaleOp op = new RescaleOp(scaleFactor, 0, null);
	 
	  //EpicarnoTiles.GameTile = op.filter(EpicarnoTiles.GameTile, null);
	  
/* 21:18 */       g.drawImage(EpicarnoTiles.GameTile, this.x - (int)EpicarnoComp.sX, this.y - (int)EpicarnoComp.sY, this.x + this.width - (int)EpicarnoComp.sX, this.y + this.height - (int)EpicarnoComp.sY, this.id[0] * EpicarnoTiles.tileSize, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, this.id[1] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, null);
/* 22:   */     }
/* 23:   */   }
/* 24:   */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.GameBlocksEpicarno
 * JD-Core Version:    0.7.0.1
 */