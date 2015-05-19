package net.epicarno.client.world;
 
 import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.TileProperties;
import net.epicarno.client.generic.Tiles.Tile;
import net.epicarno.client.player.Inventory;
 
 public class EpicarnoBackground
 {
   public static int worldH = 250;
   public static int worldW = 10000;
  public int[] TopBlock;
  public int[] BottomBlock;
  public  int[] Stone;
  public int[] BiomeFlower;
  public int[] Shrub;
  public int[] Wood;
  public int[] Leaves;
  private final long PERIOD = 600L; // Adjust to suit timing
  private long lastTime = System.currentTimeMillis() - PERIOD;
  //public int[] BiomeOrder = new int[200];
   public static boolean placed = false;
   public TileProperties prop = new TileProperties();
public int ly = 0;
   public GameTilesEpicarno[][] block = new GameTilesEpicarno[worldW][worldH];
   
   public EpicarnoBackground(int BiomeID)
   {
     for (int x = 0; x < this.block.length; x++) {
       for (int y = 0; y < this.block[0].length; y++) {
         this.block[x][y] = new GameTilesEpicarno(new Rectangle(x * EpicarnoTiles.tileSize, y * EpicarnoTiles.tileSize, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize), new Tile(EpicarnoTiles.air,0,0));
       }
     }
     gernerateELevel(BiomeID);
   }
   

   public int SwitchBiome(int startID){
	   int BiomeID = startID;

	   TopBlock = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 1);
	    BottomBlock =EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 7);
	    Stone = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 6);
	  BiomeFlower = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 2);
	   Shrub = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 3);
	   Wood =  EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 4);
	   Leaves =  EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 5);
	   
	   return BiomeID;
	   
   }
   
   public void SetBiome(int BiomeID){
	   TopBlock = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 1);
	    BottomBlock =EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 7);
	    Stone = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 6);
	  BiomeFlower = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 2);
	   Shrub = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 3);
	   Wood =  EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 4);
	   Leaves =  EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 5);
	    
   }
   
   public void gernerateELevel(int BiomeID)
   {
	   SetBiome(BiomeID);
	  
	//  int BiomeNum = 2;
 for (int x = 0; x < this.block.length; x++){
	// System.out.println("TEST"+EpicarnoTiles.wood);

	 for  (int y = 0; y < this.block[0].length; y++){
	
		 //SwitchBiome(BiomeID);
		 if (y > worldH / 4)
		          {
		            if (new Random().nextInt(worldH*2) >(worldH*0.4)) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == BottomBlock) {
		                this.block[x][y].setTile(new Tile(BottomBlock,x,y)); 
		                }
		              }
		              catch (Exception localException) {}
		            }
		            if (new Random().nextInt(worldH*2) > (worldH*0.4)) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == Stone) {
		                this.block[x][y].setTile(new Tile(Stone,x,y));
		                }
		              }
		              catch (Exception localException) {}
		            }
		            if (new Random().nextInt(worldH*2) > (worldH*0.6)) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == BottomBlock) {
		                 this.block[x][y].setTile(new Tile(BottomBlock,x,y));
		                }
		              }
		              catch (Exception localException1) {}
		            }
		            if (new Random().nextInt(worldH*2 ) > (worldH*0.6)) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == Stone) {
		                 this.block[x][y].setTile(new Tile(Stone,x,y)) ;
		                }
		              }
		              catch (Exception localException1) {}
		            }
		            try
		            {
		 	             if (this.block[x][(y - 1)].id == Stone) {
		 		              this.block[x][y].setTile(new Tile(Stone,x,y));
		 		             }
		              if (this.block[x][(y - 1)].id == BottomBlock) {
		               this.block[x][y].setTile(new Tile(BottomBlock,x,y));
		              }
		            }
		            catch (Exception localException2) {}
	//	 System.out.println(y);
		            if (new Random().nextInt((worldH*2)) < (worldH*0.9)) {
		 	                        if(y > (worldH*0.3)-(worldH*0.03)){
		              this.block[x][y].setTile(new Tile(Stone,x,y)) ;
		              //System.out.println(Stone.id);
		 	                        }else{
		 	                        	  this.block[x][y].setTile(new Tile(BottomBlock,x,y));
		 	                        }
		            }
		          }
		 //Here
		 
		 
		        }
		      }
 
 //Trees
 //BiomeNum =2;
 for (int x = 0; x < this.block.length; x++) {
	 

     for (int y = 0; y < this.block[0].length; y++) {
       try
       {
         if ((this.block[x][(y + 1)].id == BottomBlock) && (this.block[x][y].id == EpicarnoTiles.air) && 
           (new Random().nextInt(100) <= 7)) {
           for (int i = 0; i < new Random().nextInt(5) + 4; i++) {
             this.block[x][(y - i)].setTile(new Tile(Wood,x,y));
ly = y - i;
           }

for (int in = 0; in < new Random().nextInt(5) + 4; in++) {
//int ly = y - i;
           for (int i = 0; i < new Random().nextInt(5) + 2; i++) {
        	   if( this.block[x - i][(ly-in)].id == EpicarnoTiles.air){
             this.block[x - i][(ly-in)].setTile(new Tile(Leaves,x,y));
        	   }
           }

           for (int i = 0; i < new Random().nextInt(5) + 2; i++) {
        	   if(  this.block[x + i][(ly-in)].id == EpicarnoTiles.air){
             this.block[x + i][(ly-in)].setTile(new Tile(Leaves,x,y));
        	   }
           }

}
                       
         }
       }
       catch (Exception localException3) {}
     }


   }
 //EndTrees
   
 //BiomeNum =2;
 for (int x = 0; x < this.block.length; x++) {
	 
      for (int y = 0; y < this.block[0].length; y++) {
 	           if ((this.block[x][y].id == BottomBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air)) {
 	             this.block[x][y].setTile(new Tile(TopBlock,x,y)); 
 	           }
 	         }
 	       }
   
