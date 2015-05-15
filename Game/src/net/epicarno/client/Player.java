/*   1:    */ package net.epicarno.client;
/*   4:    */ import java.awt.Graphics;
/*   5:    */ import java.awt.Point;
/*   6:    */ 
/*   7:    */ public class Player
/*   8:    */   extends DobbleRec
/*   9:    */ {
/*  10:  6 */   public static double fallingspeed = 1.5D;
/*  11:  7 */   public double movingSpeed = 0.5D;
/*  12:  8 */   public double HipdieHopSpeed = 1.4D;
/*  13: 10 */   public int ScipHopHipdieHop = 50;
/*  14: 10 */   public int HipdieHopCount = 0;
/*  15: 11 */   public int anima = 0;
/*  16: 12 */   public int animaFrame = 0;
/*  17: 12 */   public int animaTime = 60;
/*  18: 14 */   public boolean isHipideHopping = false;
/*  19:    */   
/*  20:    */   public Player(int width, int height)
/*  21:    */   {
/*  22: 17 */     setBounds(EpicarnoComp.pixel.width / 2 - width / 2, EpicarnoComp.pixel.height / 2 - height / 2, width, height);

/*  23:    */   }
/*  24:    */   
public void redo(int width, int height){
	 setBounds(EpicarnoComp.pixel.width / 2 - width / 2, EpicarnoComp.pixel.height / 2 - height / 2, width, height);
	
}


/*  25:    */   public void tick()
/*  26:    */   {
	
/*  27: 21 */     if ((!this.isHipideHopping)&& (!isCollidingWithBlock(new Point((int)this.x + 2, (int)(this.y + this.height)), new Point((int)(this.x + this.width - 2.0D), (int)(this.y + this.height)))))
/*  28:    */     {
/*  29: 22 */       this.y += this.fallingspeed;
/*  30: 23 */      EpicarnoComp.sY += this.fallingspeed;
/*  31:    */     }
/*  32: 25 */     else if ((EpicarnoComp.isHipideHopping) && (!Inventory.isOpen))
/*  33:    */     {
/*  34: 26 */       this.isHipideHopping = true;
/*  35:    */     }
/*  36: 30 */     if ((EpicarnoComp.isMoving) && (!Inventory.isOpen))
/*  37:    */     {
/*  38: 31 */       boolean canMove = false;
/*  39: 33 */       if (EpicarnoComp.dir == this.movingSpeed) {
/*  40: 35 */         canMove = isCollidingWithBlock(new Point((int)(this.x + this.width), (int)this.y), new Point((int)(this.x + this.width), (int)(this.y + (this.height - 2.0D))));
/*  41: 38 */       } else if (EpicarnoComp.dir == -this.movingSpeed) {
/*  42: 41 */         canMove = isCollidingWithBlock(new Point((int)this.x - 1, (int)this.y), new Point((int)this.x - 1, (int)(this.y + (this.height - 2.0D))));
/*  43:    */       }
/*  44: 46 */       if (this.animaFrame >= this.animaTime)
/*  45:    */       {
/*  46: 47 */         if (this.anima > 1) {
/*  47: 48 */           this.anima = 1;
/*  48:    */         } else {
/*  49: 51 */           this.anima += 1;
/*  50:    */         }
/*  51: 54 */         this.animaFrame = 0;
/*  52:    */       }
/*  53:    */       else
/*  54:    */       {
/*  55: 57 */         this.animaFrame += 1;
/*  56:    */       }
/*  57: 60 */       if (!canMove)
/*  58:    */       {
/*  59: 62 */         this.x += EpicarnoComp.dir;
//EpicarnoComp.sX +100;
/*  60: 63 */         EpicarnoComp.sX += EpicarnoComp.dir ;
/*  61:    */       }
/*  62:    */     }
/*  63:    */     else
/*  64:    */     {
/*  65: 66 */       this.anima = 0;
/*  66:    */     }
/*  67: 69 */     if (this.isHipideHopping) {
/*  68: 70 */       if (!isCollidingWithBlock(new Point((int)(this.x + 2.0D), (int)this.y), new Point((int)(this.x + this.width - 2.0D), (int)this.y)))
/*  69:    */       {
/*  70: 71 */         if (this.HipdieHopCount >= this.ScipHopHipdieHop)
/*  71:    */         {
/*  72: 74 */           this.isHipideHopping = false;
/*  73:    */           
/*  74: 76 */           this.HipdieHopCount = 0;
/*  75:    */         }
/*  76:    */         else
/*  77:    */         {
/*  78: 78 */           this.y -= this.HipdieHopSpeed;
/*  79: 79 */           EpicarnoComp.sY -= this.HipdieHopSpeed;
/*  80: 80 */           this.HipdieHopCount += 1;
/*  81:    */         }
/*  82:    */       }
/*  83:    */       else
/*  84:    */       {
/*  85: 83 */         this.isHipideHopping = false;
/*  86: 84 */         this.HipdieHopCount = 0;
/*  87:    */       }
/*  88:    */     }
/*  89:    */   }
/*  90:    */   
/*  91:    */   public boolean isCollidingWithBlock(Point pt1, Point pt2)
/*  92:    */   {
/*  93: 92 */     for (int x = (int)(this.x / EpicarnoTiles.tileSize); x < this.x / EpicarnoTiles.tileSize + 3.0D; x++) {
/*  94: 93 */       for (int y = (int)(this.y / EpicarnoTiles.tileSize); y < this.y / EpicarnoTiles.tileSize + 3.0D; y++) {
/*  95: 94 */         if ((x >= 0) && (y >= 0) && (x < EpicarnoComp.epicarnol.block.length) && (y < EpicarnoComp.epicarnol.block[0].length) && 
/*  96: 95 */           (EpicarnoComp.epicarnol.block[x][y].id != EpicarnoTiles.air) && (EpicarnoComp.epicarnol.block[x][y].id != EpicarnoTiles.leaf) &&  (EpicarnoComp.epicarnol.block[x][y].id != EpicarnoTiles.wildgrass) &&  (EpicarnoComp.epicarnol.block[x][y].id != EpicarnoTiles.rose)&& (
/*  97: 96 */           (EpicarnoComp.epicarnol.block[x][y].contains(pt1)) || (EpicarnoComp.epicarnol.block[x][y].contains(pt2)))) {
/*  98: 97 */           return true;
/*  99:    */         }
/* 100:    */       }
/* 101:    */     }
/* 102:105 */     return false;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void render(Graphics g)
/* 106:    */   {
	/* 123:123 */     if (EpicarnoComp.dir == this.movingSpeed) {
		/* 124:124 */       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, EpicarnoTiles.Player[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, EpicarnoTiles.Player[1] * EpicarnoTiles.tileSize, EpicarnoTiles.Player[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, EpicarnoTiles.Player[1] * EpicarnoTiles.tileSize + (int)this.height, null);
		/* 125:    */     } else {
		/* 126:126 */       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, EpicarnoTiles.Player[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, EpicarnoTiles.Player[1] * EpicarnoTiles.tileSize, EpicarnoTiles.Player[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, EpicarnoTiles.Player[1] * EpicarnoTiles.tileSize + (int)this.height, null);
		/* 127:    */     }
/* 112:    */   }
/* 113:    */
 }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.Player
 * JD-Core Version:    0.7.0.1
 */