package net.epicarno.client.generic;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.mobs.FallingTile;

public class MsgProcessor {
	//Temp 2 Arg Fix
	public void MsgType(String msg){
		String CMD= "";
		Boolean Arg0Found = false;
		Boolean Arg1Found = false;
		String Arg0 = "";
		String Arg1 = "";
		int I = 1;
		if((msg.charAt(0) == '/') || (msg.charAt(0) == '\\')){
			while ((msg.charAt(I) != ' ') && (I < msg.length()-1)){
				CMD = CMD + msg.charAt(I) ;
				I ++;
			}
			if((msg.charAt(I) == ' ') && !(msg.charAt(I+1) == ' ')){
				I = I +1;
				while ((msg.charAt(I) != ' ') && (I < msg.length()-1)){
					Arg0 = Arg0 + msg.charAt(I) ;
					I ++;
				}
			}
			
			if((msg.charAt(I) == ' ') && !(msg.charAt(I+1) == ' ')){
				I = I +1;
				while ((msg.charAt(I) != ' ') && (I < msg.length()-1)){
					Arg1 = Arg1 + msg.charAt(I) ;
					I ++;
				}
			}
			
		}else{
			System.out.println("<Player>: "+msg);
		}
	//	System.out.println(CMD);
		//System.out.println(Arg0);
	//	System.out.println(Arg1);
		//System.out.println(CMD.toUpperCase());
		//No Vaildation yet as CBA
		if((CMD.toUpperCase().contains("TP")) && (CMD.length() == "TP".length()) && (Arg0 != "") && (Arg1 != "") ){
			try{
			EpicarnoComp.player.x = Double.parseDouble(Arg0);
			EpicarnoComp.player.y = Double.parseDouble(Arg1);
			}
			 catch(NumberFormatException exception) {
				 System.out.println("invalid x or y"); 
			 }
		}
		
	if((CMD.toUpperCase().contains("POSADD")) && (CMD.length() == "POSADD".length()) && (Arg0 != "") && (Arg1 != "")){
			
		try{
			EpicarnoComp.player.x = EpicarnoComp.player.x+ Double.parseDouble(Arg0);
			EpicarnoComp.player.y = EpicarnoComp.player.y+ Double.parseDouble(Arg1);
		
		}catch(NumberFormatException exception){
			 System.out.println("invalid x or y"); 
		}
	}
		
		if(CMD.toUpperCase().contains("GETPLAYERPOS")  && CMD.length() == "GETPLAYERPOS".length()){
			
			System.out.println("Player X :"+EpicarnoComp.player.x); 
			System.out.println("Player Y :"+EpicarnoComp.player.y); 
		}
		
		if(CMD.toUpperCase().contains("FALLINGTILE")  && (CMD.length() == "FALLINGTILE".length()) && (Arg0.length() > 0) && (Arg1.length() <= 0)){
			
			//System.out.println("Player X :"+EpicarnoComp.player.x); 
		    EpicarnoComp.epicarnol.spawnMob(new FallingTile((int) EpicarnoComp.player.x, (int) EpicarnoComp.player.y - 60, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize , EpicarnoComp.epicarnol.prop.getTileFromName(Arg0)));

			
			//System.out.println("Player Y :"+EpicarnoComp.player.y); 
		}else 		if(CMD.toUpperCase().contains("FALLINGTILE")  && (CMD.length() == "FALLINGTILE".length()) && (Arg0.length() > 0 ) && (Arg1.length() > 0)){
			
			//System.out.println("Player X :"+EpicarnoComp.player.x); 
			
			try{
				int Max = Integer.parseInt(Arg1);
				
				for (int i=0;i<Max;i++){
					
					if(((int) EpicarnoComp.player.y - 60-(i*16)) > 0){
			    EpicarnoComp.epicarnol.spawnMob(new FallingTile((int) EpicarnoComp.player.x, (int) EpicarnoComp.player.y - 60-(i*16), EpicarnoTiles.tileSize, EpicarnoTiles.tileSize , EpicarnoComp.epicarnol.prop.getTileFromName(Arg0)));
				}
				}
			
			}catch(NumberFormatException exception){
				 System.out.println("invalid number"); 
			}
			

			
			//System.out.println("Player Y :"+EpicarnoComp.player.y); 
		}
		
		
	}

}
