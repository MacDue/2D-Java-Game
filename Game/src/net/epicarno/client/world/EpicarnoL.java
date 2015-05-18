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
import net.epicarno.client.mobs.FallingTile;
import net.epicarno.client.mobs.Mob;
import net.epicarno.client.mobs.Zombie;
import net.epicarno.client.player.InvItems;
import net.epicarno.client.player.Inventory;
 
 public class EpicarnoL
 {
   public static int worldH = 50;
   public static int worldW = 10000;
  public Tile TopBlock;
  public Tile BottomBlock;
  public  Tile Stone;
  public Tile BiomeFlower;
  public Tile Shrub;
  public Tile Wood;
  public Tile Leaves;
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
         this.block[x][y] = new GameBlocksEpicarno(new Rectangle(x * EpicarnoTiles.tileSize, y * EpicarnoTiles.tileSize, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize), new Tile(EpicarnoTiles.air));
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
		                if (this.block[(x - 1)][(y - 1)].id == BottomBlock.id) {
		                this.block[x][y].setTile(BottomBlock); 
		                }
		              }
		              catch (Exception localException) {}
		            }
		            if (new Random().nextInt(100) > 20) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == Stone.id) {
		                this.block[x][y].setTile(Stone);
		                }
		              }
		              catch (Exception localException) {}
		            }
		            if (new Random().nextInt(100) > 30) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == BottomBlock.id) {
		                 this.block[x][y].setTile(BottomBlock);
		                }
		              }
		              catch (Exception localException1) {}
		            }
		            if (new Random().nextInt(100) > 30) {
		              try
		              {
		                if (this.block[(x - 1)][(y - 1)].id == Stone.id) {
		                 this.block[x][y].setTile(Stone) ;
		                }
		              }
		              catch (Exception localException1) {}
		            }
		            try
		            {
		 	             if (this.block[x][(y - 1)].id == Stone.id) {
		 		              this.block[x][y].setTile(Stone);
		 		             }
		              if (this.block[x][(y - 1)].id == BottomBlock.id) {
		               this.block[x][y].setTile(BottomBlock);
		              }
		            }
		            catch (Exception localException2) {}
	//	 System.out.println(y);
		            if (new Random().nextInt(100) < 45) {
		 	                        if(y > 15){
		              this.block[x][y].setTile(Stone) ;
		              //System.out.println(Stone.id);
		 	                        }else{
		 	                        	  this.block[x][y].setTile(BottomBlock);
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
         if ((this.block[x][(y + 1)].id == BottomBlock.id) && (this.block[x][y].id == EpicarnoTiles.air) && 
           (new Random().nextInt(100) <= 7)) {
           for (int i = 0; i < new Random().nextInt(5) + 4; i++) {
             this.block[x][(y - i)].setTile(Wood);
ly = y - i;
           }

for (int in = 0; in < new Random().nextInt(5) + 4; in++) {
//int ly = y - i;
           for (int i = 0; i < new Random().nextInt(5) + 2; i++) {
        	   if( this.block[x - i][(ly-in)].id == EpicarnoTiles.air){
             this.block[x - i][(ly-in)].setTile(Leaves);
        	   }
           }

           for (int i = 0; i < new Random().nextInt(5) + 2; i++) {
        	   if(  this.block[x + i][(ly-in)].id == EpicarnoTiles.air){
             this.block[x + i][(ly-in)].setTile(Leaves);
        	   }
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
 	           if ((this.block[x][y].id == BottomBlock.id) && (this.block[x][(y - 1)].id == EpicarnoTiles.air)) {
 	             this.block[x][y].setTile(TopBlock); 
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
 	           if ((this.block[x][y].id == TopBlock.id) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
 	  		             (new Random().nextInt(100) <= 20)) {
 	            this.block[x][y-1].setTile(Shrub);
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
 	           if ((this.block[x][y].id == TopBlock.id) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
 	  		             (new Random().nextInt(100) <= 4)) {
 	            this.block[x][y-1].setTile(BiomeFlower);
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
     	          this.block[x][y].setTile(new Tile(EpicarnoTiles.bedrock));
     	         }
     	          else if((y == this.block[0].length - 1)){
     	        	 this.block[x][y].setTile(new Tile(EpicarnoTiles.RealBR));
     	        	 Random rand = new Random();
     	        	this.block[x][y-(rand.nextInt(3)+1)].setTile(new Tile(EpicarnoTiles.RealBR));
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
               int I = 1;
               while(prop.isFallingTile(this.block[x][(y - I)].id)){
   if (prop.isFallingTile(this.block[x][(y - I)].id)) {
	            int[] FallingID =  this.block[x][(y-I)].id;
                   this.block[x][(y-I)].id = EpicarnoTiles.air;
       	        spawnMob(new FallingTile(x*16, (y-I)*16, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize , FallingID));

               }
   I ++;
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
if((sid == EpicarnoTiles.Zombie) && (!placed)){
	//EpicarnoComp.sp = true;
	//InvItems.invItems[Inventory.soming].id = EpicarnoTiles.air;
    spawnMob(new FallingTile((int) EpicarnoComp.player.x, 50, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize , EpicarnoTiles.Glass));
	        placed = true;
    break;

	
}
if((sid == EpicarnoTiles.Skeleton)  && (!placed)){
	//EpicarnoComp.sp = true;
	//InvItems.invItems[Inventory.soming].id = EpicarnoTiles.air;
	        spawnMob(new FallingTile((int) EpicarnoComp.player.x, 50, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize , EpicarnoTiles.seasand));
	        placed = true;
	        break;

	
}
             if ((!EpicarnoComp.isRightyDown) || 
              ( (!prop.isReplaceable(this.block[x][y].id))))  {
            	 
            	 break;
             }
         //    }
if( ((this.block[x][(y + 1)].id  != EpicarnoTiles.air) || (this.block[x][(y - 1)].id  != EpicarnoTiles.air) || (this.block[(x + 1)][(y)].id  != EpicarnoTiles.air) || (this.block[(x - 1)][(y)].id  != EpicarnoTiles.air)) && ((this.block[x][(y + 1)].id  != EpicarnoTiles.bedrock) || (this.block[x][(y - 1)].id  != EpicarnoTiles.bedrock) || (this.block[(x + 1)][(y)].id  != EpicarnoTiles.bedrock) || (this.block[(x - 1)][(y)].id  != EpicarnoTiles.bedrock))){
             this.block[x][y].setTile(new Tile(sid));
             
             if( prop.isFallingTile(this.block[x][y].id)){
            	 int[] FallingID =  this.block[x][y].id;
            	 this.block[x][y].id = EpicarnoTiles.air;
        	        spawnMob(new FallingTile(x*16, (y)*16, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize , FallingID));

             }
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
   
   
   public void SetTile(int x,int y, int[] Tile){
	   //try{
	
	
	   try{
		   this.block[x][y].setTile(new Tile(Tile)) ;
		   if(this.block[x][(y+1)].id ==EpicarnoTiles.Grass ){
			   this.block[x][(y+1)].setTile(new Tile(EpicarnoTiles.wizningmud));
		   }
	   }
	   catch(ArrayIndexOutOfBoundsException exception) {
System.out.println("[WARN] Block out of bounds");
//return EpicarnoTiles.air;
		}
	   //}

	   
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
	 //  block[x][y].t
     if ((!Inventory.isOpen) &&  (!EpicarnoComp.typing)) {
    
    
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

