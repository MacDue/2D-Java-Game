package net.epicarno.client.generic;

import net.epicarno.client.EpicarnoComp;

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
		
		
	}

}
