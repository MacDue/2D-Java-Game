/*   1:    */ package net.epicarno.client;
/*   2:    */ 
/*   3:    */ import java.awt.Dimension;
/*   4:    */ import java.awt.Graphics;
/*   5:    */ import java.awt.Point;
/*   6:    */ import java.awt.Rectangle;
/*   7:    */ import java.awt.event.MouseEvent;
/*   8:    */ 
/*   9:    */ public class Inventory
/*  10:    */ {
/*  11:  7 */   public static Cell[] invBar = new Cell[EpicarnoTiles.invLength];
/*  12:  8 */   public static Cell[] invBag = new Cell[EpicarnoTiles.invLength * EpicarnoTiles.invHeight];
/*  13: 10 */   public static boolean isOpen = false;
/*  14: 11 */   public static boolean isHolding = false;
/*  15: 13 */   public static int soming = 0;
/*  16: 14 */   public static int[] holdingID = EpicarnoTiles.air;
/*  17:    */   
/*  18:    */   public Inventory()
/*  19:    */   {

	/*  20: 18 */     for (int i = 0; i < invBar.length; i++) {
		/*  21: 19 */       invBar[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + i * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19- (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
		/*  22:    */     }
		/*  23: 22 */     int x = 0;int y = 0;
		/*  24: 23 */     for (int i = 0; i < invBag.length; i++)
		/*  25:    */     {
		/*  26: 26 */       invBag[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + x * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19 - (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace) - EpicarnoTiles.invHeight * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace) + y * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
		/*  27: 27 */       x++;
		/*  28: 28 */       if (x == EpicarnoTiles.invLength)
		/*  29:    */       {
		/*  30: 29 */         x = 0;
		/*  31: 30 */         y++;
		/*  32:    */       }
		/*  33:    */     }

/*  44:    */   }
/*  45:    */   






	


/*  46:    */   public static void click(MouseEvent e)
/*  47:    */   {
/*  48: 48 */     if ((e.getButton() == 1) && 
/*  49: 49 */       (isOpen))
/*  50:    */     {
/*  51: 50 */       for (int i = 0; i < invBar.length; i++) {
/*  52: 51 */         if (invBar[i].contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize, EpicarnoComp.mse.y / EpicarnoComp.pixelSize))) {
/*  53: 52 */           if ((invBar[i].id != EpicarnoTiles.air) && (!isHolding))
/*  54:    */           {
/*  55: 53 */             holdingID = invBar[i].id;
/*  56: 54 */             InvItems.invItems[i].id = EpicarnoTiles.air;
/*  57:    */             
/*  58: 56 */             isHolding = true;
/*  59:    */           }
/*  60: 57 */           else if ((isHolding) && (invBar[i].id == EpicarnoTiles.air))
/*  61:    */           {
/*  62: 58 */             InvItems.invItems[i].id = holdingID;
/*  63:    */             
/*  64:    */ 
/*  65: 61 */             isHolding = false;
/*  66:    */           }
/*  67: 62 */           else if ((isHolding) && (invBar[i].id != EpicarnoTiles.air))
/*  68:    */           {
/*  69: 63 */             int[] con = invBar[i].id;
/*  70:    */             
/*  71: 65 */             InvItems.invItems[i].id = holdingID;
/*  72: 66 */             holdingID = con;
/*  73:    */           }
/*  74:    */         }
/*  75:    */       }
/*  76: 72 */       for (int i = 0; i < invBag.length; i++) {
/*  77: 73 */         if (invBag[i].contains(new Point(EpicarnoComp.mse.x / EpicarnoComp.pixelSize, EpicarnoComp.mse.y / EpicarnoComp.pixelSize))) {
/*  78: 74 */           if ((invBag[i].id != EpicarnoTiles.air) && (!isHolding))
/*  79:    */           {
/*  80: 75 */             holdingID = invBag[i].id;
/*  81: 76 */             InvItems.invBagItems[i].id = EpicarnoTiles.air;
/*  82:    */             
/*  83: 78 */             isHolding = true;
/*  84:    */           }
/*  85: 79 */           else if ((isHolding) && (invBag[i].id == EpicarnoTiles.air))
/*  86:    */           {
/*  87: 80 */             InvItems.invBagItems[i].id = holdingID;

System.out.println( InvItems.invBagItems[i].id);
/*  88:    */             
/*  89:    */ 
/*  90: 83 */             isHolding = false;
/*  91:    */           }
/*  92: 84 */           else if ((isHolding) && (invBag[i].id != EpicarnoTiles.air))
/*  93:    */           {
/*  94: 85 */             int[] con = invBag[i].id;
/*  95:    */             
/*  96: 87 */             InvItems.invBagItems[i].id = holdingID;
/*  97: 88 */             holdingID = con;
/*  98:    */           }
/*  99:    */         }
/* 100:    */       }
/* 101:    */     }
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void render(Graphics h)
/* 105:    */   {
/* 106: 99 */     for (int i = 0; i < invBar.length; i++)
/* 107:    */     {
/* 108:100 */       boolean isSelected = false;
/* 109:101 */       if (i == soming) {
/* 110:102 */         isSelected = true;
/* 111:    */       }
/* 112:106 */       invBar[i].render(h, isSelected);
/* 113:    */     }
/* 114:109 */     if (isOpen)
/* 115:    */     {
/* 116:110 */       for (int i = 0; i < invBar.length; i++) {
/* 117:111 */         invBag[i].render(h, false);
/* 118:    */       }
/* 119:115 */       if (isHolding) {
/* 120:116 */         h.drawImage(EpicarnoTiles.GameTile, EpicarnoComp.mse.x / EpicarnoComp.pixelSize - EpicarnoTiles.incCellSize / 2 + EpicarnoTiles.BlockIcons, EpicarnoComp.mse.y / EpicarnoComp.pixelSize - EpicarnoTiles.incCellSize / 2 + EpicarnoTiles.BlockIcons, EpicarnoComp.mse.x / EpicarnoComp.pixelSize - EpicarnoTiles.incCellSize / 2 + EpicarnoTiles.incCellSize - EpicarnoTiles.BlockIcons, EpicarnoComp.mse.y / EpicarnoComp.pixelSize - EpicarnoTiles.incCellSize / 2 + EpicarnoTiles.incCellSize - EpicarnoTiles.BlockIcons, holdingID[0] * EpicarnoTiles.tileSize, holdingID[1] * EpicarnoTiles.tileSize, holdingID[0] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, holdingID[1] * EpicarnoTiles.tileSize + EpicarnoTiles.tileSize, null);
/* 121:    */       }
/* 122:    */     }
/* 123:    */   }
/* 124:    */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.Inventory
 * JD-Core Version:    0.7.0.1
 */