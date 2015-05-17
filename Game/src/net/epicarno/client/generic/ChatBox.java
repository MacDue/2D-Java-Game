package net.epicarno.client.generic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import net.epicarno.client.EpicarnoComp;

public class ChatBox {
	//W.I.P.
	public ChatBox(){
		
	}
	
	
	public void Render(Graphics g, String Text,Boolean open){
		if(open == true){
		 g.setColor(new Color(28, 28, 28, 160));
		 g.fillRect (0, EpicarnoComp.pixel.height-20, EpicarnoComp.pixel.width, 20);
		 g.setColor(new Color(255, 255, 255, 255));
		 g.setFont(new Font("", Font.PLAIN, 10)); 
		 g.drawString(Text, 3, EpicarnoComp.pixel.height-12);
		}
	}

}