// BiomeNum =2;
 for (int x = 0; x < this.block.length; x++) {
	 

 	         for (int y = 0; y < this.block[0].length; y++) {
 	           if ((this.block[x][y].id == TopBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
 	  		             (new Random().nextInt(100) <= 20)) {
 	            this.block[x][y-1].setTile(new Tile(Shrub,x,y));
 	           }
 	         }
 	       }
        
// BiomeNum =2;
 for (int x = 0; x < this.block.length; x++) {
	 
	
 	         for (int y = 0; y < this.block[0].length; y++) {
 	           if ((this.block[x][y].id == TopBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
 	  		             (new Random().nextInt(100) <= 4)) {
 	            this.block[x][y-1].setTile(new Tile(BiomeFlower,x,y));
 	           }
 	         }
 	       }
        
 //BiomeNum =2;
 for (int x = 0; x < this.block.length; x++) {

     	        for (int y = 0; y < this.block[0].length; y++) {
     	          if ((x == 0) || (y == 0) || (x == this.block.length - 1) ) {
     	          this.block[x][y].setTile(new Tile(EpicarnoTiles.bedrock,x,y));
     	         }
     	          else if((y == this.block[0].length - 1)){
     	        	 this.block[x][y].setTile(new Tile(EpicarnoTiles.RealBR,x,y));
     	        	 Random rand = new Random();
     	        	this.block[x][y-(rand.nextInt(3)+1)].setTile(new Tile(EpicarnoTiles.RealBR,x,y));
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
        	 
        	 //Change to transpancey check later
        	 if(prop.isSeethrough(EpicarnoComp.epicarnol.GetTile(x, y))){
           this.block[x][y].render(g);
        	 }

           //  g.setColor(new Color(255, 255, 255, 60));
          //g.fillRect(this.block[x][y].x - camX, this.block[x][y].y - camY, this.block[x][y].width, this.block[x][y].height);
        	   //}
           
         }
       }
     }
   }
 }

