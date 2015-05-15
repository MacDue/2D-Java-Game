/*   1:    */ package net.epicarno.client;
/*   2:    */ 
/*   3:    */ import java.awt.Graphics;
/*   4:    */ import java.awt.Point;
/*   5:    */ import java.util.Random;
/*   6:    */ 
/*   7:    */ public class Mob
/*   8:    */   extends DobbleRec
/*   9:    */ {
/*  10:    */   public int[] id;
/*  11:  9 */   public boolean isHipideHopping = false;
/*  12: 10 */   public boolean isMOOVING = false;
/*  13: 11 */   public boolean isFalling = false;
/*  14: 13 */   public double movementSpeed = 0.4D;
/*  15: 14 */   public double fallingspeed = 1.5D;
/*  16: 15 */   public double HipdieHopSpeed = 1.0D;
/*  17: 16 */   public double dir = this.movementSpeed;
/*  18: 17 */   public int ScipHopHipdieHop = 50;
/*  19: 17 */   public int HipdieHopCount = 0;
/*  20: 18 */   public int anima = 0;
/*  21: 19 */   public int animaFrame = 0;
/*  22: 19 */   public int animaTime = 30;
/*  23:    */   
/*  24:    */   public Mob(int x, int y, int width, int height, int[] id)
/*  25:    */   {
/*  26: 23 */     setBounds(x, y, width, height);
/*  27:    */     
/*  28: 25 */     this.id = id;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void tick()
/*  32:    */   {
/*  33: 30 */     if ((!this.isHipideHopping) && (!isCollidingWithBlock(new Point((int)this.x + 2, (int)(this.y + this.height)), new Point((int)(this.x + this.width - 2.0D), (int)(this.y + this.height)))))
/*  34:    */     {
/*  35: 31 */       this.y += this.fallingspeed;
/*  36: 32 */       this.isFalling = true;
/*  37:    */     }
/*  38:    */     else
/*  39:    */     {
/*  40: 34 */       this.isFalling = false;
/*  41: 36 */       if (new Random().nextInt(100) < 1)
/*  42:    */       {
/*  43: 37 */         this.isMOOVING = true;
/*  44: 39 */         if (new Random().nextInt(100) > 50) {
/*  45: 40 */           this.dir = (-this.movementSpeed);
/*  46:    */         } else {
/*  47: 42 */           this.dir = this.movementSpeed;
/*  48:    */         }
/*  49:    */       }
/*  50:    */     }
/*  51: 47 */     if (this.isMOOVING)
/*  52:    */     {
/*  53: 48 */       boolean canMove = false;
/*  54: 50 */       if (this.dir == this.movementSpeed) {
/*  55: 52 */         canMove = isCollidingWithBlock(new Point((int)(this.x + this.width), (int)this.y), new Point((int)(this.x + this.width), (int)(this.y + (this.height - 2.0D))));
/*  56: 53 */       } else if (this.dir == -this.movementSpeed) {
/*  57: 54 */         canMove = isCollidingWithBlock(new Point((int)this.x - 1, (int)this.y), new Point((int)this.x - 1, (int)(this.y + (this.height - 2.0D))));
/*  58:    */       }
/*  59: 56 */       if ((!canMove) && (!this.isFalling)) {
/*  60: 58 */         this.isHipideHopping = true;
/*  61:    */       }
/*  62: 60 */       if (this.animaFrame >= this.animaTime)
/*  63:    */       {
/*  64: 61 */         if (this.anima > 1) {
/*  65: 62 */           this.anima = 1;
/*  66:    */         } else {
/*  67: 65 */           this.anima += 1;
/*  68:    */         }
/*  69: 68 */         this.animaFrame = 0;
/*  70:    */       }
/*  71:    */       else
/*  72:    */       {
/*  73: 71 */         this.animaFrame += 1;
/*  74:    */       }
/*  75: 74 */       if (!canMove) {
/*  76: 76 */         this.x += this.dir;
/*  77:    */       }
/*  78:    */     }
/*  79:    */     else
/*  80:    */     {
/*  81: 79 */       this.anima = 0;
/*  82:    */     }
/*  83: 82 */     if (this.isHipideHopping) {
/*  84: 83 */       if (!isCollidingWithBlock(new Point((int)(this.x + 2.0D), (int)this.y), new Point((int)(this.x + this.width - 2.0D), (int)this.y)))
/*  85:    */       {
/*  86: 84 */         if (this.HipdieHopCount >= this.ScipHopHipdieHop)
/*  87:    */         {
/*  88: 87 */           this.isHipideHopping = false;
/*  89:    */           
/*  90: 89 */           this.HipdieHopCount = 0;
/*  91:    */         }
/*  92:    */         else
/*  93:    */         {
/*  94: 91 */           this.y -= this.HipdieHopSpeed;
/*  95:    */           
/*  96: 93 */           this.HipdieHopCount += 1;
/*  97:    */         }
/*  98:    */       }
/*  99:    */       else
/* 100:    */       {
/* 101: 96 */         this.isHipideHopping = false;
/* 102: 97 */         this.HipdieHopCount = 0;
/* 103:    */       }
/* 104:    */     }
/* 105:    */   }
/* 106:    */   
/* 107:    */   public boolean isCollidingWithBlock(Point pt1, Point pt2)
/* 108:    */   {
/* 109:105 */     for (int x = (int)(this.x / EpicarnoTiles.tileSize); x < this.x / EpicarnoTiles.tileSize + 3.0D; x++) {
/* 110:106 */       for (int y = (int)(this.y / EpicarnoTiles.tileSize); y < this.y / EpicarnoTiles.tileSize + 3.0D; y++) {
/* 111:107 */         if ((x >= 0) && (y >= 0) && (x < EpicarnoComp.epicarnol.block.length) && (y < EpicarnoComp.epicarnol.block[0].length) && 
/* 112:108 */           (EpicarnoComp.epicarnol.block[x][y].id != EpicarnoTiles.air) &&  (EpicarnoComp.epicarnol.block[x][y].id != EpicarnoTiles.leaf) &&  (EpicarnoComp.epicarnol.block[x][y].id != EpicarnoTiles.rose) &&  (EpicarnoComp.epicarnol.block[x][y].id != EpicarnoTiles.wildgrass)&&(
/* 113:109 */           (EpicarnoComp.epicarnol.block[x][y].contains(pt1)) || (EpicarnoComp.epicarnol.block[x][y].contains(pt2)))) {
/* 114:110 */           return true;
/* 115:    */         }
/* 116:    */       }
/* 117:    */     }
/* 118:119 */     return false;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void render(Graphics g)
/* 122:    */   {
/* 123:123 */     if (this.dir == this.movementSpeed) {
/* 124:124 */       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, this.id[1] * EpicarnoTiles.tileSize + (int)this.height, null);
/* 125:    */     } else {
/* 126:126 */       g.drawImage(EpicarnoTiles.GameTile, (int)this.x - (int)EpicarnoComp.sX, (int)this.y - (int)EpicarnoComp.sY, (int)(this.x + this.width) - (int)EpicarnoComp.sX, (int)(this.y + this.height) - (int)EpicarnoComp.sY, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima + (int)this.width, this.id[1] * EpicarnoTiles.tileSize, this.id[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize * this.anima, this.id[1] * EpicarnoTiles.tileSize + (int)this.height, null);
/* 127:    */     }
/* 128:    */   }
/* 129:    */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.Mob
 * JD-Core Version:    0.7.0.1
 */