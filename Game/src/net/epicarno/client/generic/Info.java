package net.epicarno.client.generic;

import java.awt.Color;
import java.awt.Graphics;

import net.epicarno.client.EpicarnoComp;

public class Info {
	public Info(){
		
	}
	
	
	
	
	/* 105:    */   public void render(Graphics g)
	
	/* 106:    */   {
		 g.setColor(new Color(255, 255, 255, 255));
		   g.drawString("Press ENTER to spawn!", (EpicarnoComp.pixel.width)*3, 75);
	/* 112:    */   }
	/* 113:    */ 

}