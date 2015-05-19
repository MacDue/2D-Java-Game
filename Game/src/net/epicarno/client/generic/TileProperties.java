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
	
	public boolean isUnbreakable(int[] id){

		if (id == EpicarnoTiles.bedrock){
			return true;
		}else if(id == EpicarnoTiles.RealBR){
			return true;
		
		}else {
			return false;
		}

		
	}
	
	
	public boolean isFallingTile(int[] id){

		if (id == EpicarnoTiles.seasand){
			return true;
		
		
		}else {
			return false;
		}

		
	}
	
	public boolean isReplaceable(int[] id){

		if (id == EpicarnoTiles.wildgrass){
			return true;
		
		
		}else if(id == EpicarnoTiles.rose){
			return true;
		
		}else if(id == EpicarnoTiles.air){
			return true;
		
		}else {
			return false;
		}

		
	}
	
	public boolean isPlant(int[] id){

		if (id == EpicarnoTiles.wildgrass){
			return true;
		
		
		}else if(id == EpicarnoTiles.rose){
			return true;
		
		
		}else {
			return false;
		}

		
	}
	
	public boolean isSeethrough(int[] id){

		if (id == EpicarnoTiles.wildgrass){
			return true;
		
		
		}else if(id == EpicarnoTiles.rose){
			return true;
		
		
		}else if(id == EpicarnoTiles.air){
			return true;
		
		
		}else if(id == EpicarnoTiles.Glass){
			return true;
		
		
		}else if(id == EpicarnoTiles.leaf){
			return true;
		
		
		}else {
			return false;
		}

		
	}
	
	
	//Temp Fix
	public String getTileName(int[] id) {

		if (id == EpicarnoTiles.rose) {
			return "Rose";
		} else if (id == EpicarnoTiles.leaf) {
			return "Pink Leaves";
		} else if (id == EpicarnoTiles.wildgrass) {
			return "Wild Grass";
		} else if (id == EpicarnoTiles.wood) {
			return "Wood";
		} else if (id == EpicarnoTiles.air) {
			return "Air";
		} else if (id == EpicarnoTiles.BackGroundDirt) {
			return "BG Tile";
		} else if (id == EpicarnoTiles.BackGroundStone) {
			return "BG Tile";
		} else if (id == EpicarnoTiles.stone) {
			return "Stone";
		} else if (id == EpicarnoTiles.Grass) {
			return "Grass";
		} else if (id == EpicarnoTiles.wizningmud) {
			return "Mud";
		} else if (id == EpicarnoTiles.bedrock) {
			return "Level End";
		} else if (id == EpicarnoTiles.ob) {
			return "Dragon Glass";
		} else if (id == EpicarnoTiles.bling) {
			return "Gold Tile";
		} else if (id == EpicarnoTiles.planks) {
			return "Wooden Planks";
		} else if (id == EpicarnoTiles.Glass) {
			return "Glass";
		} else if (id == EpicarnoTiles.bricks) {
			return "Bricks";
		} else if (id == EpicarnoTiles.shittybricks) {
			return "Cobblestone";
		} else if (id == EpicarnoTiles.seasand) {
			return "Sand";
		} else {
			return "Unknown Tile";
		}

	}
	
	public int[] getTileFromName(String name) {

		if (name.toLowerCase().equals("rose")) {
			return EpicarnoTiles.rose;
		} else if (name.toLowerCase().equals("pinkleaves")) {
			return EpicarnoTiles.leaf;
		}else if (name.toLowerCase().equals("wildgrass")) {
			return EpicarnoTiles.wildgrass;
		}else if (name.toLowerCase().equals("wood")) {
			return EpicarnoTiles.wood;
		} else if (name.toLowerCase().equals("air")) {
			return EpicarnoTiles.air;
		} else if (name.toLowerCase().equals("stone")) {
			return EpicarnoTiles.stone;
		} else if (name.toLowerCase().equals("grass")) {
			return EpicarnoTiles.Grass;
		} else if (name.toLowerCase().equals("mud")) {
			return EpicarnoTiles.wizningmud;
		} else if (name.toLowerCase().equals("dragonglass")) {
			return EpicarnoTiles.ob;
		} else if (name.toLowerCase().equals("goldtile")) {
			return EpicarnoTiles.bling;
		}else if (name.toLowerCase().equals("woodenplanks")) {
			return EpicarnoTiles.planks;
		}else if (name.toLowerCase().equals("glass")) {
			return EpicarnoTiles.Glass;
		}else if (name.toLowerCase().equals("bricks")) {
			return EpicarnoTiles.bricks;
		}else if (name.toLowerCase().equals("cstone")) {
			return EpicarnoTiles.shittybricks;
		} else if (name.toLowerCase().equals("sand")) {
			return EpicarnoTiles.seasand;
		} else if (name.toLowerCase().equals("bedrock")) {
			return EpicarnoTiles.RealBR;
		}else {
			return EpicarnoTiles.seasand;
		}

	}
	


}
