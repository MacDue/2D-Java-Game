 package net.epicarno.client.player;
 import java.awt.Graphics;
import java.awt.Point;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.DobbleRec;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.TileProperties;
 
 public class Player
   extends DobbleRec
 {
   public static double fallingspeed = 1.5D;
   public double movingSpeed = 0.5D;
   public double HipdieHopSpeed = 1.4D;
   public int ScipHopHipdieHop = 50;
   public int HipdieHopCount = 0;
   public int anima = 0;
   public int animaFrame = 0;
   public int animaTime = 60;
   public boolean isHipideHopping = false;
   
   public Player(int width, int height)
   {
     setBounds(EpicarnoComp.pixel.width / 2 - width / 2, EpicarnoComp.pixel.height / 2 - height / 2, width, height);

   }
   
public void redo(int width, int height){
	 setBounds(EpicarnoComp.pixel.width / 2 - width / 2, EpicarnoComp.pixel.height / 2 - height / 2, width, height);
	
}


   public void tick()
   {
	
     if ((!this.isHipideHopping)&& (!isCollidingWithBlock(new Point((int)this.x + 2, (int)(this.y + this.height)), new Point((int)(this.x + this.width - 2.0D), (int)(this.y + this.height)))))
     {
       this.y += this.fallingspeed;
      EpicarnoComp.sY += this.fallingspeed;
     }
     else if ((EpicarnoComp.isHipideHopping) && (!Inventory.isOpen))
     {
       this.isHipideHopping = true;
     }
     if ((EpicarnoComp.isMoving) && (!Inventory.isOpen))
     {
       boolean canMove = false;
       if (EpicarnoComp.dir == this.movingSpeed) {
         canMove = isCollidingWithBlock(new Point((int)(this.x + this.width), (int)this.y), new Point((int)(this.x + this.width), (int)(this.y + (this.height - 2.0D))));
       } else if (EpicarnoComp.dir == -this.movingSpeed) {
         canMove = isCollidingWithBlock(new Point((int)this.x - 1, (int)this.y), new Point((int)this.x - 1, (int)(this.y + (this.height - 2.0D))));
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
       if (!canMove)
       {
         this.x += EpicarnoComp.dir;
//EpicarnoComp.sX +100;
         EpicarnoComp.sX += EpicarnoComp.dir ;
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
           EpicarnoComp.sY -= this.HipdieHopSpeed;
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
           (tileProp.isSolidTile(EpicarnoComp.epicarnol.block[x][y].id) )&& (
           (EpicarnoComp.epicarnol.block[x][y].contains(pt1)) || (EpicarnoComp.epicarnol.block[x][y].contains(pt2)))) {
           return true;
         }
       }
     }
     return false;
   }
   
   public void render(Graphics g)
   {
	     if (EpicarnoComp.dir == this.movingSpeed) {
		       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, EpicarnoTiles.Player[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, EpicarnoTiles.Player[1] * EpicarnoTiles.tileSize, EpicarnoTiles.Player[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, EpicarnoTiles.Player[1] * EpicarnoTiles.tileSize + (int)this.height, null);
		     } else {
		       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, EpicarnoTiles.Player[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, EpicarnoTiles.Player[1] * EpicarnoTiles.tileSize, EpicarnoTiles.Player[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, EpicarnoTiles.Player[1] * EpicarnoTiles.tileSize + (int)this.height, null);
		     }
   }

 }


