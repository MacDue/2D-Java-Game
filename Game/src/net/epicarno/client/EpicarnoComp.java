/*   1:    */ package net.epicarno.client;
/*   2:    */ 
/*   3:    */ import java.applet.Applet;
/*   4:    */ import java.awt.Dimension;
/*   5:    */ import java.awt.Graphics;
/*   6:    */ import java.awt.Image;
/*   7:    */ import java.awt.Point;
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
/*   8:    */ import java.util.ArrayList;

import javax.swing.JFrame;
/*  10:    */ 
/*  11:    */ public class EpicarnoComp
/*  12:    */   extends Applet
/*  13:    */   implements Runnable  , KeyListener

/*  14:    */ {
/*  15:    */   private static final long serialVersionUID = 1L;
/*  16: 11 */   public static int pixelSize = 3;
public static int dr= 0;
/*  17: 13 */   public static int moveFronBorder = 0;
/*  18: 14 */   public static double sX = moveFronBorder;
/*  19: 14 */   public static double sY = moveFronBorder;
/*  20: 15 */   public static double dir = 0.5D;
/*  21:    */   public static Dimension realSize;
/*  22: 18 */   public static Dimension size = new Dimension(800, 600);
/*  23: 19 */   public static Dimension pixel = new Dimension(size.width / pixelSize, size.height / pixelSize);
/*  24: 21 */   public static Point mse = new Point(0, 0);
/*  25: 23 */   public static String name = "Ben Maxwell Test Java Project";
/*  26: 25 */   public static boolean isRunning = false;
/*  27: 26 */   public static boolean isMoving = false;
/*  28: 27 */   public static boolean isHipideHopping = false;
/*  29: 28 */   public static boolean isLeftyDown = false;
/*  30: 29 */   public static boolean isRightyDown = false;
public static boolean sp = false;
/*  31:    */   private Image screen;
public static boolean playerlives = false;
public static boolean redoplay = false;

/*  32:    */   public static EpicarnoL epicarnol;
/*  33:    */   public static Player player;
public static InvItems items;
public static boolean redoBar = false;
/*  34:    */   public static Inventory invent;
/*  35:    */   public static Sky sky;
/*  35:    */   public static Info info;
/*  36:    */   public static Spawner spawner;
/*  37: 38 */   public static ArrayList<Mob> mob = new ArrayList();
/*  38:    */   private static JFrame frame;
/*  39:    */   
/*  40:    */   public EpicarnoComp()
/*  41:    */   {
/*  42: 43 */     setPreferredSize(size);
/*  43: 44 */     addKeyListener(new Listening());
/*  44: 45 */     addMouseListener(new Listening());
/*  45: 46 */     addMouseMotionListener(new Listening());
/*  46: 47 */     addMouseWheelListener(new Listening());
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void start()
/*  50:    */   {
/*  51: 52 */     requestFocus();
/*  52:    */     
/*  53: 54 */     epicarnol = new EpicarnoL();
/*  54: 55 */  //   player = new Player(EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2);
/*  55: 56 */     new EpicarnoTiles();

items = new InvItems();
invent = new Inventory();
/*  56: 57 */     
/*  57: 58 */     sky = new Sky();

/*  58: 59 */     spawner = new Spawner();
player = null;
/*  59:    */     
/*  60:    */ 
/*  61: 62 */     isRunning = true;
/*  62: 63 */     new Thread(this).start();
/*  63:    */   }




/*  23: 13 */      

/*  64:    */   
/*  65:    */   public void stop()
/*  66:    */   {
/*  67: 68 */     isRunning = false;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public static void main(String[] args)
/*  71:    */   {
/*  72: 73 */     EpicarnoComp epicarnocomp = new EpicarnoComp();
/*  73:    */     
/*  74: 75 */     frame = new JFrame();


frame.addComponentListener(new ComponentListener() {
    public void componentResized(ComponentEvent e) {
    	//player.y = 50.0D;
    	  System.out.println(frame.getWidth());
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
/*  75: 76 */     frame.add(epicarnocomp);
if(playerlives == true){
frame.setResizable(false);
}
/*  76: 77 */     frame.pack();

/*  77:    */     
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
int width = (int) screenSize.getWidth();
int height = (int) screenSize.getHeight();
/*  78: 79 */     realSize = new Dimension(frame.getWidth(), frame.getHeight());
//frame.setSize(width,height);

/*  80: 81 */     frame.setTitle(name);
/*  81: 82 */     frame.setResizable(true);
/*  82: 83 */     frame.setLocationRelativeTo(null);
/*  83: 84 */     frame.setDefaultCloseOperation(3);
/*  84: 85 */     frame.setVisible(true);
/*  85:    */     
/*  86: 87 */     epicarnocomp.start();
/*  87:    */   }
/*  88:    */   

public void invRedraw(){
	/*  20: 18 */     for (int i = 0; i < Inventory.invBar.length; i++) {
		/*  21: 19 */       Inventory.invBar[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + i * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19- (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
		/*  22:    */     }
		/*  23: 22 */     int x = 0;int y = 0;
		/*  24: 23 */     for (int i = 0; i < Inventory.invBag.length; i++)
		/*  25:    */     {
		/*  26: 26 */       Inventory.invBag[i] = new Cell(new Rectangle(EpicarnoComp.pixel.width / 2 - (EpicarnoTiles.invLength * EpicarnoTiles.incCellSize + EpicarnoTiles.incCellSize) / 2 + x * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoComp.pixel.height -19 - (EpicarnoTiles.incCellSize + EpicarnoTiles.invBorderSpace) - EpicarnoTiles.invHeight * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace) + y * (EpicarnoTiles.incCellSize + EpicarnoTiles.invCellSpace), EpicarnoTiles.incCellSize, EpicarnoTiles.incCellSize), EpicarnoTiles.air);
		/*  27: 27 */       x++;
		/*  28: 28 */       if (x == EpicarnoTiles.invLength)
		/*  29:    */       {
		/*  30: 29 */         x = 0;
		/*  31: 30 */         y++;
		/*  32:    */       }
		/*  33:    */     }
		
		/*  34: 35 */    Inventory. invBar[0].id = InvItems.invItems[0].id;
		/*  35: 36 */    Inventory. invBar[1].id =  InvItems.invItems[1].id;
		/*  36: 37 */    Inventory. invBar[2].id =  InvItems.invItems[2].id;
		/*  37: 38 */    Inventory. invBar[3].id =  InvItems.invItems[3].id;
		/*  38: 39 */    Inventory. invBar[4].id =  InvItems.invItems[4].id;
		/*  39: 40 */    Inventory. invBar[5].id =  InvItems.invItems[5].id;
		/*  40: 41 */    Inventory. invBar[6].id =  InvItems.invItems[6].id;
		/*  41: 42 */    Inventory. invBar[7].id =  InvItems.invItems[7].id;
		/*  42: 43 */   Inventory.  invBag[0].id = InvItems.invBagItems[0].id;
		/*  43: 44 */   Inventory.  invBag[1].id = InvItems.invBagItems[1].id;
		
		 /*  43: 44 */    Inventory. invBag[2].id = InvItems. invBagItems[2].id; 
		 /*  43: 44 */     Inventory.invBag[3].id = InvItems.invBagItems[3].id ;
		 /*  43: 44 */    Inventory.  invBag[4].id = InvItems. invBagItems[4].id ;
		 /*  43: 44 */    Inventory.  invBag[5].id = InvItems. invBagItems[5].id ;
		 /*  43: 44 */    Inventory.  invBag[6].id = InvItems. invBagItems[6].id ;
		 /*  43: 44 */    Inventory.  invBag[7].id = InvItems. invBagItems[7].id ;
}
/*  89:    */   public void tick()
/*  90:    */   {
	
	if(redoBar == true){
		renderBar();
		if((sp == true)){
		//player.redo(EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2);
		}
		redoBar = false;
	}
	if((sp == true) && (dr == 0)){
		dr = 1;
		 player = new Player(EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2);
		 playerlives = true;
		 //frame.setResizable(false);
		// frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
	}
	
	setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int width = (int) screenSize.getWidth();
	int height = (int) screenSize.getHeight();
	

	/*  78: 79 */     //realSize = new Dimension(frame.getWidth(), frame.getHeight());
	//frame.setSize(width,height);
	size.height =frame.getHeight();
	size.width = frame.getWidth();
	//this.dir = 0.5D;
	//System.out.println();
	pixel.height =( frame.getHeight()/pixelSize);
	pixel.width =( frame.getWidth()/pixelSize);
/*  91: 91 */     //if ((frame.getWidth() != realSize.width) || (frame.getHeight() != realSize.height)) {
/*  92: 92 */    //   frame.setSize(frame.getWidth(),frame.getWidth());
/*  93:    */    // }
/*  94: 95 */     epicarnol.tick((int)sX, (int)sY, pixel.width / EpicarnoTiles.tileSize + 2, pixel.height / EpicarnoTiles.tileSize + 2);
if(playerlives == true){
	if(redoplay == false){
/*  95: 96 */  player.tick();
	}
}
/*  96: 97 */     sky.tick();
/*  97: 99 */     for (int i = 0; i < mob.toArray().length; i++) {
/*  98:100 */       ((Mob)mob.get(i)).tick();
/*  99:    */     }















/* 100:    */   }
/* 101:    */   
/* 102:    */   public void render()
/* 103:    */   {
/* 104:106 */     Graphics g = this.screen.getGraphics();
/* 105:    */     // Graphics h = this.screen.getGraphics();
/* 106:108 */     sky.render(g);
/* 107:    */     
/* 108:    */
/* 109:111 */     epicarnol.render(g, (int)sX, (int)sY, pixel.width / EpicarnoTiles.tileSize, pixel.height / EpicarnoTiles.tileSize + 2);
if(playerlives == true){
/* 110:112 */   player.render(g);
}
/* 111:114 */     for (int i = 0; i < mob.toArray().length; i++) {
/* 112:115 */       ((Mob)mob.get(i)).render(g);
/* 113:    */     }
/* 114:117 */    // invent.render(h);
//invent.render(g);
invent.render(g);
//info.render(g);
/* 115:    */     
/* 116:    */ 
/* 117:120 */     //h = invent.;
   g= getGraphics();
   int Teste = frame.getWidth();
   Teste = Teste/2;
   Teste = Teste - 400;
   Teste=0;
   int Testy = frame.getHeight();
   Testy = Testy/2;
   Testy = Testy - 400;
  //Teste =0; 
/* 118:121 */     g.drawImage(this.screen, Teste, 0, (frame.getWidth()), frame.getHeight(), 0, 0, pixel.width, pixel.height, null);

//invent.render(g);

//h.drawImage(this.screen, 0, 0, (frame.getWidth()), frame.getHeight(), 0, 0, pixel.width, pixel.height, null);
/* 119:122 */     g.dispose();
/* 120:    */   }

/* 102:    */   public  void renderBar()
/* 103:    */   {
/* 104:10 */
this.screen = createVolatileImage((frame.getWidth()/pixelSize), (frame.getHeight()/pixelSize));
/* 108:    */ 
/* 109:111 */  
/* 114:117 */     //invent.render(h);
//h= getGraphics();
/* 115:    */     
/* 116:    */ 
/* 117:120 */     //h = invent.;

//h.drawImage(this.screen, 10, 0, (frame.getWidth()), frame.getHeight(), 0, 0, pixel.width, pixel.height, null);
/* 119:122 */     //h.dispose();
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void run()
/* 123:    */   {
/* 124:126 */  renderBar();
/* 125:128 */     while (isRunning)
/* 126:    */     {
/* 127:129 */       tick();
/* 128:130 */       render();
invRedraw();
//renderBar();
/* 129:    */       try
/* 130:    */       {
/* 131:133 */         Thread.sleep(5L);
/* 132:    */       }
/* 133:    */       catch (Exception localException) {}
/* 134:    */     }
/* 135:    */   }
/* 136:    */
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
	/*  18:  9 */     switch (key)
	/*  19:    */     {
	/*  20:    */     case 13: 
		System.out.println(frame.getWidth());
	/*  23: 13 */       break;

	/*  39:    */     }
	
} }



/* Location:           E:\New folder (6)\MineD.jar

 * Qualified Name:     net.epicarno.client.EpicarnoComp

 * JD-Core Version:    0.7.0.1

 */