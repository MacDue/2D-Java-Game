 package net.epicarno.client.world;
 
 import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.RescaleOp;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
 
 public class GameBlocksEpicarno
   extends Rectangle
 {
   private static final long serialVersionUID = 1L;
   public int[] id = { -1, -1 };
               //  public int lightLevel = 16;
   
   public GameBlocksEpicarno(Rectangle size, int[] id)
   {
     setBounds(size);
     this.id = id;
   }
   
   public void render(Graphics g)
   {
     if (this.id != EpicarnoTiles.air) {
	  float scaleFactor = 0.5f;
	 
	  RescaleOp op = new RescaleOp(scaleFactor, 0, null);
	 
	  //EpicarnoTiles.GameTile = op.filter(EpicarnoTiles.GameTile, null);
	  
       g.drawImage(EpicarnoTiles.GameTile, this.x - (int)EpicarnoComp.sX, this.y - (int)EpicarnoComp.sY, this.x + this.width - (int)EpicarnoComp.sX, this.y + this.height - (int)EpicarnoComp.sY, this.id[0] * EpicarnoTiles.tileSize, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, this.id[1] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, null);
     }
   }
 }


