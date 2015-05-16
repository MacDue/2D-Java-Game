package net.epicarno.client.player;

import net.epicarno.client.EpicarnoComp;

public class Camera {
	
	public Camera(){
		EpicarnoComp.sX = EpicarnoComp.sX + 100;
	}
	
	public void tick(){
        float lerp = 0.1f;
      //  Vector3 position = this.getCamera().position;
         EpicarnoComp.sX  += (EpicarnoComp.player.x - EpicarnoComp.sX) * lerp -20;
         EpicarnoComp.sY += (EpicarnoComp.player.y - EpicarnoComp.sY) * lerp - 16;
	}

}
