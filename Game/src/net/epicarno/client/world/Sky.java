 package net.epicarno.client.world;
 
 import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;

import net.epicarno.client.EpicarnoComp;
 
 public class Sky
 {
	 
	 //TODO RENDER SUN
   public int day = 0;
   public int night = 1;
   public int time = this.day;
   public int r1 = 108;
   public int g1 = 199;
   public int b1 = 217;
   
   public int r2 = 84;
   public int g2 = 59;
   public int b2 = 87;
   public int r = this.r1;
   public int g = this.g1;
   public int b = this.b1;
   public int dayFrame = 0;
   public int dayTime = 10000;
   public int changeFrame = 0;
   public int changeTime = 4;
   
   public Sky()
   {
     if (this.time == this.day)
     {
       this.r = this.r1;
       this.g = this.g1;
       this.b = this.b1;
     }
     else if (this.time == this.night)
     {
       this.r = this.r2;
       this.g = this.g2;
       this.b = this.b2;
     }
   }
   
   public void tick()
   {
     if (this.dayFrame >= this.dayTime)
     {
       if (this.time == this.day) {
         this.time = this.night;
       } else if (this.time == this.night) {
         this.time = this.day;
       }
       this.dayFrame = 0;
     }
     else
     {
       this.dayFrame += 1;
     }
     if (this.changeFrame >= this.changeTime)
     {
       if (this.time == this.day)
       {
         if (this.r < this.r1) {
           this.r += 1;
         }
         if (this.g < this.g1) {
           this.g += 1;
         }
         if (this.b < this.b1) {
           this.b += 1;
         }
       }
       else if (this.time == this.night)
       {
         if (this.r > this.r2) {
           this.r -= 1;
         }
         if (this.g > this.g2) {
           this.g -= 1;
         }
         if (this.b > this.b2) {
           this.b -= 1;
         }
       }
       this.changeFrame = 0;
     }
     else
     {
       this.changeFrame += 1;
     }
   }
   
   public void render(Graphics gr)
   {
	   //GradientPaint redtowhite = new GradientPaint(0,0,color.RED,100, 0,color.WHITE);
	   //gr.setPaint(redtowhite);
     gr.setColor(new Color(this.r, this.g, this.b));
     gr.fillRect(0, 0, EpicarnoComp.pixel.width, EpicarnoComp.pixel.height);
   }
 }


