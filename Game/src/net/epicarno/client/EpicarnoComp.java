 package net.epicarno.client;
 
 import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.image.VolatileImage;
import java.util.ArrayList;

import javax.swing.JFrame;

import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.generic.Info;
import net.epicarno.client.mobs.Mob;
import net.epicarno.client.mobs.Spawner;
import net.epicarno.client.player.Camera;
import net.epicarno.client.player.Cell;
import net.epicarno.client.player.InvItems;
import net.epicarno.client.player.Inventory;
import net.epicarno.client.player.Listening;
import net.epicarno.client.player.Player;
import net.epicarno.client.world.BiomeDeco;
import net.epicarno.client.world.EpicarnoBackground;
import net.epicarno.client.world.EpicarnoL;
import net.epicarno.client.world.Sky;
 
 public class EpicarnoComp
   extends Applet
   implements Runnable  , KeyListener

 {
   private static final long serialVersionUID = 1L;
   public static int pixelSize = 3;
public static int dr= 0;
   public static int moveFronBorder = 0;
   public static double sX = moveFronBorder;
   public static double sY = moveFronBorder;
   public static double dir = 0.5D;
   public static Dimension realSize;
   public static Dimension size = new Dimension(1224, 768);
   public static Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
   public static Point mse = new Point(0, 0);
   public static String name = "Ben Maxwell Test Java Project";
   public static boolean isRunning = false;
   public static boolean isMoving = false;
   public static boolean isHipideHopping = false;
   public static boolean isLeftyDown = false;
   public static boolean isRightyDown = false;
public static BiomeDeco deco;
public static boolean sp = false;
   private Image screen;
public static boolean playerlives = false;
public static boolean redoplay = false;

   public static EpicarnoL epicarnol;
   public static EpicarnoBackground back;
   public static Player player;
public static InvItems items;
public static boolean redoBar = false;
   public static Inventory invent;
   public static Sky sky;
   public static Camera Cam;
   public static Info info;
   public static Spawner spawner;
   public static ArrayList<Mob> mob = new ArrayList();
   private static JFrame frame;
   
   public EpicarnoComp()
   {
     setPreferredSize(size);
     addKeyListener(new Listening());
     addMouseListener(new Listening());
     addMouseMotionListener(new Listening());
     addMouseWheelListener(new Listening());
   }
   
   public void start()
   {
     requestFocus();
     deco = new BiomeDeco();
     epicarnol = new EpicarnoL(1);
     back = new EpicarnoBackground(2);
  //   player = new Player(EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2);
     new EpicarnoTiles();

items = new InvItems();
invent = new Inventory();
     
     
     sky = new Sky();

     spawner = new Spawner();
player = new Player(EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2);

Cam = new Camera();
playerlives = true;
sp=true;
     
 
     isRunning = true;
     new Thread(this).start();
   }




      

   
   public void stop()
   {
     isRunning = false;
   }
   
   public static void main(String[] args)
   {
     EpicarnoComp epicarnocomp = new EpicarnoComp();
     
     frame = new JFrame();


frame.addComponentListener(new ComponentListener() {
    public void componentResized(ComponentEvent e) {
    	//player.y = 50.0D;
    	//  System.out.println(frame.getWidth());
    	  //renderBar();
    	  redoBar = true;
    //	  redoplay = true;
    	//  player.redo();
    	 // player.y = - 100;
    	
    	  
    //	 player. setBounds(EpicarnoComp.pixel.width / 2 - player.width / 2, EpicarnoComp.pixel.height / 2 - player.height / 2, player.width, player.height);
    	
    	// sX = sX - 50;
 //  player.redo();
   // redoplay = false;
  // player.fallingspeed = 0.0D;
    }


	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		 
	}



	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
});
     frame.add(epicarnocomp);
if(playerlives == true){
frame.setResizable(false);
}
     frame.pack();

     
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
int width = (int) screenSize.getWidth();
int height = (int) screenSize.getHeight();
     realSize = new Dimension(frame.getWidth(), frame.getHeight());
//frame.setSize(width,height);

     frame.setTitle(name);
     frame.setResizable(false);
     frame.setLocationRelativeTo(null);
     frame.setDefaultCloseOperation(3);
     frame.setVisible(true);
     
     epicarnocomp.start();
   }
   

