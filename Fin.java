import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class Fin extends World {
   GreenfootImage fin = new GreenfootImage("rip.png");

   public Fin() {
      super(800, 448, 1, false);
      Greenfoot.playSound("Game Over.wav");
   }

   public void act() {
   }
}
