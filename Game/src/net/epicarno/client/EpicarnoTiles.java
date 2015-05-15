/*  1:   */ package net.epicarno.client;
/*  2:   */ 
/*  3:   */ import java.awt.image.BufferedImage;
/*  4:   */ import java.io.File;
/*  5:   */ import javax.imageio.ImageIO;
/*  6:   */ 
/*  7:   */ public class EpicarnoTiles
/*  8:   */ {
/*  9: 9 */   public static int tileSize = 16;
/* 10:10 */   public static int invLength = 8;
/* 11:11 */   public static int invHeight = 1;
/* 12:12 */   public static int incCellSize = 25;
/* 13:13 */   public static int invCellSpace = 4;
/* 14:14 */   public static int invBorderSpace = 4;
/* 15:15 */   public static int BlockIcons = 4;
/* 16:16 */   public static int maxMobs = 6;
/* 17:19 */   public static int[] air = { -1, -1 };
/* 18:20 */   public static int[] wizningmud = new int[9];
/* 19:21 */   public static int[] Grass = { 1,0 };
/* 20:22 */   public static int[] seasand = { 2 ,0};
/* 21:23 */   public static int[] bedrock = { -1, -1 };
/* 22:24 */   public static int[] wood = { 4,0 };
/* 23:25 */   public static int[] planks = { 5,0 };
/* 24:26 */   public static int[] bling = { 6,0 };
/* 25:27 */   public static int[] bricks = { 7,0 };
/* 26:28 */   public static int[] shittybricks = { 8,0 };
/* 27:29 */   public static int[] Glass = { 9,0 };
/* 28:30 */   public static int[] ob = { 3,0 };
/* 29:32 */   public static int[] Zombie = { 1 ,0};
/* 29:32 */   public static int[] leaf = {10,0};
public static int[] stone = {11,0};
public static int[] wildgrass = {12,0};
public static int[] rose = {13,0};
public static int[] Skeleton = { 1 ,0};
/* 30:33 */   public static int[] Player = { 1 ,0};
/* 31:   */   public static BufferedImage GameTile;
/* 32:   */   public static BufferedImage tile_cell;
/* 33:   */   public static BufferedImage tile_select;
/* 34:   */   
/* 35:   */   public EpicarnoTiles()
/* 36:   */   {
/* 37:   */     try
/* 38:   */     {
/* 39:41 */       GameTile = ImageIO.read(new File("res/GameTile.png"));
/* 40:42 */       tile_cell = ImageIO.read(new File("res/tile_cell.png"));
/* 41:43 */       tile_select = ImageIO.read(new File("res/tile_select.png"));
/* 42:   */     }
/* 43:   */     catch (Exception localException) {}
/* 44:   */   }
/* 45:   */ }


/* Location:           E:\New folder (6)\MineD.jar
 * Qualified Name:     net.epicarno.client.EpicarnoTiles
 * JD-Core Version:    0.7.0.1
 */