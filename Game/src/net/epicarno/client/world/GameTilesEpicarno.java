 package net.epicarno.client.world;
 
 import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.RescaleOp;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.Tiles.Tile;
 
 public class GameTilesEpicarno
   extends Rectangle
 {
   private static final long serialVersionUID = 1L;
   public int[] id = { -1, -1 };
   public Tile GameTile;
               //  public int lightLevel = 16;
   
   public GameTilesEpicarno(Rectangle size, Tile tile)
   {
	  setBounds(size);
	  GameTile = tile;
     this.id = GameTile.id;
   }
   
   public void setTile(Tile gtile){
	   
	   GameTile = gtile;
	   this.id = gtile.id;
	   
   }
   
   public void tick(){
	   GameTile.tick();
	   
	  //if(GameTile.id)
	  // setTile(GameTile);
	   
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
   
   public void fakerender(Graphics g, int[]FakeTile)
   {
    // if (this.id != EpicarnoTiles.air) {
	  float scaleFactor = 0.5f;
	 
	  RescaleOp op = new RescaleOp(scaleFactor, 0, null);
	  Graphics2D g2 = (Graphics2D) g;
	  //EpicarnoTiles.GameTile = op.filter(EpicarnoTiles.GameTile, null);
	  float opacity = 0.5f;
	  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
      g2.drawImage(EpicarnoTiles.GameTile, this.x - (int)EpicarnoComp.sX, this.y - (int)EpicarnoComp.sY, this.x + this.width - (int)EpicarnoComp.sX, this.y + this.height - (int)EpicarnoComp.sY, FakeTile[0] * EpicarnoTiles.tileSize, FakeTile[1] * EpicarnoTiles.tileSize, FakeTile[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, FakeTile[1] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, null);
       opacity = 1f;
      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
   }
 }


