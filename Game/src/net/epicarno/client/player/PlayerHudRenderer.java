package net.epicarno.client.player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.TileProperties;

public class PlayerHudRenderer    extends Rectangle
{
	   private static final long serialVersionUID = 1L;
	   public int[] id = new int[2];
	   
	   public PlayerHudRenderer(Rectangle size, int[] id)
	   {
	     setBounds(size);
	     this.id = id;
	   }
	
	   @SuppressWarnings("unused")
	public void line(int x,int y,int x2, int y2) {
		   new TileProperties();
		    int w = x2 - x ;
		    int h = y2 - y ;
		    double m = h/(double)w ;
		    for (int i=x;i<=x2;i++) {
		        //putpixel(i,(int)j,color) ;
		     //   System.out.println(Prop.getTileName(EpicarnoComp.epicarnol.GetTile( ((i+ (int)EpicarnoComp.sX)-6 )/16, (((int)j+ (int)EpicarnoComp.sX)-10)/16   )));
		        
		        
		    }
		}
	   public void render(Graphics g,int HP)
	   {
		 // g.drawImage(EpicarnoTiles.tile_select, 100, 100, 0, 0, 100, 100, 0, 0, null);
		   for (int H = 0; H < HP;H = H +10){
			   g.drawImage(EpicarnoTiles.Heart, H, 0, null);
		   }
		   
		  // System.out.println('X'+EpicarnoComp.mse.x / EpicarnoComp.pixelSize );
		  // System.out.println( 'Y'+EpicarnoComp.mse.y/ EpicarnoComp.pixelSize );
		   g.setColor(new Color(237, 55, 76, 200));
	//	   g.drawLine(( (int)EpicarnoComp.player.x - (int)EpicarnoComp.sX)+6, (int)EpicarnoComp.player.y - (int)EpicarnoComp.sY +10, EpicarnoComp.mse.x / EpicarnoComp.pixelSize , EpicarnoComp.mse.y/ EpicarnoComp.pixelSize );
		  
	       //g.drawImage(EpicarnoTiles.tile_select, this.x - 1, this.y - 1, this.width + 2, this.height + 2, null);
	     
	   }
	   
	   public void renderP(Graphics g)
	   {
		   g.setColor(new Color(237, 55, 76, 200));
		   //line(( (int)EpicarnoComp.player.x - (int)EpicarnoComp.sX)+6, (int)EpicarnoComp.player.y - (int)EpicarnoComp.sY +10, EpicarnoComp.mse.x / EpicarnoComp.pixelSize , EpicarnoComp.mse.y/ EpicarnoComp.pixelSize );
		   g.drawLine(( (int)EpicarnoComp.player.x - (int)EpicarnoComp.sX)+6, (int)EpicarnoComp.player.y - (int)EpicarnoComp.sY +10, EpicarnoComp.mse.x / EpicarnoComp.pixelSize , EpicarnoComp.mse.y/ EpicarnoComp.pixelSize );
		  
		 // g.drawImage(EpicarnoTiles.tile_select, 100, 100, 0, 0, 100, 100, 0, 0, null);
		   g.setColor(new Color(255, 255, 255, 255));
			 g.setFont(new Font("", Font.PLAIN, 10)); 

			 g.drawString("Ben Maxwell && The Mysterious NullPointerException", 1, 20);
		  // System.out.println('X'+EpicarnoComp.mse.x / EpicarnoComp.pixelSize );
		  // System.out.println( 'Y'+EpicarnoComp.mse.y/ EpicarnoComp.pixelSize );
		
	       //g.drawImage(EpicarnoTiles.tile_select, this.x - 1, this.y - 1, this.width + 2, this.height + 2, null);
	     
	   }

}
