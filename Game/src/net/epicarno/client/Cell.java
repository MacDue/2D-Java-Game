/*  1:   */ package net.epicarno.client;
/*  2:   */ 
/*  3:   */ import java.awt.Color;
/*  4:   */ import java.awt.Graphics;
/*  5:   */ import java.awt.Point;
/*  6:   */ import java.awt.Rectangle;
/*  7:   */ 
/*  8:   */ public class Cell
/*  9:   */   extends Rectangle
/* 10:   */ {
/* 11:   */   private static final long serialVersionUID = 1L;
/* 12:12 */   public int[] id = new int[2];
/* 13:   */   
/* 14:   */   public Cell(Rectangle size, int[] id)
/* 15:   */   {
/* 16:15 */     setBounds(size);
/* 17:16 */     this.id = id;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void render(Graphics g, boolean isSelected)
/* 21:   */   {
/* 22:21 */     if ((Inventory.isOpen) && (contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize, EpicarnoComp.mse.y / EpicarnoComp.pixelSize))))
/* 23:   */     {
/* 24:22 */       g.setColor(new Color(255, 255, 255, 130));
/* 25:23 */       g.fillRect(this.x, this.y, this.width, this.height);
/* 26:   */     }
/* 27:26 */     g.drawImage(EpicarnoTiles.tile_cell, this.x, this.y, this.width, this.height, null);
/* 28:28 */     if (this.id != EpicarnoTiles.air) {
/* 29:29 */       g.drawImage(EpicarnoTiles.GameTile, this.x + EpicarnoTiles.BlockIcons, this.y + EpicarnoTiles.BlockIcons, this.x - EpicarnoTiles.BlockIcons + this.width, this.y - EpicarnoTiles.BlockIcons + this.height, this.id[0] * EpicarnoTiles.tileSize, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, this.id[1] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, null);
/* 30:   */     }
/* 31:34 */     if ((isSelected) && (!Inventory.isOpen)) {
/* 32:35 */       g.drawImage(EpicarnoTiles.tile_select, this.x - 1, this.y - 1, this.width + 2, this.height + 2, null);
/* 33:   */     }
/* 34:   */   }
/* 35:   */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.Cell
 * JD-Core Version:    0.7.0.1
 */