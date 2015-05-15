 package net.epicarno.client.generic;
 
 import java.awt.image.BufferedImage;
 import java.io.File;
 import javax.imageio.ImageIO;
 
 public class EpicarnoTiles
 {
   public static int tileSize = 16;
   public static int invLength = 8;
   public static int invHeight = 1;
   public static int incCellSize = 25;
   public static int invCellSpace = 4;
   public static int invBorderSpace = 4;
   public static int BlockIcons = 4;
   public static int maxMobs = 6;
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
public static int[] Skeleton = { 1 ,0};
   public static int[] Player = { 0 ,1};
   public static BufferedImage GameTile;
   public static BufferedImage tile_cell;
   public static BufferedImage tile_select;
   
   public EpicarnoTiles()
   {
     try
     {
       GameTile = ImageIO.read(new File("res/GameTile.png"));
       tile_cell = ImageIO.read(new File("res/tile_cell.png"));
       tile_select = ImageIO.read(new File("res/tile_select.png"));
     }
     catch (Exception localException) {}
   }
 }


