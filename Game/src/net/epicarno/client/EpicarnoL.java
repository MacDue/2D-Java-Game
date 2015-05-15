package net.epicarno.client;
/*   2:    */ 
/*   3:    */ import java.awt.Color;
/*   4:    */ import java.awt.Graphics;
/*   5:    */ import java.awt.Point;
/*   6:    */ import java.awt.Rectangle;
/*   7:    */ import java.util.Random;
/*   8:    */ 
/*   9:    */ public class EpicarnoL
/*  10:    */ {
/*  11:  7 */   public static int worldH = 50;
/*  12:  7 */   public static int worldW = 50;
public int ly = 0;
/*  13:  8 */   public GameBlocksEpicarno[][] block = new GameBlocksEpicarno[worldW][worldH];
/*  14:    */   
/*  15:    */   public EpicarnoL(int BiomeID)
/*  16:    */   {
/*  17: 11 */     for (int x = 0; x < this.block.length; x++) {
/*  18: 12 */       for (int y = 0; y < this.block[0].length; y++) {
/*  19: 13 */         this.block[x][y] = new GameBlocksEpicarno(new Rectangle(x * EpicarnoTiles.tileSize, y * EpicarnoTiles.tileSize, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize), EpicarnoTiles.air);
/*  20:    */       }
/*  21:    */     }
/*  22: 17 */     gernerateELevel(BiomeID);
/*  23:    */   }
/*  24:    */   
/* 16:   */   public void spawnMob(Mob mob)
/* 17:   */   {
/* 18:14 */     EpicarnoComp.mob.add(mob);
/* 19:   */   }
/* 20:   */   
/*  25:    */   public void gernerateELevel(int BiomeID)
/*  26:    */   {
int[] TopBlock = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 1);
 int[] BottomBlock =EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 7);
 int[] Stone = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 6);
 int[] BiomeFlower = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 2);
 int[] Shrub = EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 3);
 int[] Wood =  EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 4);
 int[] Leaves =  EpicarnoComp.deco.GetBiomeDecorations(BiomeID, 5);
