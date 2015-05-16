package net.epicarno.client.world;
 
 import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.player.Inventory;
 
 public class EpicarnoBackground
 {
   public static int worldH = 50;
   public static int worldW = 10000;
public int ly = 0;
   public GameBlocksEpicarno[][] block = new GameBlocksEpicarno[worldW][worldH];
   
   public EpicarnoBackground(int BiomeID)
   {
     for (int x = 0; x < this.block.length; x++) {
       for (int y = 0; y < this.block[0].length; y++) {
         this.block[x][y] = new GameBlocksEpicarno(new Rectangle(x * EpicarnoTiles.tileSize, y * EpicarnoTiles.tileSize, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize), EpicarnoTiles.air);
       }
     }
     gernerateELevel(BiomeID);
   }
   
   public void gernerateELevel(int BiomeID)
   {
int[] TopBlock = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 1);
 int[] BottomBlock =EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 7);
 int[] Stone = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 6);
 int[] BiomeFlower = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 2);
 int[] Shrub = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 3);
 int[] Wood =  EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 4);
 int[] Leaves =  EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 5);
 
 for (int x = 0; x < this.block.length; x++){
	// System.out.println("TEST"+EpicarnoTiles.wood);
	 for  (int y = 0; y < this.block[0].length; y++){
		 if (y > worldH / 4)
		          {
		            if (new Random().nextInt(100) > 20) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == BottomBlock) {
		                this.block[x][y].id = BottomBlock;
		                }
		              }
		              catch (Exception localException) {}
		            }
		            if (new Random().nextInt(100) > 20) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == Stone) {
		                this.block[x][y].id = Stone;
		                }
		              }
		              catch (Exception localException) {}
		            }
		            if (new Random().nextInt(100) > 30) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == BottomBlock) {
		                 this.block[x][y].id = BottomBlock;
		                }
		              }
		              catch (Exception localException1) {}
		            }
		            if (new Random().nextInt(100) > 30) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == Stone) {
		                 this.block[x][y].id = Stone;
		                }
		              }
		              catch (Exception localException1) {}
		            }
		            try
		            {
		 	             if (this.block[x][(y - 1)].id == Stone) {
		 		              this.block[x][y].id = Stone;
		 		             }
		              if (this.block[x][(y - 1)].id == BottomBlock) {
		               this.block[x][y].id = BottomBlock;
		              }
		            }
		            catch (Exception localException2) {}
	//	 System.out.println(y);
		            if (new Random().nextInt(100) < 45) {
		 	                        if(y > 15){
		              this.block[x][y].id = Stone;
		 	                        }else{
		 	                        	  this.block[x][y].id = BottomBlock;
		 	                        }
		            }
		          }
		        }
		      }
		      for (int y = 0; y < this.block.length; y++) {
		        for (int x = 0; x < this.block[0].length; x++) {
		          try
		          {
		            if ((this.block[x][(y + 1)].id == BottomBlock) && (this.block[x][y].id == EpicarnoTiles.air) && 
		              (new Random().nextInt(100) <= 7)) {
		              for (int i = 0; i < new Random().nextInt(5) + 4; i++) {
		                this.block[x][(y - i)].id = Wood;
		 ly = y - i;
		              }

		 for (int in = 0; in < new Random().nextInt(5) + 4; in++) {
		 //int ly = y - i;
		              for (int i = 0; i < new Random().nextInt(5) + 2; i++) {
		                this.block[x - i][(ly-in)].id = Leaves;
		              }

		              for (int i = 0; i < new Random().nextInt(5) + 2; i++) {
		                this.block[x + i][(ly-in)].id = Leaves;
		              }

		 }
		                          
		            }
		          }
		          catch (Exception localException3) {}
		        }


		      }
		      
		      for (int x = 0; x < this.block.length; x++) {
		    	         for (int y = 0; y < this.block[0].length; y++) {
		    	           if ((this.block[x][y].id == BottomBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air)) {
		    	             this.block[x][y].id = TopBlock;
		    	           }
		    	         }
		    	       }
		      
		           for (int x = 0; x < this.block.length; x++) {
		    	         for (int y = 0; y < this.block[0].length; y++) {
		    	           if ((this.block[x][y].id == TopBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
		    	  		             (new Random().nextInt(100) <= 20)) {
		    	            this.block[x][y-1].id = Shrub;
		    	           }
		    	         }
		    	       }
		           
		           for (int x = 0; x < this.block.length; x++) {
		    	         for (int y = 0; y < this.block[0].length; y++) {
		    	           if ((this.block[x][y].id == TopBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
		    	  		             (new Random().nextInt(100) <= 4)) {
		    	            this.block[x][y-1].id = BiomeFlower;
		    	           }
		    	         }
		    	       }
		    
	 }
	 
 
 
   
   public   void render(Graphics g, int camX, int camY, int renW, int renH)
   {
     for (int x = camX / EpicarnoTiles.tileSize; x < camX / EpicarnoTiles.tileSize + renW; x++) {
       for (int y = camY / EpicarnoTiles.tileSize; y < camY / EpicarnoTiles.tileSize + renH; y++) {
         if ((x >= 0) && (y >= 0) && (x < worldW) && (y < worldH))
         {
           this.block[x][y].render(g);
           if ((this.block[x][y].id != EpicarnoTiles.air) && (this.block[x][y].id != EpicarnoTiles.bedrock) && (!Inventory.isOpen) && 
             (this.block[x][y].contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize + (int)EpicarnoComp.sX, EpicarnoComp.mse.y / EpicarnoComp.pixelSize + (int)EpicarnoComp.sY))))
           {
           //  g.setColor(new Color(255, 255, 255, 60));
         // g.fillRect(this.block[x][y].x - camX, this.block[x][y].y - camY, this.block[x][y].width, this.block[x][y].height);
           }
         }
       }
     }
   }
 }

