package net.epicarno.client.generic;

public class TileProperties {


		


	public boolean isSolidTile(int[] id){

		if (id == EpicarnoTiles.rose){
			return false;
		}else if(id == EpicarnoTiles.leaf){
			return false;
		}else if(id == EpicarnoTiles.wildgrass){
			return false;
		}else if(id == EpicarnoTiles.wood){
			return false;
		}else if(id == EpicarnoTiles.air){
			return false;
		}else if(id == EpicarnoTiles.BackGroundDirt){
			return false;
		}else if(id == EpicarnoTiles.BackGroundStone){
			return false;
		}else {
			return true;
		}

		
	}
	


}
