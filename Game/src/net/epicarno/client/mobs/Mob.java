 package net.epicarno.client.mobs;
 
 import java.awt.Graphics;
 import java.awt.Point;
 import java.util.Random;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.DobbleRec;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.TileProperties;
 
 public class Mob
   extends DobbleRec
 {
   public int[] id;
   public boolean isHipideHopping = false;
   public boolean isMOOVING = false;
   public boolean isFalling = false;
   public double movementSpeed = 0.4D;
   public double fallingspeed = 1.5D;
   public double HipdieHopSpeed = 1.0D;
   public double dir = this.movementSpeed;
   public int ScipHopHipdieHop = 50;
   public int HipdieHopCount = 0;
   public int anima = 0;
   public int animaFrame = 0;
   public int animaTime = 30;
   
   public Mob(int x, int y, int width, int height, int[] id)
   {
     setBounds(x, y, width, height);
     
     this.id = id;
   }
   
   public void tick()
   {
     if ((!this.isHipideHopping) && (!isCollidingWithBlock(new Point((int)this.x + 2, (int)(this.y + this.height)), new Point((int)(this.x + this.width - 2.0D), (int)(this.y + this.height)))))
     {
       this.y += this.fallingspeed;
       this.isFalling = true;
     }
     else
     {
       this.isFalling = false;
       if (new Random().nextInt(100) < 1)
       {
         this.isMOOVING = true;
         if (new Random().nextInt(100) > 50) {
           this.dir = (-this.movementSpeed);
         } else {
           this.dir = this.movementSpeed;
         }
       }
     }
     if (this.isMOOVING)
     {
       boolean canMove = false;
       if (this.dir == this.movementSpeed) {
         canMove = isCollidingWithBlock(new Point((int)(this.x + this.width), (int)this.y), new Point((int)(this.x + this.width), (int)(this.y + (this.height - 2.0D))));
       } else if (this.dir == -this.movementSpeed) {
         canMove = isCollidingWithBlock(new Point((int)this.x - 1, (int)this.y), new Point((int)this.x - 1, (int)(this.y + (this.height - 2.0D))));
       }
       if ((!canMove) && (!this.isFalling)) {
         this.isHipideHopping = true;
       }
       if (this.animaFrame >= this.animaTime)
       {
         if (this.anima > 1) {
           this.anima = 1;
         } else {
           this.anima += 1;
         }
         this.animaFrame = 0;
       }
       else
       {
         this.animaFrame += 1;
       }
       if (!canMove) {
         this.x += this.dir;
       }
     }
     else
     {
       this.anima = 0;
     }
     if (this.isHipideHopping) {
       if (!isCollidingWithBlock(new Point((int)(this.x + 2.0D), (int)this.y), new Point((int)(this.x + this.width - 2.0D), (int)this.y)))
       {
         if (this.HipdieHopCount >= this.ScipHopHipdieHop)
         {
           this.isHipideHopping = false;
           
           this.HipdieHopCount = 0;
         }
         else
         {
           this.y -= this.HipdieHopSpeed;
           
           this.HipdieHopCount += 1;
         }
       }
       else
       {
         this.isHipideHopping = false;
         this.HipdieHopCount = 0;
       }
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
     if (this.dir == this.movementSpeed) {
       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, this.id[1] * EpicarnoTiles.tileSize + (int)this.height, null);
     } else {
       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, this.id[1] * EpicarnoTiles.tileSize + (int)this.height, null);
     }
   }
 }


