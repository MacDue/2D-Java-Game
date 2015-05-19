package net.epicarno.client.generic.Tiles;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.mobs.FallingTile;

public class Tile {
	public int[] id;
//	public int[] tempId;
	public int x;
	public int y;
	
	public Tile(int[] material,int x,int y){
		id = material;
		this.x =x;
		this.y = y;
	}
	
	public void tick(){
		
		//System.out.println("TileX"+x);
		if ((EpicarnoComp.epicarnol.prop.isFallingTile(this.id)) && (!EpicarnoComp.epicarnol.prop.isSolidTile(EpicarnoComp.epicarnol.GetTile(x, y+1)))){
			//this.tempId = this.id;
			//System.out.println("Falling");
			EpicarnoComp.epicarnol.SetTile(x, y,EpicarnoTiles.air);
			EpicarnoComp.epicarnol.spawnMob(new FallingTile(x*16, y*16, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize , this.id));
			this.id = EpicarnoTiles.air;

		}
		
		
		if (this.id == EpicarnoTiles.Grass){
			//this.tempId = this.id;
			//System.out.println("Falling");
			
		//	EpicarnoComp.epicarnol.SetTile(x-1, y,EpicarnoTiles.Grass);

		//	EpicarnoComp.epicarnol.SetTile(x+1, y,EpicarnoTiles.Grass);
			//EpicarnoComp.epicarnol.spawnMob(new FallingTile(x*16, y*16, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize , this.id));
			//this.id = EpicarnoTiles.air;

		}
	}
	

}