/*  27: 25 */     for (int y = 0; y < this.block.length; y++) {
/*  28: 26 */       for (int x = 0; x < this.block[0].length; x++) {
/*  29: 27 */         if (y > worldH / 4)
/*  30:    */         {
/*  31: 28 */           if (new Random().nextInt(100) > 20) {
/*  32:    */             try
/*  33:    */             {
/*  34: 31 */               if (this.block[(x - 1)][(y - 1)].id == BottomBlock) {
/*  35: 32 */               this.block[x][y].id = BottomBlock;
/*  36:    */               }
/*  37:    */             }
/*  38:    */             catch (Exception localException) {}
/*  39:    */           }
/*  31: 28 */           if (new Random().nextInt(100) > 20) {
/*  32:    */             try
/*  33:    */             {
/*  34: 31 */               if (this.block[(x - 1)][(y - 1)].id == Stone) {
/*  35: 32 */               this.block[x][y].id = Stone;
/*  36:    */               }
/*  37:    */             }
/*  38:    */             catch (Exception localException) {}
/*  39:    */           }
/*  40: 37 */           if (new Random().nextInt(100) > 30) {
/*  41:    */             try
/*  42:    */             {
/*  43: 39 */               if (this.block[(x - 1)][(y - 1)].id == BottomBlock) {
/*  44: 40 */                this.block[x][y].id = BottomBlock;
/*  45:    */               }
/*  46:    */             }
/*  47:    */             catch (Exception localException1) {}
/*  48:    */           }
/*  40: 37 */           if (new Random().nextInt(100) > 30) {
/*  41:    */             try
/*  42:    */             {
/*  43: 39 */               if (this.block[(x - 1)][(y - 1)].id == Stone) {
/*  44: 40 */                this.block[x][y].id = Stone;
/*  45:    */               }
/*  46:    */             }
/*  47:    */             catch (Exception localException1) {}
/*  48:    */           }
/*  49:    */           try
/*  50:    */           {
	/*  51: 48 */             if (this.block[x][(y - 1)].id == Stone) {
		/*  52: 49 */              this.block[x][y].id = Stone;
		/*  53:    */             }
/*  51: 48 */             if (this.block[x][(y - 1)].id == BottomBlock) {
/*  52: 49 */              this.block[x][y].id = BottomBlock;
/*  53:    */             }
/*  54:    */           }
/*  55:    */           catch (Exception localException2) {}
System.out.println(y);
/*  56: 54 */           if (new Random().nextInt(100) < 45) {
	                        if(y > 15){
/*  57: 55 */             this.block[x][y].id = Stone;
	                        }else{
	                        	  this.block[x][y].id = BottomBlock;
	                        }
/*  58:    */           }
/*  59:    */         }
/*  60:    */       }
/*  61:    */     }
/*  62: 62 */     for (int y = 0; y < this.block.length; y++) {
/*  63: 63 */       for (int x = 0; x < this.block[0].length; x++) {
/*  64:    */         try
/*  65:    */         {
/*  66: 66 */           if ((this.block[x][(y + 1)].id == BottomBlock) && (this.block[x][y].id == EpicarnoTiles.air) && 
/*  67: 67 */             (new Random().nextInt(100) <= 7)) {
/*  68: 68 */             for (int i = 0; i < new Random().nextInt(5) + 4; i++) {
/*  69: 69 */               this.block[x][(y - i)].id = Wood;
ly = y - i;
/*  70:    */             }

for (int in = 0; in < new Random().nextInt(5) + 4; in++) {
//int ly = y - i;
/*  68: 68 */             for (int i = 0; i < new Random().nextInt(5) + 2; i++) {
/*  69: 69 */               this.block[x - i][(ly-in)].id = Leaves;
/*  70:    */             }

/*  68: 68 */             for (int i = 0; i < new Random().nextInt(5) + 2; i++) {
/*  69: 69 */               this.block[x + i][(ly-in)].id = Leaves;
/*  70:    */             }

}
                         
/*  71:    */           }
/*  72:    */         }
/*  73:    */         catch (Exception localException3) {}
/*  74:    */       }


/*  75:    */     }
/*  76: 80 */     for (int y = 0; y < this.block.length; y++) {
/*  77: 81 */       for (int x = 0; x < this.block[0].length; x++) {
/*  78: 82 */         if ((this.block[x][y].id == BottomBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air)) {
/*  79: 83 */           this.block[x][y].id = TopBlock;
/*  80:    */         }
/*  81:    */       }
/*  82:    */     }
/*  76: 80 */     for (int y = 0; y < this.block.length; y++) {
/*  77: 81 */       for (int x = 0; x < this.block[0].length; x++) {
/*  78: 82 */         if ((this.block[x][y].id == TopBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
		/*  67: 67 */             (new Random().nextInt(100) <= 20)) {
/*  79: 83 */          this.block[x][y-1].id = Shrub;
/*  80:    */         }
/*  81:    */       }
/*  82:    */     }
/*  76: 80 */     for (int y = 0; y < this.block.length; y++) {
/*  77: 81 */       for (int x = 0; x < this.block[0].length; x++) {
/*  78: 82 */         if ((this.block[x][y].id == TopBlock) && (this.block[x][(y - 1)].id == EpicarnoTiles.air) && 
		/*  67: 67 */             (new Random().nextInt(100) <= 4)) {
/*  79: 83 */          this.block[x][y-1].id = BiomeFlower;
/*  80:    */         }
/*  81:    */       }
/*  82:    */     }
/*  83: 89 */     for (int y = 0; y < this.block.length; y++) {
/*  84: 90 */       for (int x = 0; x < this.block[0].length; x++) {
	
	// if (this.block[x][(y - 1)].id == BottomBlock) {
//	this.block[x][y].lightLevel = 16;
////	}else{
		//.block[x][y].lightLevel = 16;
	//}
/*  85: 91 */         if ((x == 0) || (y == 0) || (x == this.block[0].length - 1) || (y == this.block.length - 1)) {
/*  86: 92 */           this.block[x][y].id = EpicarnoTiles.bedrock;
/*  87:    */         }
/*  88:    */       }
/*  89:    */     }
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void building(int camX, int camY, int renW, int renH)
/*  93:    */   {
/*  94:102 */     if ((EpicarnoComp.isLeftyDown) || (EpicarnoComp.isRightyDown)) {
/*  95:103 */       for (int x = camX / EpicarnoTiles.tileSize; x < camX / EpicarnoTiles.tileSize + renW; x++) {
/*  96:104 */         for (int y = camY / EpicarnoTiles.tileSize; y < camY / EpicarnoTiles.tileSize + renH; y++) {
/*  97:105 */           if ((x >= 0) && (y >= 0) && (x < worldW) && (y < worldH) && 
/*  98:106 */             (this.block[x][y].contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize + (int)EpicarnoComp.sX, EpicarnoComp.mse.y / EpicarnoComp.pixelSize + (int)EpicarnoComp.sY))))
/*  99:    */           {
/* 100:107 */             int[] sid = Inventory.invBar[Inventory.soming].id;
/* 101:109 */             if (EpicarnoComp.isLeftyDown)
/* 102:    */             {
/* 103:110 */               if (this.block[x][y].id == EpicarnoTiles.bedrock) {
/* 104:    */                 break;
/* 105:    */               }
/* 106:111 */               this.block[x][y].id = EpicarnoTiles.air;
/* 107:    */               
/* 108:113 */               break;
/* 109:    */             }
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
/* 110:113 */             if ((!EpicarnoComp.isRightyDown) || 
/* 111:114 */               (this.block[x][y].id != EpicarnoTiles.air) || (
/* 112:115 */               (sid != EpicarnoTiles.wizningmud) && (sid != EpicarnoTiles.Grass) && (sid != EpicarnoTiles.seasand) && (sid != EpicarnoTiles.wood) && (sid != EpicarnoTiles.planks) && (sid != EpicarnoTiles.bling) && (sid != EpicarnoTiles.bricks) && (sid != EpicarnoTiles.ob) && (sid != EpicarnoTiles.stone) && (sid != EpicarnoTiles.Glass) && (sid != EpicarnoTiles.leaf) ) && (sid != EpicarnoTiles.shittybricks) ) {
/* 113:    */               break;
/* 114:    */             }
if( ((this.block[x][(y + 1)].id  != EpicarnoTiles.air) || (this.block[x][(y - 1)].id  != EpicarnoTiles.air) || (this.block[(x + 1)][(y)].id  != EpicarnoTiles.air) || (this.block[(x - 1)][(y)].id  != EpicarnoTiles.air)) && ((this.block[x][(y + 1)].id  != EpicarnoTiles.bedrock) || (this.block[x][(y - 1)].id  != EpicarnoTiles.bedrock) || (this.block[(x + 1)][(y)].id  != EpicarnoTiles.bedrock) || (this.block[(x - 1)][(y)].id  != EpicarnoTiles.bedrock))){
/* 115:116 */             this.block[x][y].id = sid;
}
/* 116:118 */             if (this.block[x][(y + 1)].id != EpicarnoTiles.Grass) {
/* 117:    */               break;
/* 118:    */             }
/* 119:119 */             this.block[x][(y + 1)].id = EpicarnoTiles.wizningmud;
/* 120:    */             
/* 121:    */ 
/* 122:    */ 
/* 123:    */ 
/* 124:124 */             break;
/* 125:    */           }
/* 126:    */         }
/* 127:    */       }
/* 128:    */     }
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void tick(int camX, int camY, int renW, int renH)
/* 132:    */   {
/* 133:133 */     if (!Inventory.isOpen) {
/* 134:135 */       building(camX, camY, renW, renH);
/* 135:    */     }
/* 136:    */   }
/* 137:    */   
/* 138:    */   public   void render(Graphics g, int camX, int camY, int renW, int renH)
/* 139:    */   {
/* 140:139 */     for (int x = camX / EpicarnoTiles.tileSize; x < camX / EpicarnoTiles.tileSize + renW; x++) {
/* 141:140 */       for (int y = camY / EpicarnoTiles.tileSize; y < camY / EpicarnoTiles.tileSize + renH; y++) {
/* 142:141 */         if ((x >= 0) && (y >= 0) && (x < worldW) && (y < worldH))
/* 143:    */         {
/* 144:142 */           this.block[x][y].render(g);
/* 145:144 */           if ((this.block[x][y].id != EpicarnoTiles.air) && (this.block[x][y].id != EpicarnoTiles.bedrock) && (!Inventory.isOpen) && 
/* 146:145 */             (this.block[x][y].contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize + (int)EpicarnoComp.sX, EpicarnoComp.mse.y / EpicarnoComp.pixelSize + (int)EpicarnoComp.sY))))
/* 147:    */           {
/* 148:146 */             g.setColor(new Color(255, 255, 255, 60));
/* 149:147 */          g.fillRect(this.block[x][y].x - camX, this.block[x][y].y - camY, this.block[x][y].width, this.block[x][y].height);
/* 150:    */           }
/* 151:    */         }
/* 152:    */       }
/* 153:    */     }
/* 154:    */   }
/* 155:    */ }

