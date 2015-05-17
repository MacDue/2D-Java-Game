package net.epicarno.client.world;
 
 import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.TileProperties;
import net.epicarno.client.mobs.Mob;
import net.epicarno.client.mobs.Zombie;
import net.epicarno.client.player.InvItems;
import net.epicarno.client.player.Inventory;
 
 public class EpicarnoL
 {
   public static int worldH = 50;
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
  public int[] BiomeOrder = new int[200];
   public static boolean placed = false;
   public TileProperties prop = new TileProperties();
public int ly = 0;
   public GameBlocksEpicarno[][] block = new GameBlocksEpicarno[worldW][worldH];
   
   public EpicarnoL(int BiomeID)
   {
     for (int x = 0; x < this.block.length; x++) {
       for (int y = 0; y < this.block[0].length; y++) {
         this.block[x][y] = new GameBlocksEpicarno(new Rectangle(x * EpicarnoTiles.tileSize, y * EpicarnoTiles.tileSize, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize), EpicarnoTiles.air);
       }
     }
     gernerateELevel(BiomeID);
   }
   
   public void spawnMob(Mob mob)
   {
     EpicarnoComp.mob.add(mob);
   }
   
   public int SwitchBiome(int startID){
	   int BiomeID = startID;
	   Random rand = new Random();
	   int get = rand.nextInt(6)+1;
	   if(get < 3){
		   BiomeID = 1;
	   }else{
		   BiomeID = 3;
	   }
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
	  
	   int BiomeNum = 0;
 for (int x = 0; x < this.block.length; x++){
	// System.out.println("TEST"+EpicarnoTiles.wood);
	 if((x % 50) == 0){
		 BiomeOrder[BiomeNum] = SwitchBiome(BiomeID);
		 BiomeNum = BiomeNum +1;
	//	 System.out.println("NO"+BiomeNum);
	 }
	 for  (int y = 0; y < this.block[0].length; y++){
	
		 //SwitchBiome(BiomeID);
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
		 //Here
		 
		 
		        }
		      }
 
 //Trees
 BiomeNum =0;
 for (int x = 0; x < this.block.length; x++) {
	 
	 if((x % 50) == 0){
		// BiomeOrder[BiomeNum] = SwitchBiome(BiomeID);
		 SetBiome(BiomeOrder[BiomeNum]);
		 BiomeNum = BiomeNum +1;
	//	 System.out.println("NO"+BiomeNum);
	 }
     for (int y = 0; y < this.block[0].length; y++) {
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
 //EndTrees
   
 BiomeNum =0;
 for (int x = 0; x < this.block.length; x++) {
	 
	 if((x % 50) == 0){
		// BiomeOrder[BiomeNum] = SwitchBiome(BiomeID);
		 SetBiome(BiomeOrder[BiomeNum]);
		 BiomeNum = BiomeNum +1;
	//	 System.out.println("NO"+BiomeNum);
	 }
 	         for (int y = 0; y < this.block[0].length; y++) {
 	           if ((this.block[x][y].id == BottomBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air)) {
 	             this.block[x][y].id = TopBlock;
 	           }
 	         }
 	       }
   
 BiomeNum =0;
 for (int x = 0; x < this.block.length; x++) {
	 
	 if((x % 50) == 0){
		// BiomeOrder[BiomeNum] = SwitchBiome(BiomeID);
		 SetBiome(BiomeOrder[BiomeNum]);
		 BiomeNum = BiomeNum +1;
	//	 System.out.println("NO"+BiomeNum);
	 }
 	         for (int y = 0; y < this.block[0].length; y++) {
 	           if ((this.block[x][y].id == TopBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
 	  		             (new Random().nextInt(100) <= 20)) {
 	            this.block[x][y-1].id = Shrub;
 	           }
 	         }
 	       }
        
 BiomeNum =0;
 for (int x = 0; x < this.block.length; x++) {
	 
	 if((x % 50) == 0){
		// BiomeOrder[BiomeNum] = SwitchBiome(BiomeID);
		 SetBiome(BiomeOrder[BiomeNum]);
		 BiomeNum = BiomeNum +1;
	//	 System.out.println("NO"+BiomeNum);
	 }
 	         for (int y = 0; y < this.block[0].length; y++) {
 	           if ((this.block[x][y].id == TopBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
 	  		             (new Random().nextInt(100) <= 4)) {
 	            this.block[x][y-1].id = BiomeFlower;
 	           }
 	         }
 	       }
        
 BiomeNum =0;
 for (int x = 0; x < this.block.length; x++) {
	 
	 if((x % 50) == 0){
		// BiomeOrder[BiomeNum] = SwitchBiome(BiomeID);
		 SetBiome(BiomeOrder[BiomeNum]);
		 BiomeNum = BiomeNum +1;
	//	 System.out.println("NO"+BiomeNum);
	 }
     	        for (int y = 0; y < this.block[0].length; y++) {
     	          if ((x == 0) || (y == 0) || (x == this.block.length - 1) ) {
     	          this.block[x][y].id = EpicarnoTiles.bedrock;
     	         }
     	          else if((y == this.block[0].length - 1)){
     	        	 this.block[x][y].id = EpicarnoTiles.RealBR;
     	        	 Random rand = new Random();
     	        	this.block[x][y-(rand.nextInt(3)+1)].id = EpicarnoTiles.RealBR;
     	          }
     	     }
     	     }

       
		    
	 }
	 
 
 
   
   
   public void building(int camX, int camY, int renW, int renH)
   {
	  //boolean placed = false;
     if (((EpicarnoComp.isLeftyDown) || (EpicarnoComp.isRightyDown)) && placed == false) {
       for (int x = camX / EpicarnoTiles.tileSize; x < camX / EpicarnoTiles.tileSize + renW; x++) {
         for (int y = camY / EpicarnoTiles.tileSize; y < camY / EpicarnoTiles.tileSize + renH; y++) {
           if ((x >= 0) && (y >= 0) && (x < worldW) && (y < worldH) && 
             (this.block[x][y].contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize + (int)EpicarnoComp.sX, EpicarnoComp.mse.y / EpicarnoComp.pixelSize + (int)EpicarnoComp.sY))))
           {
             int[] sid = Inventory.invBar[Inventory.soming].id;
             if (EpicarnoComp.isLeftyDown)
             {
               if (prop.isUnbreakable(this.block[x][y].id) ) {
                 break;
               }
               if (this.block[x][y].id == EpicarnoTiles.BackGroundStone) {
                   break;
                 }
               if (this.block[x][y].id == EpicarnoTiles.BackGroundDirt) {
                   break;
                 }
               if (this.block[x][(y - 1)].id != EpicarnoTiles.wildgrass) {
                   
               }else{
               this.block[x][(y - 1)].id = EpicarnoTiles.air;
               }
               
               if (this.block[x][(y - 1)].id != EpicarnoTiles.rose) {
                   
               }else{
               this.block[x][(y - 1)].id = EpicarnoTiles.air;
               }
               this.block[x][y].id = EpicarnoTiles.air;
               placed = true;
               /*
               if((this.block[x][y].id != EpicarnoTiles.stone) && (this.block[x][y].id != EpicarnoTiles.wizningmud ) && (this.block[x][y].id != EpicarnoTiles.Grass )){
               this.block[x][y].id = EpicarnoTiles.air;
               }else{
            	   if(this.block[x][y].id == EpicarnoTiles.stone) this.block[x][y].id = EpicarnoTiles.BackGroundStone;
                  // break;
  
               }
               
               if((this.block[x][y].id != EpicarnoTiles.wizningmud ) && (this.block[x][y].id != EpicarnoTiles.Grass )){
                   this.block[x][y].id = EpicarnoTiles.air;
                   }else{
                       this.block[x][y].id = EpicarnoTiles.BackGroundStone;
                       break;
      
                   }
                   */
               break;
             }
if(sid == EpicarnoTiles.Player){
	EpicarnoComp.sp = true;
	InvItems.invItems[Inventory.soming].id = EpicarnoTiles.air;
	break;
	 
	
}
if(sid == EpicarnoTiles.Zombie){
	//EpicarnoComp.sp = true;
	//InvItems.invItems[Inventory.soming].id = EpicarnoTiles.air;
	        spawnMob(new Zombie(new Random().nextInt((EpicarnoL.worldW - 2) * EpicarnoTiles.tileSize) + EpicarnoTiles.tileSize + 30, 50, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2, EpicarnoTiles.Zombie));
	        break;

	
}
if(sid == EpicarnoTiles.Skeleton){
	//EpicarnoComp.sp = true;
	//InvItems.invItems[Inventory.soming].id = EpicarnoTiles.air;
	        spawnMob(new Zombie(new Random().nextInt((EpicarnoL.worldW - 2) * EpicarnoTiles.tileSize) + EpicarnoTiles.tileSize + 30, 50, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2, EpicarnoTiles.Skeleton));
	        break;

	
}
             if ((!EpicarnoComp.isRightyDown) || 
              ( (this.block[x][y].id != EpicarnoTiles.air) &&  (this.block[x][y].id != EpicarnoTiles.rose) && (this.block[x][y].id != EpicarnoTiles.wildgrass)) || (
               (sid != EpicarnoTiles.wizningmud) && (sid != EpicarnoTiles.Grass) && (sid != EpicarnoTiles.seasand) && (sid != EpicarnoTiles.wood) && (sid != EpicarnoTiles.planks) && (sid != EpicarnoTiles.bling) && (sid != EpicarnoTiles.bricks) && (sid != EpicarnoTiles.ob) && (sid != EpicarnoTiles.stone) && (sid != EpicarnoTiles.Glass) && (sid != EpicarnoTiles.leaf) ) && (sid != EpicarnoTiles.shittybricks) ) {
               break;
             }
if( ((this.block[x][(y + 1)].id  != EpicarnoTiles.air) || (this.block[x][(y - 1)].id  != EpicarnoTiles.air) || (this.block[(x + 1)][(y)].id  != EpicarnoTiles.air) || (this.block[(x - 1)][(y)].id  != EpicarnoTiles.air)) && ((this.block[x][(y + 1)].id  != EpicarnoTiles.bedrock) || (this.block[x][(y - 1)].id  != EpicarnoTiles.bedrock) || (this.block[(x + 1)][(y)].id  != EpicarnoTiles.bedrock) || (this.block[(x - 1)][(y)].id  != EpicarnoTiles.bedrock))){
             this.block[x][y].id = sid;
             placed = true;

}
             if (this.block[x][(y + 1)].id != EpicarnoTiles.Grass) {
              
             }else{
             this.block[x][(y + 1)].id = EpicarnoTiles.wizningmud;
             }
             
       
             
 
 
 
             break;
           }
         }
       }
       
     }else{
    	// placed = false;
     }
   }
   
   public int[] GetTile(int x,int y){
	   try{
	return this.block[x][y].id;
	   }
	   catch(ArrayIndexOutOfBoundsException exception) {
System.out.println("[WARN] Block out of bounds");
return EpicarnoTiles.air;
		}
	   
   }
   
   public void onTick() {//Called every "Tick"
	    long thisTime = System.currentTimeMillis();

	    if ((thisTime - lastTime) >= PERIOD) {
	        lastTime = thisTime;

	        placed = false;
	    }
	}
   public void tick(int camX, int camY, int renW, int renH)
   {
     if (!Inventory.isOpen) {
    
    
  	 if(((EpicarnoComp.isLeftyDown) || (EpicarnoComp.isRightyDown) ) ){
	//	 placed = false;
  	   building(camX, camY, renW, renH);
	 }else if( (!EpicarnoComp.isLeftyDown) && (!EpicarnoComp.isRightyDown)){
		// placed = false;
	 }
  	 
  	onTick();
     }
       //break;
     
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
        	//   if(placed == false){
             g.setColor(new Color(255, 255, 255, 60));
          g.fillRect(this.block[x][y].x - camX, this.block[x][y].y - camY, this.block[x][y].width, this.block[x][y].height);
        	   //}
           }
         }
       }
     }
   }
 }

