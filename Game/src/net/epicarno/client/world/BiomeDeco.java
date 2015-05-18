package net.epicarno.client.world;

import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.Tiles.Tile;

public class BiomeDeco {
	
	//public Object GetBiomeEpicarnoComp;
	public BiomeDeco(){
		
	}
	   public Tile GetBiomeDecorations(int BiomeID,int type)
	  {
		   // 1 Top Block, 2 Biome Flower, 3 Biome Grass/ shrub, 4 Tree Wood, 5 Tree leaf , 6 biome stone.
		 
		   switch(BiomeID){
		   //Default
		   case 1:if (type ==1 ){
			   return new Tile(EpicarnoTiles.Grass); 
		   }else if (type == 2){
			   return new Tile(EpicarnoTiles.rose);  
		   }else if (type == 3){
			   return new Tile(EpicarnoTiles.wildgrass); 
		   }else if (type == 4){
			   return new Tile(EpicarnoTiles.wood); 
		   }else if (type == 5){
			   return new Tile(EpicarnoTiles.leaf); 
			   
		   }else if (type == 6){
			   return new Tile(EpicarnoTiles.stone); 
			   
		   }else if (type == 7){
			   return new Tile(EpicarnoTiles.wizningmud); 
			   
		   }else return new Tile(EpicarnoTiles.air);
		   
		   //BackGround
		   case 2:if (type ==1 ){
			   return new Tile(EpicarnoTiles.BackGroundDirt); 
		   }else if (type == 2){
			   return new Tile(EpicarnoTiles.air);  
		   }else if (type == 3){
			   return new Tile(EpicarnoTiles.air); 
		   }else if (type == 4){
			   return new Tile(EpicarnoTiles.air); 
		   }else if (type == 5){
			   return new Tile(EpicarnoTiles.air); 
			   
		   }else if (type == 6){
			   return new Tile(EpicarnoTiles.BackGroundStone); 
			   
		   }else if (type == 7){
			   return new Tile(EpicarnoTiles.BackGroundDirt); 
			   
		   }else return new Tile(EpicarnoTiles.air);
		   
		   //Test Biome
		   case 3:if (type ==1 ){
			   return new Tile(EpicarnoTiles.seasand); 
		   }else if (type == 2){
			   return new Tile(EpicarnoTiles.air);  
		   }else if (type == 3){
			   return new Tile(EpicarnoTiles.air); 
		   }else if (type == 4){
			   return new Tile(EpicarnoTiles.air); 
		   }else if (type == 5){
			   return new Tile(EpicarnoTiles.air); 
			   
		   }else if (type == 6){
			   return new Tile(EpicarnoTiles.stone); 
			   
		   }else if (type == 7){
			   return new Tile(EpicarnoTiles.seasand); 
			   
		   }else return new Tile(EpicarnoTiles.air);
		   default: return new Tile(EpicarnoTiles.air);
		   }
	//	return null;
		 
	  }
}

