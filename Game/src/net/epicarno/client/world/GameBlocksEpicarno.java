 package net.epicarno.client.world;
 
 import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.RescaleOp;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.Tiles.Tile;
 
 public class GameBlocksEpicarno
   extends Rectangle
 {
   private static final long serialVersionUID = 1L;
   public int[] id = { -1, -1 };
   public Tile GameTile;
               //  public int lightLevel = 16;
   
   public GameBlocksEpicarno(Rectangle size, Tile tile)
   {
	  setBounds(size);
	  GameTile = tile;
     this.id = GameTile.id;
   }
   
   public void setTile(Tile gtile){
	   //gtile.tick();
	   GameTile = gtile;
	   this.id = gtile.id;
	   
   }
   
   public void tick(){
	   if (this.id == EpicarnoTiles.bling){
		   System.out.println(this.x);
	   }
   }
   
   @SuppressWarnings("unused")
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


