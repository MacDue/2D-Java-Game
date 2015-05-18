package net.epicarno.client.mobs;

import java.awt.Graphics;
import java.awt.Point;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;

public class FallingTile    extends Mob
	 {
	   public FallingTile(int x, int y, int width, int height, int[] id)
	   {
	     super(x, y, width, height, id);
	   }
	   
	   
	   @Override
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
	     }
	     
	     if(isCollidingWithBlock(new Point((int)this.x + 2, (int)(this.y + this.height)), new Point((int)(this.x + this.width - 2.0D), (int)(this.y + this.height)))){
	     
	    	if(EpicarnoComp.epicarnol.prop.isReplaceable(EpicarnoComp.epicarnol.block[(int)this.x /16][(int)this.y/16].id)){ 
	    	 EpicarnoComp.epicarnol.SetTile(((int)this.x) /16, ((int)this.y)/16, this.id);
	    	}
	     EpicarnoComp.mob.remove(this);
	     }
	   }
	   
	   @Override
	   public void render(Graphics g)
	   {
	   
	       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, this.id[1] * EpicarnoTiles.tileSize + (int)this.height, null);
	     
	   }
}
