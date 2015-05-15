 package net.epicarno.client.world.entitys;
 
 import java.awt.Graphics;
 import java.awt.Point;
 import java.util.Random;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.DobbleRec;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.TileProperties;
 
 public class FallingObject
   extends DobbleRec
 {
   public int[] id;
   public boolean isFalling = false;
   public double movementSpeed = 0.4D;
   public double fallingspeed = 1.5D;
   public int anima = 0;
   public int animaFrame = 0;
   public int animaTime = 30;
   
   public FallingObject(int x, int y, int width, int height, int[] id)
   {
     setBounds(x, y, width, height);
     
     this.id = id;
   }
   
   public void tick()
   {
     if ( (!isCollidingWithBlock(new Point((int)this.x + 2, (int)(this.y + this.height)), new Point((int)(this.x + this.width - 2.0D), (int)(this.y + this.height)))))
     {
       this.y += this.fallingspeed;
       this.isFalling = true;
     }
     else
     {
       this.isFalling = false;
     }
   }

   
   public boolean isCollidingWithBlock(Point pt1, Point pt2)
   {
	   TileProperties tileProp = new TileProperties();
     for (int x = (int)(this.x / EpicarnoTiles.tileSize); x < this.x / EpicarnoTiles.tileSize + 3.0D; x++) {
       for (int y = (int)(this.y / EpicarnoTiles.tileSize); y < this.y / EpicarnoTiles.tileSize + 3.0D; y++) {
         if ((x >= 0) && (y >= 0) && (x < EpicarnoComp.epicarnol.block.length) && (y < EpicarnoComp.epicarnol.block[0].length) && 
            (tileProp.isSolidTile(EpicarnoComp.epicarnol.block[x][y].id) )&&(
           (EpicarnoComp.epicarnol.block[x][y].contains(pt1)) || (EpicarnoComp.epicarnol.block[x][y].contains(pt2)))) {
           return true;
         }
       }
     }
     return false;
   }
   
   public void render(Graphics g)
   {

       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, this.id[1] * EpicarnoTiles.tileSize + (int)this.height, null);
 
   }
 }



