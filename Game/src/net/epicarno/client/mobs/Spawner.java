 package net.epicarno.client.mobs;
 
 import java.util.ArrayList;
import java.util.Random;

import net.epicarno.client.EpicarnoComp;
import net.epicarno.client.generic.EpicarnoTiles;
import net.epicarno.client.world.EpicarnoL;
 
 public class Spawner
   implements Runnable
 {
   public boolean isRunning = true;
   
   public Spawner()
   {
     new Thread(this).start();
   }
   
   public void spawnMob(Mob mob)
   {
     EpicarnoComp.mob.add(mob);
   }
   
   public void run()
   {
     while (this.isRunning)
     {
       if (EpicarnoComp.mob.toArray().length < EpicarnoTiles.maxMobs) {
         spawnMob(new Zombie(new Random().nextInt((EpicarnoL.worldW - 2) * EpicarnoTiles.tileSize) + EpicarnoTiles.tileSize + 30, 50, EpicarnoTiles.tileSize, EpicarnoTiles.tileSize * 2, EpicarnoTiles.Zombie));
       }
       try
       {
         Thread.sleep(new Random().nextInt(15000) + 15000);
       }
       catch (Exception localException) {}
     }
   }
 }


