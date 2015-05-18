package net.epicarno.client.player;

import java.awt.Rectangle;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;

public class InvItems {
	 public static Cell[] invItems= new Cell[EpicarnoTiles.invLength];
	 public static Cell[] invBagItems = new Cell[EpicarnoTiles.invLength * EpicarnoTiles.invHeight];
	 
	 public InvItems(){
		      for (int i = 0; i < invItems.length; i++) {
			        invItems[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + i * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19- (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
			      }
			      int x = 0;int y = 0;
			      for (int i = 0; i < invBagItems.length; i++)
			      {
			        invBagItems[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + x * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19 - (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace) - EpicarnoTiles.invHeight * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace) + y * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
			        x++;
			        if (x == EpicarnoTiles.invLength)
			        {
			          x = 0;
			          y++;
			        }
			      }
		      invItems[0].id = EpicarnoTiles.wizningmud;
		      invItems[1].id = EpicarnoTiles.Grass;
		      invItems[2].id = EpicarnoTiles.seasand;
		      invItems[3].id = EpicarnoTiles.wood;
		      invItems[4].id = EpicarnoTiles.planks;
		      invItems[5].id = EpicarnoTiles.bling;
		      invItems[6].id = EpicarnoTiles.bricks;
		      invItems[7].id = EpicarnoTiles.Glass;
		      invBagItems[0].id = EpicarnoTiles.air;
		      invBagItems[1].id = EpicarnoTiles.air;
		      invBagItems[2].id = EpicarnoTiles.air;
		      invBagItems[3].id = EpicarnoTiles.air;
		      invBagItems[4].id = EpicarnoTiles.air;
		      invBagItems[5].id = EpicarnoTiles.air;
		      invBagItems[6].id = EpicarnoTiles.air;
		      invBagItems[7].id = EpicarnoTiles.air;
		      
		      invBagItems[8].id = EpicarnoTiles.air;
		      invBagItems[9].id = EpicarnoTiles.air;
		      invBagItems[10].id = EpicarnoTiles.air;
		      invBagItems[11].id = EpicarnoTiles.air;
		      invBagItems[12].id = EpicarnoTiles.air;
		      invBagItems[13].id = EpicarnoTiles.air;
		      invBagItems[14].id = EpicarnoTiles.air;
		      invBagItems[15].id = EpicarnoTiles.air;
		      
		      invBagItems[16].id = EpicarnoTiles.air;
		      invBagItems[17].id = EpicarnoTiles.air;
		      invBagItems[18].id = EpicarnoTiles.air;
		      invBagItems[19].id = EpicarnoTiles.air;
		      invBagItems[20].id = EpicarnoTiles.air;
		      invBagItems[21].id = EpicarnoTiles.air;
		      invBagItems[22].id = EpicarnoTiles.air;
		      invBagItems[23].id = EpicarnoTiles.air;
		      
		      invBagItems[24].id = EpicarnoTiles.wildgrass;
		      invBagItems[25].id = EpicarnoTiles.RealBR;
		      invBagItems[26].id = EpicarnoTiles.air;
		      invBagItems[27].id = EpicarnoTiles.air;
		      invBagItems[28].id = EpicarnoTiles.air;
		      invBagItems[29].id = EpicarnoTiles.air;
		      invBagItems[30].id = EpicarnoTiles.air;
		      invBagItems[31].id = EpicarnoTiles.air;
		      
		      invBagItems[32].id = EpicarnoTiles.shittybricks;
		      invBagItems[33].id = EpicarnoTiles.ob;
		      invBagItems[34].id = EpicarnoTiles.Zombie;
		      invBagItems[35].id = EpicarnoTiles.rose;
		      invBagItems[36].id = EpicarnoTiles.Skeleton;
		      invBagItems[37].id = EpicarnoTiles.stone;
		      invBagItems[38].id = EpicarnoTiles.leaf;
		      invBagItems[39].id = EpicarnoTiles.air;
		      

	 }
}
