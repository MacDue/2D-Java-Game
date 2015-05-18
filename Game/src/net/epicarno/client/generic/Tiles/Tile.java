package net.epicarno.client.generic.Tiles;

import net.epicarno.client.generic.EpicarnoTiles;

public class Tile {
	public int[] id;
	
	public Tile(int[] material){
		id = material;
	}
	
	public void tick(){
		
		if(this.id == EpicarnoTiles.stone){
			this.id = EpicarnoTiles.bling;
		}
	}
	

}
