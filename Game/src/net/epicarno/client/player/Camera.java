package net.epicarno.client.player;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.world.EpicarnoL;

public class Camera {
	
	public Camera(){
		//EpicarnoComp.sX = EpicarnoComp.sX + 100;
	}
	
	public void tick(){
		Double offsetMaxX = (double) ((EpicarnoL.worldW *16) - EpicarnoComp.pixel.width);
		Double		offsetMaxY = (double) ((EpicarnoL.worldH *16) - EpicarnoComp.pixel.height);
		Double		offsetMinX = 0D;
		Double		offsetMinY = 0D;
		Double Camx = 0D;
		Double Camy = 0D;
        float lerp = 0.1f;
      //  Vector3 position = this.getCamera().position;
        Camx  += (EpicarnoComp.player.x - EpicarnoComp.pixel.width / 2) ;
        Camy += (EpicarnoComp.player.y - EpicarnoComp.pixel.height /2) ;
        
        if (Camx > offsetMaxX){
            Camx = offsetMaxX;
        }
        else if (Camx < offsetMinX){
            Camx = offsetMinX;
        }
        
        if (Camy > offsetMaxY){
            Camy = offsetMaxY;
        }
        else if (Camy < offsetMinY){
            Camy = offsetMinY;
        }
        
        EpicarnoComp.sX = Camx;
        EpicarnoComp.sY = Camy;
        
         
	}

}
