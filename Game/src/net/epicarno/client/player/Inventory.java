 package net.epicarno.client.player;
 
 import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
 
 public class Inventory
 {
   public static Cell[] invBar = new Cell[EpicarnoTiles.invLength];
   public static Cell[] invBag = new Cell[EpicarnoTiles.invLength * EpicarnoTiles.invHeight];
   public static boolean isOpen = false;
   public static boolean isHolding = false;
   public static int soming = 0;
   public static int[] holdingID = EpicarnoTiles.air;
   
   public Inventory()
   {

	     for (int i = 0; i < invBar.length; i++) {
		       invBar[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + i * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19- (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
		     }
		     int x = 0;int y = 0;
		     for (int i = 0; i < invBag.length; i++)
		     {
		       invBag[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + x * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19 - (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace) - EpicarnoTiles.invHeight * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace) + y * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
		       x++;
		       if (x == EpicarnoTiles.invLength)
		       {
		         x = 0;
		         y++;
		       }
		     }

   }
   






	


   public static void click(MouseEvent e)
   {
     if ((e.getButton() == 1) && 
       (isOpen))
     {
       for (int i = 0; i < invBar.length; i++) {
         if (invBar[i].contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize, EpicarnoComp.mse.y / EpicarnoComp.pixelSize))) {
           if ((invBar[i].id != EpicarnoTiles.air) && (!isHolding))
           {
             holdingID = invBar[i].id;
             InvItems.invItems[i].id = EpicarnoTiles.air;
             
             isHolding = true;
           }
           else if ((isHolding) && (invBar[i].id == EpicarnoTiles.air))
           {
             InvItems.invItems[i].id = holdingID;
             
 
             isHolding = false;
           }
           else if ((isHolding) && (invBar[i].id != EpicarnoTiles.air))
           {
             int[] con = invBar[i].id;
             
             InvItems.invItems[i].id = holdingID;
             holdingID = con;
           }
         }
       }
       for (int i = 0; i < invBag.length; i++) {
         if (invBag[i].contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize, EpicarnoComp.mse.y / EpicarnoComp.pixelSize))) {
           if ((invBag[i].id != EpicarnoTiles.air) && (!isHolding))
           {
             holdingID = invBag[i].id;
             InvItems.invBagItems[i].id = EpicarnoTiles.air;
             
             isHolding = true;
           }
           else if ((isHolding) && (invBag[i].id == EpicarnoTiles.air))
           {
             InvItems.invBagItems[i].id = holdingID;

//System.out.println( InvItems.invBagItems[i].id);
             
 
             isHolding = false;
           }
           else if ((isHolding) && (invBag[i].id != EpicarnoTiles.air))
           {
             int[] con = invBag[i].id;
             
             InvItems.invBagItems[i].id = holdingID;
             holdingID = con;
           }
         }
       }
     }
   }
   
   public void render(Graphics h)
   {


     for (int i = 0; i < invBar.length; i++)
     {
       boolean isSelected = false;
       if (i == soming) {
         isSelected = true;
       }
       invBar[i].render(h, isSelected);
     }
     if (isOpen)
     {
    	// System.out.println(invBar.length);
       for (int i = 0; i < invBag.length; i++) {
         invBag[i].render(h, false);
       }
       if (isHolding) {
    	   
         h.drawImage(EpicarnoTiles.GameTile, EpicarnoComp.mse.x / EpicarnoComp.pixelSize - EpicarnoTiles.incCellSize / 2 + EpicarnoTiles.BlockIcons, EpicarnoComp.mse.y / EpicarnoComp.pixelSize - EpicarnoTiles.incCellSize / 2 + EpicarnoTiles.BlockIcons, EpicarnoComp.mse.x / EpicarnoComp.pixelSize - EpicarnoTiles.incCellSize / 2 + EpicarnoTiles.incCellSize - EpicarnoTiles.BlockIcons, EpicarnoComp.mse.y / EpicarnoComp.pixelSize - EpicarnoTiles.incCellSize / 2 + EpicarnoTiles.incCellSize - EpicarnoTiles.BlockIcons, holdingID[0] * EpicarnoTiles.tileSize, holdingID[1] * EpicarnoTiles.tileSize, holdingID[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, holdingID[1] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, null);
       }
     }
   }
 }


