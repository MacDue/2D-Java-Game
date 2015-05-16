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
	
	 public static int[] air = { -1, -1 };
	   public static int[] wizningmud = new int[9];
	   public static int[] Grass = { 1,0 };
	   public static int[] seasand = { 2 ,0};
	   public static int[] bedrock = { -1, -1 };
	   public static int[] wood = { 4,0 };
	   public static int[] planks = { 5,0 };
	   public static int[] bling = { 6,0 };
	   public static int[] bricks = { 7,0 };
	   public static int[] shittybricks = { 8,0 };
	   public static int[] Glass = { 9,0 };
	   public static int[] ob = { 3,0 };
	   public static int[] Zombie = { 1 ,0};
	   public static int[] leaf = {10,0};
	public static int[] stone = {11,0};
	public static int[] wildgrass = {12,0};
	public static int[] rose = {13,0};
	public static int[] BackGroundStone = {14,0};
	public static int[] BackGroundDirt = {15,0};
	
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
			return "Gold Block";
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
	


}