public void invRedraw(){
	     for (int i = 0; i < Inventory.invBar.length; i++) {
		       Inventory.invBar[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + i * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19- (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
		     }
		     int x = 0;int y = 0;
		     for (int i = 0; i < Inventory.invBag.length; i++)
		     {
		       Inventory.invBag[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + x * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19 - (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace) - EpicarnoTiles.invHeight * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace) + y * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
		       x++;
		       if (x == EpicarnoTiles.invLength)
		       {
		         x = 0;
		         y++;
		       }
		     }
		
		    Inventory. invBar[0].id = InvItems.invItems[0].id;
		    Inventory. invBar[1].id =  InvItems.invItems[1].id;
		    Inventory. invBar[2].id =  InvItems.invItems[2].id;
		    Inventory. invBar[3].id =  InvItems.invItems[3].id;
		    Inventory. invBar[4].id =  InvItems.invItems[4].id;
		    Inventory. invBar[5].id =  InvItems.invItems[5].id;
		    Inventory. invBar[6].id =  InvItems.invItems[6].id;
		    Inventory. invBar[7].id =  InvItems.invItems[7].id;
		  
		    Inventory.  invBag[8].id = InvItems.invBagItems[8].id;
		    Inventory.  invBag[9].id = InvItems.invBagItems[9].id;
		    Inventory. invBag[10].id = InvItems. invBagItems[10].id; 
		    Inventory.invBag[11].id = InvItems.invBagItems[11].id ;
		    Inventory.  invBag[12].id = InvItems. invBagItems[12].id ;
		    Inventory.  invBag[13].id = InvItems. invBagItems[13].id ;
		    Inventory.  invBag[14].id = InvItems. invBagItems[14].id ;
		    Inventory.  invBag[15].id = InvItems. invBagItems[15].id ;
		    
		    Inventory.  invBag[16].id = InvItems.invBagItems[16].id;
		    Inventory.  invBag[17].id = InvItems.invBagItems[17].id;
		    Inventory. invBag[18].id = InvItems. invBagItems[18].id; 
		    Inventory.invBag[19].id = InvItems.invBagItems[19].id ;
		    Inventory.  invBag[20].id = InvItems. invBagItems[20].id ;
		    Inventory.  invBag[21].id = InvItems. invBagItems[21].id ;
		    Inventory.  invBag[22].id = InvItems. invBagItems[22].id ;
		    Inventory.  invBag[23].id = InvItems. invBagItems[23].id ;
		    
		    Inventory.  invBag[24].id = InvItems.invBagItems[24].id;
		    Inventory.  invBag[25].id = InvItems.invBagItems[25].id;
		    Inventory. invBag[26].id = InvItems. invBagItems[26].id; 
		    Inventory.invBag[27].id = InvItems.invBagItems[27].id ;
		    Inventory.  invBag[28].id = InvItems. invBagItems[28].id ;
		    Inventory.  invBag[29].id = InvItems. invBagItems[29].id ;
		    Inventory.  invBag[30].id = InvItems. invBagItems[30].id ;
		    Inventory.  invBag[31].id = InvItems. invBagItems[31].id ;
		    
		    Inventory.  invBag[32].id = InvItems.invBagItems[32].id;
		    Inventory.  invBag[33].id = InvItems.invBagItems[33].id;
		    Inventory. invBag[34].id = InvItems. invBagItems[34].id; 
		    Inventory.invBag[35].id = InvItems.invBagItems[35].id ;
		    Inventory.  invBag[36].id = InvItems. invBagItems[36].id ;
		    Inventory.  invBag[37].id = InvItems. invBagItems[37].id ;
		    Inventory.  invBag[38].id = InvItems. invBagItems[38].id ;
		    Inventory.  invBag[39].id = InvItems. invBagItems[39].id ;
		    
		    Inventory.  invBag[0].id = InvItems.invBagItems[0].id;
		    Inventory.  invBag[1].id = InvItems.invBagItems[1].id;
		    Inventory. invBag[2].id = InvItems. invBagItems[2].id; 
		    Inventory.invBag[3].id = InvItems.invBagItems[3].id ;
		    Inventory.  invBag[4].id = InvItems. invBagItems[4].id ;
		    Inventory.  invBag[5].id = InvItems. invBagItems[5].id ;
		    Inventory.  invBag[6].id = InvItems. invBagItems[6].id ;
		    Inventory.  invBag[7].id = InvItems. invBagItems[7].id ;
}
   public void tick()
   {
	   
	Cam.tick();
	if(redoBar == true){
		renderBar();
		if((sp == true)){
		//player.redo(EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2);
		}
		redoBar = false;
	}
	if((sp == true) && (dr == 0)){
		dr = 1;
		// player = new Player(EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2);
		 playerlives = true;
		 //frame.setResizable(false);
		// frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
	}
	
	setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	

	     //realSize = new Dimension(frame.getWidth(), frame.getHeight());
	//frame.setSize(width,height);
	size.height =frame.getHeight();
	size.width = frame.getWidth();
	//this.dir = 0.5D;
	//System.out.println();
	pixel.height =( frame.getHeight()/pixelSize);
	pixel.width =( frame.getWidth()/pixelSize);
     //if ((frame.getWidth() != realSize.width) || (frame.getHeight() != realSize.height)) {
    //   frame.setSize(frame.getWidth(),frame.getWidth());
    // }
     epicarnol.tick((int)sX, (int)sY, pixel.width / EpicarnoTiles.tileSize + 2, pixel.height / EpicarnoTiles.tileSize + 2);
if(playerlives == true){
	if(redoplay == false){
  player.tick();
	}
}
     sky.tick();
     for (int i = 0; i < mob.toArray().length; i++) {
       ((Mob)mob.get(i)).tick();
     }















   }
   
   public void render()
   {
     Graphics g = this.screen.getGraphics();
     // Graphics h = this.screen.getGraphics();
     sky.render(g);
     
     back.render(g, (int)sX, (int)sY, pixel.width / EpicarnoTiles.tileSize +4, pixel.height / EpicarnoTiles.tileSize +4);
     epicarnol.render(g, (int)sX, (int)sY, pixel.width / EpicarnoTiles.tileSize +4, pixel.height / EpicarnoTiles.tileSize +4 );
if(playerlives == true){
   player.render(g);
}
     for (int i = 0; i < mob.toArray().length; i++) {
       ((Mob)mob.get(i)).render(g);
     }
    // invent.render(h);
//invent.render(g);
invent.render(g);
//info.render(g);
     
 
     //h = invent.;
   g= getGraphics();
   int Teste = frame.getWidth();
   Teste = Teste/2;
   Teste = Teste - 400;
   Teste=0;
   int Testy = frame.getHeight();
   Testy = Testy/2;
   Testy = Testy - 400;
  //Teste =0; 
     g.drawImage(this.screen, Teste, 0, (frame.getWidth()), frame.getHeight(), 0, 0, pixel.width, pixel.height, null);

//invent.render(g);

//h.drawImage(this.screen, 0, 0, (frame.getWidth()), frame.getHeight(), 0, 0, pixel.width, pixel.height, null);
     g.dispose();
   }

   public  void renderBar()
   {

this.screen = createVolatileImage((frame.getWidth()/pixelSize), (frame.getHeight()/pixelSize));
 
  
     //invent.render(h);
//h= getGraphics();
     
 
     //h = invent.;

//h.drawImage(this.screen, 10, 0, (frame.getWidth()), frame.getHeight(), 0, 0, pixel.width, pixel.height, null);
     //h.dispose();
   }
   
   public void run()
   {
  renderBar();
     while (isRunning)
     {
       tick();
       render();
invRedraw();
//renderBar();
       try
       {
         Thread.sleep(5L);
       }
       catch (Exception localException) {}
     }
   }

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	   int key = e.getKeyCode();
	     switch (key)
	     {
	     case 13: 
	//	System.out.println(frame.getWidth());
	       break;

	     }
	
} }



