 package net.epicarno.client.player;
 
 import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
 
 public class Cell
   extends Rectangle
 {
   private static final long serialVersionUID = 1L;
   public int[] id = new int[2];
   
   public Cell(Rectangle size, int[] id)
   {
     setBounds(size);
     this.id = id;
   }
   
   public void render(Graphics g, boolean isSelected)
   {
	   
	  
     if ((Inventory.isOpen) && (contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize, EpicarnoComp.mse.y / EpicarnoComp.pixelSize))))
     {
       g.setColor(new Color(255, 255, 255, 130));
       g.fillRect(this.x, this.y, this.width, this.height);
     }
     g.drawImage(EpicarnoTiles.tile_cell, this.x, this.y, this.width, this.height, null);
     if (this.id != EpicarnoTiles.air) {
       g.drawImage(EpicarnoTiles.GameTile, this.x + EpicarnoTiles.BlockIcons, this.y + EpicarnoTiles.BlockIcons, this.x - EpicarnoTiles.BlockIcons + this.width, this.y - EpicarnoTiles.BlockIcons + this.height, this.id[0] * EpicarnoTiles.tileSize, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, this.id[1] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, null);
     }
     if ((isSelected) && (!Inventory.isOpen)) {
       g.drawImage(EpicarnoTiles.tile_select, this.x - 1, this.y - 1, this.width + 2, this.height + 2, null);
     }
   }
 }


