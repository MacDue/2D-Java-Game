package net.epicarno.client.world;

import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.Tiles.Tile;

public class BiomeDeco {
	
	//public Object GetBiomeEpicarnoComp;
	public BiomeDeco(){
		
	}
	   public int[] GetBiomeDecorations(int BiomeID,int type)
	  {
		   // 1 Top Block, 2 Biome Flower, 3 Biome Grass/ shrub, 4 Tree Wood, 5 Tree leaf , 6 biome stone.
		 
		   switch(BiomeID){
		   //Default
		   case 1:if (type ==1 ){
			   return EpicarnoTiles.Grass; 
		   }else if (type == 2){
			   return EpicarnoTiles.rose;  
		   }else if (type == 3){
			   return EpicarnoTiles.wildgrass; 
		   }else if (type == 4){
			   return EpicarnoTiles.wood; 
		   }else if (type == 5){
			   return EpicarnoTiles.leaf; 
			   
		   }else if (type == 6){
			   return EpicarnoTiles.stone; 
			   
		   }else if (type == 7){
			   return EpicarnoTiles.wizningmud; 
			   
		   }else return EpicarnoTiles.air;
		   
		   //BackGround
		   case 2:if (type ==1 ){
			   return EpicarnoTiles.BackGroundDirt; 
		   }else if (type == 2){
			   return EpicarnoTiles.air;  
		   }else if (type == 3){
			   return EpicarnoTiles.air; 
		   }else if (type == 4){
			   return EpicarnoTiles.air; 
		   }else if (type == 5){
			   return EpicarnoTiles.air; 
			   
		   }else if (type == 6){
			   return EpicarnoTiles.BackGroundStone; 
			   
		   }else if (type == 7){
			   return EpicarnoTiles.BackGroundDirt; 
			   
		   }else return EpicarnoTiles.air;
		   
		   //Test Biome
		   case 3:if (type ==1 ){
			   return EpicarnoTiles.seasand; 
		   }else if (type == 2){
			   return EpicarnoTiles.air;  
		   }else if (type == 3){
			   return EpicarnoTiles.air; 
		   }else if (type == 4){
			   return EpicarnoTiles.air; 
		   }else if (type == 5){
			   return EpicarnoTiles.air; 
			   
		   }else if (type == 6){
			   return EpicarnoTiles.stone; 
			   
		   }else if (type == 7){
			   return EpicarnoTiles.seasand; 
			   
		   }else return EpicarnoTiles.air;
		   default: return EpicarnoTiles.air;
		   }
	//	return null;
		 
	  }
}

