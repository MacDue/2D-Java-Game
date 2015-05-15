package net.epicarno.client;

import java.awt.Rectangle;

public class InvItems {
	 public static Cell[] invItems= new Cell[EpicarnoTiles.invLength];
	 public static Cell[] invBagItems = new Cell[EpicarnoTiles.invLength * EpicarnoTiles.invHeight];
	 
	 public InvItems(){
		 /*  20: 18 */     for (int i = 0; i < invItems.length; i++) {
			 /*  21: 19 */       invItems[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + i * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19- (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
			 /*  22:    */     }
			 /*  23: 22 */     int x = 0;int y = 0;
			 /*  24: 23 */     for (int i = 0; i < invBagItems.length; i++)
			 /*  25:    */     {
			 /*  26: 26 */       invBagItems[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + x * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19 - (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace) - EpicarnoTiles.invHeight * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace) + y * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
			 /*  27: 27 */       x++;
			 /*  28: 28 */       if (x == EpicarnoTiles.invLength)
			 /*  29:    */       {
			 /*  30: 29 */         x = 0;
			 /*  31: 30 */         y++;
			 /*  32:    */       }
			 /*  33:    */     }
		 /*  34: 35 */     invItems[0].id = EpicarnoTiles.wizningmud;
		 /*  35: 36 */     invItems[1].id = EpicarnoTiles.Grass;
		 /*  36: 37 */     invItems[2].id = EpicarnoTiles.seasand;
		 /*  37: 38 */     invItems[3].id = EpicarnoTiles.wood;
		 /*  38: 39 */     invItems[4].id = EpicarnoTiles.planks;
		 /*  39: 40 */     invItems[5].id = EpicarnoTiles.bling;
		 /*  40: 41 */     invItems[6].id = EpicarnoTiles.bricks;
		 /*  41: 42 */     invItems[7].id = EpicarnoTiles.Glass;
		 /*  42: 43 */     invBagItems[0].id = EpicarnoTiles.shittybricks;
		 /*  43: 44 */     invBagItems[1].id = EpicarnoTiles.ob;
		 /*  43: 44 */     invBagItems[2].id = EpicarnoTiles.Zombie;
		 /*  43: 44 */     invBagItems[3].id = EpicarnoTiles.Player;
		 /*  43: 44 */     invBagItems[4].id = EpicarnoTiles.Skeleton;
		 /*  43: 44 */     invBagItems[5].id = EpicarnoTiles.stone;
		 /*  43: 44 */     invBagItems[6].id = EpicarnoTiles.leaf;
		 /*  43: 44 */     invBagItems[7].id = EpicarnoTiles.air;
	 }
}
